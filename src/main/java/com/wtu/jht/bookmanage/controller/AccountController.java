package com.wtu.jht.bookmanage.controller;

import com.wtu.jht.bookmanage.modal.TResource;
import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.openapi.BaseController;
import com.wtu.jht.bookmanage.openapi.constant.Constant;
import com.wtu.jht.bookmanage.openapi.pojo.ManageResult;
import com.wtu.jht.bookmanage.openapi.pojo.Menu;
import com.wtu.jht.bookmanage.service.TUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className: AccountController
 * 用户登录
 */

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    private final TUserService tUserService;


    /**
     * 注入Service
     * @param tUserService
     */
    @Autowired
    public AccountController(TUserService tUserService){
        this.tUserService=tUserService;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping(value = "/main")
    public String mainHome(){
        return "main";
    }

    /**
     *
     * @param username 用户名
     * @param password 密码
     * @param remember
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ManageResult login( @RequestParam(value = "username",required = false) String username,
                               @RequestParam(value = "password",required = false) String password,
                              @RequestParam(value = "remember",required = false, defaultValue = "false") boolean remember){
        ManageResult manageResult=new ManageResult(200);
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(remember);
            try {
                currentUser.login(token);
                //登录成功后设置session
                Session session = currentUser.getSession();
                TUser tUser = tUserService.selectByUserAccount(username);
                session.setAttribute(Constant.CURRENT_USER, tUser);
                List<TResource> tResources = tUserService.selectResource(tUser.getfId());
                List<Menu> menuList = new ArrayList<>();
                Set<String> permissions = new HashSet<>();
                for (TResource tResource : tResources) {
                    if (StringUtils.isNotBlank(tResource.getfPermissionCode())) {
                        permissions.add(tResource.getfPermissionCode());
                    }
                    Menu menu = new Menu();
                    menu.setMenuId(tResource.getfId());
                    menu.setPid(tResource.getfParentResource());
                    menu.setMenuName(tResource.getfResourceName());
                    menu.setMenuPath(tResource.getfResourcePath());
                    menu.setMenuIco(tResource.getfResourceIco());
                    menuList.add(menu);
                }
                List<Menu> menuTree = new ArrayList<>();
                for (Menu menu : menuList) {
                    if (menu.getPid() == 0) {
                        menuTree.add(getChildren(menu, menuList));
                    }
                }
                session.setAttribute(Constant.CURRENT_USER_PERMISSION, permissions);
                session.setAttribute(Constant.CURRENT_USER_MENU, menuTree);
                manageResult.setStatus(200);
            } catch (Exception e) {
                TUser tUser = tUserService.selectByUserAccount(username);
                manageResult.setStatus(300);
                manageResult.setData(e);
                manageResult.setMsg("用户名或密码错误");

            }
        }
            return manageResult;
    }

    private Menu getChildren(Menu menu, List<Menu> menuList) {
        for (Menu m : menuList) {
            if (menu.getMenuId().equals(m.getPid())) {
                if (menu.getChildren() == null) {
                    menu.setChildren(new ArrayList<>());
                }
                menu.getChildren().add(getChildren(m, menuList));
            }
        }
        return menu;
    }
}

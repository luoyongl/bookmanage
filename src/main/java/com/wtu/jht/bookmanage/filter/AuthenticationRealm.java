package com.wtu.jht.bookmanage.filter;


import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.openapi.constant.Constant;
import com.wtu.jht.bookmanage.service.TUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @ClassName: AuthenticationRealm
 * @Description: 权限认证
 * @date 2018年12月04日
 */
public class AuthenticationRealm extends AuthorizingRealm {

    /**
     * 用户信息操作接口
     */
    @Autowired
    private TUserService tUserService;

    @Override
    public String getName() {
        return "authenticationRealm";
    }

    /**
     * 获取认证信息
     *
     * @param token 令牌
     * @return 认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
//        String username = (String) token.getPrincipal();
//        TUser tUser = tUserService.selectByUserAccount(username);
//        if (tUser != null) {
//            if(tUser.getfIsEffective()!=null && !tUser.getfIsEffective()){
//                throw new BizException("用户已失效");
//            }
//            return new SimpleAuthenticationInfo(tUser.getUsername(), tUser.getPassword(),
//                    ByteSource.Util.bytes(tUser.getUsername()), getName());
//        }
//        return null;


        String username = (String) token.getPrincipal();
             TUser tUser = tUserService.selectByUserAccount(username);
        if (tUser == null) {
            // 用户名不存在抛出异常W
            System.out.println("认证：当前登录的用户不存在");
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(tUser, tUser.getPassword(), getName());
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection PrincipalCollection
     * @return 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();

        Set<String> permissions = (Set<String>) session.getAttribute(Constant.CURRENT_USER_PERMISSION);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

}
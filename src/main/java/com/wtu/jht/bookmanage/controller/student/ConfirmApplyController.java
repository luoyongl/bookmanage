package com.wtu.jht.bookmanage.controller.student;

import com.wtu.jht.bookmanage.enums.ApplyBookEnum;
import com.wtu.jht.bookmanage.modal.BApplyBook;
import com.wtu.jht.bookmanage.modal.BStudentBook;
import com.wtu.jht.bookmanage.modal.TDictionary;
import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.modal.vo.BApplyBookVO;
import com.wtu.jht.bookmanage.openapi.constant.Constant;
import com.wtu.jht.bookmanage.openapi.pojo.ManageResult;
import com.wtu.jht.bookmanage.service.BApplyBookService;
import com.wtu.jht.bookmanage.service.BStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @date ：Created in 2019/5/10 14:22
 * @description：学生确定选书控制器
 * @modified By：
 * @version: 1.0$
 */

@Controller
@RequestMapping("/student")
public class ConfirmApplyController {


    private final BApplyBookService bApplyBookService;

    private final BStudentService bStudentService;

    public ConfirmApplyController(BApplyBookService bApplyBookService,
                                  BStudentService bStudentService){
        this.bApplyBookService=bApplyBookService;
        this.bStudentService=bStudentService;
    }

    //选书界面
    @RequestMapping("/confirmApply")
    public String ui(){
        return "student/confirmApply";
    }


    //班长确认课本领取
    @RequestMapping("/exitorder")
    public String monitor(){
        return "student/exitOrder";
    }


    /**
     * 学生选取教材分页查询
     * @param page
     * @param limit
     * @param searchText
     * @param sortOrder
     * @param sortName
     * @param session
     * @return
     */

   @RequestMapping("/list")
    @ResponseBody
    public ManageResult showBookList(@RequestParam(defaultValue = "1", required = false) Integer page,
                                     @RequestParam(defaultValue = "10", required = false) Integer limit,
                                     @RequestParam(defaultValue = "", required = false) String searchText,
                                     @RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                     @RequestParam(defaultValue = "f_id", required = false) String sortName,
                                     HttpSession session) {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNumber", page);
        paramMap.put("pageSize", limit);
        paramMap.put("class",tUser.getLevel());
        paramMap.put("current_user",tUser.getfId());
        return ManageResult.ok(bApplyBookService.queryPageForStudent(paramMap));
    }



    @RequestMapping("/exitOrderList")
    @ResponseBody
    public ManageResult exitOrder(@RequestParam(defaultValue = "1", required = false) Integer page,
                                     @RequestParam(defaultValue = "10", required = false) Integer limit,
                                     @RequestParam(defaultValue = "", required = false) String searchText,
                                     @RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                     @RequestParam(defaultValue = "f_id", required = false) String sortName,
                                     HttpSession session) {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNumber", page);
        paramMap.put("pageSize", limit);
        paramMap.put("class",tUser.getLevel());
        return ManageResult.ok(bApplyBookService.queryPageExitOrder(paramMap));
    }

    /**
     * 新增选记录
     * @param
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ManageResult add(Integer fBookId,
                            HttpSession session){
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        BStudentBook bStudentBook=new BStudentBook();
        bStudentBook.setfBookId(fBookId);
        bStudentBook.setfUserId(tUser.getfId());
        bStudentBook.setfDeleteFlag(false);
        bStudentService.insert(bStudentBook);
        return ManageResult.ok();
    }



    /**
     * description: 删除
     * create time: 2019/5/5 19:55
     * @Param   * @param null
     * @return
     */


    @RequestMapping("/del")
    @ResponseBody
    public ManageResult del(Integer fBookId,
                            HttpSession session){
        TUser tUser=(TUser) session.getAttribute(Constant.CURRENT_USER);
        BStudentBook bStudentBook=new BStudentBook();
        bStudentBook.setfDeleteFlag(true);
        return ManageResult.ok(bStudentService.update(tUser.getfId(),fBookId));
    }




    @RequestMapping("/exitOrder")
    @ResponseBody
    public ManageResult exitOrder(Integer fId){
        BApplyBook bApplyBook=new BApplyBook();
        bApplyBook.setfId(fId);
        bApplyBook.setfState(String.valueOf(ApplyBookEnum.end.getCode()));
        return ManageResult.ok(bApplyBookService.updateByPrimaryKeySelective(bApplyBook));
    }




}

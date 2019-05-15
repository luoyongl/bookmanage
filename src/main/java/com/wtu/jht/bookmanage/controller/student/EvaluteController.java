package com.wtu.jht.bookmanage.controller.student;

import com.wtu.jht.bookmanage.modal.BEvaluate;
import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.openapi.constant.Constant;
import com.wtu.jht.bookmanage.openapi.pojo.ManageResult;
import com.wtu.jht.bookmanage.service.BApplyBookService;
import com.wtu.jht.bookmanage.service.BEvaluteService;
import com.wtu.jht.bookmanage.service.BStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：LY
 * @date ：Created in 2019/5/12 20:28
 * @description：
 * @modified By：
 * @version: $
 */

@Controller
@RequestMapping("/student")
public class EvaluteController {

    private final BApplyBookService bApplyBookService;

    private final BStudentService bStudentService;

    private final BEvaluteService bEvaluteService;

    public EvaluteController(BApplyBookService bApplyBookService,
                                  BStudentService bStudentService,
                             BEvaluteService bEvaluteService){
        this.bApplyBookService=bApplyBookService;
        this.bStudentService=bStudentService;
        this.bEvaluteService=bEvaluteService;
    }

    //评价界面
    @RequestMapping("/evalute")
    public String monitor(){
        return "student/evalute";
    }



    @RequestMapping("/evaluteList")
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
        return ManageResult.ok(bApplyBookService.queryPageForEvalute(paramMap));
    }


    @RequestMapping("/addevalute")
    @ResponseBody
    public ManageResult addEvaluet(BEvaluate bEvaluate,
                                     HttpSession session) {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        bEvaluate.setfUserId(tUser.getfId());
        return ManageResult.ok(bEvaluteService.insertSelective(bEvaluate));
    }
}

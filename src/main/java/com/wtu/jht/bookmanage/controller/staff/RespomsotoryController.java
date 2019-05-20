package com.wtu.jht.bookmanage.controller.staff;

import com.wtu.jht.bookmanage.modal.BApplyBook;
import com.wtu.jht.bookmanage.modal.BResponsitory;
import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.openapi.constant.Constant;
import com.wtu.jht.bookmanage.openapi.pojo.ManageResult;
import com.wtu.jht.bookmanage.service.BApplyBookService;
import com.wtu.jht.bookmanage.service.BResponsitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @date ：Created in 2019/5/15 11:34
 * @description：库存管理
 * @modified By：
 * @version: $
 */

@Controller
@RequestMapping("/staff")
public class RespomsotoryController {

    private final BResponsitoryService bResponsitoryService;

    private  final BApplyBookService bApplyBookService;

    @Autowired
    public RespomsotoryController(BResponsitoryService bResponsitoryService,
                                  BApplyBookService bApplyBookService){
        this.bResponsitoryService=bResponsitoryService;
        this.bApplyBookService=bApplyBookService;
    }



    @RequestMapping("/responsitory")
    public String ui(){
        return "staff/responsitory";
    }


    @RequestMapping("/resList")
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
        return ManageResult.ok(bResponsitoryService.List(paramMap));
    }



    @RequestMapping("/updateRes")
    @ResponseBody
    public ManageResult edit(@RequestParam(value = "fNumber",required = false,defaultValue = "0") Integer fNumber,
                             @RequestParam(value = "addNumber",required = false,defaultValue = "0") Integer addNumber,
                             @RequestParam(value = "fId",required = false,defaultValue = "0")  Integer fId,
                             Integer fBookId){
        BResponsitory bResponsitory=new BResponsitory();
        BApplyBook bApplyBook=new BApplyBook();
        //这里的bookid 为申请表id
        bResponsitory=bResponsitoryService.selectByBookId(Integer.valueOf(bApplyBookService.selectByPrimaryKey(fBookId).getfBookId()));
        if (bResponsitory==null){
            bApplyBook=bApplyBookService.selectByPrimaryKey(fBookId);
            bResponsitory.setfNumber(addNumber);
            bResponsitory.setfBookId(Integer.valueOf(bApplyBook.getfBookId()));
            bResponsitoryService.insertSelective(bResponsitory);
        }else {
            Integer resnum=bResponsitory.getfNumber()+addNumber;
            bResponsitory.setfNumber(resnum);
            bResponsitoryService.updateByPrimaryKeySelective(bResponsitory);
        }
        return ManageResult.ok();
    }

}
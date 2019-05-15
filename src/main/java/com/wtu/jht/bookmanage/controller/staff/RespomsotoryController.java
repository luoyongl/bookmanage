package com.wtu.jht.bookmanage.controller.staff;

import com.wtu.jht.bookmanage.modal.BResponsitory;
import com.wtu.jht.bookmanage.modal.TDictionary;
import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.openapi.constant.Constant;
import com.wtu.jht.bookmanage.openapi.pojo.ManageResult;
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
 * @author ：LY
 * @date ：Created in 2019/5/15 11:34
 * @description：库存管理
 * @modified By：
 * @version: $
 */

@Controller
@RequestMapping("/staff")
public class RespomsotoryController {

    private final BResponsitoryService bResponsitoryService;

    @Autowired
    public RespomsotoryController(BResponsitoryService bResponsitoryService){
        this.bResponsitoryService=bResponsitoryService;
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
    public ManageResult edit(Integer fNumber,Integer addNumber,Integer fId){
        BResponsitory bResponsitory=new BResponsitory();
        bResponsitory.setfId(fId);
        bResponsitory.setfNumber(fNumber+addNumber);
        return ManageResult.ok(bResponsitoryService.updateByPrimaryKeySelective(bResponsitory));
    }

}

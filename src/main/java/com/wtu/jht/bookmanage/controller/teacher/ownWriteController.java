package com.wtu.jht.bookmanage.controller.teacher;


import com.wtu.jht.bookmanage.enums.ApplyBookEnum;
import com.wtu.jht.bookmanage.modal.BApplyBook;
import com.wtu.jht.bookmanage.modal.BBookList;
import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.openapi.constant.Constant;
import com.wtu.jht.bookmanage.openapi.pojo.ManageResult;
import com.wtu.jht.bookmanage.service.BApplyBookService;
import com.wtu.jht.bookmanage.service.BBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 自编教材印刷控制层
 */
@Controller
@RequestMapping("/teacher")
public class ownWriteController {

    private final BBookListService bBookListService;

    private final BApplyBookService bApplyBookService;


    @Autowired
    public ownWriteController(BBookListService bBookListService,
                              BApplyBookService bApplyBookService) {
        this.bBookListService = bBookListService;
        this.bApplyBookService = bApplyBookService;
    }

    /**
     * 自编教材页面
     *
     * @return
     */
    @RequestMapping("/ownWrite")
    public String goBookList() {
        return "teacher/ownWrite";
    }


    @RequestMapping("/applyOwnBook")
    @ResponseBody
    public ManageResult applyOwnBook(@RequestParam("file") CommonsMultipartFile file,
                                     @RequestParam("fBookName") String fBookName,
                                     @RequestParam(value = "fBookEditor",required = false) String fBookEditor,
                                     BApplyBook bApplyBook,
                                     HttpSession session,
                                     HttpServletRequest request){
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        BBookList bBookList=new BBookList();
        bBookList.setfBookIswrite(true);
        bBookList.setfBookName(fBookName);
        bBookList.setfState((byte)1);
        bApplyBook.setfState(String.valueOf(ApplyBookEnum.waitReview.getCode()));
        bBookList.setfWriteId(tUser.getfId());
        try {
            if (bBookListService.insertSelective(bBookList)!=null){
                bApplyBook.setfBookId(String.valueOf(bBookList.getfId()));
                bApplyBook.setfUserId(tUser.getfId());
                bApplyBookService.insertSelective(bApplyBook);
            }
        }catch (Exception e){
            //TOOD
        }
        return null;

    }


    @RequestMapping("/editOwnBook")
    public ManageResult edit(@RequestParam(value = "fBookName",required = false)String fBookName,
                             @RequestParam(value = "fBookEditor",required = false) String fBookEditor){
        return null;
    }


}

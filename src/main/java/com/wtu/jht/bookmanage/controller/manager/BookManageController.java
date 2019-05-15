package com.wtu.jht.bookmanage.controller.manager;

import com.wtu.jht.bookmanage.enums.ApplyBookEnum;
import com.wtu.jht.bookmanage.modal.BApplyBook;
import com.wtu.jht.bookmanage.modal.TDictionary;
import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.openapi.constant.Constant;
import com.wtu.jht.bookmanage.openapi.pojo.ManageResult;
import com.wtu.jht.bookmanage.service.BApplyBookService;
import com.wtu.jht.bookmanage.service.BBookListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 教材审核
 */
@Controller
@RequestMapping("/manager/review")
public class BookManageController {

    private final BBookListService bBookListService;

    private final BApplyBookService bApplyBookService;

    public BookManageController(BBookListService bBookListService,
                                BApplyBookService bApplyBookService){
        this.bBookListService = bBookListService;
        this.bApplyBookService = bApplyBookService;
    }


    /**
     *审核界面
     *
     * @return
     */
    @RequestMapping("/applyresult")
    public String goBookList() {
        return "manager/applyResult";
    }

    /**
     * 审核历史界面
     * @return
     */
    @RequestMapping("/reviewHistory")
    public String reviewHistory(){
        return "manager/reviewHistory";
    }

    /**
     * 审核界面数据分页展示
     * @param page
     * @param limit
     * @param searchText
     * @param sortOrder
     * @param sortName
     * @param session
     * @return
     */
    @RequestMapping("/showApplyResult")@ResponseBody
    public ManageResult showApplyList(@RequestParam(defaultValue = "1", required = false) Integer page,
                                      @RequestParam(defaultValue = "10", required = false) Integer limit,
                                      @RequestParam(defaultValue = "", required = false) String searchText,
                                      @RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                      @RequestParam(defaultValue = "f_id", required = false) String sortName,
                                      HttpSession session ) {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNumber", page);
        paramMap.put("pageSize", limit);
        paramMap.put("currentUser",tUser.getfId());
        paramMap.put("waitReviewState",ApplyBookEnum.waitReview.getCode());
        return ManageResult.ok(bApplyBookService.QueryPageForManage(paramMap));
    }


    /**
     * 审核历史界面数据分页展示
     * @param page
     * @param limit
     * @param searchText
     * @param sortOrder
     * @param sortName
     * @param session
     * @return
     */
    @RequestMapping("/showReviewHistory")
    @ResponseBody
    public ManageResult showReviewHistoy(@RequestParam(defaultValue = "1", required = false) Integer page,
                                      @RequestParam(defaultValue = "10", required = false) Integer limit,
                                      @RequestParam(defaultValue = "", required = false) String searchText,
                                      @RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                      @RequestParam(defaultValue = "f_id", required = false) String sortName,
                                      HttpSession session ) {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNumber", page);
        paramMap.put("pageSize", limit);
        paramMap.put("currentUser",tUser.getfId());
        paramMap.put("reviewHistory",true);
        return ManageResult.ok(bApplyBookService.QueryPageForManage(paramMap));
    }
    /**
     * 审核通过
     * @param fId
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public ManageResult edit(Integer fId){
        try {
            BApplyBook bApplyBook=new BApplyBook();
            bApplyBook.setfId(fId);
            bApplyBook.setfState(String.valueOf(ApplyBookEnum.reviewSuccess.getCode()));
            bApplyBookService.updateByPrimaryKeySelective(bApplyBook);
            return ManageResult.ok();
        }catch (Exception e){
            return ManageResult.fail();
        }
    }

    /**
     * 审核不通过 实际上是更新删除标志
     * @param fId
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public ManageResult delete(Integer fId){
        try {
            BApplyBook bApplyBook=new BApplyBook();
            bApplyBook.setfId(fId);
            bApplyBook.setfState(String.valueOf(ApplyBookEnum.waitFail.getCode()));
            bApplyBookService.updateByPrimaryKeySelective(bApplyBook);
            return ManageResult.ok();
        }catch (Exception e){
            return ManageResult.fail();
        }
    }




}

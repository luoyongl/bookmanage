package com.wtu.jht.bookmanage.controller.teacher;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wtu.jht.bookmanage.dao.BBookListMapper;
import com.wtu.jht.bookmanage.enums.ApplyBookEnum;
import com.wtu.jht.bookmanage.modal.*;
import com.wtu.jht.bookmanage.openapi.BaseController;
import com.wtu.jht.bookmanage.openapi.constant.Constant;
import com.wtu.jht.bookmanage.openapi.pojo.ManageResult;
import com.wtu.jht.bookmanage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 教用教材领用控制层
 * 查询图书清单
 *
 * @author LY
 */

@Controller
@RequestMapping("/teacher")
public class BookListController extends BaseController {

    private final BBookListService bBookListService;

    private final BApplyBookService bApplyBookService;

    private final TDictionaryService tDictionaryService;

    private final BBookOrderService bBookOrderService;


    private final BEvaluteService bEvaluteService;


    @Autowired
    public BBookListMapper bBookListMapper;

    @Autowired
    public BookListController(BBookListService bBookListService,
                              BApplyBookService bApplyBookService,
                              TDictionaryService tDictionaryService,
                              BBookOrderService bBookOrderService,
                              BEvaluteService bEvaluteService) {
        this.bBookListService = bBookListService;
        this.bApplyBookService = bApplyBookService;
        this.tDictionaryService = tDictionaryService;
        this.bBookOrderService = bBookOrderService;
        this.bEvaluteService=bEvaluteService;
    }

    /**
     * 图书列表页面
     *
     * @return
     */
    @RequestMapping("/booklist")
    public String goBookList(Model model) {

        List<TDictionary> collegeList = new ArrayList<>();
        List<TDictionary> college = tDictionaryService.selectListByCriteria("college");
        for (TDictionary t : college) {
            if (t.getfParentNode() != 0) {
                collegeList.add(t);
            }
        }
        List<TDictionary> courseList = tDictionaryService.selectListByCriteria("course");

        model.addAttribute("collegeList", collegeList);
        model.addAttribute("courseList", courseList);
        return "teacher/booklist";
    }


    /**
     * 选书申请结果界面
     *
     * @param session 获取当前用户
     */
    @RequestMapping("/applyresult")
    public String goApplyList(HttpSession session) {
        return "teacher/applyResult";
    }

    @RequestMapping("/showApplyResult")
    @ResponseBody
    public ManageResult showApplyList(@RequestParam(defaultValue = "1", required = false) Integer page,
                                      @RequestParam(defaultValue = "10", required = false) Integer limit,
                                      @RequestParam(defaultValue = "", required = false) String searchText,
                                      @RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                      @RequestParam(defaultValue = "f_id", required = false) String sortName,
                                      HttpSession session) {

        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNumber", page);
        paramMap.put("pageSize", limit);
        paramMap.put("currentUser", tUser.getfId());
        return ManageResult.ok(bApplyBookService.QueryPage(paramMap));
    }

    /**
     * 查询图书信息 分页展示
     *
     * @param page
     * @param limit
     * @param searchText
     * @param sortOrder
     * @param sortName
     * @return
     */
    @RequestMapping("/showBookList")
    @ResponseBody
    public ManageResult showBookList(@RequestParam(defaultValue = "1", required = false) Integer page,
                                     @RequestParam(defaultValue = "10", required = false) Integer limit,
                                     @RequestParam(defaultValue = "", required = false) String searchText,
                                     @RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                     @RequestParam(defaultValue = "f_id", required = false) String sortName,
                                     @RequestParam(defaultValue = "type", required = false) Integer type,
                                     HttpSession session) {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNumber", page);
        paramMap.put("pageSize", limit);
        paramMap.put("type", type);
        paramMap.put("currentUser", tUser.getfId());
        return ManageResult.ok(bBookListService.queryPageByParam(paramMap));
    }


    /**
     * 评价界面
     *
     * @return
     */

    @RequestMapping("/lookEvalute")
    public String golookEvalute(Model model) {
        Integer eva1=bEvaluteService.countByEva("内容好");
        Integer eva2=bEvaluteService.countByEva("质量合格");
        Integer eva3=bEvaluteService.countByEva("难易适度");
        Integer eva4=bEvaluteService.countByEva("印刷差");
        Integer eva5=bEvaluteService.countByEva("不易理解");
        model.addAttribute("eva1",eva1);
        model.addAttribute("eva2",eva2);
        model.addAttribute("eva3",eva3);
        model.addAttribute("eva4",eva4);
        model.addAttribute("eva5",eva5);
        return "teacher/Lookevalute";
    }

    /**
     * 评价信息
     *
     * @param page
     * @param limit
     *
     * @return
     */
    @RequestMapping("/showevaluteList")
    @ResponseBody
    public ManageResult evalute(@RequestParam(defaultValue = "1", required = false) Integer page,
                                @RequestParam(defaultValue = "10", required = false) Integer limit,
                                HttpSession session) {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNumber", page);
        paramMap.put("pageSize", limit);
        paramMap.put("currentUser", tUser.getfId());
        return ManageResult.ok(bApplyBookService.EvaluteForTeacher(paramMap));
    }


    /**
     * 提交选书申请
     *
     * @param bApplyBook
     * @param session    获取当前操作用户
     * @return
     */
    @RequestMapping("/applyBook")
    @ResponseBody
    public ManageResult applyBook(BApplyBook bApplyBook,
                                  HttpSession session) {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        bApplyBook.setfUserId(tUser.getfId());
        bApplyBook.setfState(String.valueOf(ApplyBookEnum.waitReview.getCode()));
        try {
            if (bApplyBookService.insertSelective(bApplyBook) != null) {
                return ManageResult.ok();
            }
        } catch (Exception e) {
            return ManageResult.fail();
        }
        return ManageResult.ok();
    }


    /**
     * 退选课本
     *
     * @param fId
     * @return
     */
    @RequestMapping("/deleteApply")
    @ResponseBody
    public ManageResult deleteApply(@RequestParam Integer fId) {
        BApplyBook bApplyBook = new BApplyBook();
        bApplyBook.setfId(fId);
        bApplyBook.setfDeleteFlag(true);
        if (bApplyBookService.updateByPrimaryKeySelective(bApplyBook) > 0) {
            return ManageResult.ok();
        } else {
            return ManageResult.fail();
        }
    }

    /**
     * 结束申请
     *
     * @param fId
     * @return
     */
    @RequestMapping("/exit")
    @ResponseBody
    public ManageResult exit(@RequestParam Integer fId) {
        BApplyBook bApplyBook = new BApplyBook();
        bApplyBook.setfId(fId);
        bApplyBook.setfState(String.valueOf(ApplyBookEnum.end.getCode()));
        if (bApplyBookService.updateByPrimaryKeySelective(bApplyBook) > 0) {
            return ManageResult.ok();
        } else {
            return ManageResult.ok();
        }
    }


    /**
     * 提交订单
     *
     * @param fId
     * @return
     */
    @RequestMapping("/order")
    @ResponseBody
    public ManageResult order(@RequestParam Integer fBookId,
                              @RequestParam Integer number,
                              @RequestParam Integer fId,
                              HttpSession session) {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);

        //改变记录状态
        BApplyBook bApplyBook = new BApplyBook();
        bApplyBook.setfId(fId);
        bApplyBook.setfState(String.valueOf(ApplyBookEnum.waitorder.getCode()));
        bApplyBookService.updateByPrimaryKeySelective(bApplyBook);
        //提交订单
        BBookOrder bBookOrder = new BBookOrder();
        bBookOrder.setfBookId(fId);
        bBookOrder.setfCreatorId(tUser.getfId());
        bBookOrder.setfOrderNumber(number);
        if (bBookOrderService.insertSelective(bBookOrder) != null) {
            return ManageResult.ok();
        } else {
            return ManageResult.ok();
        }
    }


}

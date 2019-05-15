package com.wtu.jht.bookmanage.controller.staff;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wtu.jht.bookmanage.enums.ApplyBookEnum;
import com.wtu.jht.bookmanage.modal.*;
import com.wtu.jht.bookmanage.modal.vo.BBookOrderVO;
import com.wtu.jht.bookmanage.openapi.constant.Constant;
import com.wtu.jht.bookmanage.openapi.pojo.ManageResult;
import com.wtu.jht.bookmanage.service.BApplyBookService;
import com.wtu.jht.bookmanage.service.BBookOrderService;
import com.wtu.jht.bookmanage.service.BResponsitoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：LY
 * @date ：Created in 2019/5/11 10:22
 * @description：订单控制器
 * @modified By：
 * @version: $
 */

@Controller
@RequestMapping("/staff")
public class OrderController {

    private final BBookOrderService bBookOrderService;

    private final BApplyBookService bApplyBookService;

    private final BResponsitoryService bResponsitoryService;


    public OrderController(BBookOrderService bBookOrderService,
                           BApplyBookService bApplyBookService,
                           BResponsitoryService bResponsitoryService) {
        this.bApplyBookService=bApplyBookService;
        this.bBookOrderService=bBookOrderService;
        this.bResponsitoryService=bResponsitoryService;
    }

    @RequestMapping("/order")
    public  String ui(){
        return "staff/order";
    }


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
        return ManageResult.ok(bBookOrderService.queryList(paramMap));
    }


    /**
     * 发货
     * @param
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    //fBookId为申请表id 设计时出错
    public ManageResult edit(Integer fBookId,Integer number){
        //更新申请表状态
        BApplyBook bApplyBook=new BApplyBook();
        bApplyBook.setfId(fBookId);
        bApplyBook.setfState(String.valueOf(ApplyBookEnum.order.getCode()));
        bApplyBookService.updateByPrimaryKeySelective(bApplyBook);

        List<BResponsitory> list=bResponsitoryService.updateByBookId(Integer.valueOf(bApplyBookService.selectByPrimaryKey(fBookId).getfBookId()));
        if (list.size()>0){
            BResponsitory bResponsitory=list.get(0);
            Integer result_number=bResponsitory.getfNumber()-number;
            bResponsitory.setfNumber(result_number);
            bResponsitoryService.updateByPrimaryKey(bResponsitory);
        }
        //减库存

        return ManageResult.ok();
    }

}

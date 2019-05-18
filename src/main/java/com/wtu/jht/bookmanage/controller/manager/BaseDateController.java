package com.wtu.jht.bookmanage.controller.manager;

import com.wtu.jht.bookmanage.modal.TDictionary;
import com.wtu.jht.bookmanage.openapi.pojo.ManageResult;
import com.wtu.jht.bookmanage.service.BApplyBookService;
import com.wtu.jht.bookmanage.service.BBookListService;
import com.wtu.jht.bookmanage.service.TDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @date ：Created in 2019/4/4 13:13
 * @description：基础数据控制器
 * @modified By：
 * @version: 1.0$
 */

@Controller
@RequestMapping("/manager/baseDate")
public class BaseDateController {

    private final BBookListService bBookListService;

    private final BApplyBookService bApplyBookService;

    private TDictionaryService tDictionaryService;

    public BaseDateController(BBookListService bBookListService,
                              BApplyBookService bApplyBookService,
                              TDictionaryService tDictionaryService){
        this.bBookListService = bBookListService;
        this.bApplyBookService = bApplyBookService;
        this.tDictionaryService=tDictionaryService;
    }
    @GetMapping
    public String goBathDate(){
        return "manager/bathDate";
    }


    /**
     * 字典数据
     */
    @GetMapping("/dict")
    @ResponseBody
    public ManageResult dictList(@RequestParam String code) {
        List<TDictionary> tDictionaryList = tDictionaryService.selectListByCriteria(code);
        return ManageResult.ok(tDictionaryList);
    }


    /**
     * 新增字典数据
     * @param tDictionary
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ManageResult add(TDictionary tDictionary){
        tDictionary.setfUpdateTime(new Date());
        if (tDictionaryService.save(tDictionary)){
            return ManageResult.ok();
        }
        return ManageResult.ok();
    }


    /**
     * 编辑字典数据
     * @param tDictionary
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public ManageResult edit(TDictionary tDictionary){
        if (tDictionaryService.save(tDictionary)){
            return ManageResult.ok();
        }
        return ManageResult.ok();
    }



    /**
     * create by: LY
     * description: 删除
     * create time: 2019/5/5 19:55
     * @Param   * @param null
     * @return
     */


    @RequestMapping("/del")
    @ResponseBody
    public ManageResult del(Integer fId){
        if (tDictionaryService.deleteByPrimaryKey(fId)>0){
            return ManageResult.ok();
        }
        return ManageResult.ok();
    }

}

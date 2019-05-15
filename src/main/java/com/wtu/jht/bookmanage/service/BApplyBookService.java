package com.wtu.jht.bookmanage.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wtu.jht.bookmanage.modal.BApplyBook;
import com.wtu.jht.bookmanage.modal.vo.BApplyBookVO;
import com.wtu.jht.bookmanage.openapi.service.api.ParentService;

import java.util.Map;

public interface BApplyBookService extends ParentService<BApplyBook> {

    public PageInfo<BApplyBookVO> QueryPage(Map<String, Object> paramMap);

    /**
     * 查询管理员审核数据
     * @param paramMap
     * @return
     */
    public PageInfo<BApplyBookVO> QueryPageForManage(Map<String, Object> paramMap);


    PageInfo<BApplyBookVO> queryPageForStudent(Map<String, Object> paramMap);

    PageInfo<BApplyBookVO> queryPageExitOrder(Map<String, Object> paramMap);

    PageInfo<BApplyBookVO> queryPageForEvalute(Map<String, Object> paramMap);

    PageInfo<BApplyBookVO> EvaluteForTeacher(Map<String, Object> paramMap);
}

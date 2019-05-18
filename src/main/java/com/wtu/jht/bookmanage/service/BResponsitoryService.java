package com.wtu.jht.bookmanage.service;

import com.github.pagehelper.PageInfo;
import com.wtu.jht.bookmanage.modal.BResponsitory;
import com.wtu.jht.bookmanage.modal.vo.BApplyBookVO;
import com.wtu.jht.bookmanage.modal.vo.BResponsitoryVO;
import com.wtu.jht.bookmanage.openapi.service.api.ParentService;

import java.util.List;
import java.util.Map;

/**
 * @author ：LY
 * @date ：Created in 2019/5/11 19:54
 * @description：
 * @modified By：
 * @version: $
 */
public interface BResponsitoryService extends ParentService<BResponsitory> {

    public List<BResponsitory> updateByBookId(Integer fBookId);

    PageInfo<BResponsitoryVO> List(Map<String, Object> paramMap);

    Boolean selectByBookId(Integer fBookId);
}

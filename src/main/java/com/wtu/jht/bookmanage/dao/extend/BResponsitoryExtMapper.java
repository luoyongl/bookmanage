package com.wtu.jht.bookmanage.dao.extend;

import com.wtu.jht.bookmanage.modal.vo.BApplyBookVO;
import com.wtu.jht.bookmanage.modal.vo.BResponsitoryVO;

import java.util.List;
import java.util.Map;

/**
 * @author ：LY
 * @date ：Created in 2019/5/15 11:45
 * @description：
 * @modified By：
 * @version: $
 */
public interface BResponsitoryExtMapper {
    List<BResponsitoryVO> LIST(Map<String, Object> paramMap);
}

package com.wtu.jht.bookmanage.dao.extend;

import com.wtu.jht.bookmanage.modal.BBookOrder;
import com.wtu.jht.bookmanage.modal.vo.BBookOrderVO;

import java.util.List;
import java.util.Map;

/**
 * @author ：LY
 * @date ：Created in 2019/5/11 13:11
 * @description：
 * @modified By：
 * @version: $
 */
public interface BBookOrderExtMapper {

    public List<BBookOrderVO> queryList(Map<String,Object> paramMap);
}

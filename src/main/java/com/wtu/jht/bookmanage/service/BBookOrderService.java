package com.wtu.jht.bookmanage.service;

import com.github.pagehelper.PageInfo;
import com.wtu.jht.bookmanage.modal.BBookOrder;
import com.wtu.jht.bookmanage.modal.vo.BBookOrderVO;
import com.wtu.jht.bookmanage.openapi.service.api.ParentService;

import java.util.List;
import java.util.Map;

/**
 * @date ：Created in 2019/5/11 12:24
 * @description：
 * @modified By：
 * @version: $
 */
public interface BBookOrderService extends ParentService<BBookOrder> {

    public PageInfo<BBookOrderVO> queryList(Map<String,Object> paramap);
}

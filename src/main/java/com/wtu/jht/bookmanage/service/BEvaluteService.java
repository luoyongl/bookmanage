package com.wtu.jht.bookmanage.service;

import com.wtu.jht.bookmanage.modal.BEvaluate;
import com.wtu.jht.bookmanage.openapi.service.api.ParentService;

/**
 * @author ：LY
 * @date ：Created in 2019/5/13 11:44
 * @description：
 * @modified By：
 * @version: $
 */
public interface BEvaluteService extends ParentService<BEvaluate> {

    public Integer countByEva(String eva);
}

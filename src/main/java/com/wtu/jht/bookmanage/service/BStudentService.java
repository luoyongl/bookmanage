package com.wtu.jht.bookmanage.service;

import com.wtu.jht.bookmanage.modal.BStudentBook;
import com.wtu.jht.bookmanage.openapi.service.api.ParentService;

/**
 * @date ：Created in 2019/5/10 16:25
 * @description：
 * @modified By：
 * @version: $
 */
public interface BStudentService extends ParentService<BStudentBook> {

    public Integer update(Integer userId,Integer bookId);

}

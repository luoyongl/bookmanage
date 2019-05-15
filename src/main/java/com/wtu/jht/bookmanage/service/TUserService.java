package com.wtu.jht.bookmanage.service;

import com.wtu.jht.bookmanage.modal.TResource;
import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.openapi.service.api.ParentService;

import java.util.List;

public interface TUserService extends ParentService<TUser> {

    /**
     * 通过用户账号获取用户信息
     *
     * @param username
     * @return
     */
    TUser selectByUserAccount(String username);


    /**
     * 查询用户资源
     *
     * @param userId 用户id
     * @return 资源列表
     */
    List<TResource> selectResource(Integer userId);


}

package com.wtu.jht.bookmanage.dao.extend;

import com.wtu.jht.bookmanage.modal.TResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TResourceExtMapper {
    /**
     * 查询用户资源
     *
     * @param userId 用户id
     * @return 资源列表
     */
    List<TResource> selectByUserId(@Param("userId") Integer userId);
}

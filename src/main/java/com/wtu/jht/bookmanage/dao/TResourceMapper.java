package com.wtu.jht.bookmanage.dao;

import com.wtu.jht.bookmanage.modal.TResource;
import com.wtu.jht.bookmanage.modal.TResourceExample;
import java.util.List;

import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface TResourceMapper extends DBInterface<TResource> {
    int countByExample(TResourceExample example);

    int deleteByExample(TResourceExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TResource record);

    int insertSelective(TResource record);

    List<TResource> selectByExample(TResourceExample example);

    TResource selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TResource record, @Param("example") TResourceExample example);

    int updateByExample(@Param("record") TResource record, @Param("example") TResourceExample example);

    int updateByPrimaryKeySelective(TResource record);

    int updateByPrimaryKey(TResource record);
}
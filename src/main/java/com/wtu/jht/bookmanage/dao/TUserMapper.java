package com.wtu.jht.bookmanage.dao;

import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.modal.TUserExample;
import java.util.List;

import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface TUserMapper extends DBInterface<TUser> {
    int countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}
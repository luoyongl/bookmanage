package com.wtu.jht.bookmanage.dao;

import com.wtu.jht.bookmanage.modal.TRoleAndResourceLink;
import com.wtu.jht.bookmanage.modal.TRoleAndResourceLinkExample;
import java.util.List;

import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface TRoleAndResourceLinkMapper extends DBInterface<TRoleAndResourceLink> {
    int countByExample(TRoleAndResourceLinkExample example);

    int deleteByExample(TRoleAndResourceLinkExample example);

    int deleteByPrimaryKey(Integer fRoleResourcesId);

    int insert(TRoleAndResourceLink record);

    int insertSelective(TRoleAndResourceLink record);

    List<TRoleAndResourceLink> selectByExample(TRoleAndResourceLinkExample example);

    TRoleAndResourceLink selectByPrimaryKey(Integer fRoleResourcesId);

    int updateByExampleSelective(@Param("record") TRoleAndResourceLink record, @Param("example") TRoleAndResourceLinkExample example);

    int updateByExample(@Param("record") TRoleAndResourceLink record, @Param("example") TRoleAndResourceLinkExample example);

    int updateByPrimaryKeySelective(TRoleAndResourceLink record);

    int updateByPrimaryKey(TRoleAndResourceLink record);
}
package com.wtu.jht.bookmanage.dao;

import com.wtu.jht.bookmanage.modal.TRoleAndUserAssociation;
import com.wtu.jht.bookmanage.modal.TRoleAndUserAssociationExample;
import java.util.List;

import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface TRoleAndUserAssociationMapper extends DBInterface<TRoleAndUserAssociation> {
    int countByExample(TRoleAndUserAssociationExample example);

    int deleteByExample(TRoleAndUserAssociationExample example);

    int deleteByPrimaryKey(Integer fRoleAndUserId);

    int insert(TRoleAndUserAssociation record);

    int insertSelective(TRoleAndUserAssociation record);

    List<TRoleAndUserAssociation> selectByExample(TRoleAndUserAssociationExample example);

    TRoleAndUserAssociation selectByPrimaryKey(Integer fRoleAndUserId);

    int updateByExampleSelective(@Param("record") TRoleAndUserAssociation record, @Param("example") TRoleAndUserAssociationExample example);

    int updateByExample(@Param("record") TRoleAndUserAssociation record, @Param("example") TRoleAndUserAssociationExample example);

    int updateByPrimaryKeySelective(TRoleAndUserAssociation record);

    int updateByPrimaryKey(TRoleAndUserAssociation record);
}
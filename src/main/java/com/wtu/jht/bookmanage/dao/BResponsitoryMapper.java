package com.wtu.jht.bookmanage.dao;

import com.wtu.jht.bookmanage.modal.BResponsitory;
import com.wtu.jht.bookmanage.modal.BResponsitoryExample;
import java.util.List;

import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface BResponsitoryMapper extends DBInterface<BResponsitory> {
    int countByExample(BResponsitoryExample example);

    int deleteByExample(BResponsitoryExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BResponsitory record);

    int insertSelective(BResponsitory record);

    List<BResponsitory> selectByExample(BResponsitoryExample example);

    BResponsitory selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BResponsitory record, @Param("example") BResponsitoryExample example);

    int updateByExample(@Param("record") BResponsitory record, @Param("example") BResponsitoryExample example);

    int updateByPrimaryKeySelective(BResponsitory record);

    int updateByPrimaryKey(BResponsitory record);
}
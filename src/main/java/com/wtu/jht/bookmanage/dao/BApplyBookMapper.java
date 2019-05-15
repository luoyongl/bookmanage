package com.wtu.jht.bookmanage.dao;

import com.wtu.jht.bookmanage.modal.BApplyBook;
import com.wtu.jht.bookmanage.modal.BApplyBookExample;
import java.util.List;

import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface BApplyBookMapper extends DBInterface<BApplyBook> {
    int countByExample(BApplyBookExample example);

    int deleteByExample(BApplyBookExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BApplyBook record);

    int insertSelective(BApplyBook record);

    List<BApplyBook> selectByExample(BApplyBookExample example);

    BApplyBook selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BApplyBook record, @Param("example") BApplyBookExample example);

    int updateByExample(@Param("record") BApplyBook record, @Param("example") BApplyBookExample example);

    int updateByPrimaryKeySelective(BApplyBook record);

    int updateByPrimaryKey(BApplyBook record);
}
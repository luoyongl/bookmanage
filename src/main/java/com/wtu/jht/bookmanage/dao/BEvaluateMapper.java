package com.wtu.jht.bookmanage.dao;

import com.wtu.jht.bookmanage.modal.BEvaluate;
import com.wtu.jht.bookmanage.modal.BEvaluateExample;
import java.util.List;

import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface BEvaluateMapper extends DBInterface<BEvaluate> {
    int countByExample(BEvaluateExample example);

    int deleteByExample(BEvaluateExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BEvaluate record);

    int insertSelective(BEvaluate record);

    List<BEvaluate> selectByExample(BEvaluateExample example);

    BEvaluate selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BEvaluate record, @Param("example") BEvaluateExample example);

    int updateByExample(@Param("record") BEvaluate record, @Param("example") BEvaluateExample example);

    int updateByPrimaryKeySelective(BEvaluate record);

    int updateByPrimaryKey(BEvaluate record);
}
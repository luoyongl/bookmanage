package com.wtu.jht.bookmanage.dao;

import com.wtu.jht.bookmanage.modal.BBookOrder;
import com.wtu.jht.bookmanage.modal.BBookOrderExample;
import java.util.List;

import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface BBookOrderMapper extends DBInterface<BBookOrder>{
    int countByExample(BBookOrderExample example);

    int deleteByExample(BBookOrderExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BBookOrder record);

    int insertSelective(BBookOrder record);

    List<BBookOrder> selectByExample(BBookOrderExample example);

    BBookOrder selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BBookOrder record, @Param("example") BBookOrderExample example);

    int updateByExample(@Param("record") BBookOrder record, @Param("example") BBookOrderExample example);

    int updateByPrimaryKeySelective(BBookOrder record);

    int updateByPrimaryKey(BBookOrder record);
}
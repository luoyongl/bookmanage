package com.wtu.jht.bookmanage.dao;

import com.wtu.jht.bookmanage.modal.BBookList;
import com.wtu.jht.bookmanage.modal.BBookListExample;
import java.util.List;

import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface BBookListMapper extends DBInterface<BBookList> {
    int countByExample(BBookListExample example);

    int deleteByExample(BBookListExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BBookList record);

    int insertSelective(BBookList record);

    List<BBookList> selectByExample(BBookListExample example);

    BBookList selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BBookList record, @Param("example") BBookListExample example);

    int updateByExample(@Param("record") BBookList record, @Param("example") BBookListExample example);

    int updateByPrimaryKeySelective(BBookList record);

    int updateByPrimaryKey(BBookList record);
}
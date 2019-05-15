package com.wtu.jht.bookmanage.dao;

import com.wtu.jht.bookmanage.modal.BStudentBook;
import com.wtu.jht.bookmanage.modal.BStudentBookExample;
import java.util.List;

import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface BStudentBookMapper extends DBInterface<BStudentBook> {
    int countByExample(BStudentBookExample example);

    int deleteByExample(BStudentBookExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BStudentBook record);

    int insertSelective(BStudentBook record);

    List<BStudentBook> selectByExample(BStudentBookExample example);

    BStudentBook selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BStudentBook record, @Param("example") BStudentBookExample example);

    int updateByExample(@Param("record") BStudentBook record, @Param("example") BStudentBookExample example);

    int updateByPrimaryKeySelective(BStudentBook record);

    int updateByPrimaryKey(BStudentBook record);
}
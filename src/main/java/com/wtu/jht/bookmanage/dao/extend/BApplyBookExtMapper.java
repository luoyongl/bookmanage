package com.wtu.jht.bookmanage.dao.extend;

import com.wtu.jht.bookmanage.modal.vo.BApplyBookVO;

import java.util.List;
import java.util.Map;

public interface BApplyBookExtMapper {

     List<BApplyBookVO> selectApplyResult(Map<String, Object> paramMap);

     List<BApplyBookVO> selectResultForManager(Map<String, Object> paramMap);

     List<BApplyBookVO> selectResultForStudent(Map<String, Object> paramMap);

     List<BApplyBookVO> selectResultExitOrder(Map<String, Object> paramMap);

     List<BApplyBookVO> selectResultForEvalute(Map<String, Object> paramMap);

     List<BApplyBookVO> EvaluteForTeacher(Map<String, Object> paramMap);

}

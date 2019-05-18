package com.wtu.jht.bookmanage.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wtu.jht.bookmanage.dao.BApplyBookMapper;
import com.wtu.jht.bookmanage.dao.extend.BApplyBookExtMapper;
import com.wtu.jht.bookmanage.enums.ApplyBookEnum;
import com.wtu.jht.bookmanage.modal.BApplyBook;
import com.wtu.jht.bookmanage.modal.BApplyBookExample;
import com.wtu.jht.bookmanage.modal.BBookList;
import com.wtu.jht.bookmanage.modal.BBookListExample;
import com.wtu.jht.bookmanage.modal.vo.BApplyBookVO;
import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import com.wtu.jht.bookmanage.openapi.exceptions.BizException;
import com.wtu.jht.bookmanage.openapi.service.base.ParentServiceImpl;
import com.wtu.jht.bookmanage.service.BApplyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BApplyBookServiceImpl extends ParentServiceImpl<BApplyBook> implements BApplyBookService {


    @Autowired
    private BApplyBookService bApplyBookService;

    private final BApplyBookMapper bApplyBookMapper;

    private final BApplyBookExtMapper bApplyBookExtMapper;

    @Autowired
    public BApplyBookServiceImpl(BApplyBookMapper bApplyBookMapper,
                                 BApplyBookExtMapper bApplyBookExtMapper){
        this.bApplyBookMapper=bApplyBookMapper;
        this.bApplyBookExtMapper=bApplyBookExtMapper;
    }


    @Override
    public PageInfo<BApplyBookVO> QueryPageForManage(Map<String, Object> paramMap) {
        try {
            BApplyBookExample example=new BApplyBookExample();
            example.createCriteria().andFDeleteFlagEqualTo(false);
            PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
            List<BApplyBookVO> dataList = bApplyBookExtMapper.selectResultForManager(paramMap);
            if (dataList.size()>0) {
                return new PageInfo<>(dataList);
            }
            return new PageInfo<BApplyBookVO>(dataList);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PageInfo<BApplyBookVO> QueryPage(Map<String, Object> paramMap) throws BizException {
        try {
            List<BApplyBookVO> res=null;

            BApplyBookExample example=new BApplyBookExample();
            example.createCriteria().andFDeleteFlagEqualTo(false);
            PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
            List<BApplyBookVO> dataList = bApplyBookExtMapper.selectApplyResult(paramMap);


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(new Date());
            String bookDte=(String)paramMap.get("bookdate");
            if (sdf.parse(bookDte).getTime()<sdf.parse(currentTime).getTime()){
                for (BApplyBook b:dataList){
                    b.setfState(String.valueOf(ApplyBookEnum.student.getCode()));
                    bApplyBookService.updateByPrimaryKeySelective(b);
                }
            }
            if (dataList.size()>0) {
                return new PageInfo<>(dataList);
            }
            return new PageInfo<BApplyBookVO>(dataList);
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public PageInfo<BApplyBookVO> queryPageForStudent(Map<String, Object> paramMap) {
        try {
            BApplyBookExample example=new BApplyBookExample();
            example.createCriteria().andFDeleteFlagEqualTo(false);
            PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
            List<BApplyBookVO> dataList = bApplyBookExtMapper.selectResultForStudent(paramMap);
            if (dataList.size()>0) {
                return new PageInfo<>(dataList);
            }
            return new PageInfo<BApplyBookVO>(dataList);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PageInfo<BApplyBookVO> queryPageExitOrder(Map<String, Object> paramMap) {
        try {
            BApplyBookExample example=new BApplyBookExample();
            example.createCriteria().andFDeleteFlagEqualTo(false);
            PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
            List<BApplyBookVO> dataList = bApplyBookExtMapper.selectResultExitOrder(paramMap);
            if (dataList.size()>0) {
                return new PageInfo<>(dataList);
            }
            return new PageInfo<BApplyBookVO>(dataList);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PageInfo<BApplyBookVO> queryPageForEvalute(Map<String, Object> paramMap) {
        try {
            BApplyBookExample example=new BApplyBookExample();
            example.createCriteria().andFDeleteFlagEqualTo(false);
            PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
            List<BApplyBookVO> dataList = bApplyBookExtMapper.selectResultForEvalute(paramMap);
            if (dataList.size()>0) {
                return new PageInfo<>(dataList);
            }
            return new PageInfo<BApplyBookVO>(dataList);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PageInfo<BApplyBookVO> EvaluteForTeacher(Map<String, Object> paramMap) {
        try {
            BApplyBookExample example=new BApplyBookExample();
            example.createCriteria().andFDeleteFlagEqualTo(false);
            PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
            List<BApplyBookVO> dataList = bApplyBookExtMapper.EvaluteForTeacher(paramMap);
            if (dataList.size()>0) {
                return new PageInfo<>(dataList);
            }
            return new PageInfo<BApplyBookVO>(dataList);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    protected DBInterface<BApplyBook> getDao() {
        return bApplyBookMapper;
    }
}

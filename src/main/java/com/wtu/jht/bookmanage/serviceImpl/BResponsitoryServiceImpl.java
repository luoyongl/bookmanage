package com.wtu.jht.bookmanage.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wtu.jht.bookmanage.dao.BResponsitoryMapper;
import com.wtu.jht.bookmanage.dao.extend.BResponsitoryExtMapper;
import com.wtu.jht.bookmanage.modal.BBookList;
import com.wtu.jht.bookmanage.modal.BBookListExample;
import com.wtu.jht.bookmanage.modal.BResponsitory;
import com.wtu.jht.bookmanage.modal.BResponsitoryExample;
import com.wtu.jht.bookmanage.modal.vo.BApplyBookVO;
import com.wtu.jht.bookmanage.modal.vo.BResponsitoryVO;
import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import com.wtu.jht.bookmanage.openapi.service.base.ParentServiceImpl;
import com.wtu.jht.bookmanage.service.BResponsitoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @date ：Created in 2019/5/11 19:55
 * @description：
 * @modified By：
 * @version: $
 */

@Service
public class BResponsitoryServiceImpl extends ParentServiceImpl<BResponsitory> implements BResponsitoryService {

   private  final BResponsitoryMapper bResponsitoryMapper;

   private  final BResponsitoryExtMapper bResponsitoryExtMapper;

   public BResponsitoryServiceImpl(BResponsitoryMapper bResponsitoryMapper,
                                   BResponsitoryExtMapper bResponsitoryExtMapper){
       this.bResponsitoryMapper=bResponsitoryMapper;
       this.bResponsitoryExtMapper=bResponsitoryExtMapper;
   }

    @Override
    public List<BResponsitory> updateByBookId(Integer fBookId) {
        BResponsitoryExample example=new BResponsitoryExample();
        example.createCriteria().andFDeleteFlagEqualTo(false).andFBookIdEqualTo(fBookId);
       return bResponsitoryMapper.selectByExample(example);
    }


    @Override
    public PageInfo<BResponsitoryVO> List(Map<String, Object> paramMap) {

        try {
            PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
            List<BResponsitoryVO> dataList =bResponsitoryExtMapper.LIST(paramMap);
            if (dataList.size()>0) {
                return new PageInfo<>(dataList);
            }
            return new PageInfo<>(dataList);
        }catch (Exception e){
            return null;
        }
    }


    @Override
    public BResponsitory selectByBookId(Integer fBookId) {
       BResponsitoryExample example=new BResponsitoryExample();
       example.createCriteria().andFBookIdEqualTo(fBookId);
       List<BResponsitory>list=bResponsitoryMapper.selectByExample(example);
       if (list.size()>0){
           return list.get(0);
       }else {
           return null;
       }
    }

    @Override
    protected DBInterface<BResponsitory> getDao() {
        return bResponsitoryMapper;
    }
}

package com.wtu.jht.bookmanage.serviceImpl;

import com.wtu.jht.bookmanage.dao.BStudentBookMapper;
import com.wtu.jht.bookmanage.modal.BStudentBook;
import com.wtu.jht.bookmanage.modal.BStudentBookExample;
import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import com.wtu.jht.bookmanage.openapi.service.base.ParentServiceImpl;
import com.wtu.jht.bookmanage.service.BStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date ：Created in 2019/5/10 16:27
 * @description：
 * @modified By：
 * @version: $
 */

@Service
public class BStudentServiceImpl extends ParentServiceImpl<BStudentBook> implements BStudentService {

    private final BStudentBookMapper bStudentBookMapper;

    @Autowired
    public BStudentServiceImpl(BStudentBookMapper bStudentBookMapper){
        this.bStudentBookMapper=bStudentBookMapper;
    }




    @Override
    protected DBInterface<BStudentBook> getDao() {
        return bStudentBookMapper;
    }

    @Override
    public Integer update(Integer userId, Integer bookId ) {
        BStudentBookExample example=new BStudentBookExample();
        example.createCriteria().andFBookIdEqualTo(bookId).andFUserIdEqualTo(userId)
                .andFDeleteFlagEqualTo(false);
        try {
            List<BStudentBook> bsList=bStudentBookMapper.selectByExample(example);
            ;bsList.get(0).setfDeleteFlag(true);
          return bStudentBookMapper.updateByPrimaryKeySelective(bsList.get(0));
        }catch (Exception e){
            return 0;
        }
    }

}

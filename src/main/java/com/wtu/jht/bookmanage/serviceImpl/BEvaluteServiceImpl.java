package com.wtu.jht.bookmanage.serviceImpl;

import com.wtu.jht.bookmanage.dao.BEvaluateMapper;
import com.wtu.jht.bookmanage.dao.BResponsitoryMapper;
import com.wtu.jht.bookmanage.modal.BEvaluate;
import com.wtu.jht.bookmanage.modal.BEvaluateExample;
import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import com.wtu.jht.bookmanage.openapi.service.base.ParentServiceImpl;
import com.wtu.jht.bookmanage.service.BEvaluteService;
import org.springframework.stereotype.Service;

/**
 * @author ：LY
 * @date ：Created in 2019/5/13 11:45
 * @description：
 * @modified By：
 * @version: $
 */

@Service
public class BEvaluteServiceImpl extends ParentServiceImpl<BEvaluate>  implements BEvaluteService {

    private  final BEvaluateMapper bEvaluateMapper;

    public BEvaluteServiceImpl(BEvaluateMapper bEvaluateMapper){
        this.bEvaluateMapper=bEvaluateMapper;
    }


    @Override
    public Integer countByEva(String eva) {

        BEvaluateExample example=new BEvaluateExample();
        example.createCriteria().andFListLike("%"+eva+"%");
        return bEvaluateMapper.selectByExample(example).size();
    }

    @Override
    protected DBInterface<BEvaluate> getDao() {
        return bEvaluateMapper;
    }
}

package com.wtu.jht.bookmanage.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wtu.jht.bookmanage.dao.BBookOrderMapper;
import com.wtu.jht.bookmanage.dao.extend.BBookOrderExtMapper;
import com.wtu.jht.bookmanage.modal.BApplyBookExample;
import com.wtu.jht.bookmanage.modal.BBookOrder;
import com.wtu.jht.bookmanage.modal.vo.BApplyBookVO;
import com.wtu.jht.bookmanage.modal.vo.BBookOrderVO;
import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import com.wtu.jht.bookmanage.openapi.service.base.ParentServiceImpl;
import com.wtu.jht.bookmanage.service.BBookOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @date ：Created in 2019/5/11 12:25
 * @description：
 * @modified By：
 * @version: $
 */

@Service
public class BBookOrderServiceImpl extends ParentServiceImpl<BBookOrder> implements BBookOrderService {

    private final BBookOrderMapper bBookOrderMapper;

    private final BBookOrderExtMapper bBookOrderExtMapper;

    public BBookOrderServiceImpl(BBookOrderMapper bBookOrderMapper,
                                 BBookOrderExtMapper bBookOrderExtMapper) {
        this.bBookOrderMapper = bBookOrderMapper;
        this.bBookOrderExtMapper=bBookOrderExtMapper;
    }

    @Override
    protected DBInterface<BBookOrder> getDao() {
        return bBookOrderMapper;
    }

    @Override
    public PageInfo<BBookOrderVO> queryList(Map<String, Object> paramap) {
        try {
            PageHelper.startPage((Integer) paramap.get("pageNumber"), (Integer) paramap.get("pageSize"));
            List<BBookOrderVO> dataList =bBookOrderExtMapper.queryList(paramap) ;
            if (dataList.size() > 0) {
                return new PageInfo<BBookOrderVO>(dataList);
            }
            return new PageInfo<BBookOrderVO>(dataList);
        } catch (Exception e) {
            return null;
        }
    }
}

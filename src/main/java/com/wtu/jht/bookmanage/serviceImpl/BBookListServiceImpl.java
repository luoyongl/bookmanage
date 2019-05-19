package com.wtu.jht.bookmanage.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wtu.jht.bookmanage.dao.BBookListMapper;
import com.wtu.jht.bookmanage.modal.BBookList;
import com.wtu.jht.bookmanage.modal.BBookListExample;
import com.wtu.jht.bookmanage.modal.vo.BApplyBookVO;
import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import com.wtu.jht.bookmanage.openapi.exceptions.BizException;
import com.wtu.jht.bookmanage.openapi.service.base.ParentServiceImpl;
import com.wtu.jht.bookmanage.service.BBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BBookListServiceImpl extends ParentServiceImpl<BBookList> implements BBookListService {

    private final BBookListMapper bBookListMapper;

    @Autowired
    public BBookListServiceImpl(BBookListMapper bBookListMapper){
        this.bBookListMapper=bBookListMapper;
    }

    @Override
    public PageInfo<BBookList> queryPageByParam(Map<String, Object> paramMap) throws BizException {

        try {
            BBookListExample example=new BBookListExample();

            if((Integer) paramMap.get("type")==1){
                if (!paramMap.get("keyword").equals("") && paramMap.get("keyword")!=null){
                    example.createCriteria().andFDeleteFlagEqualTo(false).andFBookIswriteEqualTo(false).andFBookNameLike((String) paramMap.get("keyword"));
                }else {
                    example.createCriteria().andFDeleteFlagEqualTo(false).andFBookIswriteEqualTo(false);
                }

            }else {
                if (paramMap.get("keyword")!="" && paramMap.get("keyword")!=null){
                    example.createCriteria().andFDeleteFlagEqualTo(false).andFWriteIdEqualTo((Integer) paramMap.get("currentUser")).andFBookNameLike((String) paramMap.get("keyword"));
                }else {
                    example.createCriteria().andFDeleteFlagEqualTo(false).andFWriteIdEqualTo((Integer) paramMap.get("currentUser"));
                }

            }

            PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
            List<BBookList> dataList = bBookListMapper.selectByExample(example);
            if (dataList.size()>0) {
                return new PageInfo<>(dataList);
            }
            return new PageInfo<>(dataList);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    protected DBInterface<BBookList> getDao() {
        return bBookListMapper;
    }


}

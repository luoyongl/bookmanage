package com.wtu.jht.bookmanage.serviceImpl;

import com.wtu.jht.bookmanage.dao.TDictionaryMapper;
import com.wtu.jht.bookmanage.modal.TDictionary;
import com.wtu.jht.bookmanage.modal.TDictionaryExample;
import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import com.wtu.jht.bookmanage.openapi.service.base.ParentServiceImpl;
import com.wtu.jht.bookmanage.service.TDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
public class TDictionaryServiceImpl extends ParentServiceImpl<TDictionary> implements TDictionaryService {

    private final TDictionaryMapper dictionaryMapper;
    


    /**
     * f_dictionary_code为key的,同一类词典
     */
    private ConcurrentMap<String, List<TDictionary>> dictMap;

    @Autowired
    public TDictionaryServiceImpl(TDictionaryMapper dictionaryMapper) {
        this.dictionaryMapper = dictionaryMapper;
    }

    /**
     * <p>
     * 由于在本系统中使用<b>f_dictionary_code</b>作为类型区分key,故同一类的
     * <b>f_dictionary_code</b>和<b>f_dictionary_type</b>一致的,且后者是父类的<b>f_id</b>,
     * 查询list时,排除父类,即<b>f_dictionary_type=0</b>的记录
     * </p>
     *
     * @param criteria f_dictionary_code
     * @return 相同f_dictionary_code的字典list
     */
    @Override
    public List<TDictionary> selectListByCriteria(String criteria) {
            loadDictMap();
        return dictMap.get(criteria);
    }

    /**
     * 查询所有非顶级词典,并转换为ConcurrentHashMap
     * <b>字典更新必须调用该方法刷新数据</b>
     */
    private synchronized void loadDictMap() {
        TDictionaryExample tDictionaryExample = new TDictionaryExample();
        tDictionaryExample.createCriteria().andFDeleteFlagEqualTo(false);
        tDictionaryExample.setOrderByClause("f_sort");
        List<TDictionary> list = dictionaryMapper.selectByExample(tDictionaryExample);
        dictMap = list.stream().collect(Collectors.groupingByConcurrent(TDictionary::getfDictionaryCode));
    }

    @Override
    protected DBInterface<TDictionary> getDao() {
        return dictionaryMapper;
    }

    /**
     * 根据顶级字典(字典分类)
     *
     * @return 字典分类list
     */
    @Override
    public List<TDictionary> selectDictCategory() {
        TDictionaryExample tDictionaryExample = new TDictionaryExample();
        tDictionaryExample.createCriteria()
                .andFDeleteFlagEqualTo(false)
                .andFDictionaryTypeEqualTo(0);
        return dictionaryMapper.selectByExample(tDictionaryExample);
    }

    /**
     * 批量删除字典数据
     *
     * @param dictIdList 字典d列表
     * @return 删除的记录数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatch(List<Integer> dictIdList) {
        int result = 0;
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        for (Integer dictId : dictIdList) {
            TDictionary tDictionary = new TDictionary();
            tDictionary.setfDeleteFlag(true);
            tDictionary.setfId(dictId);
            tDictionary.setfUpdateTime(time);
            tDictionary.setfOperatorId(sessionUser.getfId());
            result = result + dictionaryMapper.updateByPrimaryKeySelective(tDictionary);
        }
        if (result > 0) {
            loadDictMap();
        }
        return result;
    }

    @Override
    public List<TDictionary> selectList() {
        TDictionaryExample example = new TDictionaryExample();
        example.createCriteria()
                .andFDictionaryCodeIsNotNull()
                .andFDeleteFlagEqualTo(false)
                .andFDictionaryTypeNotEqualTo(0);
        example.setOrderByClause("f_sort");
        return dictionaryMapper.selectByExample(example);
    }

    /**
     * 保存字典
     *
     * @param tDictionary 字典
     * @return 保存结果(影响的行数是否 > 0)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(TDictionary tDictionary) {
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        int result;
        if (tDictionary.getfId() != null) {
            tDictionary.setfOperatorId(sessionUser.getfId());
            tDictionary.setfUpdateTime(time);
            result = dictionaryMapper.updateByPrimaryKeySelective(tDictionary);
            loadDictMap();
        } else {
            tDictionary.setfCreatorId(sessionUser.getfId());
            tDictionary.setfCreateTime(time);
            tDictionary.setfDeleteFlag(false);
            result = dictionaryMapper.insertSelective(tDictionary);
            loadDictMap();
        }
        if (result > 0) {
            loadDictMap();
            return true;
        } else {
            return false;
        }
    }



}

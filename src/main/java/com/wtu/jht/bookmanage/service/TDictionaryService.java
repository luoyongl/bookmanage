package com.wtu.jht.bookmanage.service;



import com.wtu.jht.bookmanage.modal.TDictionary;
import com.wtu.jht.bookmanage.openapi.service.api.ParentService;

import java.util.List;
import java.util.Map;

/**
 * 数据字典service接口
 *
 * @author lxg
 * @date 2018/12/16
 */
public interface TDictionaryService extends ParentService<TDictionary> {

    List<TDictionary> selectList();

    /**
     * 根据条件查询部分字典数据
     *
     * @param criteria 查询条件,即f_dictionary_code
     * @return 部分字典数据list
     */
    List<TDictionary> selectListByCriteria(String criteria);

    /**
     * 根据顶级字典(字典分类)
     *
     * @return 字典分类list
     */
    List<TDictionary> selectDictCategory();

    /**
     * 批量删除字典数据
     *
     * @param dictIdList 字典d列表
     * @return 删除的记录数
     */
    int deleteBatch(List<Integer> dictIdList);

    /**
     * 保存字典
     *
     * @param tDictionary 字典
     * @return 保存结果(影响的行数是否 > 0)
     */
    boolean save(TDictionary tDictionary);


}

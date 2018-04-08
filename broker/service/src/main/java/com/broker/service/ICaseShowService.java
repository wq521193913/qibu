package com.broker.service;

import com.broker.domain.CaseShow;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-30 14:45:13
*/
public interface ICaseShowService {

    /**
     * 新增
     * @param caseShow
     * @return
     * @throws Exception
     */
    public void insertCaseShow(CaseShow caseShow) throws Exception;

    /**
     * 根据id修改
     * @param caseShow
     * @return
     * @throws Exception
     */
    public void updateCaseShowById(CaseShow caseShow) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteCaseShow(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public CaseShow queryCaseShowById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<CaseShow> queryCaseShowList(Map<String, Object> map) throws Exception;

    /**
     * 分页列表
     * @param map
     * @return
     */
    List<CaseShow> caseShowPageList(Map<String, Object> map);

    /**
     * 分页列表条数
     * @param map
     * @return
     */
    int caseShowPageCount(Map<String, Object> map);
}

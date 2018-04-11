package com.broker.dao;

import com.broker.domain.CaseSketch;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-04-11 22:28:57
 */
@Repository
public interface CaseSketchDao {

    /**
     * 新增
     * @param caseSketch
     * @return
     */
    public void insertCaseSketch(CaseSketch caseSketch);

    /**
     * 根据id修改
     * @param caseSketch
     * @return
     */
    public void updateCaseSketchById(CaseSketch caseSketch);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteCaseSketch(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return CaseSketch
     */
    public CaseSketch queryCaseSketchById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<CaseSketch>
     */
    public List<CaseSketch> queryCaseSketchList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<CaseSketch>
     */
    public List<CaseSketch> queryCaseSketchPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryCaseSketchPageCount(Map<String, Object> map);
}

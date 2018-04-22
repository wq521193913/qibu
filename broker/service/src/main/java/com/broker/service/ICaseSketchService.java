package com.broker.service;

import com.broker.domain.CaseSketch;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-04-11 22:28:57
*/
public interface ICaseSketchService {

    /**
     * 新增
     * @param caseSketch
     * @return
     * @throws Exception
     */
    public void insertCaseSketch(CaseSketch caseSketch) throws Exception;

    /**
     * 根据id修改
     * @param caseSketch
     * @return
     * @throws Exception
     */
    public void updateCaseSketchById(CaseSketch caseSketch) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteCaseSketch(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public CaseSketch queryCaseSketchById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<CaseSketch> queryCaseSketchList(Map<String, Object> map) throws Exception;

    /**
     * 新增
     * @param caseShowId
     * @param sketchImgList
     */
    void insertCaseSketch(Integer caseShowId, List<String> sketchImgList) throws Exception;
}

package com.broker.service.impl;

import com.broker.dao.CaseSketchDao;
import com.broker.domain.CaseSketch;
import com.broker.service.ICaseSketchService;
import com.broker.util.CustomException;
import com.broker.util.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-04-11 22:28:57
*/
@Service
public class CaseSketchServiceImpl implements ICaseSketchService {

    @Autowired
    private CaseSketchDao caseSketchDao;

    /**
     * 新增
     * @param caseSketch
     * @return
     * @throws Exception
     */
    public void insertCaseSketch(CaseSketch caseSketch) throws Exception{
        caseSketchDao.insertCaseSketch(caseSketch);
    }

    /**
     * 根据id修改
     * @param caseSketch
     * @return
     * @throws Exception
     */
    public void updateCaseSketchById(CaseSketch caseSketch) throws Exception{
        if(null == caseSketch || null == caseSketch.getUid()) throw new CustomException("参数检验有误");
        caseSketchDao.updateCaseSketchById(caseSketch);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteCaseSketch(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        caseSketchDao.deleteCaseSketch(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public CaseSketch queryCaseSketchById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return caseSketchDao.queryCaseSketchById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<CaseSketch> queryCaseSketchList(Map<String, Object> map) throws Exception{
        return caseSketchDao.queryCaseSketchList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<CaseSketch> queryCaseSketchPageList(Map<String, Object> map) throws Exception{
        return caseSketchDao.queryCaseSketchPageList(map);
    }

    /**
     * 批量新增
     * @param caseShowId
     * @param sketchImgList
     * @throws Exception
     */
    @Override
    public void insertCaseSketch(Integer caseShowId, List<String> sketchImgList) throws Exception{
        if(null == caseShowId) throw new CustomException("案例ID不可为空");
        List<CaseSketch> caseSketchList = new ArrayList<CaseSketch>();
        String rootPath = PropertiesUtils.getProperties("fileRootPath");
        for(String imgUrl : sketchImgList){
            CaseSketch caseSketch = new CaseSketch();
            caseSketch.setCaseId(caseShowId);
            if(imgUrl.indexOf(rootPath) >= 0){
               caseSketch.setImgUrl(imgUrl.substring(rootPath.length()));
            }else{
               caseSketch.setImgUrl(imgUrl);
            }
            caseSketchList.add(caseSketch);
        }
        caseSketchDao.insertCaseSketchBatch(caseSketchList);
    }
}

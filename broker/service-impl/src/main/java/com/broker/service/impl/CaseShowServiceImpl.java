package com.broker.service.impl;

import com.broker.dao.CaseShowDao;
import com.broker.domain.CaseShow;
import com.broker.service.ICaseShowService;
import com.broker.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-30 14:45:13
*/
@Service
public class CaseShowServiceImpl implements ICaseShowService {

    @Autowired
    private CaseShowDao caseShowDao;

    /**
     * 新增
     * @param caseShow
     * @return
     * @throws Exception
     */
    public void insertCaseShow(CaseShow caseShow) throws Exception{
        caseShowDao.insertCaseShow(caseShow);
    }

    /**
     * 根据id修改
     * @param caseShow
     * @return
     * @throws Exception
     */
    public void updateCaseShowById(CaseShow caseShow) throws Exception{
        if(null == caseShow || null == caseShow.getUid()) throw new CustomException("参数检验有误");
        caseShowDao.updateCaseShowById(caseShow);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteCaseShow(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        caseShowDao.deleteCaseShow(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public CaseShow queryCaseShowById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return caseShowDao.queryCaseShowById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<CaseShow> queryCaseShowList(Map<String, Object> map) throws Exception{
        return caseShowDao.queryCaseShowList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<CaseShow> queryCaseShowPageList(Map<String, Object> map) throws Exception{
        return caseShowDao.queryCaseShowPageList(map);
    }

    @Override
    public List<CaseShow> caseShowPageList(Map<String, Object> map) {
        return caseShowDao.caseShowPageList(map);
    }

    @Override
    public int caseShowPageCount(Map<String, Object> map) {
        return caseShowDao.caseShowPageCount(map);
    }
}

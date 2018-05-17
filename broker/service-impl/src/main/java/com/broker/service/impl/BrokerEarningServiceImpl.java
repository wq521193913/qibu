package com.broker.service.impl;

import com.broker.dao.BrokerEarningDao;
import com.broker.domain.BrokerEarning;
import com.broker.service.IBrokerEarningService;
import com.broker.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-30 09:27:37
*/
@Service
public class BrokerEarningServiceImpl implements IBrokerEarningService {

    @Autowired
    private BrokerEarningDao brokerEarningDao;

    /**
     * 新增
     * @param brokerEarning
     * @return
     * @throws Exception
     */
    public void insertBrokerEarning(BrokerEarning brokerEarning) throws Exception{
        brokerEarningDao.insertBrokerEarning(brokerEarning);
    }

    /**
     * 根据id修改
     * @param brokerEarning
     * @return
     * @throws Exception
     */
    public void updateBrokerEarningById(BrokerEarning brokerEarning) throws Exception{
        if(null == brokerEarning || null == brokerEarning.getUid()) throw new CustomException("参数检验有误");
        brokerEarningDao.updateBrokerEarningById(brokerEarning);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerEarning(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        brokerEarningDao.deleteBrokerEarning(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public BrokerEarning queryBrokerEarningById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return brokerEarningDao.queryBrokerEarningById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerEarning> queryBrokerEarningList(Map<String, Object> map) throws Exception{
        return brokerEarningDao.queryBrokerEarningList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerEarning> queryBrokerEarningPageList(Map<String, Object> map) throws Exception{
        return brokerEarningDao.queryBrokerEarningPageList(map);
    }

    @Override
    public BrokerEarning queryBrokerEarning(Map<String, Object> map) {
        return brokerEarningDao.queryBrokerEarning(map);
    }

    @Override
    public List<BrokerEarning> getEarningPageList(Map<String, Object> map) {
        return brokerEarningDao.getEarningPageList(map);
    }

    @Override
    public int getEarningPageCount(Map<String, Object> map) {
        return 0;
    }
}

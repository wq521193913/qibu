package com.broker.service.impl;

import com.broker.dao.BrokerActivityDao;
import com.broker.domain.BrokerActivity;
import com.broker.service.IBrokerActivityService;
import com.broker.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-30 11:04:27
*/
@Service
public class BrokerActivityServiceImpl implements IBrokerActivityService {

    @Autowired
    private BrokerActivityDao brokerActivityDao;

    /**
     * 新增
     * @param brokerActivity
     * @return
     * @throws Exception
     */
    public void insertBrokerActivity(BrokerActivity brokerActivity) throws Exception{
        brokerActivityDao.insertBrokerActivity(brokerActivity);
    }

    /**
     * 根据id修改
     * @param brokerActivity
     * @return
     * @throws Exception
     */
    public void updateBrokerActivityById(BrokerActivity brokerActivity) throws Exception{
        if(null == brokerActivity) throw new CustomException("参数检验有误");
        brokerActivityDao.updateBrokerActivityById(brokerActivity);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerActivity(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        brokerActivityDao.deleteBrokerActivity(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public BrokerActivity queryBrokerActivityById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return brokerActivityDao.queryBrokerActivityById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerActivity> queryBrokerActivityList(Map<String, Object> map) throws Exception{
        return brokerActivityDao.queryBrokerActivityList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerActivity> queryBrokerActivityPageList(Map<String, Object> map) throws Exception{
        return brokerActivityDao.queryBrokerActivityPageList(map);
    }
}

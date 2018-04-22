package com.broker.service;

import com.broker.domain.BrokerActivity;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-30 11:04:27
*/
public interface IBrokerActivityService {

    /**
     * 新增
     * @param brokerActivity
     * @return
     * @throws Exception
     */
    public void insertBrokerActivity(BrokerActivity brokerActivity) throws Exception;

    /**
     * 根据id修改
     * @param brokerActivity
     * @return
     * @throws Exception
     */
    public void updateBrokerActivityById(BrokerActivity brokerActivity) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerActivity(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public BrokerActivity queryBrokerActivityById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerActivity> queryBrokerActivityList(Map<String, Object> map) throws Exception;

}

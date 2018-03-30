package com.broker.service;

import com.broker.domain.BrokerBribe;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-30 11:04:27
*/
public interface IBrokerBribeService {

    /**
     * 新增
     * @param brokerBribe
     * @return
     * @throws Exception
     */
    public void insertBrokerBribe(BrokerBribe brokerBribe) throws Exception;

    /**
     * 根据id修改
     * @param brokerBribe
     * @return
     * @throws Exception
     */
    public void updateBrokerBribeById(BrokerBribe brokerBribe) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerBribe(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public BrokerBribe queryBrokerBribeById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerBribe> queryBrokerBribeList(Map<String, Object> map) throws Exception;

}

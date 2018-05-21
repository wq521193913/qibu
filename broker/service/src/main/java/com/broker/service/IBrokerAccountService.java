package com.broker.service;

import com.broker.domain.BrokerAccount;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-30 11:04:27
*/
public interface IBrokerAccountService {

    /**
     * 新增
     * @param brokerAccount
     * @return
     * @throws Exception
     */
    public void insertBrokerAccount(BrokerAccount brokerAccount) throws Exception;

    /**
     * 根据id修改
     * @param brokerAccount
     * @return
     * @throws Exception
     */
    public void updateBrokerAccountById(BrokerAccount brokerAccount) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerAccount(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public BrokerAccount queryBrokerAccountById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerAccount> queryBrokerAccountList(Map<String, Object> map) throws Exception;

    /**
     * 查询
     * @param brokerUserId
     * @return
     */
    BrokerAccount brokerAccountByUser(int brokerUserId);

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    BrokerAccount getBrokerAccountByUserId(Integer userId);
}

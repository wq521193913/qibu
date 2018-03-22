package com.broker.service;

import com.broker.domain.BrokerEarning;
import com.broker.util.CustomException;

import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/3/22 0022 16:10
 * @modified:
 */
public interface IBrokerEarningService {

    void insertBrokerEarning(BrokerEarning brokerEarning) throws CustomException;

    int updateBrokerEarningById(BrokerEarning brokerEarning) throws CustomException;

    int deleteBrokerEarningById(int uid) throws CustomException;

    BrokerEarning getBrokerEarningByUserId(int brokerUser);

    List<BrokerEarning> getEarningPageList(Map<String,Object> map);
}

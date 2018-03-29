package com.broker.service.impl;

import com.broker.dao.BrokerEarningDao;
import com.broker.domain.BrokerEarning;
import com.broker.service.IBrokerEarningService;
import com.broker.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @description: 经济人收益表
 * @date: 2018/3/22 0022 16:11
 * @modified:
 */
@Service
public class BrokerEarningServiceImpl implements IBrokerEarningService {

    @Autowired
    BrokerEarningDao brokerEarningDao;

    @Override
    public void insertBrokerEarning(BrokerEarning brokerEarnings) throws CustomException {

    }

    @Override
    public int updateBrokerEarningById(BrokerEarning brokerEarnings) throws CustomException {
        return 0;
    }

    @Override
    public int deleteBrokerEarningById(int uid) throws CustomException {
        return 0;
    }

    @Override
    public BrokerEarning getBrokerEarningByUserId(int brokerUser) {
        return null;
    }

    @Override
    public List<BrokerEarning> getEarningPageList(Map<String, Object> map) {
        return brokerEarningDao.getEarningPageList(map);
    }
}

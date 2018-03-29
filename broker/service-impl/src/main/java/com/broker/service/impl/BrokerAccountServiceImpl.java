package com.broker.service.impl;

import com.broker.dao.BrokerAccountDao;
import com.broker.domain.BrokerAccount;
import com.broker.service.IBrokerAccountService;
import com.broker.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrokerAccountServiceImpl implements IBrokerAccountService {

    @Autowired
    private BrokerAccountDao brokerAccountDao;

    @Override
    public void insertBrokerAccount(BrokerAccount brokerAccount) throws CustomException {
        if(null == brokerAccount) throw new CustomException("参数检验有误:null");

        if(null == brokerAccount.getBrokerUser()){
            throw new CustomException("参数检验有误:经济人ID不能为空");
        }

        brokerAccountDao.insert(brokerAccount);
    }

    @Override
    public int updateBrokerAccountById(BrokerAccount brokerAccount) throws CustomException {
        return 0;
    }

    @Override
    public int deleteBrokerAccountById(int uid) throws CustomException {
        return 0;
    }

    @Override
    public BrokerAccount getBrokerAccountByUserId(int brokerUser) {
        BrokerAccount brokerAccount = brokerAccountDao.getBrokerAccountByUserId(brokerUser);
        return brokerAccount;
    }
}

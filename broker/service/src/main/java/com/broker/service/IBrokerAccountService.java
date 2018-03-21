package com.broker.service;


import com.broker.domain.BrokerAccount;
import com.broker.util.CustomException;

public interface IBrokerAccountService {

    void insertBrokerAccount(BrokerAccount brokerAccount) throws CustomException;

    int updateBrokerAccountById(BrokerAccount brokerAccount) throws CustomException;

    int deleteBrokerAccountById(int uid) throws CustomException;

    BrokerAccount getBrokerAccountByUserId(int brokerUser);
}

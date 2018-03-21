package com.broker.dao;

import com.broker.domain.BrokerAccount;

public interface BrokerAccountMapper {
    /**
     *
     * @mbggenerated 2018-03-10
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insert(BrokerAccount record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insertSelective(BrokerAccount record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    BrokerAccount selectByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKeySelective(BrokerAccount record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKey(BrokerAccount record);

    BrokerAccount getBrokerAccountByUserId(int brokerUser);
}
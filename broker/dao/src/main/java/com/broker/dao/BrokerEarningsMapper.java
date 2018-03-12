package com.broker.dao;

import com.broker.domain.BrokerEarnings;

public interface BrokerEarningsMapper {
    /**
     *
     * @mbggenerated 2018-03-10
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insert(BrokerEarnings record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insertSelective(BrokerEarnings record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    BrokerEarnings selectByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKeySelective(BrokerEarnings record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKey(BrokerEarnings record);
}
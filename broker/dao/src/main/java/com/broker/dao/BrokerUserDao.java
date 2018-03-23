package com.broker.dao;

import com.broker.domain.BrokerUser;

import java.util.Map;

public interface BrokerUserDao {
    /**
     *
     * @mbggenerated 2018-03-10
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insert(BrokerUser record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insertSelective(BrokerUser record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    BrokerUser selectByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKeySelective(BrokerUser record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKey(BrokerUser record);

    BrokerUser getBrokerUserByKey(Map<String, Object> map);

}
package com.broker.dao;

import com.broker.domain.BrokerActivity;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerActivityDao {
    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insert(BrokerActivity record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insertSelective(BrokerActivity record);
}
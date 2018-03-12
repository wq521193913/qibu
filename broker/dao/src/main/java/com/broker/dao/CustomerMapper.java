package com.broker.dao;

import com.broker.domain.Customer;

public interface CustomerMapper {
    /**
     *
     * @mbggenerated 2018-03-10
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insert(Customer record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insertSelective(Customer record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    Customer selectByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKey(Customer record);
}
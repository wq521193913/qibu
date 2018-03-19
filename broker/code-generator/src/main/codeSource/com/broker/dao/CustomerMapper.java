package com.broker.dao;

import com.broker.domain.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}
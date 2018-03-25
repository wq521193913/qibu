package com.broker.dao;

import com.broker.domain.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerDao {
    int deleteByPrimaryKey(Integer uid);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Customer getCustomerByPhone(@Param("customerPhone") String customerPhone);
}
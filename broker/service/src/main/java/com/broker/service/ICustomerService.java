package com.broker.service;

import com.broker.domain.Customer;
import com.broker.util.Result;

import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/17 0017 上午 10:45
 * @modified:
 */
public interface ICustomerService {

    Result insertCustomer(Customer customer);

    int deleteCustomerById(int uid);

    int updateCustomerById(Customer customer);

    Customer queryCustomerById(int uid);

    List<Customer> queryCustomerList(Map<String, Object> map);
}

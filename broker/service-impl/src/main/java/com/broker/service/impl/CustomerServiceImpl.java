package com.broker.service.impl;

import com.broker.dao.CustomerMapper;
import com.broker.domain.Customer;
import com.broker.service.ICustomerService;
import com.broker.util.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/17 0017 上午 11:23
 * @modified:
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Result insertCustomer(Customer customer) {
        if(null == customer){
            return Result.getFailedResult("参数检验有误:null");
        }

        if(StringUtils.isEmpty(customer.getCustomerPhone())){
            return Result.getFailedResult("请输入客户电话");
        }

        customerMapper.insert(customer);

        return new Result();

    }

    @Override
    public int deleteCustomerById(int uid) {
        return 0;
    }

    @Override
    public int updateCustomerById(Customer customer) {
        return 0;
    }

    @Override
    public Customer queryCustomerById(int uid) {
        return null;
    }

    @Override
    public List<Customer> queryCustomerList(Map<String, Object> map) {
        return null;
    }
}

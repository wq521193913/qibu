package com.broker.service.impl;

import com.broker.dao.CustomerMapper;
import com.broker.domain.Customer;
import com.broker.service.ICustomerService;
import com.broker.util.CustomException;
import com.broker.util.CustomStringUtils;
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
    public void insertCustomer(Customer customer)  throws CustomException {
        if(null == customer){
            throw new CustomException("参数检验有误:null");
        }

        if(StringUtils.isEmpty(customer.getCustomerPhone())){
            throw new CustomException("请输入客户电话");
        }
        customer.setAddressDetail(CustomStringUtils.nullConvertEmpty(customer.getProvince()) +
                CustomStringUtils.nullConvertEmpty(customer.getCity()) +
                CustomStringUtils.nullConvertEmpty(customer.getDistrict()) +
                CustomStringUtils.nullConvertEmpty(customer.getAddress()));
        customerMapper.insert(customer);
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

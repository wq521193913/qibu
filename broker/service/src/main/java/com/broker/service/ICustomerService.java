package com.broker.service;

import com.broker.domain.Customer;
import com.broker.enumerate.CustomerAuditEnum;
import com.broker.util.CustomException;

import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/17 0017 上午 10:45
 * @modified:
 */
public interface ICustomerService {

    void insertCustomer(Customer customer) throws CustomException;

    int deleteCustomerById(int uid) throws CustomException;

    int updateCustomerById(Customer customer) throws CustomException;

    Customer queryCustomerById(int uid);

    List<Customer> queryCustomerList(Map<String, Object> map);

    List<Customer> customerPageList(Map<String, Object> map);

    int customerPageCount(Map<String, Object> map);

    /**
     * 客户审核
     * @param id
     * @param customerAuditEnum
     * @param auditRemarks
     * @return
     */
    boolean auditCustomer(Integer id, CustomerAuditEnum customerAuditEnum, String auditRemarks) throws Exception;
}

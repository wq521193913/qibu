package com.broker.dao;

import com.broker.domain.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomerDao {
    int deleteByPrimaryKey(Integer uid);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Customer getCustomerByPhone(@Param("customerPhone") String customerPhone);

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<Customer> customerPageList(Map<String, Object> map);

    int customerPageCount(Map<String, Object> map);
}
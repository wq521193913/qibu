package com.broker.dao;

import com.broker.domain.BrokerUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
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

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<BrokerUser> brokerUserPageList(Map<String, Object> map);

    /**
     * 分页查询总条数
     * @param map
     * @return
     */
    int brokerUserPageCount(Map<String, Object> map);
}
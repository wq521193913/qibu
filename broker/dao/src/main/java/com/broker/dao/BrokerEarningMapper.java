package com.broker.dao;

import com.broker.domain.BrokerEarning;

import java.util.List;
import java.util.Map;

public interface BrokerEarningMapper {
    /**
     *
     * @mbggenerated 2018-03-10
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insert(BrokerEarning record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insertSelective(BrokerEarning record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    BrokerEarning selectByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKeySelective(BrokerEarning record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKey(BrokerEarning record);

    /**
     * 列表
     * @param map
     */
    List<BrokerEarning> getEarningPageList(Map<String, Object> map);
}
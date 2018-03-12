package com.broker.dao;

import com.broker.domain.UserRole;

public interface UserRoleMapper {
    /**
     *
     * @mbggenerated 2018-03-10
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insert(UserRole record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insertSelective(UserRole record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    UserRole selectByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKey(UserRole record);
}
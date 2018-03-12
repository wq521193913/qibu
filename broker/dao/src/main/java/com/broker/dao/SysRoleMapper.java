package com.broker.dao;

import com.broker.domain.SysRole;

public interface SysRoleMapper {
    /**
     *
     * @mbggenerated 2018-03-10
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insert(SysRole record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insertSelective(SysRole record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    SysRole selectByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKey(SysRole record);
}
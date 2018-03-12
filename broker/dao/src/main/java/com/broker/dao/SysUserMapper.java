package com.broker.dao;

import com.broker.domain.SysUser;

public interface SysUserMapper {
    /**
     *
     * @mbggenerated 2018-03-10
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insert(SysUser record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insertSelective(SysUser record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    SysUser selectByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKey(SysUser record);
}
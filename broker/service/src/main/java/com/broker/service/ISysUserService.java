package com.broker.service;

import com.broker.domain.LoginInfo;
import com.broker.domain.SysUser;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-26 10:26:30
*/
public interface ISysUserService {

    /**
     * 新增
     * @param sysUser
     * @return
     * @throws Exception
     */
    public void insertSysUser(SysUser sysUser) throws Exception;

    /**
     * 根据id修改
     * @param sysUser
     * @return
     * @throws Exception
     */
    public void updateSysUserById(SysUser sysUser) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteSysUser(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public SysUser querySysUserById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<SysUser> querySysUserList(Map<String, Object> map) throws Exception;

    /**
     * 登录
     * @param userNo
     * @param password
     * @return
     * @throws Exception
     */
    LoginInfo login(String userNo, String password) throws Exception;
}

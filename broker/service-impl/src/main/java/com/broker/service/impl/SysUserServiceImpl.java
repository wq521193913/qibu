package com.broker.service.impl;

import com.broker.dao.SysUserDao;
import com.broker.domain.LoginInfo;
import com.broker.domain.SysUser;
import com.broker.service.ISysUserService;
import com.broker.util.CustomException;
import com.broker.util.MD5Utils;
import com.broker.util.TransformMapEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-26 10:26:30
*/
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 新增
     * @param sysUser
     * @return
     * @throws Exception
     */
    @Override
    public void insertSysUser(SysUser sysUser) throws Exception{
        sysUserDao.insertSysUser(sysUser);
    }

    /**
     * 根据id修改
     * @param sysUser
     * @return
     * @throws Exception
     */
    @Override
    public void updateSysUserById(SysUser sysUser) throws Exception{
        if(null == sysUser || null == sysUser.getUid()) throw new CustomException("参数检验有误");
        sysUserDao.updateSysUserById(sysUser);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public void deleteSysUser(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        sysUserDao.deleteSysUser(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public SysUser querySysUserById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return sysUserDao.querySysUserById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    @Override
    public List<SysUser> querySysUserList(Map<String, Object> map) throws Exception{
        return sysUserDao.querySysUserList(map);
    }

    @Override
    public LoginInfo login(String userNo, String password) throws Exception {

        if(null == userNo || null == password) throw new CustomException("参数检验错误");

        SysUser sysUser = sysUserDao.login(userNo, MD5Utils.getInstance().getStringMD5(password));
        if(null == sysUser){
            throw new CustomException("您输入的用户名或密码有误,请重新输入");
        }

        LoginInfo loginInfo = new LoginInfo();
        TransformMapEntity.entityToEntity(sysUser, loginInfo);
        loginInfo.setUserId(sysUser.getUid());

        return loginInfo;
    }
}

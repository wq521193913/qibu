package com.broker.service.impl;

import com.broker.domain.SysUser;
import com.broker.service.ISysUserService;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/11 0011 下午 1:40
 * @modified:
 */
@Service
@EnableEurekaClient
public class SysUserServiceImpl implements ISysUserService {

    @Override
    public void insertSysUser(SysUser sysUser) {

    }

    @Override
    public SysUser querySysUserById(Integer uid) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName("测试SysUser");
        return sysUser;
    }
}

package com.broker.service;

import com.broker.domain.SysUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/11 0011 下午 12:39
 * @modified:
 */
public interface ISysUserService {

    @RequestMapping("/broker/sysUser/insertSysUser")
    void insertSysUser(SysUser sysUser);

    @RequestMapping("/broker/sysUser/querySysUserById")
    SysUser querySysUserById(@RequestParam("uid") Integer uid);
}

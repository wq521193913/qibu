package com.broker.controller;

import com.broker.domain.SysUser;
import com.broker.service.ISysUserService;
import com.broker.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/11 0011 下午 1:46
 * @modified:
 */
@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController extends BaseController{

    final Logger logger = Logger.getLogger(SysUserController.class);

    @Autowired
    ISysUserService sysUserService;
    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "querySysUserById")
    @ResponseBody
    public Result querySysUserById(@RequestParam(value = "uid")Integer uid){
        Result result = new Result();
        try {
            List<String> serviceList = discoveryClient.getServices();
            for (String service : serviceList){
                System.out.println(service);
            }
            SysUser sysUser = sysUserService.querySysUserById(uid);
            result.setData(sysUser);
        }catch (Exception e){
            logger.error(e);
        }
        return result;
    }
}

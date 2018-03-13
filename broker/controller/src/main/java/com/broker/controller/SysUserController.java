package com.broker.controller;

import com.broker.domain.SysUser;
import com.broker.service.ISysUserService;
import com.broker.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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

    @RequestMapping(value = "querySysUser")
    @ResponseBody
    public Result querySysUserById(@RequestParam(value = "uid")Integer uid){
        Result result = new Result();
        try {
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances("broker");
            for (ServiceInstance serviceInstance : serviceInstances){
                System.out.println(serviceInstance.getUri());
                System.out.println(serviceInstance.getMetadata());
                System.out.println(serviceInstance.getUri());
            }
            SysUser sysUser = sysUserService.querySysUserById(uid);
            result.setData(sysUser);
        }catch (Exception e){
            logger.error(e);
        }
        return result;
    }
}

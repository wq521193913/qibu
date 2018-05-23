package com.broker.controller;

import com.broker.domain.BrokerUser;
import com.broker.domain.WxLoginInfo;
import com.broker.domain.WxUser;
import com.broker.service.IBrokerUserService;
import com.broker.service.IWxUserService;
import com.broker.util.CustomException;
import com.broker.util.RedisUtils;
import com.broker.util.Result;
import com.broker.util.TransformMapEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/static")
public class StaticController extends BaseController {

    final Logger logger = Logger.getLogger(WxUserController.class);
    @Autowired
    IWxUserService wxUserService;
    @Autowired
    IBrokerUserService brokerUserService;
    @Autowired
    RedisUtils redisUtils;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String testPage(){
        return "test";
    }
}

package com.broker.app.controller;

import com.broker.app.AppBaseController;
import com.broker.domain.BrokerAccount;
import com.broker.domain.WxLoginInfo;
import com.broker.service.IBrokerAccountService;
import com.broker.util.RedisUtils;
import com.broker.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/5/23 0023 下午 10:04
 * @modified:
 */

@Controller
@RequestMapping(value = "/brokerAccount")
public class BrokerAccountController extends AppBaseController {

    final Logger logger = Logger.getLogger(BrokerAccountController.class);
    @Autowired
    IBrokerAccountService brokerAccountService;
    @Autowired
    RedisUtils redisUtils;

    @RequestMapping(value = "getAccountBySession", method = RequestMethod.POST)
    @ResponseBody
    public Result getAccountBySession(@RequestHeader("token")String token){
        Result result = new Result();
        try {
            WxLoginInfo loginInfo = (WxLoginInfo)redisUtils.get("user_" + token);
            if(null == loginInfo){
                return Result.getFailedResult("您登录已失效");
            }
            BrokerAccount brokerAccount = brokerAccountService.getBrokerAccountByUserId(loginInfo.getBrokerId());
            result.setData(brokerAccount);
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }
}

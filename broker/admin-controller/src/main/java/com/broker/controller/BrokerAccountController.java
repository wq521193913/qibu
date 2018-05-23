package com.broker.controller;

import com.broker.domain.BrokerAccount;
import com.broker.domain.WxLoginInfo;
import com.broker.service.IBrokerAccountService;
import com.broker.util.CustomException;
import com.broker.util.RedisUtils;
import com.broker.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/brokerAccount")
public class BrokerAccountController extends BaseController {

    final Logger logger = Logger.getLogger(BrokerAccountController.class);
    @Autowired
    IBrokerAccountService brokerAccountService;
    @Autowired
    RedisUtils redisUtils;

    @RequestMapping(value = "insertBrokerAccount", method = RequestMethod.POST)
    @ResponseBody
    public Result insertBrokerAccount(BrokerAccount brokerAccount){
        Result result = new Result();
        try {
            brokerAccountService.insertBrokerAccount(brokerAccount);
        }catch (CustomException ce){
            logger.error("params:"+brokerAccount, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }

    @RequestMapping(value = "getBrokerAccountByUserId", method = RequestMethod.GET)
    @ResponseBody
    public Result getBrokerAccountByUserId(@RequestParam("userId")Integer userId){
        Result result = new Result();
        try {
            BrokerAccount brokerAccount = brokerAccountService.getBrokerAccountByUserId(userId);
            result.setData(brokerAccount);
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }

    @RequestMapping(value = "getAccountBySession", method = RequestMethod.POST)
    @ResponseBody
    public Result getAccountBySession(@RequestHeader("session_3rd")String session_3rd){
        Result result = new Result();
        try {
            WxLoginInfo loginInfo = (WxLoginInfo)redisUtils.get("user_" + session_3rd);
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

package com.broker.app.controller;

import com.broker.app.AppBaseController;
import com.broker.domain.BrokerUser;
import com.broker.domain.WxLoginInfo;
import com.broker.domain.WxUser;
import com.broker.service.IBrokerUserService;
import com.broker.service.IWxUserService;
import com.broker.util.CustomException;
import com.broker.util.RedisUtils;
import com.broker.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/static")
public class StaticController {

    final Logger logger = Logger.getLogger(StaticController.class);
    @Autowired
    IWxUserService wxUserService;
    @Autowired
    IBrokerUserService brokerUserService;
    @Autowired
    RedisUtils redisUtils;

    @RequestMapping(value = "/wxLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result wxLogin(WxUser wxUser, @RequestParam("iv")String iv){
        Result result = new Result();
        Map<String, Object> resultMap = new HashMap<String, Object>(1);
        try {
            boolean loginOk = wxUserService.wxLogin(wxUser, iv);
            if(!loginOk){
                return Result.getFailedResult("登录失败");
            }
            BrokerUser brokerUser = brokerUserService.getBrokerUserByOpenId(wxUser.getWxOpenId());

            if(null == brokerUser){
                resultMap.put("isRegister",false);
            }else {
                WxLoginInfo wxLoginInfo = new WxLoginInfo();
                wxLoginInfo.setBrokerId(brokerUser.getUid());
                wxLoginInfo.setBrokerName(brokerUser.getBrokerName());
                wxLoginInfo.setBrokerPhone(brokerUser.getBrokerPhone());
                resultMap.put("isRegister", true);
                redisUtils.set("user_" + wxUser.getWxOpenId(), wxLoginInfo);
            }
            resultMap.put("token", wxUser.getWxOpenId());
            result.setData(resultMap);
        }catch (CustomException ce){
            logger.error("params:" + wxUser, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            logger.error("微信用户登录异常:",e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String testPage(){
        return "test";
    }
}

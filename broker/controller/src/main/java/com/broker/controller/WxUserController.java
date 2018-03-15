package com.broker.controller;

import com.broker.domain.WxUser;
import com.broker.service.IWxUserService;
import com.broker.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


@Controller
@RequestMapping(value = "/wxUser")
public class WxUserController extends BaseController {

    final Logger logger = Logger.getLogger(WxUserController.class);
    @Autowired
    IWxUserService wxUserService;

    @RequestMapping(value = "insertWxUser", method = RequestMethod.POST)
    @ResponseBody
    public Result insertWxUser(WxUser wxUser){
       Result result = new Result();
       try {
           wxUserService.insertWxUser(wxUser);
       }catch (Exception e){
           logger.error("新增wxUser异常:",e);
           return Result.getSystemErrorMsg();
       }
       return result;
    }

    @RequestMapping(value = "getWxUserByOpenId", method = RequestMethod.GET)
    @ResponseBody
    public Result getWxUserByOpenId(@RequestParam("openId")String openId){
        Result result = new Result();
        try {
            WxUser wxUser = wxUserService.queryWxUserKey(new HashMap<String, Object>(){{
                put("openId",openId);
            }});
            if(wxUser == null) {
                result.setSuccess(false);
                result.setMsg("无法查询到此用户");
            }else{
                result.setData(wxUser);
            }
        }catch (Exception e){
            logger.error("getWxUserByOpenId异常:",e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }
}

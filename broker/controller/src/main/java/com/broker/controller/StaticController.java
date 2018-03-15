package com.broker.controller;

import com.broker.service.IWxUserService;
import com.broker.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/static")
public class StaticController extends BaseController {

    final Logger logger = Logger.getLogger(WxUserController.class);
    @Autowired
    IWxUserService wxUserService;

    @RequestMapping(value = "/wxLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result wxLogin(@RequestParam("code")String code){
        Result result = null;
        try {
            result = wxUserService.wxLogin(code);

        }catch (Exception e){
            logger.error("微信用户登录异常:",e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }
}

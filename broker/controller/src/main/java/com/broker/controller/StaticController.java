package com.broker.controller;

import com.broker.domain.WxUser;
import com.broker.service.IWxUserService;
import com.broker.util.CustomException;
import com.broker.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/static")
public class StaticController extends BaseController {

    final Logger logger = Logger.getLogger(WxUserController.class);
    @Autowired
    IWxUserService wxUserService;

    @RequestMapping(value = "/wxLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result wxLogin(WxUser wxUser, @RequestParam("iv")String iv){
        Result result = new Result();
        try {
            boolean loginOk = wxUserService.wxLogin(wxUser, iv);
            if(!loginOk){
                return Result.getFailedResult("登录失败");
            }
        }catch (CustomException ce){
            logger.error("params:" + wxUser, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            logger.error("微信用户登录异常:",e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }
}

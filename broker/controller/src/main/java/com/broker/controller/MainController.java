package com.broker.controller;

import com.broker.service.ISysUserService;
import com.broker.util.CustomException;
import com.broker.util.Result;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/25 0025 下午 7:34
 * @modified:
 */
@Controller
public class MainController extends BaseController {

    final Logger logger = Logger.getLogger(MainController.class);
    @Autowired
    ISysUserService userService;

    @RequestMapping("/")
    public String index(){
        if(null == this.getHttpSession().getAttribute("userInfo")){
            return "login";
        }else {
            return "main";
        }
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    public Result login(@RequestParam("userNo")String userNo, @RequestParam("password")String password){
        Result result = new Result();
        try {
            boolean loginOk = userService.login(userNo, password);

        }catch (CustomException ce){
            logger.error("params:" + JSONObject.fromObject(this.request.getParameterMap()), ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }
}

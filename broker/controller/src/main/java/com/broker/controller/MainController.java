package com.broker.controller;

import com.broker.domain.LoginInfo;
import com.broker.service.ISysUserService;
import com.broker.util.*;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.HashMap;

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
    public String main(Model model){
        model.addAttribute("loginInfo", this.getHttpSession().getAttribute("loginInfo"));
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam("userNo")String userNo, @RequestParam("password")String password){
        Result result = new Result();
        try {
            LoginInfo loginInfo = userService.login(userNo, password);
            this.getHttpSession().setAttribute("loginInfo", loginInfo);
            result.setData(loginInfo);
        }catch (CustomException ce){
            logger.error("params:" + JSONObject.fromObject(this.request.getParameterMap()), ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public Result uploadFile(MultipartHttpServletRequest multipartHttpServletRequest){
        Result result = new Result();
        try {
            String filename = multipartHttpServletRequest.getFile("file").getOriginalFilename();
            String path = FastDfsUtils.getInstance().uploadFile(multipartHttpServletRequest.getFile("file").getBytes(), filename);
            result.setData(new HashMap<String, Object>(){{
                put("path", PropertiesUtils.getProperties("fileRootPath") + path);
            }});

        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
            return Result.getSystemErrorMsg();
        }
        return result;
    }
}

package com.broker.controller;

import com.broker.domain.BrokerUser;
import com.broker.service.IBrokerUserService;
import com.broker.util.CustomException;
import com.broker.util.RedisUtils;
import com.broker.util.Result;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/19 0019 下午 9:54
 * @modified:
 */
@Controller
@RequestMapping(value = "/brokerUser")
public class BrokerUserController extends BaseController {

    final Logger logger = Logger.getLogger(BrokerUserController.class);

    @Autowired
    IBrokerUserService brokerUserService;
    @Autowired
    RedisUtils redisUtils;

    @RequestMapping(value = "insertBrokerUser")
    @ResponseBody
    public Result insertBrokerUser(@RequestBody BrokerUser brokerUser, @RequestHeader(value = "session_3rd")String session_3rd){
        Result result = new Result();
        try {
            String wxData = (String) redisUtils.get(session_3rd);
            brokerUser.setOpenId(JSONObject.fromObject(wxData).get("openId").toString());
            brokerUserService.insertBrokerUser(brokerUser);
        }catch (CustomException ce){
            logger.error("params:"+brokerUser, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(), e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }
}

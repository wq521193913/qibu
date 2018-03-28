package com.broker.controller;

import com.broker.domain.BrokerUser;
import com.broker.service.IBrokerUserService;
import com.broker.util.CustomException;
import com.broker.util.PageResult;
import com.broker.util.RedisUtils;
import com.broker.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "insertBrokerUser", method = RequestMethod.POST)
    @ResponseBody
    public Result insertBrokerUser(BrokerUser brokerUser, @RequestHeader(value = "session_3rd")String session_3rd){
        Result result = new Result();
        try {
            brokerUser.setOpenId(session_3rd);
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

    @RequestMapping(value = "brokerRegister", method = RequestMethod.POST)
    @ResponseBody
    public Result brokerRegister(BrokerUser brokerUser, @RequestParam(value = "inviteCode", required = false)String inviteCode,
                                 @RequestHeader(value = "session_3rd")String session_3rd){
        Result result = new Result();
        try {
            brokerUser.setOpenId(session_3rd);
            brokerUserService.insertBrokerUser(brokerUser,inviteCode);
        }catch (CustomException ce){
            logger.error("params:"+brokerUser, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(), e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }

    @RequestMapping(value = "brokerUserPageList", method = RequestMethod.GET)
    @ResponseBody
    public Result brokerUserPageList(){
        Result result = new Result();
        try {
            Map<String, Object> map = this.getWebPageParameters();

            List<BrokerUser> brokerUsers = brokerUserService.brokerUserPageList(map);
            int total = brokerUserService.brokerUserPageCount(map);

            result.setData(PageResult.getPageResult(total, map.get("page"), map.get("rows"), brokerUsers));

        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }

    @RequestMapping(value = "brokerListPage", method = RequestMethod.GET)
    public String brokerListPage(){
        return "broker/broker_list";
    }

    @RequestMapping(value = "brokerEditPage", method = RequestMethod.GET)
    public String brokerEditPage(){
        return "broker/broker_edit";
    }

}

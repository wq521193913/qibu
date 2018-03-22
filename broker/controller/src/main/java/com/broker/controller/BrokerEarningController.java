package com.broker.controller;

import com.broker.domain.BrokerEarning;
import com.broker.service.IBrokerEarningService;
import com.broker.util.CustomException;
import com.broker.util.Result;
import com.broker.util.TransformMapEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/3/22 0022 16:20
 * @modified:
 */
@Controller
@RequestMapping(value = "/brokerEarning")
public class BrokerEarningController extends BaseController {
    
    final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    IBrokerEarningService brokerEarningService;

    @RequestMapping(value = "insertBrokerEarning", method = RequestMethod.POST)
    @ResponseBody
    public Result insertBrokerEarning(BrokerEarning brokerEarning){
        Result result = new Result();
        try {
            brokerEarningService.insertBrokerEarning(brokerEarning);
        }catch (CustomException ce){
            logger.error("params:" + brokerEarning, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }

    @RequestMapping(value = "getEarningsPageList", method = RequestMethod.GET)
    @ResponseBody
    public Result getEarningPageList(){
        Result result = new Result();
        try {
            Map<String, Object> map = this.getWebPageParameters();
            List<BrokerEarning> brokerEarnings = brokerEarningService.getEarningPageList(map);
            result.setData(TransformMapEntity.getSpecifiedFieldMap("earning_source,earning_amount",brokerEarnings));
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }
}

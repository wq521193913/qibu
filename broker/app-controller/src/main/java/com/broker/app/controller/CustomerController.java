package com.broker.app.controller;

import com.broker.app.AppBaseController;
import com.broker.domain.Customer;
import com.broker.service.ICustomerService;
import com.broker.util.CustomException;
import com.broker.util.PageResult;
import com.broker.util.Result;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/17 0017 下午 12:49
 * @modified:
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController extends AppBaseController {

    final Logger logger = Logger.getLogger(CustomerController.class);
    @Autowired
    ICustomerService customerService;

    @RequestMapping(value = "insertCustomer", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCustomer(Customer customer){
        Result result = new Result();
        try {
            customer.setBrokerUser(wxLoginInfo.getBrokerId());
            customerService.insertCustomer(customer);
        }catch (CustomException ce){
            logger.error("params:" + JSONObject.fromObject(customer) ,ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
            return Result.getSystemErrorMsg();
        }
        return result;
    }

    /**
     * 我的客户
     * @return
     */
    @RequestMapping(value = "queryMyCustomer", method = RequestMethod.GET)
    @ResponseBody
    public Result queryMyCustomer(){
        Result result = new Result();
        try {
            Map<String, Object> map = this.getWebPageParameters();
            map.put("brokerUser", wxLoginInfo.getBrokerId());
            List<Customer> customers = customerService.customerPageList(map);
            int total = customerService.customerPageCount(map);
            result.setData(PageResult.getPageResult(total, map.get("page"), map.get("rows"), customers));
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
            return Result.getSystemErrorMsg();
        }
        return result;
    }

}

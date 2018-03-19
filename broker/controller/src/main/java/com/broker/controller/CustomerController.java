package com.broker.controller;

import com.broker.domain.Customer;
import com.broker.service.ICustomerService;
import com.broker.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/17 0017 下午 12:49
 * @modified:
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    final Logger logger = Logger.getLogger(CustomerController.class);
    @Autowired
    ICustomerService customerService;

    @RequestMapping(value = "insertCustomer", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCustomer(Customer customer){
        Result result = null;
        try {
            result = customerService.insertCustomer(customer);
        }catch (Exception e){
            logger.error(e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }

}

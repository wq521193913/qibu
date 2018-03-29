package com.broker.controller;

import com.broker.domain.Customer;
import com.broker.domain.WxLoginInfo;
import com.broker.service.ICustomerService;
import com.broker.util.CustomException;
import com.broker.util.PageResult;
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
 * @date: Create in 2018/3/17 0017 下午 12:49
 * @modified:
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController extends BaseController{

    final Logger logger = Logger.getLogger(CustomerController.class);
    @Autowired
    ICustomerService customerService;

    @RequestMapping(value = "insertCustomer", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCustomer(@RequestBody Customer customer){
        Result result = new Result();
        try {
            customer.setBrokerUser(((WxLoginInfo)this.getHttpSession().getAttribute("userInfo")).getBrokerId());
            customerService.insertCustomer(customer);
        }catch (CustomException ce){
            logger.error("params:"+customer,ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            logger.error(e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }

    @RequestMapping(value = "customerPageList", method = RequestMethod.GET)
    @ResponseBody
    public Result customerPageList(){
        Result result = new Result();
        try {
            Map<String,Object> map = this.getWebPageParameters();
            List<Customer> customers = customerService.customerPageList(map);
            int total = customerService.customerPageCount(map);
            result = super.defaultPageResult(total,customers);
        }catch (Exception e){
            logger.error(e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }

    @RequestMapping(value = "customerListPage", method = RequestMethod.GET)
    public String customerListPage(){
        return "customer/customer_list";
    }

}

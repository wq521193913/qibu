package com.broker.controller;

import com.broker.domain.BrokerEarning;
import com.broker.service.IBrokerEarningService;
import com.broker.util.CustomException;
import com.broker.util.Result;
import com.broker.util.TransformMapEntity;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-30 09:27:36
*/
@Controller
@RequestMapping(value = "/brokerEarning")
public class BrokerEarningController extends BaseController{
	
	private final Logger logger = Logger.getLogger(BrokerEarningController.class);

    @Autowired
    private IBrokerEarningService brokerEarningService;

    /**
     * 新增
     * @param brokerEarning
     * @return 
     * @author Administrator
     * @date 2018-03-30 09:27:36
    */
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
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerEarningController.insertBrokerEarning error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param brokerEarning
     * @return 
     * @author Administrator
     * @date 2018-03-30 09:27:36
    */
    @RequestMapping(value = "updateBrokerEarningById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateBrokerEarningById(BrokerEarning brokerEarning){
        Result result = new Result();
        try {
            brokerEarningService.updateBrokerEarningById(brokerEarning);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerEarningController.updateBrokerEarningById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-03-30 09:27:36
    */
    @RequestMapping(value = "deleteBrokerEarning", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteBrokerEarning(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            brokerEarningService.deleteBrokerEarning(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerEarningController.deleteBrokerEarning error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-03-30 09:27:36
    */
    @RequestMapping(value = "queryBrokerEarningById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryBrokerEarningById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            BrokerEarning brokerEarning = brokerEarningService.queryBrokerEarningById(id);
            if(null == brokerEarning){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(brokerEarning);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerEarningController.queryBrokerEarningById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-03-30 09:27:36
    */
    @RequestMapping(value = "queryBrokerEarningList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryBrokerEarningList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<BrokerEarning> brokerEarningList = brokerEarningService.queryBrokerEarningList(paramMap);
            result.setData(brokerEarningList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return
     * @author Administrator
     * @date 2018-03-30 09:27:36
     */
    @RequestMapping(value = "getEarningsPageList", method = RequestMethod.GET)
    @ResponseBody
    public Result getEarningsPageList(){
        Result result = new Result();
        try {
            Map<String, Object> map = this.getWebPageParameters();
            List<BrokerEarning> brokerEarnings = brokerEarningService.getEarningPageList(map);
            int total = brokerEarningService.getEarningPageCount(map);
            result.setData(TransformMapEntity.getSpecifiedFieldMap("earning_source,earning_amount",brokerEarnings));
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            return Result.getSystemErrorMsg();
        }
        return result;
    }
}

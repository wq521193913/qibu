package com.broker.app.controller;

import com.broker.app.AppBaseController;
import com.broker.domain.BrokerEarning;
import com.broker.service.IBrokerEarningService;
import com.broker.util.CustomException;
import com.broker.util.PageResult;
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
public class BrokerEarningController extends AppBaseController {
	
	private final Logger logger = Logger.getLogger(BrokerEarningController.class);

    @Autowired
    private IBrokerEarningService brokerEarningService;

    /**
     * 查询列表
     * @param
     * @return
     * @author Administrator
     * @date 2018-03-30 09:27:36
     */
    @RequestMapping(value = "getEarningPageList", method = RequestMethod.GET)
    @ResponseBody
    public Result getEarningPageList(){
        Result result = new Result();
        try {
            Map<String, Object> map = this.getWebPageParameters();
            List<BrokerEarning> brokerEarnings = brokerEarningService.getEarningPageList(map);
            int total = brokerEarningService.getEarningPageCount(map);
            result.setData(PageResult.getPageResult(total,map.get("page"), map.get("rows"),TransformMapEntity.getSpecifiedFieldMap("earningSource,earningAmount",brokerEarnings)));
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
            return Result.getSystemErrorMsg();
        }
        return result;
    }
}

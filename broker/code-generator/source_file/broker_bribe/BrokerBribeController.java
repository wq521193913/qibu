
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
 * @date 2018-03-30 11:04:27
*/
@Controller
@RequestMapping(value = "/brokerBribe")
public class BrokerBribeController {
	
	private final Logger logger = Logger.getLogger(BrokerBribeController.class);

    @Autowired
    private IBrokerBribeService brokerBribeService;

    /**
     * 新增
     * @param brokerBribe
     * @return 
     * @author Administrator
     * @date 2018-03-30 11:04:27
    */
    @RequestMapping(value = "insertBrokerBribe", method = RequestMethod.POST)
    @ResponseBody
    public Result insertBrokerBribe(BrokerBribe brokerBribe){
        Result result = new Result();
        try {
            brokerBribeService.insertBrokerBribe(brokerBribe);
        }catch (CustomException ce){
            logger.error("params:" + brokerBribe, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerBribeController.insertBrokerBribe error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param brokerBribe
     * @return 
     * @author Administrator
     * @date 2018-03-30 11:04:27
    */
    @RequestMapping(value = "updateBrokerBribeById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateBrokerBribeById(BrokerBribe brokerBribe){
        Result result = new Result();
        try {
            brokerBribeService.updateBrokerBribeById(brokerBribe);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerBribeController.updateBrokerBribeById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-03-30 11:04:27
    */
    @RequestMapping(value = "deleteBrokerBribe", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteBrokerBribe(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            brokerBribeService.deleteBrokerBribe(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerBribeController.deleteBrokerBribe error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-03-30 11:04:27
    */
    @RequestMapping(value = "queryBrokerBribeById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryBrokerBribeById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            BrokerBribe brokerBribe = brokerBribeService.queryBrokerBribeById(id);
            if(null == brokerBribe){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(brokerBribe);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerBribeController.queryBrokerBribeById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-03-30 11:04:27
    */
    @RequestMapping(value = "queryBrokerBribeList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryBrokerBribeList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<BrokerBribe> brokerBribeList = brokerBribeService.queryBrokerBribeList(paramMap);
            result.setData(brokerBribeList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerBribeController.queryBrokerBribeList error:", e);
        }
        return result;
    }
}

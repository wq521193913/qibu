
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
@RequestMapping(value = "/brokerActivity")
public class BrokerActivityController {
	
	private final Logger logger = Logger.getLogger(BrokerActivityController.class);

    @Autowired
    private IBrokerActivityService brokerActivityService;

    /**
     * 新增
     * @param brokerActivity
     * @return 
     * @author Administrator
     * @date 2018-03-30 11:04:27
    */
    @RequestMapping(value = "insertBrokerActivity", method = RequestMethod.POST)
    @ResponseBody
    public Result insertBrokerActivity(BrokerActivity brokerActivity){
        Result result = new Result();
        try {
            brokerActivityService.insertBrokerActivity(brokerActivity);
        }catch (CustomException ce){
            logger.error("params:" + brokerActivity, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerActivityController.insertBrokerActivity error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param brokerActivity
     * @return 
     * @author Administrator
     * @date 2018-03-30 11:04:27
    */
    @RequestMapping(value = "updateBrokerActivityById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateBrokerActivityById(BrokerActivity brokerActivity){
        Result result = new Result();
        try {
            brokerActivityService.updateBrokerActivityById(brokerActivity);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerActivityController.updateBrokerActivityById error:", e);
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
    @RequestMapping(value = "deleteBrokerActivity", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteBrokerActivity(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            brokerActivityService.deleteBrokerActivity(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerActivityController.deleteBrokerActivity error:", e);
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
    @RequestMapping(value = "queryBrokerActivityById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryBrokerActivityById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            BrokerActivity brokerActivity = brokerActivityService.queryBrokerActivityById(id);
            if(null == brokerActivity){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(brokerActivity);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerActivityController.queryBrokerActivityById error:", e);
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
    @RequestMapping(value = "queryBrokerActivityList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryBrokerActivityList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<BrokerActivity> brokerActivityList = brokerActivityService.queryBrokerActivityList(paramMap);
            result.setData(brokerActivityList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerActivityController.queryBrokerActivityList error:", e);
        }
        return result;
    }
}

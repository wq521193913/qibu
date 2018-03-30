
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
@RequestMapping(value = "/brokerAccount")
public class BrokerAccountController {
	
	private final Logger logger = Logger.getLogger(BrokerAccountController.class);

    @Autowired
    private IBrokerAccountService brokerAccountService;

    /**
     * 新增
     * @param brokerAccount
     * @return 
     * @author Administrator
     * @date 2018-03-30 11:04:27
    */
    @RequestMapping(value = "insertBrokerAccount", method = RequestMethod.POST)
    @ResponseBody
    public Result insertBrokerAccount(BrokerAccount brokerAccount){
        Result result = new Result();
        try {
            brokerAccountService.insertBrokerAccount(brokerAccount);
        }catch (CustomException ce){
            logger.error("params:" + brokerAccount, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerAccountController.insertBrokerAccount error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param brokerAccount
     * @return 
     * @author Administrator
     * @date 2018-03-30 11:04:27
    */
    @RequestMapping(value = "updateBrokerAccountById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateBrokerAccountById(BrokerAccount brokerAccount){
        Result result = new Result();
        try {
            brokerAccountService.updateBrokerAccountById(brokerAccount);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerAccountController.updateBrokerAccountById error:", e);
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
    @RequestMapping(value = "deleteBrokerAccount", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteBrokerAccount(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            brokerAccountService.deleteBrokerAccount(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerAccountController.deleteBrokerAccount error:", e);
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
    @RequestMapping(value = "queryBrokerAccountById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryBrokerAccountById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            BrokerAccount brokerAccount = brokerAccountService.queryBrokerAccountById(id);
            if(null == brokerAccount){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(brokerAccount);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerAccountController.queryBrokerAccountById error:", e);
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
    @RequestMapping(value = "queryBrokerAccountList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryBrokerAccountList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<BrokerAccount> brokerAccountList = brokerAccountService.queryBrokerAccountList(paramMap);
            result.setData(brokerAccountList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("BrokerAccountController.queryBrokerAccountList error:", e);
        }
        return result;
    }
}

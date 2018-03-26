
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
 * @date 2018-03-26 15:00:18
*/
@Controller
@RequestMapping(value = "/dbOrderQueue")
public class DbOrderQueueController {
	
	private final Logger logger = Logger.getLogger(DbOrderQueueController.class);

    @Autowired
    private IDbOrderQueueService dbOrderQueueService;

    /**
     * 新增
     * @param dbOrderQueue
     * @return 
     * @author Administrator
     * @date 2018-03-26 15:00:18
    */
    @RequestMapping(value = "insertDbOrderQueue", method = RequestMethod.POST)
    @ResponseBody
    public Result insertDbOrderQueue(DbOrderQueue dbOrderQueue){
        Result result = new Result();
        try {
            dbOrderQueueService.insertDbOrderQueue(dbOrderQueue);
        }catch (CustomException ce){
            logger.error("params:" + dbOrderQueue, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbOrderQueueController.insertDbOrderQueue error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param dbOrderQueue
     * @return 
     * @author Administrator
     * @date 2018-03-26 15:00:18
    */
    @RequestMapping(value = "updateDbOrderQueueById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateDbOrderQueueById(DbOrderQueue dbOrderQueue){
        Result result = new Result();
        try {
            dbOrderQueueService.updateDbOrderQueueById(dbOrderQueue);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbOrderQueueController.updateDbOrderQueueById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-03-26 15:00:18
    */
    @RequestMapping(value = "deleteDbOrderQueue", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteDbOrderQueue(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            dbOrderQueueService.deleteDbOrderQueue(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbOrderQueueController.deleteDbOrderQueue error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-03-26 15:00:18
    */
    @RequestMapping(value = "queryDbOrderQueueById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryDbOrderQueueById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            DbOrderQueue dbOrderQueue = dbOrderQueueService.queryDbOrderQueueById(id);
            if(null == dbOrderQueue){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(dbOrderQueue);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbOrderQueueController.queryDbOrderQueueById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-03-26 15:00:18
    */
    @RequestMapping(value = "queryDbOrderQueueList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryDbOrderQueueList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<DbOrderQueue> dbOrderQueueList = dbOrderQueueService.queryDbOrderQueueList(paramMap);
            result.setData(dbOrderQueueList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbOrderQueueController.queryDbOrderQueueList error:", e);
        }
        return result;
    }
}

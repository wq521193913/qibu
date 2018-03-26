
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
 * @date 2018-03-26 15:00:17
*/
@Controller
@RequestMapping(value = "/dbOrderReserver")
public class DbOrderReserverController {
	
	private final Logger logger = Logger.getLogger(DbOrderReserverController.class);

    @Autowired
    private IDbOrderReserverService dbOrderReserverService;

    /**
     * 新增
     * @param dbOrderReserver
     * @return 
     * @author Administrator
     * @date 2018-03-26 15:00:17
    */
    @RequestMapping(value = "insertDbOrderReserver", method = RequestMethod.POST)
    @ResponseBody
    public Result insertDbOrderReserver(DbOrderReserver dbOrderReserver){
        Result result = new Result();
        try {
            dbOrderReserverService.insertDbOrderReserver(dbOrderReserver);
        }catch (CustomException ce){
            logger.error("params:" + dbOrderReserver, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbOrderReserverController.insertDbOrderReserver error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param dbOrderReserver
     * @return 
     * @author Administrator
     * @date 2018-03-26 15:00:17
    */
    @RequestMapping(value = "updateDbOrderReserverById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateDbOrderReserverById(DbOrderReserver dbOrderReserver){
        Result result = new Result();
        try {
            dbOrderReserverService.updateDbOrderReserverById(dbOrderReserver);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbOrderReserverController.updateDbOrderReserverById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-03-26 15:00:17
    */
    @RequestMapping(value = "deleteDbOrderReserver", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteDbOrderReserver(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            dbOrderReserverService.deleteDbOrderReserver(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbOrderReserverController.deleteDbOrderReserver error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-03-26 15:00:17
    */
    @RequestMapping(value = "queryDbOrderReserverById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryDbOrderReserverById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            DbOrderReserver dbOrderReserver = dbOrderReserverService.queryDbOrderReserverById(id);
            if(null == dbOrderReserver){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(dbOrderReserver);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbOrderReserverController.queryDbOrderReserverById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-03-26 15:00:17
    */
    @RequestMapping(value = "queryDbOrderReserverList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryDbOrderReserverList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<DbOrderReserver> dbOrderReserverList = dbOrderReserverService.queryDbOrderReserverList(paramMap);
            result.setData(dbOrderReserverList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbOrderReserverController.queryDbOrderReserverList error:", e);
        }
        return result;
    }
}

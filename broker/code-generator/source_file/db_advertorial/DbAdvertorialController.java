
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
@RequestMapping(value = "/dbAdvertorial")
public class DbAdvertorialController {
	
	private final Logger logger = Logger.getLogger(DbAdvertorialController.class);

    @Autowired
    private IDbAdvertorialService dbAdvertorialService;

    /**
     * 新增
     * @param dbAdvertorial
     * @return 
     * @author Administrator
     * @date 2018-03-26 15:00:18
    */
    @RequestMapping(value = "insertDbAdvertorial", method = RequestMethod.POST)
    @ResponseBody
    public Result insertDbAdvertorial(DbAdvertorial dbAdvertorial){
        Result result = new Result();
        try {
            dbAdvertorialService.insertDbAdvertorial(dbAdvertorial);
        }catch (CustomException ce){
            logger.error("params:" + dbAdvertorial, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbAdvertorialController.insertDbAdvertorial error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param dbAdvertorial
     * @return 
     * @author Administrator
     * @date 2018-03-26 15:00:18
    */
    @RequestMapping(value = "updateDbAdvertorialById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateDbAdvertorialById(DbAdvertorial dbAdvertorial){
        Result result = new Result();
        try {
            dbAdvertorialService.updateDbAdvertorialById(dbAdvertorial);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbAdvertorialController.updateDbAdvertorialById error:", e);
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
    @RequestMapping(value = "deleteDbAdvertorial", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteDbAdvertorial(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            dbAdvertorialService.deleteDbAdvertorial(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbAdvertorialController.deleteDbAdvertorial error:", e);
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
    @RequestMapping(value = "queryDbAdvertorialById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryDbAdvertorialById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            DbAdvertorial dbAdvertorial = dbAdvertorialService.queryDbAdvertorialById(id);
            if(null == dbAdvertorial){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(dbAdvertorial);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbAdvertorialController.queryDbAdvertorialById error:", e);
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
    @RequestMapping(value = "queryDbAdvertorialList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryDbAdvertorialList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<DbAdvertorial> dbAdvertorialList = dbAdvertorialService.queryDbAdvertorialList(paramMap);
            result.setData(dbAdvertorialList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("DbAdvertorialController.queryDbAdvertorialList error:", e);
        }
        return result;
    }
}

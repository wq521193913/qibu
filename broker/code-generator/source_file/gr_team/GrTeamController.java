
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
 * @date 2018-04-18 18:07:56
*/
@Controller
@RequestMapping(value = "/grTeam")
public class GrTeamController {
	
	private final Logger logger = Logger.getLogger(GrTeamController.class);

    @Autowired
    private IGrTeamService grTeamService;

    /**
     * 新增
     * @param grTeam
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:56
    */
    @RequestMapping(value = "insertGrTeam", method = RequestMethod.POST)
    @ResponseBody
    public Result insertGrTeam(GrTeam grTeam){
        Result result = new Result();
        try {
            grTeamService.insertGrTeam(grTeam);
        }catch (CustomException ce){
            logger.error("params:" + grTeam, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrTeamController.insertGrTeam error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param grTeam
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:56
    */
    @RequestMapping(value = "updateGrTeamById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateGrTeamById(GrTeam grTeam){
        Result result = new Result();
        try {
            grTeamService.updateGrTeamById(grTeam);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrTeamController.updateGrTeamById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-04-18 18:07:56
    */
    @RequestMapping(value = "deleteGrTeam", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteGrTeam(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            grTeamService.deleteGrTeam(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrTeamController.deleteGrTeam error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:56
    */
    @RequestMapping(value = "queryGrTeamById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryGrTeamById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            GrTeam grTeam = grTeamService.queryGrTeamById(id);
            if(null == grTeam){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(grTeam);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrTeamController.queryGrTeamById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:56
    */
    @RequestMapping(value = "queryGrTeamList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryGrTeamList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<GrTeam> grTeamList = grTeamService.queryGrTeamList(paramMap);
            result.setData(grTeamList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrTeamController.queryGrTeamList error:", e);
        }
        return result;
    }
}

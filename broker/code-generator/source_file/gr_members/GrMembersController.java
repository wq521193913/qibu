
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
 * @date 2018-04-18 18:07:57
*/
@Controller
@RequestMapping(value = "/grMembers")
public class GrMembersController {
	
	private final Logger logger = Logger.getLogger(GrMembersController.class);

    @Autowired
    private IGrMembersService grMembersService;

    /**
     * 新增
     * @param grMembers
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:57
    */
    @RequestMapping(value = "insertGrMembers", method = RequestMethod.POST)
    @ResponseBody
    public Result insertGrMembers(GrMembers grMembers){
        Result result = new Result();
        try {
            grMembersService.insertGrMembers(grMembers);
        }catch (CustomException ce){
            logger.error("params:" + grMembers, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrMembersController.insertGrMembers error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param grMembers
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:57
    */
    @RequestMapping(value = "updateGrMembersById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateGrMembersById(GrMembers grMembers){
        Result result = new Result();
        try {
            grMembersService.updateGrMembersById(grMembers);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrMembersController.updateGrMembersById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-04-18 18:07:57
    */
    @RequestMapping(value = "deleteGrMembers", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteGrMembers(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            grMembersService.deleteGrMembers(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrMembersController.deleteGrMembers error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:57
    */
    @RequestMapping(value = "queryGrMembersById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryGrMembersById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            GrMembers grMembers = grMembersService.queryGrMembersById(id);
            if(null == grMembers){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(grMembers);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrMembersController.queryGrMembersById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:57
    */
    @RequestMapping(value = "queryGrMembersList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryGrMembersList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<GrMembers> grMembersList = grMembersService.queryGrMembersList(paramMap);
            result.setData(grMembersList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrMembersController.queryGrMembersList error:", e);
        }
        return result;
    }
}

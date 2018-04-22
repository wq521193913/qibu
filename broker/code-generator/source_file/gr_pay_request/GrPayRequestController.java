
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
@RequestMapping(value = "/grPayRequest")
public class GrPayRequestController {
	
	private final Logger logger = Logger.getLogger(GrPayRequestController.class);

    @Autowired
    private IGrPayRequestService grPayRequestService;

    /**
     * 新增
     * @param grPayRequest
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:56
    */
    @RequestMapping(value = "insertGrPayRequest", method = RequestMethod.POST)
    @ResponseBody
    public Result insertGrPayRequest(GrPayRequest grPayRequest){
        Result result = new Result();
        try {
            grPayRequestService.insertGrPayRequest(grPayRequest);
        }catch (CustomException ce){
            logger.error("params:" + grPayRequest, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrPayRequestController.insertGrPayRequest error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param grPayRequest
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:56
    */
    @RequestMapping(value = "updateGrPayRequestById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateGrPayRequestById(GrPayRequest grPayRequest){
        Result result = new Result();
        try {
            grPayRequestService.updateGrPayRequestById(grPayRequest);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrPayRequestController.updateGrPayRequestById error:", e);
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
    @RequestMapping(value = "deleteGrPayRequest", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteGrPayRequest(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            grPayRequestService.deleteGrPayRequest(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrPayRequestController.deleteGrPayRequest error:", e);
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
    @RequestMapping(value = "queryGrPayRequestById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryGrPayRequestById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            GrPayRequest grPayRequest = grPayRequestService.queryGrPayRequestById(id);
            if(null == grPayRequest){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(grPayRequest);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrPayRequestController.queryGrPayRequestById error:", e);
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
    @RequestMapping(value = "queryGrPayRequestList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryGrPayRequestList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<GrPayRequest> grPayRequestList = grPayRequestService.queryGrPayRequestList(paramMap);
            result.setData(grPayRequestList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrPayRequestController.queryGrPayRequestList error:", e);
        }
        return result;
    }
}

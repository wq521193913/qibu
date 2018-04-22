
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
 * @date 2018-04-18 18:07:55
*/
@Controller
@RequestMapping(value = "/grGoodsDetail")
public class GrGoodsDetailController {
	
	private final Logger logger = Logger.getLogger(GrGoodsDetailController.class);

    @Autowired
    private IGrGoodsDetailService grGoodsDetailService;

    /**
     * 新增
     * @param grGoodsDetail
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:55
    */
    @RequestMapping(value = "insertGrGoodsDetail", method = RequestMethod.POST)
    @ResponseBody
    public Result insertGrGoodsDetail(GrGoodsDetail grGoodsDetail){
        Result result = new Result();
        try {
            grGoodsDetailService.insertGrGoodsDetail(grGoodsDetail);
        }catch (CustomException ce){
            logger.error("params:" + grGoodsDetail, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrGoodsDetailController.insertGrGoodsDetail error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param grGoodsDetail
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:55
    */
    @RequestMapping(value = "updateGrGoodsDetailById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateGrGoodsDetailById(GrGoodsDetail grGoodsDetail){
        Result result = new Result();
        try {
            grGoodsDetailService.updateGrGoodsDetailById(grGoodsDetail);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrGoodsDetailController.updateGrGoodsDetailById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-04-18 18:07:55
    */
    @RequestMapping(value = "deleteGrGoodsDetail", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteGrGoodsDetail(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            grGoodsDetailService.deleteGrGoodsDetail(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrGoodsDetailController.deleteGrGoodsDetail error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:55
    */
    @RequestMapping(value = "queryGrGoodsDetailById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryGrGoodsDetailById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            GrGoodsDetail grGoodsDetail = grGoodsDetailService.queryGrGoodsDetailById(id);
            if(null == grGoodsDetail){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(grGoodsDetail);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrGoodsDetailController.queryGrGoodsDetailById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:55
    */
    @RequestMapping(value = "queryGrGoodsDetailList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryGrGoodsDetailList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<GrGoodsDetail> grGoodsDetailList = grGoodsDetailService.queryGrGoodsDetailList(paramMap);
            result.setData(grGoodsDetailList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrGoodsDetailController.queryGrGoodsDetailList error:", e);
        }
        return result;
    }
}


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
@RequestMapping(value = "/grGoods")
public class GrGoodsController {
	
	private final Logger logger = Logger.getLogger(GrGoodsController.class);

    @Autowired
    private IGrGoodsService grGoodsService;

    /**
     * 新增
     * @param grGoods
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:55
    */
    @RequestMapping(value = "insertGrGoods", method = RequestMethod.POST)
    @ResponseBody
    public Result insertGrGoods(GrGoods grGoods){
        Result result = new Result();
        try {
            grGoodsService.insertGrGoods(grGoods);
        }catch (CustomException ce){
            logger.error("params:" + grGoods, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrGoodsController.insertGrGoods error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param grGoods
     * @return 
     * @author Administrator
     * @date 2018-04-18 18:07:55
    */
    @RequestMapping(value = "updateGrGoodsById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateGrGoodsById(GrGoods grGoods){
        Result result = new Result();
        try {
            grGoodsService.updateGrGoodsById(grGoods);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrGoodsController.updateGrGoodsById error:", e);
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
    @RequestMapping(value = "deleteGrGoods", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteGrGoods(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            grGoodsService.deleteGrGoods(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrGoodsController.deleteGrGoods error:", e);
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
    @RequestMapping(value = "queryGrGoodsById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryGrGoodsById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            GrGoods grGoods = grGoodsService.queryGrGoodsById(id);
            if(null == grGoods){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(grGoods);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrGoodsController.queryGrGoodsById error:", e);
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
    @RequestMapping(value = "queryGrGoodsList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryGrGoodsList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<GrGoods> grGoodsList = grGoodsService.queryGrGoodsList(paramMap);
            result.setData(grGoodsList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("GrGoodsController.queryGrGoodsList error:", e);
        }
        return result;
    }
}

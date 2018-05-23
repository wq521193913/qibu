package com.broker.controller;

import com.broker.domain.CaseSketch;
import com.broker.service.ICaseSketchService;
import com.broker.util.CustomException;
import com.broker.util.Result;
import org.apache.commons.lang3.exception.ExceptionUtils;
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
 * @date 2018-04-11 22:28:57
*/
@Controller
@RequestMapping(value = "/caseSketch")
public class CaseSketchController extends BaseController{
	
	private final Logger logger = Logger.getLogger(CaseSketchController.class);

    @Autowired
    private ICaseSketchService caseSketchService;

    /**
     * 新增
     * @param caseSketch
     * @return 
     * @author Administrator
     * @date 2018-04-11 22:28:57
    */
    @RequestMapping(value = "insertCaseSketch", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCaseSketch(CaseSketch caseSketch){
        Result result = new Result();
        try {
            caseSketchService.insertCaseSketch(caseSketch);
        }catch (CustomException ce){
            logger.error("params:" + caseSketch, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CaseSketchController.insertCaseSketch error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param caseSketch
     * @return 
     * @author Administrator
     * @date 2018-04-11 22:28:57
    */
    @RequestMapping(value = "updateCaseSketchById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateCaseSketchById(CaseSketch caseSketch){
        Result result = new Result();
        try {
            caseSketchService.updateCaseSketchById(caseSketch);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CaseSketchController.updateCaseSketchById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-04-11 22:28:57
    */
    @RequestMapping(value = "deleteCaseSketch", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteCaseSketch(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            caseSketchService.deleteCaseSketch(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CaseSketchController.deleteCaseSketch error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-04-11 22:28:57
    */
    @RequestMapping(value = "queryCaseSketchById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryCaseSketchById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            CaseSketch caseSketch = caseSketchService.queryCaseSketchById(id);
            if(null == caseSketch){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(caseSketch);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CaseSketchController.queryCaseSketchById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-04-11 22:28:57
    */
    @RequestMapping(value = "queryCaseSketchList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryCaseSketchList(){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = this.getWebParameters();
            List<CaseSketch> caseSketchList = caseSketchService.queryCaseSketchList(paramMap);
            result.setData(caseSketchList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }
}

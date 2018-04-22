package com.broker.controller;

import com.broker.domain.CaseShow;
import com.broker.domain.extend.CaseShowExt;
import com.broker.service.ICaseShowService;
import com.broker.util.CustomException;
import com.broker.util.PageResult;
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
 * @date 2018-03-30 14:45:13
*/
@Controller
@RequestMapping(value = "/caseShow")
public class CaseShowController extends BaseController{
	
	private final Logger logger = Logger.getLogger(CaseShowController.class);

    @Autowired
    private ICaseShowService caseShowService;

    /**
     * 新增
     * @param caseShowExt
     * @return 
     * @author Administrator
     * @date 2018-03-30 14:45:13
    */
    @RequestMapping(value = "insertCaseShow", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCaseShow(CaseShowExt caseShowExt){
        Result result = new Result();
        try {
            caseShowService.insertCaseShow(caseShowExt);
            result.setData(caseShowExt);
        }catch (CustomException ce){
            logger.error("params:" + caseShowExt, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param caseShow
     * @return 
     * @author Administrator
     * @date 2018-03-30 14:45:13
    */
    @RequestMapping(value = "updateCaseShowById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateCaseShowById(CaseShow caseShow){
        Result result = new Result();
        try {
            caseShowService.updateCaseShowById(caseShow);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CaseShowController.updateCaseShowById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-03-30 14:45:13
    */
    @RequestMapping(value = "deleteCaseShow", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteCaseShow(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            caseShowService.deleteCaseShow(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CaseShowController.deleteCaseShow error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-03-30 14:45:13
    */
    @RequestMapping(value = "queryCaseShowById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryCaseShowById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            CaseShow caseShow = caseShowService.queryCaseShowById(id);
            if(null == caseShow){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(caseShow);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CaseShowController.queryCaseShowById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-03-30 14:45:13
    */
    @RequestMapping(value = "queryCaseShowList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryCaseShowList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<CaseShow> caseShowList = caseShowService.queryCaseShowList(paramMap);
            result.setData(caseShowList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CaseShowController.queryCaseShowList error:", e);
        }
        return result;
    }

    /**
     * 查询分页列表
     * @param
     * @return
     * @author Administrator
     * @date 2018-03-30 14:45:13
     */
    @RequestMapping(value = "caseShowPageList", method = RequestMethod.GET)
    @ResponseBody
    public Result caseShowPageList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> map = this.getWebPageParameters();
            List<CaseShow> caseShowList = caseShowService.caseShowPageList(map);
            int total = caseShowService.caseShowPageCount(map);
            result.setData(PageResult.getPageResult(total, map.get("page"), map.get("rows"), caseShowList));
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }

    @RequestMapping(value = "caseListPage", method = RequestMethod.GET)
    public String caseListPage(){
        return "case/case_list";
    }

    @RequestMapping(value = "caseEditPage", method = RequestMethod.GET)
    public String caseEditPage(){
        return "case/case_edit";
    }
}

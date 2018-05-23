package com.broker.controller;

import com.broker.domain.SysUser;
import com.broker.service.ISysUserService;
import com.broker.util.CustomException;
import com.broker.util.Result;
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
 * @date 2018-03-26 10:26:30
*/
@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController {
	
	private final Logger logger = Logger.getLogger(SysUserController.class);

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 新增
     * @param sysUser
     * @return 
     * @author Administrator
     * @date 2018-03-26 10:26:30
    */
    @RequestMapping(value = "insertSysUser", method = RequestMethod.POST)
    @ResponseBody
    public Result insertSysUser(SysUser sysUser){
        Result result = new Result();
        try {
            sysUserService.insertSysUser(sysUser);
        }catch (CustomException ce){
            logger.error("params:" + sysUser, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("SysUserController.insertSysUser error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param sysUser
     * @return 
     * @author Administrator
     * @date 2018-03-26 10:26:30
    */
    @RequestMapping(value = "updateSysUserById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateSysUserById(SysUser sysUser){
        Result result = new Result();
        try {
            sysUserService.updateSysUserById(sysUser);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("SysUserController.updateSysUserById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-03-26 10:26:30
    */
    @RequestMapping(value = "deleteSysUser", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteSysUser(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            sysUserService.deleteSysUser(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("SysUserController.deleteSysUser error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-03-26 10:26:30
    */
    @RequestMapping(value = "querySysUserById", method = RequestMethod.GET)
    @ResponseBody
    public Result querySysUserById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            SysUser sysUser = sysUserService.querySysUserById(id);
            if(null == sysUser){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(sysUser);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("SysUserController.querySysUserById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-03-26 10:26:30
    */
    @RequestMapping(value = "querySysUserList", method = RequestMethod.GET)
    @ResponseBody
    public Result querySysUserList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<SysUser> sysUserList = sysUserService.querySysUserList(paramMap);
            result.setData(sysUserList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("SysUserController.querySysUserList error:", e);
        }
        return result;
    }
}

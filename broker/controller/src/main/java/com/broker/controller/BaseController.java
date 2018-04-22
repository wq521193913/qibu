package com.broker.controller;

import com.broker.util.PageResult;
import com.broker.util.Result;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/11 0011 下午 1:46
 * @modified:
 */
public class BaseController {

    public HttpServletRequest request;
    public HttpServletResponse response;
    public HttpSession session;

//    protected LoginInfo loginInfo;

    protected HttpServletRequest getServletRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpSession getHttpSession(){
        return getServletRequest().getSession();
    }

//    @ModelAttribute
//    private void setBasicInfo(HttpServletRequest request, HttpServletResponse response){
//        try {
//            loginInfo = LoginInfo.getLoginInfo(getHttpSession());
//            this.request = request;
//            this.response = response;
//            session = getHttpSession();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    /**
     * 获取页面参数
     * @return
     */
    protected Map<String, Object> getWebParameters(){
        Map<String, Object> map = WebUtils.getParametersStartingWith(getServletRequest(),"");
        return map;
    }

    /**
     * 获取分页参数 无page和rows使用默认
     * @return
     */
    protected Map<String, Object> getWebPageParameters(){
        Map<String, Object> map = WebUtils.getParametersStartingWith(getServletRequest(),"");
        int offset = 0;
        Integer rows = 10;
        Integer page = 1;
        if(map.containsKey("page") && null != map.get("page")){
            page = Integer.valueOf(map.get("page").toString());
        }
        if(map.containsKey("rows") && null != map.get("rows")){
            rows = Integer.valueOf(map.get("rows").toString());
        }
        if(page == 0) page = 1;
        offset = (page.intValue() -1)*rows;
        map.put("offset", offset);
        map.put("rows", rows);
        return map;
    }

    /**
     * 返回分页列表
     * @param total
     * @param data
     * @return
     */
    protected Result defaultPageResult(int total, Object data){
        Map<String, Object> map = this.getWebPageParameters();
        Result result = new Result();
        result.setData(PageResult.getPageResult(total, map.get("page"), map.get("rows"), data));
        return result;
    }
}

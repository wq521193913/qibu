package com.broker.app.controller.intercept;

import com.broker.domain.BrokerUser;
import com.broker.domain.LoginInfo;
import com.broker.domain.WxLoginInfo;
import com.broker.service.IBrokerUserService;
import com.broker.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerIntercept extends HandlerInterceptorAdapter {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    IBrokerUserService brokerUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().indexOf("static") <= 0){
            String token = request.getHeader("token");
            if(null != redisUtils.get("user_" + token)){

            }else {
                BrokerUser brokerUser = brokerUserService.getBrokerUserByOpenId(token);
                WxLoginInfo wxLoginInfo = new WxLoginInfo();
                wxLoginInfo.setOpenId(token);
                if(null != brokerUser){
                    wxLoginInfo.setBrokerId(brokerUser.getUid());
                    wxLoginInfo.setBrokerName(brokerUser.getBrokerName());
                    wxLoginInfo.setBrokerPhone(brokerUser.getBrokerPhone());
                }
                redisUtils.set("user_" + token, wxLoginInfo, 30*60L);
                request.getSession().setAttribute("userInfo", wxLoginInfo);

            }
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}

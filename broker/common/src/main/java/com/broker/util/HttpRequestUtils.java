package com.broker.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/4/23 0023 10:38
 * @modified:
 */
@Component
public class HttpRequestUtils {


    private static Integer lock = 0;
    private static HttpRequestUtils httpRequestUtils = null;
    private static HttpServletRequest request = null;

    public static HttpRequestUtils getInstance(){
        if(null == httpRequestUtils){
            synchronized (lock){
                request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                httpRequestUtils = new HttpRequestUtils();
            }
        }
        return httpRequestUtils;
    }

    public HttpServletRequest getRequest(){
        return request;
    }

    public String getDomainUrl(){
        StringBuffer domainUrl = new StringBuffer();
        if(null != request){
            domainUrl.append(request.getScheme())
                    .append("://")
                    .append(request.getServerName())
                    .append(":")
                    .append(request.getServerPort())
                    .append("/");
        }
        return domainUrl.toString();
    }

    public String getIpAddr() {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public String getLocalHostIp(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }
}

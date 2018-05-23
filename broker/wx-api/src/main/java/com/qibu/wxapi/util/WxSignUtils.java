package com.qibu.wxapi.util;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/4/23 0023 17:26
 * @modified:
 */
public class WxSignUtils {

    final Logger logger = Logger.getLogger(WxApiXmlUtils.class);
    public static Integer lock = 0;

    private static WxSignUtils wxSignUtils = null;

    private WxSignUtils(){}

    public static WxSignUtils getInstance(){
        if(null == wxSignUtils){
            synchronized (lock){
                if(null == wxSignUtils){
                    wxSignUtils = new WxSignUtils();
                }
            }
        }
        return wxSignUtils;
    }

    public String generateSign(JSONObject json, String appKey){
        List<String> signList = new ArrayList<String>();
        logger.info("sign json:" + json);
        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            if(key.equals("wxPackage")){
                key = "package";
            }
            signList.add(key);
        }
        Collections.sort(signList);
        logger.info("sign key:" + ArrayUtils.toString(signList));
        StringBuilder sign = new StringBuilder();
        String value = "";
        for (int i = 0; i < signList.size(); i++) {
            String key = signList.get(i);
            if(key.equals("key") || key.equals("sign")) continue;
            if(key.equals("package")){
                value = json.getString("wxPackage");
            }else {
                value = json.getString(key);
            }
            if(StringUtils.isEmpty(value)) continue;
            sign.append(key + "=" + value + "&");
        }
        sign.append("key=" + appKey);
        logger.info("sign is:" + sign);
        logger.info(" md5 sign is:" + MD5Utils.getMD5Code(sign.toString()).toUpperCase());
        return MD5Utils.getMD5Code(sign.toString()).toUpperCase();
    }
}

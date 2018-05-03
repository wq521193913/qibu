package com.broker.util.wx;

import com.broker.util.MD5Utils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
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
        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            signList.add(key);
        }
        Collections.sort(signList);
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < signList.size(); i++) {
            String key = signList.get(i);
            if(key.equals("key") || key.equals("sign")) continue;
            String value = json.optString(key);
            if(StringUtils.isEmpty(value)) continue;
            sign.append(key + "=" + value + "&");
        }
        sign.append("key=" + appKey);
        String md5Str = MD5Utils.getInstance().getStringMD5(sign.toString()).toUpperCase();
        logger.debug("sign is:" + sign);
        logger.debug(" md5 sign is:" + md5Str);
        return md5Str;
    }
}

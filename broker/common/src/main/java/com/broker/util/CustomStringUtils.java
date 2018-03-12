package com.broker.util;

import org.apache.commons.lang.StringUtils;

/**
 * 自定义值检查
 * @author: wanqing
 * @date: 2017/2/13 14:11
 */
public class CustomStringUtils extends StringUtils {

    public static boolean isNullOrZero(Integer value){
        if(null == value || value.intValue() == 0){
            return true;
        }
        return false;
    }

    public static boolean isNotNullAndZero(Integer value){
        return !CustomStringUtils.isNotNullAndZero(value);
    }

    public static boolean isEmpty(Object value){
        if(null == value || (null != value && value.toString().equals(""))){
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Object value){
        return !CustomStringUtils.isEmpty(value);
    }

    /**
     * null转空字符串
     * @param value
     * @return
     */
    public static String nullConvertEmpty(String value){
        if(null == value) return "";
        return value;
    }

    public static String quote(String arg){
        if(!StringUtils.isEmpty(arg)){
            return arg.replace("'","''");
        }
        return arg;
    }
}

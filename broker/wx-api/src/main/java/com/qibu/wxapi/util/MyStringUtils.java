package com.qibu.wxapi.util;

import org.apache.commons.lang.StringUtils;

import java.util.Random;
import java.util.UUID;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/4/19 0019 19:58
 * @modified:
 */
public class MyStringUtils{

    int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private static final Integer lock = 0;

    private static MyStringUtils myStringUtils;

    private MyStringUtils(){}

    public static MyStringUtils getInstance(){
        if(null == myStringUtils){
            synchronized (lock){
                if(null == myStringUtils){
                    myStringUtils = new MyStringUtils();
                }
            }
        }
        return myStringUtils;
    }

    /**
     * 获取随机数(时间戳+3位数)
     * @return
     */
    public String getRandomStr(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        Random random = new Random();
        int index = 0;
        for(int i = 0; i < 3; i++){
            index = random.nextInt(10);
            stringBuilder.append(intArray[index]);
        }
        return stringBuilder.toString();
    }

    /**
     * 组合成key-value形式
     * @param key
     * @param values
     * @return
     */
    public String keyValueStr(String key, String... values){
        if(null == key || values.length <=0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        if(key.indexOf(";") > 0){
            String[] str = key.split(";");
            for(int i = 0; i < str.length; i++){
                if(StringUtils.isNotEmpty(str[i])){
                    stringBuilder.append(str[i] + ":" + values[i] + ";");
                }
            }
        }else {
            stringBuilder.append(key + ":" + values[0] + ";");
        }
        return stringBuilder.toString();
    }

}

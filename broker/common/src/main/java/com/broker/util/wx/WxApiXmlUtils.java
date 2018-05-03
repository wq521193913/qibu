package com.broker.util.wx;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/4/24 0024 19:27
 * @modified:
 */
public class WxApiXmlUtils {

    final Logger logger = Logger.getLogger(WxApiXmlUtils.class);
    private static Integer lock = 0;

    private static WxApiXmlUtils wxApiXmlUtils = null;

    private WxApiXmlUtils(){}

    public static WxApiXmlUtils getInstance(){
        if(null == wxApiXmlUtils){
            synchronized (lock){
                if(null == wxApiXmlUtils){
                    wxApiXmlUtils = new WxApiXmlUtils();
                }
            }
        }
        return wxApiXmlUtils;
    }

    /**
     * java bean 转 xml
     * @param bean
     * @return
     */
    public String beanToXml(Object bean){
        StringBuilder xmlStr = new StringBuilder();
        try {
            xmlStr.append("<xml>");
            Field[] fields = bean.getClass().getDeclaredFields();
            Object value = null;
            String name = null;
            for (Field field : fields){
                field.setAccessible(true);
                name = field.getName();
                value = field.get(bean);
                if(value == null) {
                    continue;
                }
                xmlStr.append("<").append(name).append(">").append("<![CDATA[").append(value).append("]]>").append("</").append(name).append(">");
            }
            xmlStr.append("</xml>");
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        logger.debug(xmlStr);
        return xmlStr.toString();

    }

    /**
     * xml 转 java bean
     * @param xml
     * @param tagClass
     * @param <T>
     * @return
     */
    public <T> T xmlToBean(String xml, Class<T> tagClass){
        T t = null;
        try {
            logger.debug(xml);
            t = tagClass.newInstance();
            Object value = null;
            String name = null;
            Field[] fields = tagClass.getDeclaredFields();
            for (Field field : fields){
                name = field.getName();
                if(xml.indexOf(name) > 0){
                    value = xml.substring(xml.indexOf(name + ">") + name.length() + 1, xml.indexOf("</" + name + ">"));
                    if(value.toString().indexOf("<![CDATA[") >= 0){
                        value = value.toString().replace("<![CDATA[", "").replace("]]>", "");
                    }
                    field.setAccessible(true);
                    field.set(t, value);
                }
            }
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return t;
    }
}

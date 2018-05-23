package com.qibu.wxapi.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import java.lang.reflect.Field;
import java.math.BigDecimal;

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
                    String typeName = field.getGenericType().getTypeName();
                    if(typeName.indexOf("Integer") > 0){
                        field.set(t, Integer.valueOf(String.valueOf(value)));
                    }else if(typeName.indexOf("BigDecimal") > 0){
                        field.set(t, BigDecimal.valueOf(Long.parseLong(String.valueOf(value))));
                    }else {
                        field.set(t, value);
                    }

                }
            }
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return t;
    }

    public static void main(String[] args){
        String xml = "<xml><appid><![CDATA[wxaac9\n" +
                "acd7121cff33]]></appid>\n" +
                "<attach><![CDATA[1525848184172949]]></attach>\n" +
                "<bank_type><![CDATA[CFT]]></bank_type>\n" +
                "<cash_fee><![CDATA[1]]></cash_fee>\n" +
                "<fee_type><![CDATA[CNY]]></fee_type>\n" +
                "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
                "<mch_id><![CDATA[1489080012]]></mch_id>\n" +
                "<nonce_str><![CDATA[1525848184177]]></nonce_str>\n" +
                "<openid><![CDATA[ofzcV0dDreUBmgaFEYBe59RNQQwI]]></openid>\n" +
                "<out_trade_no><![CDATA[1525848184151557]]></out_trade_no>\n" +
                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "<return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<sign><![CDATA[359CCF6998AE13D637340FCDEB07B0F9]]></sign>\n" +
                "<time_end><![CDATA[20180509144318]]></time_end>\n" +
                "<total_fee>1</total_fee>\n" +
                "<trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "<transaction_id><![CDATA[4200000109201805095974001780]]></transaction_id>\n" +
                "</xml>";
//        WxPayNotifyResult wxPayNotifyResult = new WxApiXmlUtils().xmlToBean(xml,WxPayNotifyResult.class);
        System.out.println(1);
    }
}

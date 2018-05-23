package com.qibu.wxapi.log;

import com.qibu.wxapi.dto.pay.WxPayResult;
import com.qibu.wxapi.dto.pay.WxPayUnifiedorder;
import com.qibu.wxapi.dto.refund.WxRefundRequest;
import com.qibu.wxapi.dto.refund.WxRefundResult;
import com.weishier.groupon.wxapi.dto.*;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Administrator
 * @description: 微信接口请求日志
 * @date: 2018/5/10 0010 20:11
 * @modified:
 */
public abstract class WxRequestLog  {

    private final Logger logger = Logger.getLogger(WxRequestLog.class);

    public Map<String, Object> extendMap = new HashMap<String, Object>();

    public void saveLog(){}

    public void savePayLog(WxPayUnifiedorder wxPayUnifiedorder, WxPayResult wxPayResult){
        logger.info(JSONObject.fromObject(wxPayUnifiedorder));
        logger.info(JSONObject.fromObject(wxPayResult));
    }

    public void saveRefundLog(WxRefundRequest wxRefundRequest, WxRefundResult wxRefundResult){
        logger.info(JSONObject.fromObject(wxRefundRequest));
        logger.info(JSONObject.fromObject(wxRefundResult));
    }
}

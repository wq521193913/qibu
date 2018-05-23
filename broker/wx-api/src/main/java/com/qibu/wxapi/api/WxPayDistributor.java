package com.qibu.wxapi.api;

import com.qibu.wxapi.dto.pay.WxPayParam;
import com.qibu.wxapi.dto.pay.WxPayResult;
import com.qibu.wxapi.dto.pay.WxPayUnifiedorder;
import com.qibu.wxapi.dto.WxRequestPayment;
import com.qibu.wxapi.log.WxRequestLog;
import com.qibu.wxapi.util.*;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * @author: Administrator
 * @description: 微信统一下单
 * @date: 2018/5/11 0011 09:31
 * @modified:
 */
public class WxPayDistributor {

    private static final Logger logger = Logger.getLogger(WxPayDistributor.class);

    private WxPayDistributor(){}

    /**
     * 微信统一下单
     * @param wxPayParam
     * @param mch_key
     * @return
     * @throws Exception
     */
    public static WxPayResult wxPayUnifiedorder(WxPayParam wxPayParam, String mch_key, WxRequestLog wxRequestLog) throws Exception{
        logger.info(String.format("微信统一下单请求参数 --------> WxPayParam:%s; mch_key:%s"
                ,JSONObject.fromObject(wxPayParam), mch_key));
        if(null == wxPayParam) throw new ValidatorException("微信预支付参数检验有误");
        if(null == mch_key) throw new ValidatorException("mch_key不能为空");

        ParamsValidator.getInstance().getValidator(wxPayParam);

        WxPayUnifiedorder wxPayUnifiedorder = new WxPayUnifiedorder();
        TransformDto.entityToEntity(wxPayParam, wxPayUnifiedorder);
        if(null == wxPayUnifiedorder.getFee_type()){
            wxPayUnifiedorder.setFee_type("CNY");
        }
        wxPayUnifiedorder.setNonce_str(String.valueOf(System.currentTimeMillis()));

        if(null == wxPayParam.getTrade_type()){
            wxPayUnifiedorder.setTrade_type("JSAPI");
        }
        //MD5加密
        wxPayUnifiedorder.setSign(WxSignUtils.getInstance().generateSign(JSONObject.fromObject(wxPayUnifiedorder), mch_key));

        String wxResult = HttpUtils.getInstance().requestPost(WxApiUrl.WX_PAY_unifiedorder, WxApiXmlUtils.getInstance().beanToXml(wxPayUnifiedorder));
        logger.info("获取微信预支付接口返回值:"+ wxResult);
        WxPayResult wxPayResult = WxApiXmlUtils.getInstance().xmlToBean(wxResult, WxPayResult.class);
        if(null != wxRequestLog){
            wxRequestLog.savePayLog(wxPayUnifiedorder, wxPayResult);
        }

        wxPayResult.setMch_id(wxPayParam.getMch_id());
        wxPayResult.setMch_key(mch_key);

        return wxPayResult;
    }

    /**
     * 小程序端请求付款参数
     * @param wxPayResult
     * @return
     */
    public static WxRequestPayment fillRequestPayment(WxPayResult wxPayResult){
        WxRequestPayment wxRequestPayment = new WxRequestPayment();
        wxRequestPayment.setAppId(wxPayResult.getAppid());
        wxRequestPayment.setNonceStr(MyStringUtils.getInstance().getRandomStr());
        wxRequestPayment.setSignType("MD5");
        wxRequestPayment.setWxPackage("prepay_id=" + wxPayResult.getPrepay_id());
        wxRequestPayment.setTimeStamp(String.valueOf(new Date().getTime()));
        wxRequestPayment.setPaySign(WxSignUtils.getInstance().generateSign(JSONObject.fromObject(wxRequestPayment), wxPayResult.getMch_key()));
        return wxRequestPayment;
    }

}

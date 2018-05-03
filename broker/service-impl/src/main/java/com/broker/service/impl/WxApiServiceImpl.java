package com.broker.service.impl;

import com.broker.domain.distributor.*;
import com.broker.service.IWxApiService;
import com.broker.util.*;
import com.broker.util.wx.WxApiUrl;
import com.broker.util.wx.WxApiXmlUtils;
import com.broker.util.wx.WxSignUtils;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/4/20 0020 10:13
 * @modified:
 */
@Service("wxApiService")
public class WxApiServiceImpl implements IWxApiService {


    Logger logger = Logger.getLogger(WxApiServiceImpl.class);

    /**
     * 申请退款
     * @param wxRefundParam
     * @return
     * @throws Exception
     */
    @Override
    public WxRefundResult wxRefund(WxRefundParam wxRefundParam) throws Exception {
        if(null == wxRefundParam ) throw new CustomException("微信退款参数检验有误");
        ParamCheckUtils.getInstance().paramIsRequired(wxRefundParam, new HashMap<String, String>(){{
            put("transaction_id","微信订单号");
            put("out_trade_no","商户订单号");
            put("total_fee","订单金额");
            put("refund_fee","退款金额");
            put("openid","用户openid");
            put("notify_url","退款通知接口");
        }});

        String appid = PropertiesUtils.getProperties("wx_appid");
        String requestNo = MyStringUtils.getRandomStr();

        WxRefundRequest wxRefundRequest = new WxRefundRequest();
        TransformMapEntity.entityToEntity(wxRefundParam, wxRefundRequest);
        wxRefundRequest.setAppid(appid);
        wxRefundRequest.setMch_id(PropertiesUtils.getProperties("mch_id"));
        wxRefundRequest.setOut_refund_no(requestNo);

        if(null == wxRefundRequest.getRefund_fee_type()){
            wxRefundRequest.setRefund_fee_type("CNY");
        }
        wxRefundRequest.setNonce_str(String.valueOf(System.currentTimeMillis()));

        //MD5加密
        wxRefundRequest.setSign(WxSignUtils.getInstance().generateSign(JSONObject.fromObject(wxRefundRequest), PropertiesUtils.getProperties("mch_key")));

        String wxResult = HttpUtils.getInstance().certRequestPost(WxApiUrl.WX_PAY_refund
                ,PropertiesUtils.getProperties("mch_cret")
                ,PropertiesUtils.getProperties("mch_id")
                , WxApiXmlUtils.getInstance().beanToXml(wxRefundRequest)
        );

        WxRefundResult wxRefundResult = WxApiXmlUtils.getInstance().xmlToBean(wxResult, WxRefundResult.class);



        return wxRefundResult;
    }

    /**
     * 微信预预支付
     * @param wxPayParam
     * @return
     * @throws Exception
     */
    @Override
    public WxPayResult wxPayUnifiedorder(WxPayParam wxPayParam) throws Exception{

        if(null == wxPayParam ) throw new CustomException("微信预支付参数检验有误");

        ParamCheckUtils.getInstance().paramIsRequired(wxPayParam, new HashMap<String, String>(){{
            put("total_fee","订单总金额");
            put("body","商品描述");
            put("out_trade_no","商户订单号");
            put("spbill_create_ip","终端IP");
            put("notify_url","通知地址");
        }});

        String appid = PropertiesUtils.getProperties("wx_appid");
        String requestNo = MyStringUtils.getRandomStr();

        WxPayUnifiedorder wxPayUnifiedorder = new WxPayUnifiedorder();
        TransformMapEntity.entityToEntity(wxPayParam, wxPayUnifiedorder);
        wxPayUnifiedorder.setAppid(appid);
        wxPayUnifiedorder.setAttach(requestNo);
        wxPayUnifiedorder.setMch_id(PropertiesUtils.getProperties("mch_id"));
        if(null == wxPayUnifiedorder.getFee_type()){
            wxPayUnifiedorder.setFee_type("CNY");
        }
        wxPayUnifiedorder.setNonce_str(String.valueOf(System.currentTimeMillis()));

        if(null == wxPayParam.getTrade_type()){
            wxPayUnifiedorder.setTrade_type("JSAPI");
        }
        //MD5加密
        wxPayUnifiedorder.setSign(WxSignUtils.getInstance().generateSign(JSONObject.fromObject(wxPayUnifiedorder), PropertiesUtils.getProperties("mch_key")));

        String wxResult = HttpUtils.getInstance().requestPost(WxApiUrl.WX_PAY_unifiedorder, WxApiXmlUtils.getInstance().beanToXml(wxPayUnifiedorder));

        WxPayResult wxPayResult = WxApiXmlUtils.getInstance().xmlToBean(wxResult, WxPayResult.class);

//        this.logRequest(wxPayParam,companyId,wxPayResult,wxPayUnifiedorder);

        if(wxPayResult.getReturn_code().equals("FAIL")){
            throw new CustomException("微信支付统一下单失败:" + wxPayResult.getReturn_msg());
        }
        if(wxPayResult.getResult_code().equals("FAIL")){
            throw new CustomException("微信支付统一下单失败:" + wxPayResult.getErr_code_des());
        }

        return wxPayResult;
    }

//    private void logRequest(WxPayParam wxPayParam, Integer companyId, WxPayResult wxPayResult,WxPayUnifiedorder wxPayUnifiedorder) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                GrPayRequest grPayRequest = new GrPayRequest();
//                grPayRequest.setRequestNo(wxPayParam.getRequestNo());
//                grPayRequest.setRequestParam(JSONObject.fromObject(wxPayUnifiedorder).toString());
//                grPayRequest.setShopId(companyId);
//                grPayRequest.setRequestAdvance(wxPayResult.getPrepay_id());
//                grPayRequest.setRequestOpenid(wxPayParam.getOpenid());
//                grPayRequest.setResponseCode(wxPayResult.getReturn_code());
//                grPayRequest.setResponseParam(JSONObject.fromObject(wxPayResult).toString());
//                grPayRequest.setRequestType(GrPayRequestType.TYPE_PAY.getIndex());
//                try {
//                    grPayRequestService.insertGrPayRequest(grPayRequest);
//                } catch (Exception e) {
//                    logger.error(JSONObject.fromObject(grPayRequest));
//                    logger.error(ExceptionUtils.getStackTrace(e));
//                }
//            }
//        }).start();
//    }
}

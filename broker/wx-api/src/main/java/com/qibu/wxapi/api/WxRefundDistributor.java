package com.qibu.wxapi.api;

import com.qibu.wxapi.dto.refund.WxRefundParam;
import com.qibu.wxapi.dto.refund.WxRefundRequest;
import com.qibu.wxapi.dto.refund.WxRefundResult;
import com.qibu.wxapi.log.WxRequestLog;
import com.qibu.wxapi.util.*;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

/**
 * @author: Administrator
 * @description: 微信退款
 * @date: 2018/5/11 0011 16:09
 * @modified:
 */
public class WxRefundDistributor {

    private static final Logger logger = Logger.getLogger(WxRefundDistributor.class);

    public static WxRefundResult wxRefund(WxRefundParam wxRefundParam, String mch_key, String certPath, WxRequestLog wxRequestLog) throws Exception{

        logger.info(String.format("申请微信退款参数-----------------> WxRefundParam:%s; mch_key:%s; certPath:%s",
                JSONObject.fromObject(wxRefundParam),mch_key,certPath));

        WxRefundRequest wxRefundRequest = new WxRefundRequest();
        TransformDto.entityToEntity(wxRefundParam, wxRefundRequest);

        if(null == wxRefundRequest.getRefund_fee_type()){
            wxRefundRequest.setRefund_fee_type("CNY");
        }
        wxRefundRequest.setNonce_str(String.valueOf(System.currentTimeMillis()));

        //MD5加密
        wxRefundRequest.setSign(WxSignUtils.getInstance().generateSign(JSONObject.fromObject(wxRefundRequest), mch_key));

        String wxResult = HttpUtils.getInstance().certRequestPost(WxApiUrl.WX_PAY_refund
                ,certPath
                ,wxRefundParam.getMch_id()
                ,WxApiXmlUtils.getInstance().beanToXml(wxRefundRequest)
        );

        WxRefundResult wxRefundResult = WxApiXmlUtils.getInstance().xmlToBean(wxResult, WxRefundResult.class);
        if(null != wxRequestLog){
            wxRequestLog.saveRefundLog(wxRefundRequest, wxRefundResult);
        }

        return wxRefundResult;
    }
}

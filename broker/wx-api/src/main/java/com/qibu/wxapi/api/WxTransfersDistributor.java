package com.qibu.wxapi.api;

import com.qibu.wxapi.dto.transfers.WxTransfersParam;
import com.qibu.wxapi.dto.transfers.WxTransfersRequest;
import com.qibu.wxapi.dto.transfers.WxTransfersResult;
import com.qibu.wxapi.log.WxRequestLog;
import com.qibu.wxapi.util.*;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

/**
 * @author: Administrator
 * @description: 企业付款至零钱
 * @date: 2018/5/23 0023 11:11
 * @modified:
 */
public class WxTransfersDistributor {

    private static final Logger logger = Logger.getLogger(WxRefundDistributor.class);

    public static WxTransfersResult transfers(WxTransfersParam wxTransfersParam, String mch_key, String certPath, WxRequestLog wxRequestLog) throws Exception{

        logger.info(String.format("申请微信退款参数-----------------> wxTransfersParam:%s; mch_key:%s; certPath:%s",
                JSONObject.fromObject(wxTransfersParam),mch_key,certPath));

        ParamsValidator.getInstance().getValidator(wxTransfersParam);

        WxTransfersRequest wxTransfersRequest = new WxTransfersRequest();
        TransformDto.entityToEntity(wxTransfersParam, wxTransfersRequest);

        wxTransfersRequest.setNonce_str(MyStringUtils.getInstance().getRandomStr());

        if(null == wxTransfersRequest.getCheck_name() && null == wxTransfersRequest.getRe_user_name()){
            wxTransfersRequest.setCheck_name("NO_CHECK");
        }

        wxTransfersRequest.setSign(WxSignUtils.getInstance().generateSign(JSONObject.fromObject(wxTransfersRequest), mch_key));
        String wxResult = HttpUtils.getInstance().certRequestPost(WxApiUrl.WX_PAY_transfers
                ,certPath
                ,wxTransfersRequest.getMchid()
                ,WxApiXmlUtils.getInstance().beanToXml(wxTransfersRequest)
        );

        WxTransfersResult wxTransfersResult = WxApiXmlUtils.getInstance().xmlToBean(wxResult, WxTransfersResult.class);
        if(null != wxRequestLog){
            wxRequestLog.saveLog(wxTransfersRequest, wxTransfersResult);
        }

        return wxTransfersResult;
    }

    public static WxTransfersResult transfers(WxTransfersParam wxTransfersParam, String mch_key, String certPath) throws Exception{
        return WxTransfersDistributor.transfers(wxTransfersParam, mch_key, certPath,null);
    }
}

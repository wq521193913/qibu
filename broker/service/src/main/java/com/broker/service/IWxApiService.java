package com.broker.service;

import com.qibu.wxapi.dto.pay.WxPayParam;
import com.qibu.wxapi.dto.pay.WxPayResult;
import com.qibu.wxapi.dto.refund.WxRefundParam;
import com.qibu.wxapi.dto.refund.WxRefundResult;

/**
 * @author: Administrator
 * @description: 微信Api
 * @date: 2018/4/20 0020 10:11
 * @modified:
 */
public interface IWxApiService {
    /**
     * 微信预支付
     * @param wxPayParam
     * @return
     * @throws Exception
     */
    WxPayResult wxPayUnifiedorder(WxPayParam wxPayParam) throws Exception;

    /**
     * 微信退款
     * @param wxRefundParam
     * @return
     * @throws Exception
     */
    WxRefundResult wxRefund(WxRefundParam wxRefundParam) throws Exception;
}

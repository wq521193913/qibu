package com.broker.service;

import com.broker.domain.distributor.WxPayParam;
import com.broker.domain.distributor.WxPayResult;
import com.broker.domain.distributor.WxRefundParam;
import com.broker.domain.distributor.WxRefundResult;

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

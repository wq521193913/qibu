package com.qibu.wxapi.util;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/4/20 0020 19:54
 * @modified:
 */
public class WxApiUrl {

    /**
     * 统一下单-预支付接口
     */
    public static final String WX_PAY_unifiedorder = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 退款
     */
    public static final String WX_PAY_refund = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    /**
     * 企业付款至用户零钱
     */
    public static final String WX_PAY_transfers = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

    /**
     * 企业付款至用户零钱
     */
    public static final String WX_PAY_pay_bank = "https://api.mch.weixin.qq.com/mmpaysptrans/pay_bank";
}

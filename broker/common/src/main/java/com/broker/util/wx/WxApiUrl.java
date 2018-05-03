package com.broker.util.wx;

/**
 * @author: Administrator
 * @description: 微信API接口
 * @date: Create in 2018/5/2 0002 下午 11:27
 * @modified:
 */
public class WxApiUrl {

    /**
     * 获取微信openid和session
     */
    public static String WX_OPEN_jscode2session = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    /**
     * 统一下单-预支付接口
     */
    public static String WX_PAY_unifiedorder = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 退款
     */
    public static String WX_PAY_refund = "https://api.mch.weixin.qq.com/secapi/pay/refund";
}

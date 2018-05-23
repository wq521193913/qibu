package com.qibu.wxapi.dto.transfers;

import javax.validation.constraints.NotNull;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/5/23 0023 13:53
 * @modified:
 */
public class WxTransfersParam {
    /**
     * 商户账号appid	mch_appid	是	wx8888888888888888	String	申请商户号的appid或商户号绑定的appid
     */
    @NotNull(message = "商户账号(mch_appid)不能为空")
    private String mch_appid;
    /**
     * 商户号	mchid	是	1900000109	String(32)	微信支付分配的商户号
     */
    @NotNull(message = "商户号(mchid)不能为空")
    private String mchid;
    /**
     * 设备号	device_info	否	013467007045764	String(32)	微信支付分配的终端设备号
     */
    private String device_info;
    /**
     * 商户订单号	partner_trade_no	是	10000098201411111234567890	String	商户订单号，需保持唯一性
     * (只能是字母或者数字，不能包含有符号)
     */
    @NotNull(message = "商户订单号(partner_trade_no)不能为空")
    private String partner_trade_no;
    /**
     * 用户openid	openid	是	oxTWIuGaIt6gTKsQRLau2M0yL16E	String	商户appid下，某用户的openid
     */
    @NotNull(message = "用户openid(openid)不能为空")
    private String openid;
    /**
     * 校验用户姓名选项	check_name	是	FORCE_CHECK	String	NO_CHECK：不校验真实姓名
     * FORCE_CHECK：强校验真实姓名
     */
    private String check_name;
    /**
     * 收款用户姓名	re_user_name	可选	王小王	String	收款用户真实姓名。
     * 如果check_name设置为FORCE_CHECK，则必填用户真实姓名
     */
    private String re_user_name;
    /**
     * 金额	amount	是	10099	int	企业付款金额，单位为分
     */
    @NotNull(message = "金额(amount)不能为空")
    private String amount;
    /**
     * 企业付款描述信息	desc	是	理赔	String	企业付款操作说明信息。必填。
     */
    @NotNull(message = "企业付款描述信息(desc)不能为空")
    private String desc;
    /**
     * Ip地址	spbill_create_ip	是	192.168.0.1	String(32)	该IP同在商户平台设置的IP白名单中的IP没有关联，该IP可传用户端或者服务端的IP。
     */
    @NotNull(message = "Ip地址(spbill_create_ip)不能为空")
    private String spbill_create_ip;

    public String getMch_appid() {
        return mch_appid;
    }

    public WxTransfersParam setMch_appid(String mch_appid) {
        this.mch_appid = mch_appid;
        return this;
    }

    public String getMchid() {
        return mchid;
    }

    public WxTransfersParam setMchid(String mchid) {
        this.mchid = mchid;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public WxTransfersParam setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public WxTransfersParam setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public WxTransfersParam setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getCheck_name() {
        return check_name;
    }

    public WxTransfersParam setCheck_name(String check_name) {
        this.check_name = check_name;
        return this;
    }

    public String getRe_user_name() {
        return re_user_name;
    }

    public WxTransfersParam setRe_user_name(String re_user_name) {
        this.re_user_name = re_user_name;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public WxTransfersParam setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public WxTransfersParam setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public WxTransfersParam setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
        return this;
    }
}

package com.qibu.wxapi.dto.transfers;

import com.qibu.wxapi.dto.WxResult;

/**
 * @author: Administrator
 * @description: 企业付款至用户零钱返回实体
 * @date: 2018/5/23 0023 14:07
 * @modified:
 */
public class WxTransfersResult extends WxResult{

    //    字段名	变量名	必填	示例值	类型	描述
    /**
     *    返回状态码	return_code	是	SUCCESS	String(16)	SUCCESS/FAIL
     *    此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    private String return_code;
    /**
     *    返回信息	return_msg	否	签名失败	String(128)	返回信息，如非空，为错误原因
     *            签名失败
     *    参数格式校验错误
     */
    private String return_msg;
    //    以下字段在return_code为SUCCESS的时候有返回
    //
    //    字段名	变量名	必填	示例值	类型	描述
    /**
     *    商户appid	mch_appid	是	wx8888888888888888	String	申请商户号的appid或商户号绑定的appid（企业号corpid即为此appId）
     */
    private String mch_appid;

    /**
     * 商户号	mchid	是	1900000109	String(32)	微信支付分配的商户号
     */
    private String mchid;
    /**
     * 设备号	device_info	否	013467007045764	String(32)	微信支付分配的终端设备号，
     */
    private String device_info;
    /**
     * 随机字符串	nonce_str	是	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	String(32)	随机字符串，不长于32位
     */
    private String nonce_str;
    /**
     * 业务结果	result_code	是	SUCCESS	String(16)	SUCCESS/FAIL，注意：当状态为FAIL时，存在业务结果未明确的情况，所以如果状态FAIL，请务必再请求一次查询接口[请务必关注错误代码（err_code字段），通过查询查询接口确认此次付款的结果。]，以确认此次付款的结果。
     */
    private String result_code;
    /**
     * 错误代码	err_code	否	SYSTEMERROR	String(32)	错误码信息，注意：出现未明确的错误码时（SYSTEMERROR等）[出现系统错误的错误码时（SYSTEMERROR），请务必用原商户订单号重试，或通过查询接口确认此次付款的结果。]，请请务必再请求一次查询接口，以确认此次付款的结果。
     */
    private String err_code;
    /**
     * 错误代码描述	err_code_des	否	系统错误	String(128)	结果信息描述
     */
    private String err_code_des;

    //    以下字段在return_code 和result_code都为SUCCESS的时候有返回
    //
    //    字段名	变量名	必填	示例值	类型	描述
    /**
     * 商户订单号	partner_trade_no	是	1217752501201407033233368018	String(32)	商户订单号，需保持历史全局唯一性(只能是字母或者数字，不能包含有符号)
     */
    private String partner_trade_no;
    /**
     * 微信订单号	payment_no	是	1007752501201407033233368018	String	企业付款成功，返回的微信订单号
     */
    private String payment_no;
    /**
     * 微信支付成功时间	payment_time	是	2015-05-19 15：26：59	String	企业付款成功时间
     */
    private String payment_time;

    public String getReturn_code() {
        return return_code;
    }

    public WxTransfersResult setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public WxTransfersResult setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getMch_appid() {
        return mch_appid;
    }

    public WxTransfersResult setMch_appid(String mch_appid) {
        this.mch_appid = mch_appid;
        return this;
    }

    public String getMchid() {
        return mchid;
    }

    public WxTransfersResult setMchid(String mchid) {
        this.mchid = mchid;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public WxTransfersResult setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public WxTransfersResult setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public WxTransfersResult setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public WxTransfersResult setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public WxTransfersResult setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public WxTransfersResult setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
        return this;
    }

    public String getPayment_no() {
        return payment_no;
    }

    public WxTransfersResult setPayment_no(String payment_no) {
        this.payment_no = payment_no;
        return this;
    }

    public String getPayment_time() {
        return payment_time;
    }

    public WxTransfersResult setPayment_time(String payment_time) {
        this.payment_time = payment_time;
        return this;
    }
}

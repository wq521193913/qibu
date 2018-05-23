package com.qibu.wxapi.dto.pay;

import com.qibu.wxapi.dto.WxApiDto;

/**
 * @author: Administrator
 * @description: 微信预支付返回结果
 * @date: 2018/4/20 0020 11:35
 * @modified:
 */
public class WxPayResult extends WxApiDto {
    /**
     * 返回状态码		是	String(16)	SUCCESS
     * SUCCESS/FAIL
     * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    private String return_code;
    /**
     * 返回信息	return_msg	否	String(128)	签名失败
     * 返回信息，如非空，为错误原因
     */
    private String return_msg;

    /**
     *  小程序ID	appid	是	String(32)	wx8888888888888888	调用接口提交的小程序ID
     */
    private String appid;

    /**
     * 商户号	mch_id	是	String(32)	1900000109	调用接口提交的商户号
     */
    private String mch_id;
    /**
     * 设备号	device_info	否	String(32)	013467007045764	自定义参数，可以为请求支付的终端设备号等
     */
    private String device_info;

    /**
     *  随机字符串	nonce_str	是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	微信返回的随机字符串
     */
    private String nonce_str;

    /**
     * 签名	sign	是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	微信返回的签名值，详见签名算法
     */
    private String sign;

    /**
     * 业务结果	result_code	是	String(16)	SUCCESS	SUCCESS/FAIL
     */
    private String result_code;

    /**
     * 错误代码	err_code	否	String(32)	SYSTEMERROR	详细参见下文错误列表
     */
    private String err_code;

    /**
     *  错误代码描述	err_code_des	否	String(128)	系统错误	错误信息描述
     */
    private String err_code_des;

    /**
     *  交易类型	trade_type	是	String(16)	JSAPI	交易类型，取值为：JSAPI，NATIVE，APP等，说明详见参数规定
     */
    private String trade_type;

    /**
     *  预支付交易会话标识	prepay_id	是	String(64)	wx201410272009395522657a690389285100	微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    private String prepay_id;

    /**
     *  二维码链接	code_url	否	String(64)	URl：weixin：//wxpay/s/An4baqw	trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
     */
    private String code_url;
    /**
     * 商户key
     */
    private String mch_key;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    public String getCode_url() {
        return code_url;
    }

    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }

    public String getMch_key() {
        return mch_key;
    }

    public void setMch_key(String mch_key) {
        this.mch_key = mch_key;
    }

}

package com.qibu.wxapi.dto.refund;

/**
 * @author: Administrator
 * @description: 退款通知返回值
 * @date: 2018/4/23 0023 19:53
 * @modified:
 */
public class WxRefundNotifyResult {
    /**
     * 返回状态码 return_code 是 String(16)
     * SUCCESS
     * SUCCESS/FAIL
     * 此字段是通信标识，非结果标识，退款是否成功需要解密后查看refund_status 来判断
     */
    private String return_code;
    /**
     * 返回信息 return_msg 否 String(128) 返回信息，如非空，为错误原因 参数格式校验错误
     */
    private String return_msg;
    /**
     * 公众账号ID appid 是 String(32) wx8888888888888888 微信分配的公众账号ID（企业号corpid即为此appId）
     */
    private String appid;

    /**
     * 退款的商户号  mch_id  是 String(32) 1900000109  微信支付分配的商户号
     */
    private String mch_id;
    /**
     * 随机字符串  nonce_str  是  String(32) 5K8264ILTKCH16CQ2502SI8ZNMTM67VS 随机字符串，不长于32位。推荐随机数生成算法
     */
    private String nonce_str;
    /**
     * 加密信息 req_info 是 String(1024) 加密信息请用商户秘钥进行解密，详见解密方式
     */
    private String req_info;

    /**
     * 微信订单号 transaction_id  是 String(32) 1217752501201407033233368018 微信订单号
     */
    private String transaction_id;
    /**
     * 商户订单号 out_trade_no  是 String(32) 1217752501201407033233368018 商户系统内部的订单号
     */
    private String out_trade_no;
    /**
     * 微信退款单号 refund_id 是 String(32) 1217752501201407033233368018 微信退款单号
     */
    private String refund_id;
    /**
     * 商户退款单号 out_refund_no 是 String(64) 1217752501201407033233368018 商户退款单号
     */
    private String out_refund_no;
    /**
     * 订单金额 total_fee   是  Int 100 订单总金额，单位为分，只能为整数，详见支付金额
     */
    private int total_fee;
    /**
     * 应结订单金额 settlement_total_fee  否  Int 100 当该订单有使用非充值券时，返回此字段。应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
     */
    private int settlement_total_fee;
    /**
     * 申请退款金额 refund_fee 是 Int 100 退款总金额,单位为分
     */
    private int refund_fee;
    /**
     退款金额 settlement_refund_fee  是 Int 100 退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
     */
    private int settlement_refund_fee;
    /**
     * 退款状态  refund_status  是String(16) SUCCESS
     * SUCCESS-退款成功
     * CHANGE-退款异常
     * REFUNDCLOSE—退款关闭
     */
    private String refund_status;
    /**
     * 退款成功时间  success_time  否 String(20) 2017-12-15 09:46:01 资金退款至用户帐号的时间，格式2017-12-15 09:46:01
     */
    private String success_time;
    /**
     * 退款入账账户  refund_recv_accout 是 String(64) 招商银行信用卡0403 取当前退款单的退款入账方
     * 1）退回银行卡：
     * {银行名称}{卡类型}{卡尾号}
     * 2）退回支付用户零钱:
     * 支付用户零钱
     * 3）退还商户:
     * 商户基本账户
     * 商户结算银行账户
     * 4）退回支付用户零钱通:
     * 支付用户零钱通
     */
    private String refund_recv_accout;
    /**
     * 退款资金来源 refund_account 是  String(30)
     * REFUND_SOURCE_RECHARGE_FUNDS
     * REFUND_SOURCE_RECHARGE_FUNDS 可用余额退款/基本账户
     * REFUND_SOURCE_UNSETTLED_FUNDS 未结算资金退款
     */
    private String refund_account;
    /**
     * 退款发起来源 refund_request_source 是 String(30) API API接口
     * VENDOR_PLATFORM商户平台
     */
    private String refund_request_source;

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

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getReq_info() {
        return req_info;
    }

    public void setReq_info(String req_info) {
        this.req_info = req_info;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public int getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public void setSettlement_total_fee(int settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    public int getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(int refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(String refund_status) {
        this.refund_status = refund_status;
    }

    public String getSuccess_time() {
        return success_time;
    }

    public void setSuccess_time(String success_time) {
        this.success_time = success_time;
    }

    public String getRefund_recv_accout() {
        return refund_recv_accout;
    }

    public void setRefund_recv_accout(String refund_recv_accout) {
        this.refund_recv_accout = refund_recv_accout;
    }

    public String getRefund_account() {
        return refund_account;
    }

    public void setRefund_account(String refund_account) {
        this.refund_account = refund_account;
    }

    public String getRefund_request_source() {
        return refund_request_source;
    }

    public void setRefund_request_source(String refund_request_source) {
        this.refund_request_source = refund_request_source;
    }

    public int getSettlement_refund_fee() {
        return settlement_refund_fee;
    }

    public void setSettlement_refund_fee(int settlement_refund_fee) {
        this.settlement_refund_fee = settlement_refund_fee;
    }
}

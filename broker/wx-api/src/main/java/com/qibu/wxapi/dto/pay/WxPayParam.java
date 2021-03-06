package com.qibu.wxapi.dto.pay;

import javax.validation.constraints.NotNull;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/4/20 0020 17:37
 * @modified:
 */
public class WxPayParam {
    /**
     * 自定义请求单号
     */

    private String requestNo;
    /**
     * 应用ID	appid	是	String(32)	wxd678efh567hg6787	微信开放平台审核通过的应用APPID
     */
    @NotNull(message = "应用ID(appid)不能为空")
    private String appid;
    /**
     * 商户号	mch_id	是	String(32)	1230000109	微信支付分配的商户号
     */
    @NotNull(message = "商户号(mch_id)不能为空")
    private String mch_id;
    /**
     * 商品描述	body	是	String(128)	腾讯充值中心-QQ会员充值
     商品描述交易字段格式根据不同的应用场景按照以下格式：
     APP——需传入应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值。
     */
    @NotNull(message = "商品描述(body)不可为空")
    private String body;
    /**
     * 商品详情	detail	否	String(8192)	 	商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见“单品优惠参数说明”
     */
    private String detail;
    /**
     * 附加数据	attach	否	String(127)	深圳分店	附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     */
    private String attach;
    /**
     * 商户订单号	out_trade_no	是	String(32)	20150806125346	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。详见商户订单号
     */
    @NotNull(message = "商户订单号(out_trade_no)不可为空")
    private String out_trade_no;
    /**
     * 货币类型	fee_type	否	String(16)	CNY	符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String fee_type;
    /**
     * 总金额	total_fee	是	Int	888	订单总金额，单位为分，详见支付金额
     */
    @NotNull(message = "总金额(total_fee)不可为空")
    private Integer total_fee;
    /**
     * 终端IP	spbill_create_ip	是	String(16)	123.12.12.123	用户端实际ip
     */
    @NotNull(message = "终端IP(spbill_create_ip)不可为空")
    private String spbill_create_ip;
    /**
     * 交易起始时间	time_start	否	String(14)	20091225091010	订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    private String time_start;
    /**
     *交易结束时间	time_expire	否	String(14)	20091227091010
     订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。订单失效时间是针对订单号而言的，由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，所以在重入时间超过2小时的时候需要重新请求下单接口获取新的prepay_id。其他详见时间规则
     建议：最短失效时间间隔大于1分钟
     */
    private String time_expire;
    /**
     * 订单优惠标记	goods_tag	否	String(32)	WXG	订单优惠标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
     */
    private String goods_tag;
    /**
     * 通知地址	notify_url	是	String(256)	http://www.weixin.qq.com/wxpay/pay.php	接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
     */
    @NotNull(message = "通知地址(notify_url)不可为空")
    private String notify_url;
    /**
     * 交易类型	trade_type	是	String(16)	JSAPI	小程序取值如下：JSAPI，详细说明见参数规定
     */
    private String trade_type;
    /**
     * 商品ID	product_id	否	String(32)	12235413214070356458058	trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
     */
    private String product_id;//
    /**
     * 指定支付方式	limit_pay	否	String(32)	no_credit	上传此参数no_credit--可限制用户不能使用信用卡支付
     */
    private String limit_pay;
    /**
     * 用户标识	openid	否	String(128)	oUpF8uMuAJO_M2pxb1Q9zNjWeS6o	trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考【获取openid】。
     */
    private String openid;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
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
}

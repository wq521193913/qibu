package com.broker.domain;

import java.util.Date;

public class BrokerUser {
    /**
     * id
     */
    private Integer uid;

    /**
     * 用户编号
     */
    private String brokerNo;

    /**
     * 用户姓名
     */
    private String brokerName;

    /**
     * 用户手机
     */
    private String brokerPhone;

    /**
     * 用户性别(-1:没填写;0=女;1=男)
     */
    private Byte brokerSex;

    /**
     * 用户身份证号
     */
    private String brokerIdCard;

    /**
     * 用户现住址
     */
    private String brokerAddress;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 用户
     */
    private String brokerQq;

    /**
     * 用户微信
     */
    private String brokerWeixin;

    /**
     * 用户微博号
     */
    private String brokerWeibo;

    /**
     * 用户头像
     */
    private String brokerImg;

    /**
     * 其他联系电话
     */
    private String otherTel;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 认证码
     */
    private String userCode;
    /**
     * 微信openid
     */
    private String openId;
    /**
     * 手机种类(ios/android)
     */
    private String phoneType;

    /**
     * id
     * @return uid id
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * id
     * @param uid id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getBrokerNo() {
        return brokerNo;
    }

    public void setBrokerNo(String brokerNo) {
        this.brokerNo = brokerNo;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getBrokerPhone() {
        return brokerPhone;
    }

    public void setBrokerPhone(String brokerPhone) {
        this.brokerPhone = brokerPhone;
    }

    public Byte getBrokerSex() {
        return brokerSex;
    }

    public void setBrokerSex(Byte brokerSex) {
        this.brokerSex = brokerSex;
    }

    public String getBrokerIdCard() {
        return brokerIdCard;
    }

    public void setBrokerIdCard(String brokerIdCard) {
        this.brokerIdCard = brokerIdCard;
    }

    public String getBrokerAddress() {
        return brokerAddress;
    }

    public void setBrokerAddress(String brokerAddress) {
        this.brokerAddress = brokerAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getBrokerQq() {
        return brokerQq;
    }

    public void setBrokerQq(String brokerQq) {
        this.brokerQq = brokerQq;
    }

    public String getBrokerWeixin() {
        return brokerWeixin;
    }

    public void setBrokerWeixin(String brokerWeixin) {
        this.brokerWeixin = brokerWeixin;
    }

    public String getBrokerWeibo() {
        return brokerWeibo;
    }

    public void setBrokerWeibo(String brokerWeibo) {
        this.brokerWeibo = brokerWeibo;
    }

    public String getBrokerImg() {
        return brokerImg;
    }

    public void setBrokerImg(String brokerImg) {
        this.brokerImg = brokerImg;
    }

    public String getOtherTel() {
        return otherTel;
    }

    public void setOtherTel(String otherTel) {
        this.otherTel = otherTel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public BrokerUser setPhoneType(String phoneType) {
        this.phoneType = phoneType;
        return this;
    }
}
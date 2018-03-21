package com.broker.domain;

import java.io.Serializable;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/19 0019 下午 9:11
 * @modified:
 */
public class WxLoginInfo implements Serializable{

    private int brokerId;

    private String brokerName;

    private String brokerPhone;

    private String openId;

    public int getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(int brokerId) {
        this.brokerId = brokerId;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "brokerId=" + brokerId +
                ", brokerName='" + brokerName + '\'' +
                ", brokerPhone='" + brokerPhone + '\'' +
                ", openId='" + openId + '\'' +
                '}';
    }
}

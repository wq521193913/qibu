package com.broker.domain;

import java.math.BigDecimal;

public class BrokerEarning {
    /**
     * uid
     */
    private Integer uid;

    /**
     * 经纪人ID
     */
    private Integer brokerUser;

    /**
     * 收益金额
     */
    private BigDecimal earningAmount;

    /**
     * 收益来源
     */
    private String earningSource;

    /**
     * 状态(0=待收;1=已收)
     */
    private Byte status;

    /**
     * uid
     * @return uid uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * uid
     * @param uid uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 经纪人ID
     * @return broker_user 经纪人ID
     */
    public Integer getBrokerUser() {
        return brokerUser;
    }

    /**
     * 经纪人ID
     * @param brokerUser 经纪人ID
     */
    public void setBrokerUser(Integer brokerUser) {
        this.brokerUser = brokerUser;
    }

    /**
     * 收益金额
     * @return earning_amount 收益金额
     */
    public BigDecimal getearningAmount() {
        return earningAmount;
    }

    /**
     * 收益金额
     * @param earningAmount 收益金额
     */
    public void setearningAmount(BigDecimal earningAmount) {
        this.earningAmount = earningAmount;
    }

    /**
     * 收益来源
     * @return earning_source 收益来源
     */
    public String getearningSource() {
        return earningSource;
    }

    /**
     * 收益来源
     * @param earningSource 收益来源
     */
    public void setearningSource(String earningSource) {
        this.earningSource = earningSource == null ? null : earningSource.trim();
    }

    /**
     * 状态(0=待收;1=已收)
     * @return status 状态(0=待收;1=已收)
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态(0=待收;1=已收)
     * @param status 状态(0=待收;1=已收)
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}
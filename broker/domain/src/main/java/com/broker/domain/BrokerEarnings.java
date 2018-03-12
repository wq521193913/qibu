package com.broker.domain;

import java.math.BigDecimal;

public class BrokerEarnings {
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
    private BigDecimal earningsAmount;

    /**
     * 收益来源
     */
    private String earningsSource;

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
     * @return earnings_amount 收益金额
     */
    public BigDecimal getEarningsAmount() {
        return earningsAmount;
    }

    /**
     * 收益金额
     * @param earningsAmount 收益金额
     */
    public void setEarningsAmount(BigDecimal earningsAmount) {
        this.earningsAmount = earningsAmount;
    }

    /**
     * 收益来源
     * @return earnings_source 收益来源
     */
    public String getEarningsSource() {
        return earningsSource;
    }

    /**
     * 收益来源
     * @param earningsSource 收益来源
     */
    public void setEarningsSource(String earningsSource) {
        this.earningsSource = earningsSource == null ? null : earningsSource.trim();
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
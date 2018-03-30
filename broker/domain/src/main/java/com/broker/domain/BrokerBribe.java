package com.broker.domain;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @date 2018-03-30 11:04:27
 */
public class BrokerBribe {
    /**
     *
     */
    private Integer uid;
    /**
     * 经纪人ID
     */
    private Integer brokerUser;
    /**
     * 红包ID
     */
    private Integer bribeId;
    /**
     * 红包金额
     */
    private BigDecimal bribeAmount;

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setBrokerUser(Integer brokerUser) {
        this.brokerUser = brokerUser;
    }

    public Integer getBrokerUser() {
        return this.brokerUser;
    }

    public void setBribeId(Integer bribeId) {
        this.bribeId = bribeId;
    }

    public Integer getBribeId() {
        return this.bribeId;
    }

    public void setBribeAmount(BigDecimal bribeAmount) {
        this.bribeAmount = bribeAmount;
    }

    public BigDecimal getBribeAmount() {
        return this.bribeAmount;
    }

}
package com.broker.domain.extend;

import com.broker.domain.Customer;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/3/29 0029 16:18
 * @modified:
 */
public class CustomerExt extends Customer {

    private String brokerName;

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }
}

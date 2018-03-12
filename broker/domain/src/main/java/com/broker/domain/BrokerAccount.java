package com.broker.domain;

import java.math.BigDecimal;

public class BrokerAccount {
    /**
     * uid
     */
    private Integer uid;

    /**
     * 经纪人ID
     */
    private Integer brokerUser;

    /**
     * 银行卡号
     */
    private String bankNo;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 开户支行
     */
    private String bankBranch;

    /**
     * 账户余额
     */
    private BigDecimal accountBalance;

    /**
     * 冻结金额
     */
    private BigDecimal freezeBalance;

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
     * 银行卡号
     * @return bank_no 银行卡号
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 银行卡号
     * @param bankNo 银行卡号
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    /**
     * 开户行
     * @return bank_name 开户行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 开户行
     * @param bankName 开户行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 开户支行
     * @return bank_branch 开户支行
     */
    public String getBankBranch() {
        return bankBranch;
    }

    /**
     * 开户支行
     * @param bankBranch 开户支行
     */
    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch == null ? null : bankBranch.trim();
    }

    /**
     * 账户余额
     * @return account_balance 账户余额
     */
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    /**
     * 账户余额
     * @param accountBalance 账户余额
     */
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * 冻结金额
     * @return freeze_balance 冻结金额
     */
    public BigDecimal getFreezeBalance() {
        return freezeBalance;
    }

    /**
     * 冻结金额
     * @param freezeBalance 冻结金额
     */
    public void setFreezeBalance(BigDecimal freezeBalance) {
        this.freezeBalance = freezeBalance;
    }
}
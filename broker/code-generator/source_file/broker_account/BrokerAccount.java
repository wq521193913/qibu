package com.broker.domain;
/** 
* @author: Administrator 
* @description:* @date 2018-03-30 14:45:12
*/ 
public class BrokerAccount{ 
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

public void setBankNo(String bankNo) { 
this.bankNo = bankNo;
}

public String getBankNo() {
return this.bankNo;
}

public void setBankName(String bankName) { 
this.bankName = bankName;
}

public String getBankName() {
return this.bankName;
}

public void setBankBranch(String bankBranch) { 
this.bankBranch = bankBranch;
}

public String getBankBranch() {
return this.bankBranch;
}

public void setAccountBalance(BigDecimal accountBalance) { 
this.accountBalance = accountBalance;
}

public BigDecimal getAccountBalance() {
return this.accountBalance;
}

public void setFreezeBalance(BigDecimal freezeBalance) { 
this.freezeBalance = freezeBalance;
}

public BigDecimal getFreezeBalance() {
return this.freezeBalance;
}

}
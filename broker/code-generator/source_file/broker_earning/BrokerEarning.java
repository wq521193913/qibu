package com.broker.domain;
/** 
* @author Administrator 
* @date 2018-03-30 09:27:36
*/ 
public class BrokerEarning{ 
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
private Integer status;
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

public void setEarningsAmount(BigDecimal earningsAmount) { 
this.earningsAmount = earningsAmount;
}

public BigDecimal getEarningsAmount() {
return this.earningsAmount;
}

public void setEarningsSource(String earningsSource) { 
this.earningsSource = earningsSource;
}

public String getEarningsSource() {
return this.earningsSource;
}

public void setStatus(Integer status) { 
this.status = status;
}

public Integer getStatus() {
return this.status;
}

}
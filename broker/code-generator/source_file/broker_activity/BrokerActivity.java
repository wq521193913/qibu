package com.broker.domain;
/** 
* @author Administrator 
* @date 2018-03-30 11:04:27
*/ 
public class BrokerActivity{ 
/** 
* 经纪人ID
*/
private Integer brokerUser;
/** 
* 活动时间
*/
private Date activityDate;
/** 
* 操作记录
*/
private String activity;
public void setBrokerUser(Integer brokerUser) { 
this.brokerUser = brokerUser;
}

public Integer getBrokerUser() {
return this.brokerUser;
}

public void setActivityDate(Date activityDate) { 
this.activityDate = activityDate;
}

public Date getActivityDate() {
return this.activityDate;
}

public void setActivity(String activity) { 
this.activity = activity;
}

public String getActivity() {
return this.activity;
}

}
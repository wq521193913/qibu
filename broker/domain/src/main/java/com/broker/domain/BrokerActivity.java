package com.broker.domain;

import java.util.Date;

public class BrokerActivity {
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
     * 活动时间
     * @return activity_date 活动时间
     */
    public Date getActivityDate() {
        return activityDate;
    }

    /**
     * 活动时间
     * @param activityDate 活动时间
     */
    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    /**
     * 操作记录
     * @return activity 操作记录
     */
    public String getActivity() {
        return activity;
    }

    /**
     * 操作记录
     * @param activity 操作记录
     */
    public void setActivity(String activity) {
        this.activity = activity == null ? null : activity.trim();
    }
}
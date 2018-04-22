package com.broker.domain;

/**
 * @author Administrator
 * @date 2018-03-23 22:07:05
 */
public class InviteFriend {
    /**
     * uid
     */
    private Integer uid;
    /**
     * 经纪人ID
     */
    private Integer brokerUser;
    /**
     * 好友手机号
     */
    private String friendPhone;
    /**
     * 来源
     */
    private Integer friendId;

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

    public void setFriendPhone(String friendPhone) {
        this.friendPhone = friendPhone;
    }

    public String getFriendPhone() {
        return this.friendPhone;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getFriendId() {
        return this.friendId;
    }

}
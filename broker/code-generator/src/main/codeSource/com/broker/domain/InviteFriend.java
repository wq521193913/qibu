package com.broker.domain;

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
     * 好友ID
     */
    private Integer friendId;

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
     * 好友手机号
     * @return friend_phone 好友手机号
     */
    public String getFriendPhone() {
        return friendPhone;
    }

    /**
     * 好友手机号
     * @param friendPhone 好友手机号
     */
    public void setFriendPhone(String friendPhone) {
        this.friendPhone = friendPhone == null ? null : friendPhone.trim();
    }

    /**
     * 好友ID
     * @return friend_id 好友ID
     */
    public Integer getFriendId() {
        return friendId;
    }

    /**
     * 好友ID
     * @param friendId 好友ID
     */
    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }
}
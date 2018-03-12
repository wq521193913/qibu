package com.broker.domain;

public class InviteFriends {
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
    private String friendsPhone;

    /**
     * 来源
     */
    private String inviteSource;

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
     * @return friends_phone 好友手机号
     */
    public String getFriendsPhone() {
        return friendsPhone;
    }

    /**
     * 好友手机号
     * @param friendsPhone 好友手机号
     */
    public void setFriendsPhone(String friendsPhone) {
        this.friendsPhone = friendsPhone == null ? null : friendsPhone.trim();
    }

    /**
     * 来源
     * @return invite_source 来源
     */
    public String getInviteSource() {
        return inviteSource;
    }

    /**
     * 来源
     * @param inviteSource 来源
     */
    public void setInviteSource(String inviteSource) {
        this.inviteSource = inviteSource == null ? null : inviteSource.trim();
    }
}
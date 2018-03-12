package com.broker.domain;

import java.util.Date;

public class BrokerUser {
    /**
     * id
     */
    private Integer uid;

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户手机
     */
    private String userPhone;

    /**
     * 用户性别(-1:没填写;0=女;1=男)
     */
    private Byte userSex;

    /**
     * 用户身份证号
     */
    private String userIdcard;

    /**
     * 用户现住址
     */
    private String userAddress;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 用户
     */
    private String userQq;

    /**
     * 用户微信
     */
    private String userWeixin;

    /**
     * 用户微博号
     */
    private String userWeibo;

    /**
     * 用户头像
     */
    private String userImg;

    /**
     * 其他联系电话
     */
    private String otherTel;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 认证码
     */
    private String userCode;

    /**
     * id
     * @return uid id
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * id
     * @param uid id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 用户编号
     * @return user_no 用户编号
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 用户编号
     * @param userNo 用户编号
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * 用户姓名
     * @return user_name 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户姓名
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 用户手机
     * @return user_phone 用户手机
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 用户手机
     * @param userPhone 用户手机
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * 用户性别(-1:没填写;0=女;1=男)
     * @return user_sex 用户性别(-1:没填写;0=女;1=男)
     */
    public Byte getUserSex() {
        return userSex;
    }

    /**
     * 用户性别(-1:没填写;0=女;1=男)
     * @param userSex 用户性别(-1:没填写;0=女;1=男)
     */
    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    /**
     * 用户身份证号
     * @return user_idCard 用户身份证号
     */
    public String getUserIdcard() {
        return userIdcard;
    }

    /**
     * 用户身份证号
     * @param userIdcard 用户身份证号
     */
    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard == null ? null : userIdcard.trim();
    }

    /**
     * 用户现住址
     * @return user_address 用户现住址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 用户现住址
     * @param userAddress 用户现住址
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    /**
     * 家庭住址
     * @return home_address 家庭住址
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * 家庭住址
     * @param homeAddress 家庭住址
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    /**
     * 用户
     * @return user_qq 用户
     */
    public String getUserQq() {
        return userQq;
    }

    /**
     * 用户
     * @param userQq 用户
     */
    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    /**
     * 用户微信
     * @return user_weixin 用户微信
     */
    public String getUserWeixin() {
        return userWeixin;
    }

    /**
     * 用户微信
     * @param userWeixin 用户微信
     */
    public void setUserWeixin(String userWeixin) {
        this.userWeixin = userWeixin == null ? null : userWeixin.trim();
    }

    /**
     * 用户微博号
     * @return user_weibo 用户微博号
     */
    public String getUserWeibo() {
        return userWeibo;
    }

    /**
     * 用户微博号
     * @param userWeibo 用户微博号
     */
    public void setUserWeibo(String userWeibo) {
        this.userWeibo = userWeibo == null ? null : userWeibo.trim();
    }

    /**
     * 用户头像
     * @return user_img 用户头像
     */
    public String getUserImg() {
        return userImg;
    }

    /**
     * 用户头像
     * @param userImg 用户头像
     */
    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }

    /**
     * 其他联系电话
     * @return other_tel 其他联系电话
     */
    public String getOtherTel() {
        return otherTel;
    }

    /**
     * 其他联系电话
     * @param otherTel 其他联系电话
     */
    public void setOtherTel(String otherTel) {
        this.otherTel = otherTel == null ? null : otherTel.trim();
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 修改时间
     * @return update_date 修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 修改时间
     * @param updateDate 修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 认证码
     * @return user_code 认证码
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 认证码
     * @param userCode 认证码
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }
}
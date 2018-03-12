package com.broker.domain;

import java.util.Date;

public class SysUser {
    /**
     * uid
     */
    private Integer uid;

    /**
     * 工号
     */
    private String userNo;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 身份证号
     */
    private String userIdcard;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 现住址
     */
    private String userAddress;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 性别(-1:未填写;0=男;1=女)
     */
    private Byte userSex;

    /**
     * 生日
     */
    private Date userBirthday;

    /**
     * 毕业院校
     */
    private String userSchool;

    /**
     * 学历
     */
    private String userEducation;

    /**
     * 特长
     */
    private String userStrong;

    /**
     * 入职日期
     */
    private Date entryDate;

    /**
     * 离职日期
     */
    private Date dimissionDate;

    /**
     * 状态(0:在职;1=离职;2=停薪留职)
     */
    private Byte status;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 修改人
     */
    private Integer updateUser;

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
     * 工号
     * @return user_no 工号
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 工号
     * @param userNo 工号
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * 姓名
     * @return user_name 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 姓名
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 身份证号
     * @return user_idCard 身份证号
     */
    public String getUserIdcard() {
        return userIdcard;
    }

    /**
     * 身份证号
     * @param userIdcard 身份证号
     */
    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard == null ? null : userIdcard.trim();
    }

    /**
     * 手机号
     * @return user_phone 手机号
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 手机号
     * @param userPhone 手机号
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * 现住址
     * @return user_address 现住址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 现住址
     * @param userAddress 现住址
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
     * 性别(-1:未填写;0=男;1=女)
     * @return user_sex 性别(-1:未填写;0=男;1=女)
     */
    public Byte getUserSex() {
        return userSex;
    }

    /**
     * 性别(-1:未填写;0=男;1=女)
     * @param userSex 性别(-1:未填写;0=男;1=女)
     */
    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    /**
     * 生日
     * @return user_birthday 生日
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * 生日
     * @param userBirthday 生日
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * 毕业院校
     * @return user_school 毕业院校
     */
    public String getUserSchool() {
        return userSchool;
    }

    /**
     * 毕业院校
     * @param userSchool 毕业院校
     */
    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool == null ? null : userSchool.trim();
    }

    /**
     * 学历
     * @return user_education 学历
     */
    public String getUserEducation() {
        return userEducation;
    }

    /**
     * 学历
     * @param userEducation 学历
     */
    public void setUserEducation(String userEducation) {
        this.userEducation = userEducation == null ? null : userEducation.trim();
    }

    /**
     * 特长
     * @return user_strong 特长
     */
    public String getUserStrong() {
        return userStrong;
    }

    /**
     * 特长
     * @param userStrong 特长
     */
    public void setUserStrong(String userStrong) {
        this.userStrong = userStrong == null ? null : userStrong.trim();
    }

    /**
     * 入职日期
     * @return entry_date 入职日期
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * 入职日期
     * @param entryDate 入职日期
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * 离职日期
     * @return dimission_date 离职日期
     */
    public Date getDimissionDate() {
        return dimissionDate;
    }

    /**
     * 离职日期
     * @param dimissionDate 离职日期
     */
    public void setDimissionDate(Date dimissionDate) {
        this.dimissionDate = dimissionDate;
    }

    /**
     * 状态(0:在职;1=离职;2=停薪留职)
     * @return status 状态(0:在职;1=离职;2=停薪留职)
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态(0:在职;1=离职;2=停薪留职)
     * @param status 状态(0:在职;1=离职;2=停薪留职)
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 备注
     * @return remarks 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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
     * 创建人
     * @return create_user 创建人
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     * @param createUser 创建人
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
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
     * 修改人
     * @return update_user 修改人
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     * @param updateUser 修改人
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }
}
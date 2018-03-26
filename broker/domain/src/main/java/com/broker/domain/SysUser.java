package com.broker.domain;

import java.util.Date;

/**
 * @author Administrator
 * @date 2018-03-26 10:26:30
 */
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
    private String userIdCard;
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
    private Integer userSex;
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
    private Integer status;
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

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserNo() {
        return this.userNo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getUserIdCard() {
        return this.userIdCard;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserAddress() {
        return this.userAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress() {
        return this.homeAddress;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserSex() {
        return this.userSex;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Date getUserBirthday() {
        return this.userBirthday;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getUserSchool() {
        return this.userSchool;
    }

    public void setUserEducation(String userEducation) {
        this.userEducation = userEducation;
    }

    public String getUserEducation() {
        return this.userEducation;
    }

    public void setUserStrong(String userStrong) {
        this.userStrong = userStrong;
    }

    public String getUserStrong() {
        return this.userStrong;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getEntryDate() {
        return this.entryDate;
    }

    public void setDimissionDate(Date dimissionDate) {
        this.dimissionDate = dimissionDate;
    }

    public Date getDimissionDate() {
        return this.dimissionDate;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getCreateUser() {
        return this.createUser;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

}
package com.broker.domain;

public class UserRole {
    /**
     * 
     */
    private Integer uid;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色编号
     */
    private String roleNo;

    /**
     * 
     * @return uid 
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 
     * @param uid 
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 用户ID
     * @return user_id 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 角色编号
     * @return role_no 角色编号
     */
    public String getRoleNo() {
        return roleNo;
    }

    /**
     * 角色编号
     * @param roleNo 角色编号
     */
    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo == null ? null : roleNo.trim();
    }
}
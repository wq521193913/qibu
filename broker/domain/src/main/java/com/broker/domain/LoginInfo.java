package com.broker.domain;

/**
 * @author: Administrator
 * @description: 后台登录信息
 * @date: 2018/3/26 0026 17:41
 * @modified:
 */
public class LoginInfo {

    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户手机
     */
    private String userPhone;
    /**
     * 角色
     */
    private String userRole;
    /**
     * 角色名
     */
    private String roleName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

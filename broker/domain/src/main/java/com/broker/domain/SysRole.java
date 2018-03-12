package com.broker.domain;

public class SysRole {
    /**
     * uid
     */
    private Integer uid;

    /**
     * 角色编号
     */
    private String roleNo;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 删除
     */
    private Byte isDel;

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

    /**
     * 角色名称
     * @return role_name 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 删除
     * @return is_del 删除
     */
    public Byte getIsDel() {
        return isDel;
    }

    /**
     * 删除
     * @param isDel 删除
     */
    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }
}
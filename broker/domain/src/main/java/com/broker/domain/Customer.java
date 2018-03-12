package com.broker.domain;

import java.util.Date;

public class Customer {
    /**
     * uid
     */
    private Integer uid;

    /**
     * 客户电话
     */
    private String customerPhone;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户住址
     */
    private String customerAdd;

    /**
     * 录入经纪人
     */
    private Integer brokerUser;

    /**
     * 装修意向(0=咨询;1=马上会装修;2=已装修;3=不装修了)
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 修改人
     */
    private Integer updateUser;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 删除(0=未删除;1=已删除)
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
     * 客户电话
     * @return customer_phone 客户电话
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * 客户电话
     * @param customerPhone 客户电话
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    /**
     * 客户姓名
     * @return customer_name 客户姓名
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 客户姓名
     * @param customerName 客户姓名
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * 客户住址
     * @return customer_add 客户住址
     */
    public String getCustomerAdd() {
        return customerAdd;
    }

    /**
     * 客户住址
     * @param customerAdd 客户住址
     */
    public void setCustomerAdd(String customerAdd) {
        this.customerAdd = customerAdd == null ? null : customerAdd.trim();
    }

    /**
     * 录入经纪人
     * @return broker_user 录入经纪人
     */
    public Integer getBrokerUser() {
        return brokerUser;
    }

    /**
     * 录入经纪人
     * @param brokerUser 录入经纪人
     */
    public void setBrokerUser(Integer brokerUser) {
        this.brokerUser = brokerUser;
    }

    /**
     * 装修意向(0=咨询;1=马上会装修;2=已装修;3=不装修了)
     * @return status 装修意向(0=咨询;1=马上会装修;2=已装修;3=不装修了)
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 装修意向(0=咨询;1=马上会装修;2=已装修;3=不装修了)
     * @param status 装修意向(0=咨询;1=马上会装修;2=已装修;3=不装修了)
     */
    public void setStatus(Byte status) {
        this.status = status;
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
     * 删除(0=未删除;1=已删除)
     * @return is_del 删除(0=未删除;1=已删除)
     */
    public Byte getIsDel() {
        return isDel;
    }

    /**
     * 删除(0=未删除;1=已删除)
     * @param isDel 删除(0=未删除;1=已删除)
     */
    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }
}
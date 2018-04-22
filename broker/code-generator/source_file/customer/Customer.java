package com.broker.domain;
/** 
* @author Administrator 
* @date 2018-03-29 16:53:50
*/ 
public class Customer{ 
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
* 详细住址
*/
private String address;
/** 
* 录入经纪人
*/
private Integer brokerUser;
/** 
* 装修意向(0=咨询;1=马上会装修;2=已装修;3=不装修了)
*/
private Integer status;
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
* 省
*/
private String province;
/** 
* 市
*/
private String city;
/** 
* 区
*/
private String district;
/** 
* 全住址
*/
private String addressDetail;
/** 
* 审计(0=待审核;1=装修中;2=装修完工)
*/
private Integer audit;
public void setUid(Integer uid) { 
this.uid = uid;
}

public Integer getUid() {
return this.uid;
}

public void setCustomerPhone(String customerPhone) { 
this.customerPhone = customerPhone;
}

public String getCustomerPhone() {
return this.customerPhone;
}

public void setCustomerName(String customerName) { 
this.customerName = customerName;
}

public String getCustomerName() {
return this.customerName;
}

public void setAddress(String address) { 
this.address = address;
}

public String getAddress() {
return this.address;
}

public void setBrokerUser(Integer brokerUser) { 
this.brokerUser = brokerUser;
}

public Integer getBrokerUser() {
return this.brokerUser;
}

public void setStatus(Integer status) { 
this.status = status;
}

public Integer getStatus() {
return this.status;
}

public void setCreateDate(Date createDate) { 
this.createDate = createDate;
}

public Date getCreateDate() {
return this.createDate;
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

public void setRemarks(String remarks) { 
this.remarks = remarks;
}

public String getRemarks() {
return this.remarks;
}

public void setProvince(String province) { 
this.province = province;
}

public String getProvince() {
return this.province;
}

public void setCity(String city) { 
this.city = city;
}

public String getCity() {
return this.city;
}

public void setDistrict(String district) { 
this.district = district;
}

public String getDistrict() {
return this.district;
}

public void setAddressDetail(String addressDetail) { 
this.addressDetail = addressDetail;
}

public String getAddressDetail() {
return this.addressDetail;
}

public void setAudit(Integer audit) { 
this.audit = audit;
}

public Integer getAudit() {
return this.audit;
}

}
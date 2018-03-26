package com.broker.domain;
/** 
* @author Administrator 
* @date 2018-03-26 15:00:17
*/ 
public class DbOrderReserver{ 
/** 
* id
*/
private Integer id;
/** 
* 预约单号
*/
private String reserverNo;
/** 
* 预约时间
*/
private Date reserverDate;
/** 
* 用餐人数
*/
private Integer personNum;
/** 
* 预定人
*/
private String reserverName;
/** 
* 手机号
*/
private String reserverPhone;
/** 
* 备注
*/
private String remarks;
/** 
* 状态(0=待审核;1=预约成功;2=预约失败)
*/
private Integer status;
/** 
* 餐厅回复
*/
private String reply;
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
public void setId(Integer id) { 
this.id = id;
}

public Integer getId() {
return this.id;
}

public void setReserverNo(String reserverNo) { 
this.reserverNo = reserverNo;
}

public String getReserverNo() {
return this.reserverNo;
}

public void setReserverDate(Date reserverDate) { 
this.reserverDate = reserverDate;
}

public Date getReserverDate() {
return this.reserverDate;
}

public void setPersonNum(Integer personNum) { 
this.personNum = personNum;
}

public Integer getPersonNum() {
return this.personNum;
}

public void setReserverName(String reserverName) { 
this.reserverName = reserverName;
}

public String getReserverName() {
return this.reserverName;
}

public void setReserverPhone(String reserverPhone) { 
this.reserverPhone = reserverPhone;
}

public String getReserverPhone() {
return this.reserverPhone;
}

public void setRemarks(String remarks) { 
this.remarks = remarks;
}

public String getRemarks() {
return this.remarks;
}

public void setStatus(Integer status) { 
this.status = status;
}

public Integer getStatus() {
return this.status;
}

public void setReply(String reply) { 
this.reply = reply;
}

public String getReply() {
return this.reply;
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

}
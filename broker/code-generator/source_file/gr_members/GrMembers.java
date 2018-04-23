package com.weishier.domain;
/** 
* @author: Administrator 
* @description:* @date 2018-04-18 18:07:57
*/ 
public class GrMembers{ 
/** 
* id
*/
private Integer id;
/** 
* 团ID
*/
private Integer teamId;
/** 
* 成员ID
*/
private String memberOpenid;
/** 
* 加入时间
*/
private Date joinDate;
/** 
* 状态(0=等待中;1=已入团;2=入团失败)
*/
private Integer status;
/** 
* 预付款编号
*/
private String advanceNo;
/** 
* 商家ID
*/
private Integer shopId;
/** 
* 备注
*/
private String remarks;
public void setId(Integer id) { 
this.id = id;
}

public Integer getId() {
return this.id;
}

public void setTeamId(Integer teamId) { 
this.teamId = teamId;
}

public Integer getTeamId() {
return this.teamId;
}

public void setMemberOpenid(String memberOpenid) { 
this.memberOpenid = memberOpenid;
}

public String getMemberOpenid() {
return this.memberOpenid;
}

public void setJoinDate(Date joinDate) { 
this.joinDate = joinDate;
}

public Date getJoinDate() {
return this.joinDate;
}

public void setStatus(Integer status) { 
this.status = status;
}

public Integer getStatus() {
return this.status;
}

public void setAdvanceNo(String advanceNo) { 
this.advanceNo = advanceNo;
}

public String getAdvanceNo() {
return this.advanceNo;
}

public void setShopId(Integer shopId) { 
this.shopId = shopId;
}

public Integer getShopId() {
return this.shopId;
}

public void setRemarks(String remarks) { 
this.remarks = remarks;
}

public String getRemarks() {
return this.remarks;
}

}
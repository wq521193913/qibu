package com.weishier.domain;
/** 
* @author: Administrator 
* @description:* @date 2018-04-18 18:07:56
*/ 
public class GrTeam{ 
/** 
* id
*/
private Integer id;
/** 
* 团名称(默认商品名称)
*/
private String teamName;
/** 
* 发起人openid
*/
private String teamCaptain;
/** 
* 发起时间
*/
private Date createDate;
/** 
* 结束时间
*/
private Date endDate;
/** 
* 成员数
*/
private Integer membersNum;
/** 
* 状态(0=等待中;1=拼团成功;2=拼团失败)
*/
private Integer status;
/** 
* 版本号
*/
private Integer version;
public void setId(Integer id) { 
this.id = id;
}

public Integer getId() {
return this.id;
}

public void setTeamName(String teamName) { 
this.teamName = teamName;
}

public String getTeamName() {
return this.teamName;
}

public void setTeamCaptain(String teamCaptain) { 
this.teamCaptain = teamCaptain;
}

public String getTeamCaptain() {
return this.teamCaptain;
}

public void setCreateDate(Date createDate) { 
this.createDate = createDate;
}

public Date getCreateDate() {
return this.createDate;
}

public void setEndDate(Date endDate) { 
this.endDate = endDate;
}

public Date getEndDate() {
return this.endDate;
}

public void setMembersNum(Integer membersNum) { 
this.membersNum = membersNum;
}

public Integer getMembersNum() {
return this.membersNum;
}

public void setStatus(Integer status) { 
this.status = status;
}

public Integer getStatus() {
return this.status;
}

public void setVersion(Integer version) { 
this.version = version;
}

public Integer getVersion() {
return this.version;
}

}
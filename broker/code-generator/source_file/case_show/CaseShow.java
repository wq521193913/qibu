package com.broker.domain;
/** 
* @author: Administrator 
* @description:* @date 2018-04-08 14:47:03
*/ 
public class CaseShow{ 
/** 
* uid
*/
private Integer uid;
/** 
* 案例标题
*/
private String caseTitle;
/** 
* 图片地址
*/
private String caseImg;
/** 
* 描述
*/
private String caseDesc;
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
* 风格
*/
private Integer caseStyle;
public void setUid(Integer uid) { 
this.uid = uid;
}

public Integer getUid() {
return this.uid;
}

public void setCaseTitle(String caseTitle) { 
this.caseTitle = caseTitle;
}

public String getCaseTitle() {
return this.caseTitle;
}

public void setCaseImg(String caseImg) { 
this.caseImg = caseImg;
}

public String getCaseImg() {
return this.caseImg;
}

public void setCaseDesc(String caseDesc) { 
this.caseDesc = caseDesc;
}

public String getCaseDesc() {
return this.caseDesc;
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

public void setCaseStyle(Integer caseStyle) { 
this.caseStyle = caseStyle;
}

public Integer getCaseStyle() {
return this.caseStyle;
}

}
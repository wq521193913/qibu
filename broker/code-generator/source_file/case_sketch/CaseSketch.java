package com.broker.domain;
/** 
* @author: Administrator 
* @description:* @date 2018-04-11 22:28:57
*/ 
public class CaseSketch{ 
/** 
* uid
*/
private Integer uid;
/** 
* 案例ID
*/
private Integer caseId;
/** 
* 图片地址
*/
private String imgUrl;
public void setUid(Integer uid) { 
this.uid = uid;
}

public Integer getUid() {
return this.uid;
}

public void setCaseId(Integer caseId) { 
this.caseId = caseId;
}

public Integer getCaseId() {
return this.caseId;
}

public void setImgUrl(String imgUrl) { 
this.imgUrl = imgUrl;
}

public String getImgUrl() {
return this.imgUrl;
}

}
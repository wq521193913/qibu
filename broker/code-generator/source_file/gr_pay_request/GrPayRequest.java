package com.weishier.domain;
/** 
* @author: Administrator 
* @description:* @date 2018-04-18 18:07:56
*/ 
public class GrPayRequest{ 
/** 
* id
*/
private Integer id;
/** 
* 请求单号
*/
private String requestNo;
/** 
* 请求参数
*/
private String requestParam;
/** 
* 付款人
*/
private String reqestOpenid;
/** 
* 商家
*/
private Integer shopId;
/** 
* 预付款编号
*/
private String reqestAdvance;
/** 
* 返回值
*/
private String responseParam;
/** 
* 返回状态码
*/
private String responseCode;
/** 
* 团ID
*/
private Integer grTeamId;
public void setId(Integer id) { 
this.id = id;
}

public Integer getId() {
return this.id;
}

public void setRequestNo(String requestNo) { 
this.requestNo = requestNo;
}

public String getRequestNo() {
return this.requestNo;
}

public void setRequestParam(String requestParam) { 
this.requestParam = requestParam;
}

public String getRequestParam() {
return this.requestParam;
}

public void setReqestOpenid(String reqestOpenid) { 
this.reqestOpenid = reqestOpenid;
}

public String getReqestOpenid() {
return this.reqestOpenid;
}

public void setShopId(Integer shopId) { 
this.shopId = shopId;
}

public Integer getShopId() {
return this.shopId;
}

public void setReqestAdvance(String reqestAdvance) { 
this.reqestAdvance = reqestAdvance;
}

public String getReqestAdvance() {
return this.reqestAdvance;
}

public void setResponseParam(String responseParam) { 
this.responseParam = responseParam;
}

public String getResponseParam() {
return this.responseParam;
}

public void setResponseCode(String responseCode) { 
this.responseCode = responseCode;
}

public String getResponseCode() {
return this.responseCode;
}

public void setGrTeamId(Integer grTeamId) { 
this.grTeamId = grTeamId;
}

public Integer getGrTeamId() {
return this.grTeamId;
}

}
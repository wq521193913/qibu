package com.weishier.domain;
/** 
* @author: Administrator 
* @description:* @date 2018-04-18 18:07:55
*/ 
public class GrGoods{ 
/** 
* id
*/
private Integer id;
/** 
* 商品id
*/
private Integer goodsId;
/** 
* 商品名称
*/
private String goodsName;
/** 
* 拼团名称
*/
private String grouponName;
/** 
* 开启时间
*/
private Date startDate;
/** 
* 结束时间
*/
private Date endDate;
/** 
* 状态(0=开启;1=关闭)
*/
private Integer status;
/** 
* 删除(0=未删除;1=已删除)
*/
private Integer isDel;
/** 
* 描述
*/
private String grouponDesc;
/** 
* 拼团人数
*/
private Integer grouponNum;
/** 
* 单次限购
*/
private Integer limitNum;
/** 
* 限购次数
*/
private Integer buyNum;
/** 
* 缩略图
*/
private String thumbnail;
public void setId(Integer id) { 
this.id = id;
}

public Integer getId() {
return this.id;
}

public void setGoodsId(Integer goodsId) { 
this.goodsId = goodsId;
}

public Integer getGoodsId() {
return this.goodsId;
}

public void setGoodsName(String goodsName) { 
this.goodsName = goodsName;
}

public String getGoodsName() {
return this.goodsName;
}

public void setGrouponName(String grouponName) { 
this.grouponName = grouponName;
}

public String getGrouponName() {
return this.grouponName;
}

public void setStartDate(Date startDate) { 
this.startDate = startDate;
}

public Date getStartDate() {
return this.startDate;
}

public void setEndDate(Date endDate) { 
this.endDate = endDate;
}

public Date getEndDate() {
return this.endDate;
}

public void setStatus(Integer status) { 
this.status = status;
}

public Integer getStatus() {
return this.status;
}

public void setIsDel(Integer isDel) { 
this.isDel = isDel;
}

public Integer getIsDel() {
return this.isDel;
}

public void setGrouponDesc(String grouponDesc) { 
this.grouponDesc = grouponDesc;
}

public String getGrouponDesc() {
return this.grouponDesc;
}

public void setGrouponNum(Integer grouponNum) { 
this.grouponNum = grouponNum;
}

public Integer getGrouponNum() {
return this.grouponNum;
}

public void setLimitNum(Integer limitNum) { 
this.limitNum = limitNum;
}

public Integer getLimitNum() {
return this.limitNum;
}

public void setBuyNum(Integer buyNum) { 
this.buyNum = buyNum;
}

public Integer getBuyNum() {
return this.buyNum;
}

public void setThumbnail(String thumbnail) { 
this.thumbnail = thumbnail;
}

public String getThumbnail() {
return this.thumbnail;
}

}
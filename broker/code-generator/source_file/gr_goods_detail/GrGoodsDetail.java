package com.weishier.domain;
/** 
* @author: Administrator 
* @description:* @date 2018-04-18 18:07:55
*/ 
public class GrGoodsDetail{ 
/** 
* id
*/
private Integer id;
/** 
* 拼团商品ID
*/
private Integer goodsId;
/** 
* 规格
*/
private String goodsSize;
/** 
* 价格
*/
private BigDecimal goodsPrice;
/** 
* 成本价
*/
private BigDecimal costPrice;
/** 
* 库存
*/
private Integer goodsInventory;
/** 
* 团购价
*/
private BigDecimal grouponPrice;
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

public void setGoodsSize(String goodsSize) { 
this.goodsSize = goodsSize;
}

public String getGoodsSize() {
return this.goodsSize;
}

public void setGoodsPrice(BigDecimal goodsPrice) { 
this.goodsPrice = goodsPrice;
}

public BigDecimal getGoodsPrice() {
return this.goodsPrice;
}

public void setCostPrice(BigDecimal costPrice) { 
this.costPrice = costPrice;
}

public BigDecimal getCostPrice() {
return this.costPrice;
}

public void setGoodsInventory(Integer goodsInventory) { 
this.goodsInventory = goodsInventory;
}

public Integer getGoodsInventory() {
return this.goodsInventory;
}

public void setGrouponPrice(BigDecimal grouponPrice) { 
this.grouponPrice = grouponPrice;
}

public BigDecimal getGrouponPrice() {
return this.grouponPrice;
}

}
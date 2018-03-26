package com.broker.domain;
/** 
* @author Administrator 
* @date 2018-03-26 15:00:18
*/ 
public class DbOrderQueue{ 
/** 
* id
*/
private Integer id;
/** 
* 队号
*/
private Integer queueNo;
/** 
* 餐桌类型
*/
private Integer tablesType;
/** 
* 用餐人数
*/
private Integer personNum;
/** 
* 创建时间
*/
private Date createDate;
/** 
* 状态(0=等待中;1=已安排;2=已过期;3=已取消)
*/
private Integer status;
public void setId(Integer id) { 
this.id = id;
}

public Integer getId() {
return this.id;
}

public void setQueueNo(Integer queueNo) { 
this.queueNo = queueNo;
}

public Integer getQueueNo() {
return this.queueNo;
}

public void setTablesType(Integer tablesType) { 
this.tablesType = tablesType;
}

public Integer getTablesType() {
return this.tablesType;
}

public void setPersonNum(Integer personNum) { 
this.personNum = personNum;
}

public Integer getPersonNum() {
return this.personNum;
}

public void setCreateDate(Date createDate) { 
this.createDate = createDate;
}

public Date getCreateDate() {
return this.createDate;
}

public void setStatus(Integer status) { 
this.status = status;
}

public Integer getStatus() {
return this.status;
}

}
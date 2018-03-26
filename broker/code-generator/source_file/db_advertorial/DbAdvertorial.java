package com.broker.domain;
/** 
* @author Administrator 
* @date 2018-03-26 15:00:18
*/ 
public class DbAdvertorial{ 
/** 
* 
*/
private Integer id;
/** 
* 标题
*/
private String title;
/** 
* 图片
*/
private String imgUrl;
/** 
* 内容
*/
private  content;
/** 
* 状态(0=启用;1=禁用;2=删除)
*/
private Integer status;
public void setId(Integer id) { 
this.id = id;
}

public Integer getId() {
return this.id;
}

public void setTitle(String title) { 
this.title = title;
}

public String getTitle() {
return this.title;
}

public void setImgUrl(String imgUrl) { 
this.imgUrl = imgUrl;
}

public String getImgUrl() {
return this.imgUrl;
}

public void setContent( content) { 
this.content = content;
}

public  getContent() {
return this.content;
}

public void setStatus(Integer status) { 
this.status = status;
}

public Integer getStatus() {
return this.status;
}

}
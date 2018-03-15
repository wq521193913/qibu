package com.broker.util;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

/**
 * 
 * @Description:
 * @author:wanqing
 * @date:2016-9-19
 */
public class Result {
	
	private boolean success;
	private String msg;
	private Object data;
	private String code;
	
	public Result(){
		this.success = true;
		this.msg = "";
		this.data = null;
		this.code = "1200";
	}

	public Result(boolean success, String msg, Object data, String code){
		this.success = success;
		this.msg = msg;
		this.data = data;
		this.code = code;
	}
	
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public void setPageData(Integer total, Object page, Object rows, Object data){
		PageResult pageResult = PageResult.getPageResult(total, page, rows, data);
		this.setData(pageResult);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", this.success);
		jsonObject.put("msg", this.msg);
		jsonObject.put("data", this.data != null ? this.data : "");
		jsonObject.put("code", this.code);
		return jsonObject.toString();
	}

	public static Result getSystemErrorMsg(){
		return Result.getSystemErrorMsg("");
	}

	public static Result getSystemErrorMsg(String errorMsg){
		Result result = new Result(false,"操作失败,请重新操作",null,"1405");
		if(StringUtils.isNotEmpty(errorMsg)){
			result.setMsg(errorMsg);
		}
		return result;
	}

	public static Result getSystemErrorMsg(Exception e){
		if(e instanceof CustomException){
			return Result.getSystemErrorMsg(((CustomException) e).getMessage());
		}else {
			return Result.getSystemErrorMsg("");
		}
	}

	public static Result getSuccessdResult(){
		return new Result();
	}

	public static Result getFailedResult(String msg){
		return new Result(false,msg,null,"1405");
	}

	public static String getSysCode(){
		return "1200";
	}
}

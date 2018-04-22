package com.broker.domain.extend;

/**
 * @author: Administrator
 * @description: 接口返回值实体
 * @date: Create in 2018/4/19 0019 下午 9:25
 * @modified:
 */
public class ApiResponse {

    private String resCode;

    private String resMsg;

    private Object resData;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public Object getResData() {
        return resData;
    }

    public void setResData(Object resData) {
        this.resData = resData;
    }
}

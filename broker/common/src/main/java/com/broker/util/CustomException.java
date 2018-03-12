package com.broker.util;

/**
 * Created by Administrator on 2016/11/23.
 */
public class CustomException extends Exception {

    private String errorMsg;

    public CustomException(){
        super();
    }

    public CustomException(String errorMsg){
        super(errorMsg);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

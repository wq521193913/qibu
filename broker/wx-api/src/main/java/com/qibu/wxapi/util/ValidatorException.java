package com.qibu.wxapi.util;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/5/11 0011 09:19
 * @modified:
 */
public class ValidatorException extends Exception{
    private String errorMsg;

    public ValidatorException(){
        super();
    }

    public ValidatorException(String errorMsg){
        super(errorMsg);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}

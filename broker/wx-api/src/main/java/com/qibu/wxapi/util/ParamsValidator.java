package com.qibu.wxapi.util;

import net.sf.json.JSONArray;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/4/28 0028 10:48
 * @modified:
 */
public class ParamsValidator {
    private static Integer lock = 0;

    private static ParamsValidator paramsValidator = null;

    public static ParamsValidator getInstance(){
        if(null == paramsValidator){
            synchronized (lock){
                if(null == paramsValidator){
                    paramsValidator = new ParamsValidator();
                }
            }
        }
        return paramsValidator;
    }

    public <T> void getValidator(T var1, Class...groups) throws ValidatorException{
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(var1,groups);
        List<String> messageList = new ArrayList<>();
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            messageList.add(constraintViolation.getMessage());
        }
        if(messageList.size() > 0){
            throw new ValidatorException(JSONArray.fromObject(messageList).toString());
        }
    }
}

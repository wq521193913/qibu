package com.broker.service;

import com.broker.domain.WxUser;
import com.broker.util.CustomException;

import java.util.Map;

public interface IWxUserService {

    /**
     * 新增
     * @param wxUser
     */
    void insertWxUser(WxUser wxUser) throws CustomException;

    /**
     * 查询
     * @param map
     * @return
     */
    WxUser queryWxUserKey(Map<String, Object> map);

    /**
     * 微信用户登录
     * @param wxUser
     * @param iv
     */
    boolean wxLogin(WxUser wxUser, String iv) throws CustomException ;
}

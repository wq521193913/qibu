package com.broker.service;

import com.broker.domain.WxUser;
import com.broker.util.Result;

import java.util.Map;

public interface IWxUserService {

    /**
     * 新增
     * @param wxUser
     */
    void insertWxUser(WxUser wxUser);

    /**
     * 查询
     * @param map
     * @return
     */
    WxUser queryWxUserKey(Map<String, Object> map);

    /**
     * 微信用户登录
     * @param wxUser
     */
    Result wxLogin(WxUser wxUser) ;
}

package com.broker.service.impl;

import com.broker.dao.WxUserMapper;
import com.broker.domain.WxUser;
import com.broker.service.IWxUserService;
import com.broker.util.*;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WxUserServiceImpl implements IWxUserService {

    @Autowired
    WxUserMapper wxUserMapper;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public void insertWxUser(WxUser wxUser) {
        wxUserMapper.insert(wxUser);
    }

    @Override
    public WxUser queryWxUserKey(Map<String, Object> map) {
        return wxUserMapper.queryWxUserKey(map);
    }

    @Override
    public boolean wxLogin(WxUser wxUser, String iv) throws CustomException{
        if(null == wxUser){
            throw new CustomException("参数检验有误:null");
        }
        boolean loginOk = false;
        String code = wxUser.getCode();
        String encryptedData = wxUser.getEncryptedData();
        if(StringUtils.isEmpty(code)){
            throw new CustomException("微信登录Code不能为空");
        }

        String returnData = HttpUtils.getInstance().requestGet(String.format(PropertiesUtil.getProperties("wx_getOpenIdUrl"),code));
        if(null == returnData){
            throw new CustomException("无法得到用户唯一标识");
        }
        JSONObject jsonObject = JSONObject.fromObject(returnData);

        String openId = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("session_key");
        if(StringUtils.isEmpty(openId)){
            throw new CustomException("获取用户openId失败");
        }

        //获取用户信息
//        String Stringdec = AesCbcUtils.getInstance().decrypt(encryptedData,sessionKey,iv,"UTF-8");
        Result result = new Result();
        if(redisUtils.get(openId) == null || (null != redisUtils.get(openId) && !redisUtils.get(openId).equals(returnData))){
            redisUtils.set(openId,returnData,30L);
            WxUser wxUser1 = this.queryWxUserKey(new HashMap<String, Object>(){{
                put("openId", wxUser.getWxOpenId());
            }});
            if(null == wxUser1){
                wxUser.setWxOpenId(openId);
                this.insertWxUser(wxUser);
            }
        }
        result.setData(openId);
        loginOk = true;
        return loginOk;
    }
}

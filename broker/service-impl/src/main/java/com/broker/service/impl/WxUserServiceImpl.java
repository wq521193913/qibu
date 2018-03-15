package com.broker.service.impl;

import com.broker.dao.WxUserMapper;
import com.broker.domain.WxUser;
import com.broker.service.IWxUserService;
import com.broker.util.HttpUtils;
import com.broker.util.PropertiesUtil;
import com.broker.util.Result;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WxUserServiceImpl implements IWxUserService {

    @Autowired
    WxUserMapper wxUserMapper;

    @Override
    public void insertWxUser(WxUser wxUser) {
        wxUserMapper.insert(wxUser);
    }

    @Override
    public WxUser queryWxUserKey(Map<String, Object> map) {
        return wxUserMapper.queryWxUserKey(map);
    }

    @Override
    public Result wxLogin(String code) {
        if(StringUtils.isEmpty(code)){
            return Result.getFailedResult("微信登录Code不能为空");
        }

        String returnData = HttpUtils.getInstance().requestGet(PropertiesUtil.getProperties("wx_getOpenIdUrl"));
        if(null == returnData){
            return Result.getFailedResult("无法得到用户唯一标识");
        }
        JSONObject jsonObject = JSONObject.fromObject(returnData);

        Result result = new Result();

//        if(null == wxUser){
//            return Result.getFailedResult("参数检验有误");
//        }
//        if(StringUtils.isEmpty(wxUser.getWxOpenId())){
//            return Result.getFailedResult("微信用户OpenId不可为空");
//        }
//        WxUser wxUser1 = this.queryWxUserKey(new HashMap<String, Object>(){{
//            put("openId", wxUser.getWxOpenId());
//        }});
//
//        if(null == wxUser1){
//            this.insertWxUser(wxUser);
//        }
        return result;
    }
}

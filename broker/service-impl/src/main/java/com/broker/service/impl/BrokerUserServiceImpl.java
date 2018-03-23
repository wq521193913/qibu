package com.broker.service.impl;

import com.broker.dao.BrokerUserMapper;
import com.broker.domain.BrokerAccount;
import com.broker.domain.BrokerUser;
import com.broker.service.IBrokerAccountService;
import com.broker.service.IBrokerUserService;
import com.broker.util.CustomException;
import com.broker.util.CustomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/19 0019 下午 9:18
 * @modified:
 */
@Service
public class BrokerUserServiceImpl implements IBrokerUserService {

    @Autowired
    private BrokerUserMapper brokerUserMapper;
    @Autowired
    private IBrokerAccountService brokerAccountService;

    @Override
    public void insertBrokerUser(BrokerUser brokerUser) throws CustomException {
        if(null == brokerUser) throw new CustomException("参数检验有误:null");
        if(CustomStringUtils.isEmpty(brokerUser.getBrokerPhone())) throw new CustomException("用户手机号不能为空");
        brokerUser.setUserCode(String.valueOf(System.currentTimeMillis()));

        BrokerUser brokerUser1 = brokerUserMapper.getBrokerUserByKey(new HashMap<String, Object>(){{
            put("brokerPhone", brokerUser.getBrokerPhone());
        }});
        if(null != brokerUser1){
            throw new CustomException("此手机号已注册");
        }
        brokerUserMapper.insert(brokerUser);

        //账户
        BrokerAccount brokerAccount = new BrokerAccount();
        brokerAccount.setBrokerUser(brokerUser.getUid());
        brokerAccountService.insertBrokerAccount(brokerAccount);
    }

    @Override
    public void insertBrokerUser(BrokerUser brokerUser, String inviteCode) throws CustomException{
        this.insertBrokerUser(brokerUser);

        if(null != inviteCode){

        }
    }

    @Override
    public int updateBrokerUserById(BrokerUser brokerUser) throws CustomException{
        return 0;
    }

    @Override
    public int deleteBrokerUserById(int uid) throws CustomException{
        return 0;
    }

    @Override
    public BrokerUser getBrokerUserByKey(Map<String, Object> map) {
        return brokerUserMapper.getBrokerUserByKey(map);
    }

    @Override
    public BrokerUser getBrokerUserByOpenId(String openId) {
        BrokerUser brokerUser = this.getBrokerUserByKey(new HashMap<String, Object>(){{
            put("openId", openId);
        }});
        return brokerUser;
    }
}

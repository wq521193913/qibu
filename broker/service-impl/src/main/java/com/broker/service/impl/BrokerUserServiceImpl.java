package com.broker.service.impl;

import com.broker.dao.BrokerUserMapper;
import com.broker.domain.BrokerUser;
import com.broker.service.IBrokerUserService;
import com.broker.util.CustomException;
import com.broker.util.CustomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void insertBrokerUser(BrokerUser brokerUser) throws CustomException {
        if(null == brokerUser) throw new CustomException("参数检验有误:null");
        if(CustomStringUtils.isEmpty(brokerUser.getUserPhone())) throw new CustomException("用户手机号不能为空");
        brokerUser.setUserCode(String.valueOf(System.currentTimeMillis()));
        brokerUserMapper.insert(brokerUser);
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
    public BrokerUser queryBrokerUserByKey(Map<String, Object> map) {
        return null;
    }
}

package com.broker.service.impl;

import com.broker.dao.BrokerUserDao;
import com.broker.domain.BrokerAccount;
import com.broker.domain.BrokerUser;
import com.broker.domain.InviteFriend;
import com.broker.service.IBrokerAccountService;
import com.broker.service.IBrokerUserService;
import com.broker.service.IInviteFriendService;
import com.broker.util.CustomException;
import com.broker.util.CustomStringUtils;
import com.broker.util.RandomCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
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
    private BrokerUserDao brokerUserDao;
    @Autowired
    private IBrokerAccountService brokerAccountService;
    @Autowired
    private IInviteFriendService inviteFriendService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertBrokerUser(BrokerUser brokerUser) throws Exception {
        if(null == brokerUser) throw new CustomException("参数检验有误:null");
        if(CustomStringUtils.isEmpty(brokerUser.getBrokerPhone())) throw new CustomException("用户手机号不能为空");
        brokerUser.setUserCode(String.valueOf(System.currentTimeMillis()));

        BrokerUser brokerUser1 = brokerUserDao.getBrokerUserByKey(new HashMap<String, Object>(){{
            put("brokerPhone", brokerUser.getBrokerPhone());
        }});
        if(null != brokerUser1){
            throw new CustomException("此手机号已注册");
        }
        brokerUser.setUserCode(RandomCodeUtils.getInstance().getRandomCode() + brokerUser.getBrokerPhone().substring(brokerUser.getBrokerPhone().length() - 2));
        brokerUserDao.insert(brokerUser);

        //账户
        BrokerAccount brokerAccount = new BrokerAccount();
        brokerAccount.setBrokerUser(brokerUser.getUid());
        brokerAccountService.insertBrokerAccount(brokerAccount);
    }

    @Override
    public void insertBrokerUser(BrokerUser brokerUser, String inviteCode) throws Exception{
        this.insertBrokerUser(brokerUser);

        //如果是好友邀请的,添加邀请记录
        if(null != inviteCode && !inviteCode.equals("test")){
            BrokerUser inviteUser = brokerUserDao.getBrokerUserByKey(new HashMap<String, Object>(){{
                put("userCode", inviteCode);
            }});
            if(null == inviteUser) throw new CustomException("无法查询到邀请人");
            InviteFriend inviteFriend = new InviteFriend();
            inviteFriend.setFriendId(brokerUser.getUid());
            inviteFriend.setFriendPhone(brokerUser.getBrokerPhone());
            inviteFriend.setBrokerUser(inviteUser.getUid());
            inviteFriendService.insertInviteFriend(inviteFriend);
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
        return brokerUserDao.getBrokerUserByKey(map);
    }

    @Override
    public BrokerUser getBrokerUserByOpenId(String openId) {
        BrokerUser brokerUser = this.getBrokerUserByKey(new HashMap<String, Object>(){{
            put("openId", openId);
        }});
        return brokerUser;
    }

    @Override
    public List<BrokerUser> brokerUserPageList(Map<String, Object> map) {
        return brokerUserDao.brokerUserPageList(map);
    }

    @Override
    public int brokerUserPageCount(Map<String, Object> map) {
        return brokerUserDao.brokerUserPageCount(map);
    }
}

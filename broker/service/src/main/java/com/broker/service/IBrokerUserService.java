package com.broker.service;

import com.broker.domain.BrokerUser;
import com.broker.util.CustomException;

import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/19 0019 下午 9:16
 * @modified:
 */
public interface IBrokerUserService {

    void insertBrokerUser(BrokerUser brokerUser) throws CustomException;

    int updateBrokerUserById(BrokerUser brokerUser) throws CustomException;

    int deleteBrokerUserById(int uid) throws CustomException;

    BrokerUser getBrokerUserByKey(Map<String, Object> map);

    BrokerUser getBrokerUserByOpenId(String openId);

    /**
     * @author: Administrator
     * @description: 邀请好友注册
     * @param brokerUser
     * @param inviteCode
     * @return:
     * @date: Create in 2018/3/24 0024 上午 11:18
     * @modified:
     */
    void insertBrokerUser(BrokerUser brokerUser, String inviteCode) throws Exception;

    /**
     * @author: wq
     * @description: 分页查询
     * @date: 2018/3/28 0028 16:28
     * @modified:
     */
    List<BrokerUser> brokerUserPageList(Map<String, Object> map);

    /**
     * @author: wq
     * @description: 分页查询总条数
     * @date: 2018/3/28 0028 16:29
     * @modified:
     */
    int brokerUserPageCount(Map<String, Object> map);
}

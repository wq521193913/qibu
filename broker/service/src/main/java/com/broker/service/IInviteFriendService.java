package com.broker.service;

import com.broker.domain.InviteFriend;
import com.broker.util.CustomException;

import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @description: 邀请好友
 * @date: 2018/3/23 0023 16:39
 * @modified:
 */
public interface IInviteFriendService {

    void insertInviteFriend(InviteFriend inviteFriend) throws CustomException;

    int updateInviteFriendById(InviteFriend inviteFriend) throws CustomException;

    int deleteInviteFriendById(int uid) throws CustomException;

    InviteFriend queryByFriendId(int friendId);

    List<InviteFriend> getInviteFriendByBroker(int brokerUser);
}

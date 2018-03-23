package com.broker.service.impl;

import com.broker.domain.InviteFriend;
import com.broker.service.IInviteFriendService;
import com.broker.util.CustomException;

import java.util.List;

/**
 * @author: Administrator
 * @description:
 * @date: 2018/3/23 0023 16:44
 * @modified:
 */
public class InviteFriendServiceImpl implements IInviteFriendService {

    @Override
    public void insertInviteFriend(InviteFriend inviteFriend) throws CustomException {

    }

    @Override
    public int updateInviteFriendById(InviteFriend inviteFriend) throws CustomException {
        return 0;
    }

    @Override
    public int deleteInviteFriendById(int uid) throws CustomException {
        return 0;
    }

    @Override
    public InviteFriend queryByFriendId(int friendId) {
        return null;
    }

    @Override
    public List<InviteFriend> getInviteFriendByBroker(int brokerUser) {
        return null;
    }
}

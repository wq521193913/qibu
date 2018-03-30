package com.broker.service;

import com.broker.domain.InviteFriend;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-23 22:07:05
*/
public interface IInviteFriendService {

    /**
     * 新增
     * @param inviteFriend
     * @return
     * @throws Exception
     */
    public void insertInviteFriend(InviteFriend inviteFriend) throws Exception;

    /**
     * 根据id修改
     * @param inviteFriend
     * @return
     * @throws Exception
     */
    public void updateInviteFriendById(InviteFriend inviteFriend) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteInviteFriend(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public InviteFriend queryInviteFriendById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<InviteFriend> queryInviteFriendList(Map<String, Object> map) throws Exception;

    /**
     * 根据被邀请人查询
     * @param inviteeId
     * @return
     */
    InviteFriend getInviteFriendByInv(int inviteeId);
}

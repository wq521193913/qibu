package com.broker.dao;

import com.broker.domain.InviteFriend;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-03-23 22:07:05
 */
@Repository
public interface InviteFriendDao {

    /**
     * 新增
     * @param inviteFriend
     * @return
     */
    public void insertInviteFriend(InviteFriend inviteFriend);

    /**
     * 根据id修改
     * @param inviteFriend
     * @return
     */
    public void updateInviteFriendById(InviteFriend inviteFriend);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteInviteFriend(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return InviteFriend
     */
    public InviteFriend queryInviteFriendById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<InviteFriend>
     */
    public List<InviteFriend> queryInviteFriendList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<InviteFriend>
     */
    public List<InviteFriend> queryInviteFriendPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryInviteFriendPageCount(Map<String, Object> map);

    /**
     * 根据被邀请人查询
     * @param inviteeId
     * @return
     */
    InviteFriend getInviteFriendByInv(int inviteeId);
}

package com.broker.dao;

import com.broker.domain.InviteFriends;

public interface InviteFriendsMapper {
    /**
     *
     * @mbggenerated 2018-03-10
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insert(InviteFriends record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int insertSelective(InviteFriends record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    InviteFriends selectByPrimaryKey(Integer uid);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKeySelective(InviteFriends record);

    /**
     *
     * @mbggenerated 2018-03-10
     */
    int updateByPrimaryKey(InviteFriends record);
}
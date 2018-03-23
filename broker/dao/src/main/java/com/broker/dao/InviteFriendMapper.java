package com.broker.dao;

import com.broker.domain.InviteFriend;

public interface InviteFriendMapper {
    /**
     *
     * @mbg.generated 2018-03-23
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     *
     * @mbg.generated 2018-03-23
     */
    int insert(InviteFriend record);

    /**
     *
     * @mbg.generated 2018-03-23
     */
    int insertSelective(InviteFriend record);

    /**
     *
     * @mbg.generated 2018-03-23
     */
    InviteFriend selectByPrimaryKey(Integer uid);

    /**
     *
     * @mbg.generated 2018-03-23
     */
    int updateByPrimaryKeySelective(InviteFriend record);

    /**
     *
     * @mbg.generated 2018-03-23
     */
    int updateByPrimaryKey(InviteFriend record);
}
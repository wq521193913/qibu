package com.broker.dao;

import com.broker.domain.WxUser;

import java.util.Map;

public interface WxUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbg.generated
     */
    int insert(WxUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbg.generated
     */
    int insertSelective(WxUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbg.generated
     */
    WxUser selectByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(WxUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(WxUser record);

    WxUser queryWxUserKey(Map<String, Object> map);
}
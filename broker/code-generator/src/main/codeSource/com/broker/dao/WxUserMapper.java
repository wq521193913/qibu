package com.broker.dao;

import com.broker.domain.WxUser;

public interface WxUserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
}
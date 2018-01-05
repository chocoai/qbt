package com.qbt.persistent.mapper;

import com.qbt.persistent.entity.BaseWeixinMenu;

public interface BaseWeixinMenuMapper {
    int insert(BaseWeixinMenu record);

    int insertSelective(BaseWeixinMenu record);

    BaseWeixinMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseWeixinMenu record);

    int updateByPrimaryKey(BaseWeixinMenu record);
}
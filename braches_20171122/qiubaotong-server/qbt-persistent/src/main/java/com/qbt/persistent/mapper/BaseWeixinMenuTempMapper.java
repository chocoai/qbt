package com.qbt.persistent.mapper;

import com.qbt.persistent.entity.BaseWeixinMenuTemp;

public interface BaseWeixinMenuTempMapper {
    int insert(BaseWeixinMenuTemp record);

    int insertSelective(BaseWeixinMenuTemp record);

    BaseWeixinMenuTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseWeixinMenuTemp record);

    int updateByPrimaryKey(BaseWeixinMenuTemp record);
}
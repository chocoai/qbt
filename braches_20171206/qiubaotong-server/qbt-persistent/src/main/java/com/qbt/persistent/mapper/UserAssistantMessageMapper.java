package com.qbt.persistent.mapper;

import com.qbt.persistent.entity.UserAssistantMessage;

public interface UserAssistantMessageMapper {
    int insert(UserAssistantMessage record);

    int insertSelective(UserAssistantMessage record);

    UserAssistantMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAssistantMessage record);

    int updateByPrimaryKeyWithBLOBs(UserAssistantMessage record);

    int updateByPrimaryKey(UserAssistantMessage record);
}
package com.qbt.persistent.mapper;

import com.qbt.persistent.entity.UserAssistantFee;

public interface UserAssistantFeeMapper {
    int insert(UserAssistantFee record);

    int insertSelective(UserAssistantFee record);

    UserAssistantFee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAssistantFee record);

    int updateByPrimaryKey(UserAssistantFee record);
}
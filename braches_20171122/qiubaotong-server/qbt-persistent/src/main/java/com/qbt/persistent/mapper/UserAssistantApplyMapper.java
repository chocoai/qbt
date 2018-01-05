package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.UserAssistantApplyWX;
import com.qbt.persistent.entity.UserAssistantApply;

public interface UserAssistantApplyMapper {
	
    int insert(UserAssistantApply record);

    int insertSelective(UserAssistantApply record);

    UserAssistantApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAssistantApply record);

    int updateByPrimaryKey(UserAssistantApply record);
    
    int updateByAssistantId(UserAssistantApply record);
    
	List<UserAssistantApply> findByPage(PageEntity<UserAssistantApply> pageEntity);
	
	UserAssistantApply selectByUserId(String userId);

	UserAssistantApply findByAssitantId(int id);

	List<UserAssistantApplyWX> list(@Param("applyId")Integer applyId, @Param("applyType")int applyType);

	List<UserAssistantApply> findByApplyIdApplyType(int applyId, int applyType);

	void updatestatusStop(@Param("applyId")Integer applyId, @Param("applyType")int applyType, @Param("status")int status);
	
	UserAssistantApply findPartnerByUserId(@Param("userId")int userId,@Param("type")int type);
	
}
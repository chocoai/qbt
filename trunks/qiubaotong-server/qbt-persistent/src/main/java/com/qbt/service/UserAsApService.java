package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.UserAssistantApplyWX;
import com.qbt.persistent.entity.UserAssistantApply;

public interface UserAsApService {

	List<UserAssistantApply> findByPage(PageEntity<UserAssistantApply> pageEntity);

	void updateStatus(UserAssistantApply u);

	UserAssistantApply findById(Integer id);
	
	UserAssistantApply selectById(int id);
	
	UserAssistantApply selectByUserId(String userId);

	UserAssistantApply findByAssitantId(int id);
	
	List<UserAssistantApply> findByApplyIdAndApplyType(int applyId, int applyTyep);
	
	int insertUserAssistantApply(UserAssistantApply apply);
	
	int updateApplyByAssistantId(UserAssistantApply apply);

	void update(UserAssistantApply uAsAp);

	List<UserAssistantApplyWX> list(Integer applyId,int applyType);

	void updatestatusStop(Integer applyId, int applyType, int status);
	
	UserAssistantApply findPartnerByUserId(int userId,int type);
}

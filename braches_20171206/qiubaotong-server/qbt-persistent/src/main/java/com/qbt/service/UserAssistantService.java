package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserAssistant;

public interface UserAssistantService {
	
	public List<UserAssistant> findAssistantBySiteId(int siteId,int type);
	
	public UserAssistant  selectByUserId(int userId);

	public List<UserAssistant> findByPage(PageEntity<UserAssistant> pageEntity);
	
	public int inserAssistant(UserAssistant user);
	
	public int updateById(UserAssistant user);

	public UserAssistant findById(Integer id);
	
	int queryAssistantByApply(int applyType, int applyId);
}

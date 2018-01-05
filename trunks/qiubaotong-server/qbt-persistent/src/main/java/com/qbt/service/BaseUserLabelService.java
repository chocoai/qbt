package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.BaseUserLabel;

public interface BaseUserLabelService {

	int insertByBatch(List<BaseUserLabel> configs);
	
	void deleteByMobile(String mobile);

	List<BaseUserLabel> getByMobile(String mobile);

	List<BaseUserLabel> listContentByMobile(String mobile);
	
	List<BaseUserLabel> findByUser(Integer userType, Integer userId);

	List<BaseUserLabel> findContentByUser(Integer userType, Integer userId);
	
	/**
	 *根据用户类型和用户id删除 
	 * @param userType
	 * @param userId
	 */
	void deleteByUser(Integer userType, Integer userId);
	
}

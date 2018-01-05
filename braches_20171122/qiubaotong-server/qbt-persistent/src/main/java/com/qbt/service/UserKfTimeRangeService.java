package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.UserKfTimeRange;

public interface UserKfTimeRangeService {
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);
	
	/**
	 * 根据顺丰客服id删除
	 * @param serviceId
	 * @return
	 */
	int deleteByServiceId(Integer serviceId);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<UserKfTimeRange> findAll();
	
	/**
	 * 新增
	 * @param userKfTimeRange
	 * @return
	 */
	int insert(UserKfTimeRange userKfTimeRange);
	
	/**
	 * 根据条件查询
	 * @param condition
	 * @return
	 */
	List<UserKfTimeRange> findByCondition(UserKfTimeRange condition);
	
}

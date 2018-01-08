package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserActivityOrderDetail;
import com.qbt.persistent.entity.UserActivityPackage;

public interface UserActivityOrderDetailService {
	
	/**
	 * 分页查询
	 * @param pageEntity
	 * @return
	 */
	List<UserActivityOrderDetail> findByPage(PageEntity<UserActivityOrderDetail> pageEntity);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	UserActivityOrderDetail findById(Integer id);
	
	/**
	 * 新增活动
	 * @param activity
	 * @return
	 */
	int insert(UserActivityOrderDetail ticket);
	
	/**
	 * 更新活动
	 * @param activity
	 * @return
	 */
	int update(UserActivityOrderDetail ticket);
	
	/**
	 * findlistUsed(active_status=1 and today>expiration_time)
	 * @param activeStatus
	 * @param expirationTime
	 * @return
	 */
	List<UserActivityPackage> findlistUsed(int userId);
	
	List<UserActivityPackage> findlistNotActive(int userId);
	
	int findEffectiveDayByOrderDetailId(int orderDetailId);
}

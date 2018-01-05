package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserActivityOrder;

public interface TicketPackageOrderService {
	
	/**
	 * 分页查询
	 * @param pageEntity
	 * @return
	 */
	List<UserActivityOrder> findByPage(PageEntity<UserActivityOrder> pageEntity);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	UserActivityOrder findById(Integer id);
	
	/**
	 * 新增活动
	 * @param activity
	 * @return
	 */
	int insert(UserActivityOrder ticket);
	
	/**
	 * 更新活动
	 * @param activity
	 * @return
	 */
	int update(UserActivityOrder ticket);
}

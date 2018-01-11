package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserActivityPackage;

public interface TicketPackageService {
	
	/**
	 * 分页查询
	 * @param pageEntity
	 * @return
	 */
	List<UserActivityPackage> findByPage(PageEntity<UserActivityPackage> pageEntity);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	UserActivityPackage findById(Integer id);
	
	/**
	 * 新增活动
	 * @param activity
	 * @return
	 */
	int insert(UserActivityPackage ticketPackage);
	
	/**
	 * 更新活动
	 * @param activity
	 * @return
	 */
	int update(UserActivityPackage ticketPackage);
}

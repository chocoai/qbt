package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserPackageTicket;

public interface UserPackageTicketService {
	
	/**
	 * 分页查询
	 * @param pageEntity
	 * @return
	 */
	List<UserPackageTicket> findByPage(PageEntity<UserPackageTicket> pageEntity);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	UserPackageTicket findById(Integer id);
	
	/**
	 * 新增活动
	 * @param activity
	 * @return
	 */
	int insert(UserPackageTicket ticket);
	
	/**
	 * 更新活动
	 * @param activity
	 * @return
	 */
	int update(UserPackageTicket ticket);
	
	List<UserPackageTicket> findTicketsForOrderDetail(Integer orderDetailId);
}

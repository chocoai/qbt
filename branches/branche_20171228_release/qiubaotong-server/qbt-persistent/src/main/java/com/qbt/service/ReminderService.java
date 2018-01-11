package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Reminder;

public interface ReminderService {
	
	/**
	 * 分页查询
	 * @param pageEntity
	 * @return
	 */
	List<Reminder> findByPage(PageEntity<Reminder> pageEntity);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Reminder findById(Integer id);
	
	/**
	 * 新增活动
	 * @param reminder
	 * @return
	 */
	int insert(Reminder reminder);
	
	/**
	 * 更新活动
	 * @param reminder
	 * @return
	 */
	int update(Reminder reminder);	
	
	/**
	 * 分页查询
	 * @param pageEntity
	 * @return
	 */
	List<Reminder> list();
	
}

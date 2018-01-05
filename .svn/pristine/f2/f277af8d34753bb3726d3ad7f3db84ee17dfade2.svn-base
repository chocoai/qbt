package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Urgent;

public interface UrgentService {
	
	/**
	 * 分页查询
	 * @param pageEntity
	 * @return
	 */
	List<Urgent> findByPage(PageEntity<Urgent> pageEntity);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Urgent findById(Integer id);
	
	/**
	 * 新增活动
	 * @param urgent
	 * @return
	 */
	int insert(Urgent urgent);
	
	/**
	 * 更新活动
	 * @param urgent
	 * @return
	 */
	int update(Urgent urgent);
	
	/**
	 * 根据条件查询
	 * @param urgent
	 * @return
	 */
	List<Urgent> findByCondition(Urgent urgent);
	
	int deleteById(Integer id);
}

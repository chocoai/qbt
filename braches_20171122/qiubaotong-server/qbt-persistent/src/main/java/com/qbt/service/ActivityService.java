package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Activity;

public interface ActivityService {
	
	/**
	 * 分页查询
	 * @param pageEntity
	 * @return
	 */
	List<Activity> findByPage(PageEntity<Activity> pageEntity);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Activity findById(Integer id);
	
	/**
	 * 新增活动
	 * @param activity
	 * @return
	 */
	int insert(Activity activity);
	
	/**
	 * 更新活动
	 * @param activity
	 * @return
	 */
	int update(Activity activity);
	
	/**
	 * 根据条件查询
	 * @param activity
	 * @return
	 */
	List<Activity> findByCondition(Activity activity);
	
	/**
	 * 检查是否存在活动名称或暗号
	 * @param name
	 * @return
	 */
	int isExist(String name, String code);
	
	/**
	 * 根据暗号查询活动
	 * @param code
	 * @return
	 */
	Activity findByCode(String code);
	
	List<Activity> findCurrentCouponActivity(Integer type);
}

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserSfKf;

public interface UserSfKfService {
	
	/**
	 * 分页查询
	 * @param pageEntity
	 * @return
	 */
	List<UserSfKf> findByPage(PageEntity<UserSfKf> pageEntity);
	
	/**
	 * 新增
	 * @param userSfKf
	 * @return
	 */
	int insert(UserSfKf userSfKf);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delete(Integer id);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<UserSfKf> findAll();

	/**
	 *  查询客服值班人员
	  * @Title: findDutyKf
	  * @Description: TODO
	  * @author: share 2016年8月15日
	  * @modify: share 2016年8月15日
	  * @param week
	  * @param hour
	  * @return
	 */
	UserSfKf findDutyKf(int week, int hour);
	
	/**
	 * 根据条件查询
	 * @param userSfKf
	 * @return
	 */
	List<UserSfKf> findByCondition(UserSfKf userSfKf);
	
	/**
	 * name或mobile查询是否重复
	 * @param userSfKf
	 * @return
	 */
	int isExist(String name, String mobile);
}

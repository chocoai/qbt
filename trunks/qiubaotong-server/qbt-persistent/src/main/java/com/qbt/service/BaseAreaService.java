package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.BaseArea;

public interface BaseAreaService {

	/**
	 * 添加
	 * @param user
	 */
	public void insert(BaseArea area);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public BaseArea findById(int id);
	
	/**
	 *  根据用户ID查询
	 * @param userId
	 * @return
	 */
	public List<BaseArea> findBySuperId(int superId);
	
	/**
	 * 更新
	 * @param address
	 * @return
	 */
	public int update(BaseArea address);
	
	/**
	 * findByName
	 * @param name
	 * @return
	 */
	public BaseArea findByName(String name);
	
	/**
	 *  
	  * @Title: findByName
	  * @Description: TODO
	  * @author: share 2016年8月11日
	  * @modify: share 2016年8月11日
	  * @param name
	  * @return
	 */
	public BaseArea findByName(String city,String district);
	
	/**
	 * findByLevel
	 * @param level
	 * @return
	 */
	public List<BaseArea> findByLevel(int level);
	
}

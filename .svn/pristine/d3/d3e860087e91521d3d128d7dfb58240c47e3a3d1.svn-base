package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserAddress;

public interface UserAddressService {

	/**
	 * 添加
	 * @param user
	 */
	public int insert(UserAddress address);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public UserAddress findById(int id);
	
	/**
	 *  根据用户ID查询
	 * @param userId
	 * @return
	 */
	public List<UserAddress> findByUserId(int userId, Integer labelType);
	
	/**
	 * 更新
	 * @param address
	 * @return
	 */
	public int update(UserAddress address);
	
	/**
	 * 置顶
	 * @param address
	 * @return
	 */
	public int updateUpdateTime(UserAddress address);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
	/**
	 * 根据唯一id查询
	 * @param uuid userId+areaId+address md5字符串
	 * @return
	 */
	public UserAddress findByUuid(String uuid);
	
	/**
	 * 用户地址分页查询
	 * @param pageEntity
	 * @return
	 */
	public List<UserAddress> findByPage(PageEntity<UserAddress> pageEntity);
	
	/**
	 * 
	 * exists:(检查地址是否重复).
	 *
	 * @author huangyihao
	 * 2017年2月27日 下午6:01:34
	 * @param id
	 * @param uuid
	 * @return
	 *
	 */
	int exists(Integer id, String uuid);
}

/**
 * Project Name:qbt-persistent
 * File Name:UserProxyAddressServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年2月27日下午4:34:37
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserAddress;
import com.qbt.persistent.entity.UserProxyAddress;
import com.qbt.persistent.mapper.UserProxyAddressMapper;
import com.qbt.service.UserProxyAddressService;

/**
 * ClassName:UserProxyAddressServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月27日 下午4:34:37
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class UserProxyAddressServiceImpl implements UserProxyAddressService {
	
	@Resource
	private UserProxyAddressMapper userProxyAddressMapper;
	
	@Override
	public int insert(UserProxyAddress address) {
		userProxyAddressMapper.insert(address);
		checkIsDefault(address);
		return address.getId();
	}
	
	private void checkIsDefault(UserProxyAddress address){
		if(address.getIsDefault()){
			userProxyAddressMapper.updateOtherDefault(address);
		}
	}
	
	@Override
	public UserProxyAddress findById(Integer id) {
		return userProxyAddressMapper.findById(id);
	}

	@Override
	public int update(UserProxyAddress address) {
		int result = userProxyAddressMapper.update(address);
		 checkIsDefault(address);
		return result;
	}

	@Override
	public int delete(Integer id) {
		return userProxyAddressMapper.delete(id);
	}

	@Override
	public List<UserProxyAddress> findByPage(PageEntity<UserProxyAddress> pageEntity) {
		return userProxyAddressMapper.findByPage(pageEntity);
	}

	@Override
	public List<UserProxyAddress> findByUserId(Integer proxyUserId, Integer userId, Integer labelType) {
		return userProxyAddressMapper.findByUserId(proxyUserId, userId, labelType);
	}

	@Override
	public UserProxyAddress findByUuid(String uuid) {
		return userProxyAddressMapper.findByUuid(uuid);
	}

	@Override
	public int exists(Integer id, String uuid) {
		return userProxyAddressMapper.exists(id, uuid);
	}

	@Override
	public int updateUpdateTime(UserAddress address) {
		 int result = userProxyAddressMapper.updateUpdateTime(address);
		 return result;
	}
	
}

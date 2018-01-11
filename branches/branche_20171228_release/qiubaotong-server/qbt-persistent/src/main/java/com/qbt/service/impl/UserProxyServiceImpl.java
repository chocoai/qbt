/**
 * Project Name:qbt-persistent
 * File Name:UserProxyServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年2月27日上午11:31:18
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.UserProxy;
import com.qbt.persistent.mapper.UserProxyMapper;
import com.qbt.service.UserProxyService;

/**
 * ClassName:UserProxyServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月27日 上午11:31:18
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class UserProxyServiceImpl implements UserProxyService {
	
	@Resource
	private UserProxyMapper userProxyMapper;
	
	@Override
	public int insert(UserProxy userProxy) {
		userProxyMapper.insert(userProxy);
		return userProxy.getId();
	}

	@Override
	public UserProxy findById(Integer id) {
		return userProxyMapper.findById(id);
	}

	@Override
	public int update(UserProxy userProxy) {
		return userProxyMapper.update(userProxy);
	}

	@Override
	public List<UserProxy> findByProxyUserId(Integer proxUserId) {
		return userProxyMapper.findByProxyUserId(proxUserId);
	}

	@Override
	public UserProxy findByUserId(Integer proxUserId, Integer userId) {
		return userProxyMapper.findByUserId(proxUserId, userId);
	}

	@Override
	public List<UserProxy> findByKeyword(Integer proxUserId, String keyword) {
		return userProxyMapper.findByKeyword(proxUserId, keyword);
	}

}

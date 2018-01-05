/**
 * Project Name:qbt-persistent
 * File Name:UserImageServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年1月11日上午11:06:21
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.UserImage;
import com.qbt.persistent.mapper.UserImageMapper;
import com.qbt.service.UserImageService;

/**
 * ClassName:UserImageServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月11日 上午11:06:21
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class UserImageServiceImpl implements UserImageService {
	
	@Resource
	private UserImageMapper userImageMapper;
	
	@Override
	public int insert(UserImage userImage) {
		userImageMapper.insert(userImage);
		return userImage.getId();
	}

	@Override
	public UserImage findById(Integer id) {
		return userImageMapper.selectById(id);
	}

	@Override
	public int deleteById(Integer id) {
		return userImageMapper.deleteById(id);
	}

	@Override
	public List<UserImage> findByUserId(Integer userId, Integer type) {
		return userImageMapper.selectByUserId(userId, type);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		return userImageMapper.deleteByIds(ids);
	}

	@Override
	public List<UserImage> findByIds(List<Integer> ids) {
		return userImageMapper.selectByIds(ids);
	}

}

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserActivityOrder;
import com.qbt.persistent.mapper.UserActivityOrderMapper;
import com.qbt.service.UserActivityOrderService;

@Service
public class UserActivityOrderServiceImpl implements UserActivityOrderService {
	
	@Resource
	private UserActivityOrderMapper userActivityOrderMapper;
	
	@Override
	public List<UserActivityOrder> findByPage(PageEntity<UserActivityOrder> pageEntity) {
		return userActivityOrderMapper.findByPage(pageEntity);
	}

	@Override
	public UserActivityOrder findById(Integer id) {
		return userActivityOrderMapper.selectById(id);
	}

	@Override
	public int insert(UserActivityOrder ticket) {
		userActivityOrderMapper.insert(ticket);
		return ticket.getId();
	}

	@Override
	public int update(UserActivityOrder ticket) {
		if(ticket.getId() > 0){
			int count = userActivityOrderMapper.updateById(ticket);			
			return count;
		}
		return 0;
	}

}

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.UserKfTimeRange;
import com.qbt.persistent.mapper.UserKfTimeRangeMapper;
import com.qbt.service.UserKfTimeRangeService;

@Service
public class UserKfTimeRangeServiceImpl implements UserKfTimeRangeService {
	
	@Resource
	private UserKfTimeRangeMapper userKfTimeRangeMapper;
	
	@Override
	public int deleteById(Integer id) {
		return userKfTimeRangeMapper.deleteById(id);
	}

	@Override
	public int deleteByServiceId(Integer serviceId) {
		return userKfTimeRangeMapper.deleteByServiceId(serviceId);
	}

	@Override
	public List<UserKfTimeRange> findAll() {
		return userKfTimeRangeMapper.findAll();
	}

	@Override
	public int insert(UserKfTimeRange userKfTimeRange) {
		int count = userKfTimeRangeMapper.insert(userKfTimeRange);
		if(count > 0){
			return userKfTimeRange.getId();
		}
		return 0;
	}

	@Override
	public List<UserKfTimeRange> findByCondition(UserKfTimeRange condition) {
		return userKfTimeRangeMapper.findByCondition(condition);
	}

}

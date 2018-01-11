package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserSfKf;
import com.qbt.persistent.mapper.UserSfKfMapper;
import com.qbt.service.UserSfKfService;

@Service
public class UserSfKfServiceImpl implements UserSfKfService {
	
	@Resource
	private UserSfKfMapper userSfKfMapper;
	
	@Override
	public List<UserSfKf> findByPage(PageEntity<UserSfKf> pageEntity) {
		return userSfKfMapper.findByPage(pageEntity);
	}

	@Override
	public int insert(UserSfKf userSfKf) {
		int count = userSfKfMapper.insert(userSfKf);
		if(count > 0){
			return userSfKf.getId();
		}
		return 0;
	}

	@Override
	public int delete(Integer id) {
		return userSfKfMapper.deleteById(id);
	}

	@Override
	public List<UserSfKf> findAll() {
		return userSfKfMapper.findAll();
	}

	@Override
	public UserSfKf findDutyKf(int week, int hour) {
		// TODO Auto-generated method stub
		return userSfKfMapper.findDutyKf(week,hour);
	}
	
	public List<UserSfKf> findByCondition(UserSfKf userSfKf) {
		return userSfKfMapper.findByCondition(userSfKf);
	}

	@Override
	public int isExist(String name, String mobile) {
		return userSfKfMapper.isExist(name, mobile);
	}
	
}

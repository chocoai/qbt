package com.qbt.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserKf;
import com.qbt.persistent.mapper.UserKfMapper;
import com.qbt.service.UserKfService;

@Service
public class UserKfServiceImpl implements UserKfService {
	
	@Resource
	private UserKfMapper userKfMapper;
	
	@Override
	public int insert(UserKf userKf) {
		userKfMapper.insert(userKf);
		return userKf.getId();
	}

	@Override
	public UserKf selectById(Integer id) {
		return userKfMapper.selectById(id);
	}

	@Override
	public int updateById(UserKf userKf) {
		return userKfMapper.updateById(userKf);
	}

	@Override
	public int delete(Integer id) {
		return userKfMapper.delete(id);
	}

	@Override
	public List<UserKf> findByType(int type) {
		return userKfMapper.findByType(type);
	}
	
	@Override
	public List<UserKf> findByPage(PageEntity<UserKf> pageEntity) {
		return userKfMapper.findByPage(pageEntity);
	}

	@Override
	public List<UserKf> findByCondition(UserKf condition) {
		// TODO Auto-generated method stub
		return userKfMapper.findByCondition(condition);
	}

}

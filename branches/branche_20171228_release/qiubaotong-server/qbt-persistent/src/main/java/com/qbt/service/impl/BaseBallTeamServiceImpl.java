package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseBallTeam;
import com.qbt.persistent.mapper.BaseBallTeamMapper;
import com.qbt.service.BaseBallTeamService;

@Service
public class BaseBallTeamServiceImpl implements BaseBallTeamService {

	@Resource
	private BaseBallTeamMapper baseBallTeamMapper;
	
	@Override
	public List<BaseBallTeam> findByPage(PageEntity<BaseBallTeam> pageEntity) {
		// TODO Auto-generated method stub
		return baseBallTeamMapper.findByPage(pageEntity);
	}

	@Override
	public void add(BaseBallTeam baseTeachCenter) {
		// TODO Auto-generated method stub
		baseBallTeamMapper.insert(baseTeachCenter);
	}

	@Override
	public void update(BaseBallTeam baseTeachCenter) {
		// TODO Auto-generated method stub
		baseBallTeamMapper.updateByPrimaryKeySelective(baseTeachCenter);
	}

	@Override
	public BaseBallTeam findById(Integer id) {
		// TODO Auto-generated method stub
		return baseBallTeamMapper.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		baseBallTeamMapper.deleteById(id);
	}

}

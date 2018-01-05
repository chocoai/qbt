package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.RewardActitvity;
import com.qbt.persistent.mapper.RewardActitvityMapper;
import com.qbt.service.RewardActitvityService;

@Service
public class RewardActitvityServiceImpl implements RewardActitvityService {
	
	@Resource
	private RewardActitvityMapper mapper;
	
	@Override
	public void insert(RewardActitvity rewardActivity) {
		mapper.insert(rewardActivity);
	}

	@Override
	public void updateById(RewardActitvity rewardActivity) {
		mapper.updateById(rewardActivity);
	}

	@Override
	public void deleteById(RewardActitvity rewardActivity) {
		mapper.deleteById(rewardActivity);
	}



	@Override
	public List<RewardActitvity> list(PageEntity<RewardActitvity> pageEntity) {
		return mapper.list(pageEntity);
	}

	@Override
	public List<Integer> timeValidate(RewardActitvity rewardActivity) {
		return mapper.timeValidate(rewardActivity);
	}

	@Override
	public RewardActitvity findById(Integer id) {
		return mapper.findById(id);
	}
	
	@Override
	public RewardActitvity findCurrentRewardActitvity() {
		return mapper.findCurrentRewardActitvity();
	}

}

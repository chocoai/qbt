package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.RewardActitvity;

public interface RewardActitvityService {
	
	void insert(RewardActitvity rewardActivity);
	
	void updateById(RewardActitvity rewardActivity);
	
	void deleteById(RewardActitvity rewardActivity);
	
	List<RewardActitvity> list(PageEntity<RewardActitvity> pageEntity);
	
	List<Integer> timeValidate(RewardActitvity rewardActivity);
	
	RewardActitvity findById(Integer id);
	
	RewardActitvity findCurrentRewardActitvity();
	
}

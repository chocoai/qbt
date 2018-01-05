package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.RewardActitvity;

public interface RewardActitvityMapper {
	void insert(RewardActitvity rewardActivity);
	void updateById(RewardActitvity rewardActivity);
	void deleteById(RewardActitvity rewardActivity);
	List<RewardActitvity> list(PageEntity<RewardActitvity> pageEntity);
	List<Integer> timeValidate(RewardActitvity rewardActivity);
	RewardActitvity findById(@Param("id")Integer id);
	RewardActitvity findCurrentRewardActitvity();
}

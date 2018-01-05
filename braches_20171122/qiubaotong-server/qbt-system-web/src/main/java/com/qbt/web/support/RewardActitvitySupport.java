package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.OrderInfo;
import com.qbt.web.pojo.activity.ActivityVo;
import com.qbt.web.pojo.rewardActitvity.RewardActitvityPageReqVo;
import com.qbt.web.pojo.rewardActitvity.RewardActitvityVo;
import com.qbt.web.pojo.rewardActitvity.WinnerListPageReqVo;
import com.qbt.web.pojo.rewardActitvity.WinnerListVo;

public interface RewardActitvitySupport {
	
	boolean insert(RewardActitvityVo entity) throws Exception;
	
	boolean updateById(RewardActitvityVo entity) throws Exception;
	
	void deleteById(RewardActitvityVo entity);
	
	List<RewardActitvityVo> list(RewardActitvityPageReqVo vo);
	
	RewardActitvityVo findById(Integer id);
	
	List<ActivityVo> findCurrentCoupon(Integer type);
	
	public void reward(OrderInfo orderInfo);
	
	void deblockingCoupon(Integer orderId);
	
	boolean isWinner(Integer orderId);
	
	List<WinnerListVo> findWinnerListByPage(WinnerListPageReqVo vo);
	
}

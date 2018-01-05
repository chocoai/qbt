package com.qbt.web.pojo.rewardActitvity;

import com.qbt.common.result.Paging;

public class WinnerListPageReqVo extends Paging {
	private Integer rewardActivityId;
	private Integer status;
	public Integer getRewardActivityId() {
		return rewardActivityId;
	}
	public void setRewardActivityId(Integer rewardActivityId) {
		this.rewardActivityId = rewardActivityId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}

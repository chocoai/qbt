package com.qbt.web.pojo.activity;

import java.util.List;

public class ActivityInfoVo extends ActivityVo {

private List<ActivityOffConfigVo> configs;
	
	private List<ActivityOffAmountConfigVo> amountConfigs;

	public List<ActivityOffConfigVo> getConfigs() {
		return configs;
	}

	public void setConfigs(List<ActivityOffConfigVo> configs) {
		this.configs = configs;
	}

	public List<ActivityOffAmountConfigVo> getAmountConfigs() {
		return amountConfigs;
	}

	public void setAmountConfigs(List<ActivityOffAmountConfigVo> amountConfigs) {
		this.amountConfigs = amountConfigs;
	}
	
	
}

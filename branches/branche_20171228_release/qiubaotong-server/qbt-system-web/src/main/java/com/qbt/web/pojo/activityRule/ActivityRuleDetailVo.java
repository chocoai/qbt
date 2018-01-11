package com.qbt.web.pojo.activityRule;

import java.util.List;

public class ActivityRuleDetailVo extends ActivityRuleVo {
	
	private List<ActivityRuleConfigVo> configs;

	public List<ActivityRuleConfigVo> getConfigs() {
		return configs;
	}

	public void setConfigs(List<ActivityRuleConfigVo> configs) {
		this.configs = configs;
	}
	
}

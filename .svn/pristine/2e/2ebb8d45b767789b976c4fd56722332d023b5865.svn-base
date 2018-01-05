package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.activityRule.ActivityRuleDetailVo;
import com.qbt.web.pojo.activityRule.ActivityRulePageReqVo;
import com.qbt.web.pojo.activityRule.ActivityRuleVo;

public interface ActivityRuleSupport {
	
	List<ActivityRuleVo> list();
	
	List<ActivityRuleVo> findByPage(ActivityRulePageReqVo reqVo);
	
	ActivityRuleDetailVo findById(int id);
	
	int add(ActivityRuleDetailVo vo) throws BusinessException;
	
	boolean update(ActivityRuleDetailVo vo) throws BusinessException;
}

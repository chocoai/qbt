package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.activity.ActivityRequest;
import com.qbt.web.pojo.activity.ActivityResponse;

public interface ActivitySupport {
	
	public Map<String, Object> exportCoupon(Integer activityId, SysUser sysUser);
    
	public Map<String, Object> exportActivity(ActivityRequest activity, SysUser sysUser);

	public List<ActivityResponse> findByPage(ActivityRequest activity);
}

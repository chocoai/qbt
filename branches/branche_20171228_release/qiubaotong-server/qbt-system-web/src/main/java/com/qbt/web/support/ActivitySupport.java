package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.activity.ActivityAddReqVo;
import com.qbt.web.pojo.activity.ActivityPageReqVo;
import com.qbt.web.pojo.activity.ActivityVo;

public interface ActivitySupport {

	List<ActivityVo> findByPage(ActivityPageReqVo reqVo);
	
	ActivityVo findById(Integer id);
	
	int add(ActivityAddReqVo vo);
	
	boolean updateStatus(ActivityVo vo);
}

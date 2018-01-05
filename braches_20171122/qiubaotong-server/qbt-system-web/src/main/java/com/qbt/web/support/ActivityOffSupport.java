package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.activityOff.ActivityOffDetailVo;
import com.qbt.web.pojo.activityOff.ActivityOffPageReqVo;
import com.qbt.web.pojo.activityOff.ActivityOffVo;
import com.qbt.web.pojo.order.OrderActivityRequestVo;
import com.qbt.web.pojo.order.OrderActivityResponseVo;

public interface ActivityOffSupport {
	
	int add(ActivityOffDetailVo vo) throws BusinessException;
	
	boolean update(Integer id) throws BusinessException;
	
	boolean delete(Integer id);
	
	ActivityOffDetailVo findById(Integer id);
	
	List<ActivityOffVo> findByPage(ActivityOffPageReqVo reqVo);

	OrderActivityResponseVo checkActivity(OrderActivityRequestVo orderActivityVo);
}

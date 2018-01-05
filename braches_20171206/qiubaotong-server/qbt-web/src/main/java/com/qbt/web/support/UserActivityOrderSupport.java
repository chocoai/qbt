package com.qbt.web.support;

import com.qbt.persistent.entity.UserActivityOrder;
import com.qbt.web.pojo.ticket.UserActivityOrderVo;

public interface UserActivityOrderSupport {
	
	int add(UserActivityOrder vo);
	UserActivityOrderVo findById(Integer id);
	
}

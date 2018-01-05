package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.UserActivityOrder;
import com.qbt.web.pojo.ticket.UserActivityOrderAddReqVo;
import com.qbt.web.pojo.ticket.UserActivityOrderPageReqVo;
import com.qbt.web.pojo.ticket.UserActivityOrderVo;

public interface UserActivityOrderSupport {

	List<UserActivityOrderVo> findByPage(UserActivityOrderPageReqVo reqVo);
	
	UserActivityOrderVo findById(Integer id);
	
	int add(UserActivityOrderAddReqVo vo);
	
	boolean update(UserActivityOrderVo vo);
	
	void createPackageAfterPaid(int orderId);
	
	Map<String, String> pushTicketPackagePaymentNotify(UserActivityOrder userActivityOrder);
}

package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.ticket.UserPackageTicketAddReqVo;
import com.qbt.web.pojo.ticket.UserPackageTicketPageReqVo;
import com.qbt.web.pojo.ticket.UserPackageTicketVo;

public interface UserPackageTicketSupport {

	List<UserPackageTicketVo> findByPage(UserPackageTicketPageReqVo reqVo);
	
	UserPackageTicketVo findById(Integer id);
	
	int add(UserPackageTicketAddReqVo vo);
	
	boolean update(UserPackageTicketVo vo);
	
	List<UserPackageTicketVo> findTicketsForOrderDetail(Integer orderDetailId);
}

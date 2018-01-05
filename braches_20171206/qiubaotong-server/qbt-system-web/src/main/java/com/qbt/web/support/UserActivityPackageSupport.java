package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.ticket.UserActivityPackageAddReqVo;
import com.qbt.web.pojo.ticket.UserActivityPackagePageReqVo;
import com.qbt.web.pojo.ticket.UserActivityPackageVo;

public interface UserActivityPackageSupport {

	List<UserActivityPackageVo> findByPage(UserActivityPackagePageReqVo reqVo);
	
	UserActivityPackageVo findById(Integer id);
	
	int add(UserActivityPackageAddReqVo vo);
	
	boolean update(UserActivityPackageVo vo);
}

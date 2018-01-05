package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.asAp.UserAsApPageReqVo;
import com.qbt.web.pojo.asAp.UserAsApVo;
import com.qbt.web.pojo.asAp.UserAsUpdateVo;

public interface UserAsApSupport {
	
	List<UserAsApVo> findByPage(UserAsApPageReqVo reqVo);

	void updateStatus(UserAsUpdateVo u);

	List<UserAsApVo> list(Integer applyId,int applyType);
	
}

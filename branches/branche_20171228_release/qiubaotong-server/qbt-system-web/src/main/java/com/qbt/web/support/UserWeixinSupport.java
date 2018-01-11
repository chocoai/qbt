package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.userWeixin.UserWeixinPageReqVo;
import com.qbt.web.pojo.userWeixin.UserWeixinVo;
import com.qbt.web.pojo.userWeixin.WeiXinVO;

public interface UserWeixinSupport {

	List<UserWeixinVo> findByPage(UserWeixinPageReqVo reqVo);

	UserWeixinVo findById(Integer id);

	void update(UserWeixinPageReqVo reqVo);

	List<UserWeixinVo> list();

	WeiXinVO isWeiXinUser(String mobile);

	Integer findUserIdByOpenId(String openId);


}

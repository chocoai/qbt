package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserWeixin;

public interface UserWeixinMapper {
	
    int insert(UserWeixin user);

    UserWeixin selectById(Integer id);

    UserWeixin selectByOpenId(String openId);

    List<UserWeixin> findByPage(PageEntity<UserWeixin> pageEntity);

	void updateById(UserWeixin userWeixin);
    
	/**
	 * 根据客服类型查询微信用户
	 * @param kfType
	 * @return
	 */
    List<UserWeixin> findByKfType(@Param("kfType")Integer kfType);

	List<UserWeixin> list();

	List<UserWeixin> isWeiXinUser(@Param("mobile")String mobile);
	
	List<UserWeixin> findByMobileList(@Param("mobileList")List<String> mobileList);

}
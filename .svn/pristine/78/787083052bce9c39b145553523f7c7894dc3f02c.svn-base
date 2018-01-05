
 /**
 * @Title: VipUserServiceImpl.java
 * @Package com.qbt.service.impl
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2016年11月3日
 * @version V1.0
 **/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.persistent.mapper.VipInfoMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.VipUserService;

/**
  * @ClassName: VipUserServiceImpl
  * @Description: TODO
  * @author chenxiaocong 2016年11月3日
  * @modify chenxiaocong 2016年11月3日
  */
@Service
public class VipUserServiceImpl implements VipUserService {

	
	@Resource
	private VipInfoMapper vipInfoMapper;
	
	@Resource
	private RedisService redisManager;
	
	/**
	 * @Title: findByOpenId
	 * @Description: TODO
	 * @author: chenxiaocong 2016年11月3日
	 * @modify: chenxiaocong 2016年11月3日
	 * @param openId
	 * @return
	 * @see com.qbt.service.VipUserService#findByOpenId(java.lang.String)
	 */

	@Override
	public List<VipInfo> findByOpenId(String openId) {
		List<VipInfo> vipInfo = vipInfoMapper.selectByOpenId(openId);
		return vipInfo;
		
	}

	@Override
	public List<VipInfo> findByPage(PageEntity<VipInfo> pageEntity) {
		return vipInfoMapper.findByPage(pageEntity);
	}

	@Override
	public List<VipInfo> findByUserId(int userId) {
		List<VipInfo> vipInfo = vipInfoMapper.findByUserId(userId);
		return vipInfo;
	}
	
	@Override
	public int updateById(VipInfo vipInfo) {
		int result = vipInfoMapper.updateById(vipInfo);
		return result;
	}

	@Override
	public VipInfo findById(Integer id) {
		return vipInfoMapper.selectById(id);
	}

	
	 /**
	  * @Title: insert
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月4日
	  * @modify: chenxiaocong 2016年11月4日
	  * @param vipInfo
	  * @return
	  * @see com.qbt.service.VipUserService#insert(com.qbt.persistent.entity.VipInfo)
	  */
	
	@Override
	public int insert(VipInfo vipInfo) {
		int v = vipInfoMapper.insert(vipInfo);
		return v;
	}

	
	 /**
	  * @Title: findByOpenMobile
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月4日
	  * @modify: chenxiaocong 2016年11月4日
	  * @param mobile
	  * @return
	  * @see com.qbt.service.VipUserService#findByOpenMobile(java.lang.String)
	  */
	
	@Override
	public List<VipInfo> findByMobile(String mobile) {
		return vipInfoMapper.selectByMobile(mobile);
	}

	@Override
	public int updateMobile(VipInfo vipInfo) {
		int v = vipInfoMapper.updateMobile(vipInfo);
		return v;
	}
	
	@Override
	public int updateUserName(VipInfo vipInfo) {
		int v = vipInfoMapper.updateUserName(vipInfo);
		return v;
	}

	@Override
	public int updateUsedOrder(VipInfo vipInfo) {
		int v = vipInfoMapper.updateUsedOrder(vipInfo);
		return v;
	}

	@Override
	public VipInfo findBestByOpenId(String openId) {
		VipInfo v = vipInfoMapper.findBestByOpenId(openId);
		return v;
	}

	@Override
	public int updateImg(VipInfo vipInfo) {
		return vipInfoMapper.updateImg(vipInfo);
	}

	@Override
	public List<VipInfo> findByImageIds(List<Integer> imageIds) {
		return vipInfoMapper.selectByImageIds(imageIds);
	}

	@Override
	public List<String> findAllVipNo() {
		return vipInfoMapper.findAllVipNo();
	}

}

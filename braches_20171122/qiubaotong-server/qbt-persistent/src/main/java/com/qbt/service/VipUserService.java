
 /**
 * @Title: VipUserService.java
 * @Package com.qbt.service
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2016年11月3日
 * @version V1.0
 **/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipInfo;

/**
  * @ClassName: VipUserService
  * @Description: TODO
  * @author chenxiaocong 2016年11月3日
  * @modify chenxiaocong 2016年11月3日
  */

public interface VipUserService {

	List<VipInfo> findByOpenId(String openId);
	
	List<VipInfo> findByUserId(int userId);
	
	VipInfo findBestByOpenId(String openId);
	
	List<VipInfo> findByPage(PageEntity<VipInfo> pageEntity);
	
	int updateById(VipInfo vipInfo);
	
	VipInfo findById(Integer id);
	
	int insert(VipInfo vipInfo);
	
	List<VipInfo> findByMobile(String mobile);
	
	int updateMobile(VipInfo vipInfo);
	
	int updateUserName(VipInfo vipInfo);

	int updateUsedOrder(VipInfo vipInfo);
	
	int updateImg(VipInfo vipInfo);
	
	List<VipInfo> findByImageIds(List<Integer> imageIds);
	
	List<String> findAllVipNo();
}

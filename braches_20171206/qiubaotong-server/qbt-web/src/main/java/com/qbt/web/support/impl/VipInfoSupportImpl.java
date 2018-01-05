/**
 * Project Name:qbt-web
 * File Name:VipInfoSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年2月20日下午3:01:52
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.pojo.vip.VipOrderConfirmRequest;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.service.OrderInfoService;
import com.qbt.service.VipUserService;
import com.qbt.web.pojo.vip.VipInfoVo;
import com.qbt.web.pojo.vip.VipOrderConfirmVo;
import com.qbt.web.support.VipInfoSupport;

/**
 * ClassName:VipInfoSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月20日 下午3:01:52
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class VipInfoSupportImpl implements VipInfoSupport {
	
	@Resource
	private VipUserService vipUserService;
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Override
	public VipOrderConfirmVo checkVipOrderByUser(VipOrderConfirmRequest vipOrderConfirmRequest) {
		// 检查是否满足VIP订单要求
		VipOrderConfirmVo confirmVo = new VipOrderConfirmVo();
		if(!vipOrderConfirmRequest.getjMobile().equals(vipOrderConfirmRequest.getdMobile())
				|| !vipOrderConfirmRequest.getjName().equals(vipOrderConfirmRequest.getdName())){
			return confirmVo;
		}
		// 预约取包时间校验
		Date consignedTime = DateUtil.str2Date(vipOrderConfirmRequest.getConsignedTime().substring(0, 16)+":00", DateUtil.DATE_TIME_FORMAT_01);
		if (consignedTime.getTime() < System.currentTimeMillis()) {
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "取包时间已失效");
		}
		long sendSfTime = consignedTime.getTime();
		List<VipInfo> vipInfos = vipUserService.findByUserId(vipOrderConfirmRequest.getUserId());
		List<VipInfo> validVipInfos = new ArrayList<VipInfo>();
		for (VipInfo vipInfo : vipInfos) {
			confirmVo.setIsVip(true);
			// 检查用户是否是VIP购买用户
			long vipExpireTime = (vipInfo.getValidTime().getTime() + 24 * 60 * 60 * 1000);
			if (vipInfo.getStatus() == 2 
					|| vipExpireTime < System.currentTimeMillis()
					|| sendSfTime > vipExpireTime) {
				LogCvt.info("VIP会员用户已失效");
				continue;
			}

			if (!vipOrderConfirmRequest.getjMobile().equals(vipInfo.getMobile())
					|| !vipOrderConfirmRequest.getjName().equals(vipInfo.getUserName())) {
				LogCvt.info("用户名或手机号不匹配");
				continue;
			}
			OrderInfo lastVipOrder = orderInfoService.getLastVipOrder(vipOrderConfirmRequest.getjMobile(),
					vipOrderConfirmRequest.getjName(), vipInfo.getId());
			long deliverDate = 0;
			if (lastVipOrder != null) {
				deliverDate = DateUtil.str2Date(lastVipOrder.getDeliverDate(), DateUtil.DATE_TIME_FORMAT_01).getTime();
				if (deliverDate > consignedTime.getTime()) {
					continue;
				}
			}
			validVipInfos.add(vipInfo);
		}
		List<VipInfoVo> vipInfoList = confirmVo.getVipInfos();
		for(VipInfo vipInfo : validVipInfos){
			VipInfoVo vo = BeanUtil.a2b(vipInfo, VipInfoVo.class);
			vipInfoList.add(vo);
		}
		
		return confirmVo;
	}

}

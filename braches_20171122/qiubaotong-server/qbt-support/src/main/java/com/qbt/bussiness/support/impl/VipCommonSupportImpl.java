/**
 * Project Name:qbt-support
 * File Name:VipCommonSupportImpl.java
 * Package Name:com.qbt.bussiness.support.impl
 * Date:2017年9月1日上午11:38:44
 *
*/

package com.qbt.bussiness.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.pojo.vip.VipOrderConfirmRequest;
import com.qbt.bussiness.pojo.vip.VipOrderConfirmResponse;
import com.qbt.bussiness.support.VipCommonSupport;
import com.qbt.common.exception.BaseException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Arith;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OutRangeAddress;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.service.BaseCourseService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OutRangeAddressService;
import com.qbt.service.VipUserService;

/**
 * ClassName:VipCommonSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年9月1日 上午11:38:44
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class VipCommonSupportImpl implements VipCommonSupport {
	
	@Resource
	private VipUserService vipUserService;
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Resource
	private BaseCourseService baseCourseService;
	
	@Resource
	private OutRangeAddressService outRangeAddressService;
	
	@Override
	public VipOrderConfirmResponse checkVipOrder(VipOrderConfirmRequest vipOrderConfirmRequest) {
		// 检查是否满足VIP订单要求
		VipOrderConfirmResponse confirm = new VipOrderConfirmResponse();
		if (!vipOrderConfirmRequest.getjMobile().equals(vipOrderConfirmRequest.getdMobile())
				|| !vipOrderConfirmRequest.getjName().equals(vipOrderConfirmRequest.getdName())) {
			return confirm;
		}
		int num = vipOrderConfirmRequest.getNum();
		// 预约取包时间校验
		Date consignedTime = DateUtil.str2Date(
				vipOrderConfirmRequest.getConsignedTime().substring(0, 16) + ":00", DateUtil.DATE_TIME_FORMAT_01);
		if (consignedTime.getTime() < System.currentTimeMillis()) {
			throw new BaseException("取包时间已失效");
		}
		long sendSfTime = consignedTime.getTime();
		List<VipInfo> vipInfos = vipUserService.findByMobile(vipOrderConfirmRequest.getjMobile());
		List<VipInfo> validVipInfos = new ArrayList<VipInfo>();
		for (VipInfo vipInfo : vipInfos) {
			// 检查用户是否是VIP购买用户
			long vipExpireTime = (vipInfo.getValidTime().getTime() + 24 * 60 * 60 * 1000);
			if (vipInfo.getStatus() == 2 
					|| vipExpireTime < System.currentTimeMillis() 
					|| sendSfTime > vipExpireTime) {
				LogCvt.info("非VIP会员用户");
				continue;
			}

			if (!vipOrderConfirmRequest.getjMobile().equals(vipInfo.getMobile())
					|| !vipOrderConfirmRequest.getjName().equals(vipInfo.getUserName())) {
				LogCvt.info("用户名或手机号不匹配");
				continue;
			}
			OrderInfo lastVipOrder = orderInfoService.getLastVipOrder(
					vipOrderConfirmRequest.getjMobile(), vipOrderConfirmRequest.getjName(), vipInfo.getId());
			long deliverDate = 0;
			if (lastVipOrder != null) {
				deliverDate = DateUtil.str2Date(lastVipOrder.getDeliverDate(), DateUtil.DATE_TIME_FORMAT_01).getTime();
				if (deliverDate > consignedTime.getTime()) {
					continue;
				}
			}
			validVipInfos.add(vipInfo);
		}
		int validNum = validVipInfos.size() >= num ? num : validVipInfos.size();
		double[] orderAmount = new double[validNum];
		int[] vipId = new int[validNum];
		for (int i = 0; i < validNum; i++) {
			orderAmount[i] = validVipInfos.get(i).getOrderAmount();
			vipId[i] = validVipInfos.get(i).getId();
		}

		double outRangeAmount = 0;
		if (vipOrderConfirmRequest.getSrcCourseId() > 0) {
			BaseCourse course = baseCourseService.findById(vipOrderConfirmRequest.getSrcCourseId());
			if (course.getIsOutRange()) {
				outRangeAmount = Arith.add(outRangeAmount, course.getOutRangePrice());
			}
		} else {
			OutRangeAddress jAddress = outRangeAddressService.findByAreaId(vipOrderConfirmRequest.getSrc_area_id(),
					vipOrderConfirmRequest.getSrc_address());
			if (Checker.isNotEmpty(jAddress)) {
				outRangeAmount = Arith.add(outRangeAmount, jAddress.getOutRangePrice());
			}
		}
		if (vipOrderConfirmRequest.getDestCourseId() > 0) {
			BaseCourse course = baseCourseService.findById(vipOrderConfirmRequest.getDestCourseId());
			if (course.getIsOutRange()) {
				outRangeAmount = Arith.add(outRangeAmount, course.getOutRangePrice());
			}
		} else {
			// 偏远地址
			OutRangeAddress dAddress = outRangeAddressService.findByAreaId(vipOrderConfirmRequest.getDest_area_id(),
					vipOrderConfirmRequest.getDest_address());
			if (Checker.isNotEmpty(dAddress)) {
				outRangeAmount = Arith.add(outRangeAmount, dAddress.getOutRangePrice());
			}
		}
		confirm.setVipOrder(vipId.length > 0 ? true : false);
		confirm.setVipOrderAmount(orderAmount);
		confirm.setOutRangeAmount(outRangeAmount);
		confirm.setVipId(vipId);
		confirm.setNum(orderAmount.length);
		return confirm;
	}
	
}

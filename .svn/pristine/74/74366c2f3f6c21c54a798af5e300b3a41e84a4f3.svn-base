package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.UserActivityOrder;
import com.qbt.persistent.entity.UserActivityOrderDetail;
import com.qbt.service.UserActivityOrderDetailService;
import com.qbt.service.UserActivityOrderService;
import com.qbt.web.pojo.ticketPackage.UserPackageTicketVo;
import com.qbt.web.support.TicketPackageSupport;

@Service
public class TicketPackageSupportImpl implements TicketPackageSupport {
	
	@Resource
	private UserActivityOrderDetailService userActivityOrderDetailService;
	
	@Resource
	private UserActivityOrderService userActivityOrderService;
	
	@Override
	public Map<String, Object> export(UserPackageTicketVo vo) {
		
		Integer orderId = vo.getId();
		UserActivityOrder userActivityOrder = userActivityOrderService.findById(orderId);
		
		PageEntity<UserActivityOrderDetail> pageEntity = new PageEntity<UserActivityOrderDetail>();
		List<UserActivityOrderDetail> list = userActivityOrderDetailService.findByPage(pageEntity);
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		if(Checker.isNotEmpty(list)){
			Map<String, String> data = null;
			for(UserActivityOrderDetail detail:list){
				data = new HashMap<String, String>();
				data.put("activityName", userActivityOrder.getActivityName());
				data.put("purchaser", userActivityOrder.getPurchaser());
				data.put("purchaserAddress", userActivityOrder.getPurchaserAddress());
				data.put("purchaserNumber", userActivityOrder.getPurchaserNumber());
				data.put("code", detail.getCode());
				data.put("qrcode", detail.getQrCode());
				//TODO 增加分享页面的
				data.put("qrcode_url", "");
				data.put("qrcode_picture", detail.getCode()+".png");
				result.add(data);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", userActivityOrder.getActivityName());
		map.put("list", result);
		return map;
	}
	
}

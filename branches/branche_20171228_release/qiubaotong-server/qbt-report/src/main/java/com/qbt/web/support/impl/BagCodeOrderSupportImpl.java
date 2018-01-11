/**
 * Project Name:qbt-report
 * File Name:BagCodeOrderSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年8月25日下午3:51:45
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.pojo.bagCode.BagCodeOrderPageReq;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.BagCodeOrderStatus;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.dto.BagCodeOrderDto;
import com.qbt.persistent.entity.BagCodeOrder;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.BagCodeOrderService;
import com.qbt.web.support.BagCodeOrderSupport;

/**
 * ClassName:BagCodeOrderSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午3:51:45
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BagCodeOrderSupportImpl implements BagCodeOrderSupport {
	
	@Resource
	private BagCodeOrderService bagCodeOrderService;
	
	@Override
	public Map<String, Object> export(BagCodeOrderPageReq pageReq, String title, SysUser sysUser) {
		PageEntity<BagCodeOrderDto> pageEntity = BeanUtil.pageConvert(pageReq, BagCodeOrderDto.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("startTime", DateUtil.formatDate(pageReq.getStartTime(), DateUtil.DATE_FORMAT_02));
		map.put("endTime", DateUtil.formatDate(pageReq.getEndTime(), DateUtil.DATE_FORMAT_02));
		map.put("keyword", pageReq.getKeyword());
		map.put("status", pageReq.getStatus() == null ? null : BagCodeOrderStatus.getByCode(pageReq.getStatus()).getDesc());
		map.put("bagCode", pageReq.getBagCode());
		map.put("orderNumber", pageReq.getOrderNumber());
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			
			List<BagCodeOrder> list = bagCodeOrderService.findByPage(pageEntity);
			Map<String, String> data = null;
			for(BagCodeOrder order : list) {
				data = new HashMap<String, String>();
				data.put("bagCodePartnerName", order.getBagCodePartnerName());
				data.put("bagCode", order.getBagCode());
				data.put("nickname", order.getNickname());
				data.put("name", order.getName());
				data.put("mobile", order.getMobile());
				data.put("activityName", order.getActivityName());
				data.put("createTime", DateUtil.formatDate(order.getCreateTime(), DateUtil.DATE_TIME_FORMAT_01));
				data.put("orderNumber", order.getOrderNumber());
				data.put("status", BagCodeOrderStatus.getByCode(order.getStatus()).getDesc());
				data.put("result", order.getResult());
				listMap.add(data);
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		return map;
	}
	
	
	
}

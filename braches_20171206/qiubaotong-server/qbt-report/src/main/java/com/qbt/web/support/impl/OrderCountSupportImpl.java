package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.ToolsUtil;
import com.qbt.persistent.dto.OrderCountAmount;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.ReportOrderService;
import com.qbt.web.pojo.orderCount.OrderCountRequest;
import com.qbt.web.pojo.orderCount.OrderCountResponse;
import com.qbt.web.support.OrderCountSupport;

@Service
public class OrderCountSupportImpl implements OrderCountSupport{

	@Resource
	private ReportOrderService reportOrderService;
	
	@Override
	public List<OrderCountResponse> findByPage(OrderCountRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		
		List<OrderCountAmount> list = reportOrderService.orderCountAmount(pageEntity);
		List<OrderCountResponse> orderCountResponseList = new ArrayList<OrderCountResponse>();
		for (OrderCountAmount orderCountAmount : list) {
			OrderCountResponse orderCountResponse = new OrderCountResponse();
			orderCountResponse.setMobile(orderCountAmount.getMobile());
			orderCountResponse.setName(orderCountAmount.getName());
			orderCountResponse.setCount(orderCountAmount.getCount());
			orderCountResponseList.add(orderCountResponse);
		}
		req.setTotalCount(pageEntity.getTotalCount());
		return orderCountResponseList;
	}

	@Override
	public Map<String, Object> export(SysUser sysUser, String title, OrderCountRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<OrderCountAmount> list = reportOrderService.orderCountAmount(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(OrderCountAmount orderCountAmount : list){
					data = new HashMap<String, String>();
					data.put("name", orderCountAmount.getName());
					data.put("mobile", ToolsUtil.hideMobile(orderCountAmount.getMobile()));
					data.put("count", String.valueOf(orderCountAmount.getCount()));
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		return map;
	}

}

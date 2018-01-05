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
import com.qbt.persistent.dto.OrderFirst;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.ReportOrderService;
import com.qbt.web.pojo.orderFirst.OrderFirstRequest;
import com.qbt.web.pojo.orderFirst.OrderFirstResponse;
import com.qbt.web.support.OrderFirstSupport;

@Service
public class OrderFirstSupportImpl implements OrderFirstSupport{

	@Resource
	private ReportOrderService reportOrderService;
	
	@Override
	public List<OrderFirstResponse> findByPage(OrderFirstRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		
		List<OrderFirst> list = reportOrderService.orderFirstAmount(pageEntity);
		List<OrderFirstResponse> orderFirstResponseList = new ArrayList<OrderFirstResponse>();
		for (OrderFirst orderFirst : list) {
			OrderFirstResponse orderFirstResponse = new OrderFirstResponse();
			orderFirstResponse.setCreateTime(orderFirst.getCreateTime());
			orderFirstResponse.setMobile(orderFirst.getMobile());
			orderFirstResponse.setName(orderFirst.getName());
			orderFirstResponseList.add(orderFirstResponse);
		}
		req.setTotalCount(pageEntity.getTotalCount());
		return orderFirstResponseList;
	}

	@Override
	public Map<String, Object> export(SysUser sysUser, String title, OrderFirstRequest req) {
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
			List<OrderFirst> list = reportOrderService.orderFirstAmount(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(OrderFirst orderFirst : list){
					data = new HashMap<String, String>();
					data.put("createTime", DateUtil.formatDate(orderFirst.getCreateTime(), DateUtil.DATE_TIME_FORMAT_03));
					data.put("name", orderFirst.getName());
					data.put("mobile", orderFirst.getMobile());
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		return map;
	}
	
}

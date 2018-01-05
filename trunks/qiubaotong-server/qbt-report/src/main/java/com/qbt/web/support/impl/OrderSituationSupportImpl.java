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
import com.qbt.persistent.dto.OrderSituation;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.ReportOrderService;
import com.qbt.web.pojo.orderSituation.OrderSituationRequest;
import com.qbt.web.pojo.orderSituation.OrderSituationResponse;
import com.qbt.web.support.OrderSituationSupport;

@Service
public class OrderSituationSupportImpl implements OrderSituationSupport{

	@Resource
	private ReportOrderService reportOrderService;
	
	@Override
	public List<OrderSituationResponse> findByPage(OrderSituationRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		
		List<OrderSituation> list = reportOrderService.orderSituation(pageEntity);
		List<OrderSituationResponse> orderSituationResponseList = new ArrayList<OrderSituationResponse>();
		for (OrderSituation orderSituation : list) {
			OrderSituationResponse orderSituationResponse = new OrderSituationResponse();
			orderSituationResponse.setDate(orderSituation.getDate());
			orderSituationResponse.setTotal(orderSituation.getTotal());
			orderSituationResponse.setEffectiveOrder(orderSituation.getEffectiveOrder());
			orderSituationResponse.setWaitPay(orderSituation.getWaitPay());
			orderSituationResponse.setDestroyOrder(orderSituation.getDestroyOrder());
			orderSituationResponse.setCancelOrder(orderSituation.getCancelOrder());
			orderSituationResponseList.add(orderSituationResponse);
		}
		req.setTotalCount(pageEntity.getTotalCount());
		return orderSituationResponseList;
	}

	@Override
	public Map<String, Object> export(SysUser sysUser, String title, OrderSituationRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		int totalCount = 0;
		int totalEffectiveOrder = 0;
		int totalWaitPay = 0;
		int totalDestroyOrder = 0;
		int totalCancelOrder = 0;
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<OrderSituation> list = reportOrderService.orderSituation(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(OrderSituation orderSituation : list){
					data = new HashMap<String, String>();
					data.put("date", DateUtil.formatDate(orderSituation.getDate(), DateUtil.DATE_TIME_FORMAT_03));
					data.put("total", String.valueOf(orderSituation.getTotal()));
					data.put("effectiveOrder", String.valueOf(orderSituation.getEffectiveOrder()));
					data.put("waitPay", String.valueOf(orderSituation.getWaitPay()));
					data.put("destroyOrder", String.valueOf(orderSituation.getDestroyOrder()));
					data.put("cancelOrder", String.valueOf(orderSituation.getCancelOrder()));
					listMap.add(data);
					
					totalCount += orderSituation.getTotal();
					totalEffectiveOrder += orderSituation.getEffectiveOrder();
					totalWaitPay += orderSituation.getWaitPay();
					totalDestroyOrder += orderSituation.getDestroyOrder();
					totalCancelOrder += orderSituation.getCancelOrder();
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		
		map.put("totalCount", String.valueOf(totalCount));
		map.put("totalEffectiveOrder", String.valueOf(totalEffectiveOrder));
		map.put("totalWaitPay", String.valueOf(totalWaitPay));
		map.put("totalDestroyOrder", String.valueOf(totalDestroyOrder));
		map.put("totalCancelOrder", String.valueOf(totalCancelOrder));
		
		return map;
	}

	
	
}

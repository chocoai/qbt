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
import com.qbt.common.util.Utils;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.dto.ReportSiteOrder;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.ReportOrderService;
import com.qbt.web.pojo.orderSite.OrderSiteRequest;
import com.qbt.web.pojo.orderSite.OrderSiteResponse;
import com.qbt.web.support.OrderSiteSupport;

@Service
public class OrderSiteSupportImpl implements OrderSiteSupport {
	
	@Resource
	private ReportOrderService reportOrderService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, String title, OrderSiteRequest req) {
		ReportOrderQuery query = getQueryCondition(req);
		
		PageEntity<ReportOrderQuery> pageEntity = new PageEntity<ReportOrderQuery>();
		pageEntity.setCondition(query);
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
			List<ReportSiteOrder> list = reportOrderService.findSiteOrders(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(ReportSiteOrder o : list){
					data = new HashMap<String, String>();
					String jSiteName = o.getjAddrType() == 4 ? o.getjTreePath() : o.getjAddrName();
					String dSiteName = o.getdAddrType() == 4 ? o.getdTreePath() : o.getdAddrName();
					data.put("jSiteName", jSiteName);//寄件地区/寄件球场/寄件站点
					data.put("dSiteName", dSiteName);//收件地域/收件球场/收件站点
					data.put("totalOrder", o.getTotalOrder().toString());//总订单数
					data.put("validOrder", o.getValidOrder().toString());//有效订单
					data.put("cancelOrder", o.getCancelOrder().toString());//取消订单
					data.put("totalAmount", Utils.formatNumberByDecimal(o.getTotalAmount()));//总金额
					data.put("validAmount", Utils.formatNumberByDecimal(o.getValidAmount()));//有效金额
					data.put("cancelAmount", Utils.formatNumberByDecimal(o.getCancelAmount()));//退货金额
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		return map;
	}

	@Override
	public List<OrderSiteResponse> findByPage(OrderSiteRequest req) {
		ReportOrderQuery query = getQueryCondition(req);
		
		PageEntity<ReportOrderQuery> pageEntity = new PageEntity<ReportOrderQuery>();
		pageEntity.setCondition(query);
		pageEntity.setPageNumber(req.getPageNo());
		pageEntity.setPageSize(req.getPageSize());
		
		List<ReportSiteOrder> list = reportOrderService.findSiteOrders(pageEntity);
		List<OrderSiteResponse> respList = BeanUtil.list2list(list, OrderSiteResponse.class);
		req.setTotalCount(pageEntity.getTotalCount());
		return respList;
	}
	
	private ReportOrderQuery getQueryCondition(OrderSiteRequest req) {
		ReportOrderQuery query = new ReportOrderQuery();
		query.setStartDate(req.getStartDate());
		query.setEndDate(req.getEndDate());
		query.setjAddrType(req.getjAddrType());
		query.setdAddrType(req.getdAddrType());
		if(Checker.isNotEmpty(req.getjAddrType()) && req.getjAddrType() > 0){
			if(req.getjAddrType() == 4){
				query.setjAreaId(req.getjSiteId());
			}else{
				query.setjAddrId(req.getjSiteId());
			}
		}
		if(Checker.isNotEmpty(req.getdAddrType())  && req.getdAddrType() > 0){
			if(req.getdAddrType() == 4){
				query.setdAreaId(req.getdSiteId());
			}else{
				query.setdAddrId(req.getdSiteId());
			}
		}
		return query;
	}
	
}

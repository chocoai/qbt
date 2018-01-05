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
import com.qbt.web.pojo.orderCourse.OrderCourseRequest;
import com.qbt.web.pojo.orderCourse.OrderCourseResponse;
import com.qbt.web.support.OrderCourseSupport;

@Service
public class OrderCourseSupportImpl implements OrderCourseSupport {
	
	@Resource
	private ReportOrderService reportOrderService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, String title, OrderCourseRequest req) {
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
			List<ReportSiteOrder> list = reportOrderService.findCourseOrders(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(ReportSiteOrder o : list){
					data = new HashMap<String, String>();
					data.put("jAddrName", o.getjAddrName());//寄件球场名称
					data.put("dAddrName", o.getdAddrName());//收件球场名称
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
	public List<OrderCourseResponse> findByPage(OrderCourseRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		
		List<ReportSiteOrder> list = reportOrderService.findCourseOrders(pageEntity);
		List<OrderCourseResponse> respList = BeanUtil.list2list(list, OrderCourseResponse.class);
		req.setTotalCount(pageEntity.getTotalCount());
		return respList;
	}

}

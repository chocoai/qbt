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
import com.qbt.common.util.Utils;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.dto.ReportSiteOrder;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.ReportOrderService;
import com.qbt.web.pojo.orderJCourse.OrderJCourseRequest;
import com.qbt.web.pojo.orderJCourse.OrderJCourseResponse;
import com.qbt.web.support.OrderJCourseSupport;

@Service
public class OrderJCourseSupportImpl implements OrderJCourseSupport {
	
	@Resource
	private ReportOrderService reportOrderService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, String title, OrderJCourseRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		
		int pageNo = 0;
		int sumTotalOrder = 0;
		int sumValidOrder = 0;
		int sumCancelOrder = 0;
		double sumTotalAmount = 0;
		double sumValidAmount = 0;
		double sumCancelAmount = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<ReportSiteOrder> list = reportOrderService.findJCourseOrders(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(ReportSiteOrder o : list){
					data = new HashMap<String, String>();
					data.put("jMobile", ToolsUtil.hideMobile(o.getjMobile()));//寄件人手机
					data.put("jContact", o.getjContact());//寄件人姓名
					data.put("jAddrName", o.getjAddrName());//寄件球场名称
					data.put("dAddrName", o.getdAddrName());//收件球场名称
					data.put("totalOrder", o.getTotalOrder().toString());//总订单数
					data.put("validOrder", o.getValidOrder().toString());//有效订单
					data.put("cancelOrder", o.getCancelOrder().toString());//取消订单
					data.put("totalAmount", Utils.formatNumberByDecimal(o.getTotalAmount()));//总金额
					data.put("validAmount", Utils.formatNumberByDecimal(o.getValidAmount()));//有效金额
					data.put("cancelAmount", Utils.formatNumberByDecimal(o.getCancelAmount()));//退货金额
					listMap.add(data);
					
					sumTotalOrder += o.getTotalOrder();
					sumValidOrder += o.getValidOrder();
					sumCancelOrder += o.getCancelOrder();
					sumTotalAmount += o.getTotalAmount();
					sumValidAmount += o.getValidAmount();
					sumCancelAmount += o.getCancelAmount();
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		map.put("sumTotalOrder", String.valueOf(sumTotalOrder));
		map.put("sumValidOrder", String.valueOf(sumValidOrder));
		map.put("sumCancelOrder", String.valueOf(sumCancelOrder));
		map.put("sumTotalAmount", Utils.formatNumberByDecimal(sumTotalAmount));
		map.put("sumValidAmount", Utils.formatNumberByDecimal(sumValidAmount));
		map.put("sumCancelAmount", Utils.formatNumberByDecimal(sumCancelAmount));
		return map;
	}

	@Override
	public List<OrderJCourseResponse> findByPage(OrderJCourseRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		
		List<ReportSiteOrder> list = reportOrderService.findJCourseOrders(pageEntity);
		List<OrderJCourseResponse> respList = BeanUtil.list2list(list, OrderJCourseResponse.class);
		req.setTotalCount(pageEntity.getTotalCount());
		return respList;
	}

}

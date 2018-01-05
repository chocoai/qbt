package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderInfo;
import com.qbt.persistent.dto.OrderCountAmount;
import com.qbt.persistent.dto.OrderFirst;
import com.qbt.persistent.dto.OrderSituation;
import com.qbt.persistent.dto.ReportOrderAmount;
import com.qbt.persistent.dto.ReportOrderCostItem;
import com.qbt.persistent.dto.ReportOrderDetail;
import com.qbt.persistent.dto.ReportOrderPage;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.dto.ReportPartnerOrder;
import com.qbt.persistent.dto.ReportSiteOrder;
import com.qbt.persistent.dto.ReportUserOrderCount;
import com.qbt.persistent.mapper.ReportOrderMapper;
import com.qbt.service.ReportOrderService;

@Service
public class ReportOrderServiceImpl implements ReportOrderService {
	
	@Resource
	private ReportOrderMapper reportOrderMapper;
	
	@Override
	public List<ReportOrderDetail> findOrderDetails(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findOrderDetails(pageEntity);
	}

	@Override
	public List<ReportOrderAmount> findOrdersAmount(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findOrdersAmount(pageEntity);
	}

	@Override
	public List<OrderFirst> orderFirstAmount(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.orderFirstAmount(pageEntity);
	}

	@Override
	public List<OrderCountAmount> orderCountAmount(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.orderCountAmount(pageEntity);
	}

	@Override
	public List<OrderSituation> orderSituation(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.orderSituation(pageEntity);
	}
	public List<ReportSiteOrder> findJCourseOrders(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findJCourseOrders(pageEntity);
	}

	@Override
	public List<ReportSiteOrder> findJAreaOrders(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findJAreaOrders(pageEntity);
	}

	@Override
	public List<ReportUserOrderCount> findUserOrderCountByPage(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findUserOrderCountByPage(pageEntity);
	}
	
	public List<ReportSiteOrder> findCourseOrders(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findCourseOrders(pageEntity);
	}

	@Override
	public List<ReportSiteOrder> findAreaOrders(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findAreaOrders(pageEntity);
	}

	@Override
	public List<ReportSiteOrder> findSiteOrders(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findSiteOrders(pageEntity);
	}

	@Override
	public List<ReportPartnerOrder> findPartnerOrders(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findPartnerOrders(pageEntity);
	}

	@Override
	public List<ReportSiteOrder> findSiteTimeOrders(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findSiteTimeOrders(pageEntity);
	}

	@Override
	public List<ReportUserOrderCount> findUserOrderCountTimeByPage(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findUserOrderCountTimeByPage(pageEntity);
	}

	@Override
	public List<ReportOrderCostItem> findCostItemByPage(PageEntity<ReportOrderQuery> pageEntity) {
		return reportOrderMapper.findCostItemByPage(pageEntity);
	}

	public List<BossOrderInfo> findByPageReport(PageEntity<ReportOrderPage> pageEntity) {
		return reportOrderMapper.findByPageReport(pageEntity);
	}
	
}

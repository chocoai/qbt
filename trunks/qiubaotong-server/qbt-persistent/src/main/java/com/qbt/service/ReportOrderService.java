package com.qbt.service;

import java.util.List;

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

public interface ReportOrderService {
	
	public List<ReportOrderDetail> findOrderDetails(PageEntity<ReportOrderQuery> pageEntity);
	
	public List<ReportOrderAmount> findOrdersAmount(PageEntity<ReportOrderQuery> pageEntity);
	
	public List<OrderFirst> orderFirstAmount(PageEntity<ReportOrderQuery> pageEntity);

	public List<OrderCountAmount> orderCountAmount(PageEntity<ReportOrderQuery> pageEntity);

	public List<OrderSituation> orderSituation(PageEntity<ReportOrderQuery> pageEntity);
	
	public List<ReportSiteOrder> findJCourseOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	public List<ReportUserOrderCount> findUserOrderCountByPage(PageEntity<ReportOrderQuery> pageEntity);

	public List<ReportSiteOrder> findJAreaOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	public List<ReportSiteOrder> findCourseOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	public List<ReportSiteOrder> findAreaOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	public List<ReportSiteOrder> findSiteOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	public List<ReportPartnerOrder> findPartnerOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	public List<ReportSiteOrder> findSiteTimeOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	public List<ReportUserOrderCount> findUserOrderCountTimeByPage(PageEntity<ReportOrderQuery> pageEntity);
	
	public List<ReportOrderCostItem> findCostItemByPage(PageEntity<ReportOrderQuery> pageEntity);

	/**
	 * 报表
	 * @param pageEntity
	 * @author wuwang
	 * @return
	 */
	public List<BossOrderInfo> findByPageReport(PageEntity<ReportOrderPage> pageEntity);
	
}

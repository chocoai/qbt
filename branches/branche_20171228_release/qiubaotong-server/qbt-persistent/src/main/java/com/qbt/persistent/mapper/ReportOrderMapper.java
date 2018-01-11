package com.qbt.persistent.mapper;

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

public interface ReportOrderMapper {
	
	List<ReportOrderDetail> findOrderDetails(PageEntity<ReportOrderQuery> pageEntity);
	
	List<ReportOrderAmount> findOrdersAmount(PageEntity<ReportOrderQuery> pageEntity);

	List<OrderFirst> orderFirstAmount(PageEntity<ReportOrderQuery> pageEntity);

	List<OrderCountAmount> orderCountAmount(PageEntity<ReportOrderQuery> pageEntity);

	List<OrderSituation> orderSituation(PageEntity<ReportOrderQuery> pageEntity);
	
	List<ReportSiteOrder> findJCourseOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	List<ReportUserOrderCount> findUserOrderCountByPage(PageEntity<ReportOrderQuery> pageEntity);

	List<ReportSiteOrder> findJAreaOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	List<ReportSiteOrder> findCourseOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	List<ReportSiteOrder> findAreaOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	List<ReportSiteOrder> findSiteOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	List<ReportPartnerOrder> findPartnerOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	List<ReportSiteOrder> findSiteTimeOrders(PageEntity<ReportOrderQuery> pageEntity);
	
	List<ReportUserOrderCount> findUserOrderCountTimeByPage(PageEntity<ReportOrderQuery> pageEntity);
	
	List<ReportOrderCostItem> findCostItemByPage(PageEntity<ReportOrderQuery> pageEntity);
	
	List<BossOrderInfo> findByPageReport(PageEntity<ReportOrderPage> pageEntity);
}

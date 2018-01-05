package com.qbt.web.support;

import java.util.List;

import com.qbt.sf.api.bean.routepush.RoutePushReqDeliver;
import com.qbt.web.pojo.sf.WayBill;

public interface OrderWaybillSupport {

	public void insert(RoutePushReqDeliver deliver);

	public List<WayBill> findByWayBill(String orderId);
}

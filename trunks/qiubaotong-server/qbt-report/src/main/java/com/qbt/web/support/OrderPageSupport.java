package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderPage.OrderPageRequest;
import com.qbt.web.pojo.orderPage.OrderPageResponse;

public interface OrderPageSupport {

	List<OrderPageResponse> findByPage(OrderPageRequest req);

	Map<String, Object> export(SysUser sysUser, String title, OrderPageRequest req);

}

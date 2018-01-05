package com.qbt.web.support;

import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderRefund.OrderRefundRequest;

public interface OrderRefundSupport {

	Map<String, Object> export(SysUser sysUser, String title, OrderRefundRequest req);

}

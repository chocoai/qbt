package com.qbt.web.support;

import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderInfoRequest;

public interface SaleOrderInfoSupport {

	Map<String, Object> export(SysUser sysUser, String title, SaleOrderInfoRequest req, String currentDay);

}

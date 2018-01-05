package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.salebusiness.SaleOrderResponse;
import com.qbt.web.pojo.salebusiness.SaleReqPage;
import com.qbt.web.pojo.salebusiness.SaleSubcripbeResponse;

public interface SalerBusinessSupport {

	List<SaleOrderResponse> findOrderByPage(SaleReqPage req);
	
	Map<String, Object> exportSaleOrder(SaleReqPage req, SysUser sysUser);

	List<SaleSubcripbeResponse> findSubcripbeByPage(SaleReqPage req);

	Map<String, Object> exportSaleSubcripbe(SaleReqPage req, SysUser sysUser);

}

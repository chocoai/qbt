package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.saleOrderInfo.SaleOrderInfoPageReqVo;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderInfoVo;

public interface SaleOrderInfoSupport {

	List<SaleOrderInfoVo> findByPageBySaleId(SaleOrderInfoPageReqVo reqVo);

}

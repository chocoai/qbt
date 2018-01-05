package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.saleWeixinSubcripbeInfo.SaleWeixinSubcripbeInfoPageReqVo;
import com.qbt.web.pojo.saleWeixinSubcripbeInfo.SaleWeixinSubcripbeInfoVo;

public interface SaleWeixinSubcripbeInfoSupport {

	List<SaleWeixinSubcripbeInfoVo> findByPageBySaleId(SaleWeixinSubcripbeInfoPageReqVo reqVo);

}

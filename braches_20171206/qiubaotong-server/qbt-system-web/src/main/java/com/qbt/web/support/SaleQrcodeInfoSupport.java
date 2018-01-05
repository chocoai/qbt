package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.saleQrcodeInfo.SaleQrcodeInfoPageReqVo;
import com.qbt.web.pojo.saleQrcodeInfo.SaleQrcodeInfoVo;

public interface SaleQrcodeInfoSupport {

	List<SaleQrcodeInfoVo> findByPage(SaleQrcodeInfoPageReqVo reqVo);

	
	
}

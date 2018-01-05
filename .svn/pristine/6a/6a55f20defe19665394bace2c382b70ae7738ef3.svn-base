package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.dto.SaleOrderInfoDto;
import com.qbt.persistent.entity.SaleOrderInfo;
import com.qbt.service.SaleOrderInfoService;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderInfoPageReqVo;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderInfoVo;
import com.qbt.web.support.SaleOrderInfoSupport;

@Service
public class SaleOrderInfoSupportImpl implements SaleOrderInfoSupport {

	@Resource
	private SaleOrderInfoService saleOrderInfoService;
	
	@Override
	public List<SaleOrderInfoVo> findByPageBySaleId(SaleOrderInfoPageReqVo reqVo) {
		PageEntity<SaleOrderInfoDto> pageEntity = BeanUtil.pageConvert(reqVo, SaleOrderInfoDto.class);
		List<SaleOrderInfo> list = saleOrderInfoService.findByPageBySaleId(pageEntity);
		List<SaleOrderInfoVo> voList = BeanUtil.list2list(list, SaleOrderInfoVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}

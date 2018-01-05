package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.dto.SaleWeixinSubcripbeInfoDto;
import com.qbt.persistent.entity.SaleWeixinSubcripbeInfo;
import com.qbt.service.SaleWeixinSubcripbeInfoService;
import com.qbt.web.pojo.saleWeixinSubcripbeInfo.SaleWeixinSubcripbeInfoPageReqVo;
import com.qbt.web.pojo.saleWeixinSubcripbeInfo.SaleWeixinSubcripbeInfoVo;
import com.qbt.web.support.SaleWeixinSubcripbeInfoSupport;

@Service
public class SaleWeixinSubcripbeInfoSupportImpl implements SaleWeixinSubcripbeInfoSupport {

	@Resource
	private SaleWeixinSubcripbeInfoService saleWeixinSubcripbeInfoService; 
	
	@Override
	public List<SaleWeixinSubcripbeInfoVo> findByPageBySaleId(SaleWeixinSubcripbeInfoPageReqVo reqVo) {
		PageEntity<SaleWeixinSubcripbeInfoDto> pageEntity = BeanUtil.pageConvert(reqVo, SaleWeixinSubcripbeInfoDto.class);
		List<SaleWeixinSubcripbeInfo> list = saleWeixinSubcripbeInfoService.findByPageBySaleId(pageEntity);
		List<SaleWeixinSubcripbeInfoVo> voList = BeanUtil.list2list(list, SaleWeixinSubcripbeInfoVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}

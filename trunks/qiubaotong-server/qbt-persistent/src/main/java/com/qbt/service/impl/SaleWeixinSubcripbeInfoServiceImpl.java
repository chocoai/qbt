package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleSubcripbeInfoDto;
import com.qbt.persistent.dto.SaleWeixinSubcripbeInfoDto;
import com.qbt.persistent.entity.SaleWeixinSubcripbeInfo;
import com.qbt.persistent.mapper.SaleWeixinSubcripbeInfoMapper;
import com.qbt.service.SaleWeixinSubcripbeInfoService;

@Service
public class SaleWeixinSubcripbeInfoServiceImpl implements SaleWeixinSubcripbeInfoService {

	@Resource
	private SaleWeixinSubcripbeInfoMapper saleWeixinSubcripbeInfoMapper;
	
	@Override
	public List<SaleWeixinSubcripbeInfo> findByPage(PageEntity<SaleWeixinSubcripbeInfo> pageEntity) {
		return null;
	}
	
	
	@Override
	public int insert(SaleWeixinSubcripbeInfo saleWeixinSubcripbeInfo) {
		return saleWeixinSubcripbeInfoMapper.insert(saleWeixinSubcripbeInfo);
	}


	@Override
	public List<SaleSubcripbeInfoDto> reportSubcripbeInfoPage(PageEntity<SaleSubcripbeInfoDto> pageEntity) {
		return saleWeixinSubcripbeInfoMapper.reportSubcripbeInfoPage(pageEntity);
	}

	public SaleWeixinSubcripbeInfoDto settleAbleInfo(SaleWeixinSubcripbeInfoDto dto) {
		return saleWeixinSubcripbeInfoMapper.settleAbleInfo(dto);
	}


	@Override
	public int settleOrder(SaleWeixinSubcripbeInfoDto dto) {
		return saleWeixinSubcripbeInfoMapper.settleOrder(dto);
	}


	@Override
	public List<SaleWeixinSubcripbeInfo> findByPageBySaleId(PageEntity<SaleWeixinSubcripbeInfoDto> pageEntity) {
		return saleWeixinSubcripbeInfoMapper.findByPageBySaleId(pageEntity);
	}


	@Override
	public List<SaleSubcripbeInfoDto> wechatUserSubcripbeList(SaleSubcripbeInfoDto dto) {
		return saleWeixinSubcripbeInfoMapper.wechatUserSubcripbeList(dto);
	}
	
}

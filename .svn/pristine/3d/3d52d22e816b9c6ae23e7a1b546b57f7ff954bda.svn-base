package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleOrderInfoDto;
import com.qbt.persistent.entity.SaleOrderInfo;
import com.qbt.persistent.mapper.SaleOrderInfoMapper;
import com.qbt.service.SaleOrderInfoService;

@Service
public class SaleOrderInfoServiceImpl implements SaleOrderInfoService {
	
	@Resource
	private SaleOrderInfoMapper saleOrderInfoMapper;
	
	@Override
	public List<SaleOrderInfo> findByPage(PageEntity<SaleOrderInfo> pageEntity) {
		return null;
	}

	@Override
	public int insert(SaleOrderInfo saleOrderInfo) {
		return saleOrderInfoMapper.insert(saleOrderInfo);
	}

	@Override
	public void updateStatus(int orderId, int status) {
		saleOrderInfoMapper.updateStatus(orderId,status);
	}

	@Override
	public List<SaleOrderInfoDto> reportOrderInfoPage(PageEntity<SaleOrderInfoDto> pageEntity) {
		return saleOrderInfoMapper.reportOrderInfoPage(pageEntity);
	}
	
	public SaleOrderInfoDto settleAbleInfo(SaleOrderInfoDto dto) {
		return saleOrderInfoMapper.settleAbleInfo(dto);
	}

	@Override
	public int settleOrder(SaleOrderInfoDto dto) {
		return saleOrderInfoMapper.settleOrder(dto);
	}

	@Override
	public List<SaleOrderInfo> findByPageBySaleId(PageEntity<SaleOrderInfoDto> pageEntity) {
		return saleOrderInfoMapper.findByPageBySaleId(pageEntity);
	}

	@Override
	public List<SaleOrderInfoDto> wechatUserOrderList(SaleOrderInfoDto dto) {
		return saleOrderInfoMapper.wechatUserOrderList(dto);
	}

}

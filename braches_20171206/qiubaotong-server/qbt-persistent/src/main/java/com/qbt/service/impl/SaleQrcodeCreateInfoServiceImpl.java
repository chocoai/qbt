package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleQrcodeCreateInfoDto;
import com.qbt.persistent.entity.SaleQrcodeCreateInfo;
import com.qbt.persistent.mapper.SaleQrcodeCreateInfoMapper;
import com.qbt.service.SaleQrcodeCreateInfoService;

@Service
public class SaleQrcodeCreateInfoServiceImpl implements SaleQrcodeCreateInfoService{

	@Resource
	private SaleQrcodeCreateInfoMapper saleQrcodeCreateInfoMapper;
	
	@Override
	public int insert(SaleQrcodeCreateInfo saleQrcodeCreateInfo) {
		return saleQrcodeCreateInfoMapper.insert(saleQrcodeCreateInfo);
	}

	@Override
	public List<SaleQrcodeCreateInfo> findByPage(PageEntity<SaleQrcodeCreateInfoDto> pageEntity) {
		return saleQrcodeCreateInfoMapper.findByPage(pageEntity);
	}

	@Override
	public List<SaleQrcodeCreateInfo> findByCondition(SaleQrcodeCreateInfo condition) {
		return saleQrcodeCreateInfoMapper.findByCondition(condition);
	}

	@Override
	public SaleQrcodeCreateInfo findById(Integer id) {
		// TODO Auto-generated method stub
		return saleQrcodeCreateInfoMapper.selectById(id);
	}

	@Override
	public int updateById(SaleQrcodeCreateInfo createInfo) {
		return saleQrcodeCreateInfoMapper.updateById(createInfo);
	}

	@Override
	public Integer getAutoMaxNawmeNumber() {
		// TODO Auto-generated method stub
		return saleQrcodeCreateInfoMapper.getAutoMaxNawmeNumber();
	}

}

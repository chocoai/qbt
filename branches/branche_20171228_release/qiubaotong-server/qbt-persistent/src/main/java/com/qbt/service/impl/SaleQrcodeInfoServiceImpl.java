package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.entity.SaleQrcodeInfo;
import com.qbt.persistent.mapper.SaleQrcodeInfoMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.SaleQrcodeInfoService;

@Service
public class SaleQrcodeInfoServiceImpl implements SaleQrcodeInfoService{

	@Resource
	private SaleQrcodeInfoMapper saleQrcodeInfoMapper;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public int getMaxId() {
		return saleQrcodeInfoMapper.getMaxId();
	}

	@Override
	public List<SaleQrcodeInfo> findByPage(PageEntity<SaleQrcodeInfo> pageEntity) {
		return saleQrcodeInfoMapper.findByPage(pageEntity);
	}

	@Override
	public List<SaleQrcodeInfo> findList() {
		return saleQrcodeInfoMapper.findList();
	}

	@Override
	public int insertByBatch(List<SaleQrcodeInfo> infos) {
		return saleQrcodeInfoMapper.insertByBatch(infos);
	}

	@Override
	public SaleQrcodeInfo findByCode(String salesmanCode) {
		return saleQrcodeInfoMapper.selectByCode(salesmanCode);
	}

	@Override
	public int updateById(SaleQrcodeInfo saleQrcodeInfo) {
		return saleQrcodeInfoMapper.updateById(saleQrcodeInfo);
	}

	@Override
	public List<String> findNoApplySalesmanCode() {
		return saleQrcodeInfoMapper.findNoApplySalesmanCode();
	}

	@Override
	public String getSysSalemanCode() {
		return redisService.lpop(RedisKeyUtil.salesman_code_key());
	}

}

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleUserDto;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.mapper.SaleUserMapper;
import com.qbt.service.SaleUserService;

@Service
public class SaleUserServiceImpl implements SaleUserService {

	@Resource
	private SaleUserMapper saleUserMapper;
	
	@Override
	public int insert(SaleUser saleUser) {
		saleUserMapper.insert(saleUser);
		return saleUser.getId();
	}
	
	@Override
	public SaleUser findById(Integer id) {
		return saleUserMapper.findById(id);
	}

	@Override
	public SaleUser findByCode(String code) {
		return saleUserMapper.findByCode(code);
	}

	@Override
	public int updateById(SaleUser saleUser) {
		return saleUserMapper.updateById(saleUser);
	}

	@Override
	public SaleUser findByUserId(Integer userId) {
		return saleUserMapper.findByUserId(userId);
	}

	@Override
	public List<SaleUserDto> findByPage(PageEntity<SaleUserDto> pageEntity) {
		return saleUserMapper.findByPage(pageEntity);
	}

	@Override
	public int updateForBoss(SaleUser saleUser) {
		return saleUserMapper.updateForBoss(saleUser);
	}

	@Override
	public int udpateBatch(SaleUserDto dto) {
		return saleUserMapper.udpateBatch(dto);
	}

	@Override
	public int existCode(Integer userId, String code) {
		return saleUserMapper.existCode(userId, code);
	}

	@Override
	public int updateForWechatApply(SaleUser saleUser) {
		return saleUserMapper.updateForWechatApply(saleUser);
	}

	@Override
	public int auditSaleUser(SaleUser saleUser) {
		return saleUserMapper.auditSaleUser(saleUser);
	}

	@Override
	public List<SaleUser> listByApplyStatus(Integer applyStatus) {
		return saleUserMapper.listByApplyStatus(applyStatus);
	}

}

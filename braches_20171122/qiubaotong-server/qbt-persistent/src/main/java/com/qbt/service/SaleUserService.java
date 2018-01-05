package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleUserDto;
import com.qbt.persistent.entity.SaleUser;

public interface SaleUserService {
	
	int insert(SaleUser saleUser);

	SaleUser findById(Integer id);
	
	SaleUser findByCode(String code);
	
	int updateById(SaleUser saleUser);
	
	SaleUser findByUserId(Integer userId);
	
	List<SaleUserDto> findByPage(PageEntity<SaleUserDto> pageEntity);
	
	int updateForBoss(SaleUser saleUser);
	
	int udpateBatch(SaleUserDto dto);
	
	int existCode(Integer userId, String code);
	
	int updateForWechatApply(SaleUser saleUser);
	 
	int auditSaleUser(SaleUser saleUser);

	List<SaleUser> listByApplyStatus(Integer applyStatus);
}

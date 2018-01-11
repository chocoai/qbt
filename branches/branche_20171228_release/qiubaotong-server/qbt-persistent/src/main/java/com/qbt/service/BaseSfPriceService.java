package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseSfPrice;

public interface BaseSfPriceService {

	
	public int insert(BaseSfPrice sfPrice);
	
	public int update(BaseSfPrice price);
	
	public BaseSfPrice findByCityName(BaseSfPrice price);

	public List<BaseSfPrice> findByPage(PageEntity<BaseSfPrice> pageEntity);

	public void deleteById(Integer id);

	public BaseSfPrice findById(Integer id);
	
	
}

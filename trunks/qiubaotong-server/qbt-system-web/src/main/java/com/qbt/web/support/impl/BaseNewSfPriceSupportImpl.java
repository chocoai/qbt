package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.BaseNewSfPrice;
import com.qbt.service.BaseNewSfPriceService;
import com.qbt.web.pojo.baseNewSfPrice.BaseNewSfPricePageReqVo;
import com.qbt.web.pojo.baseNewSfPrice.BaseNewSfPriceVo;
import com.qbt.web.support.BaseNewSfPriceSupport;

@Service
public class BaseNewSfPriceSupportImpl implements BaseNewSfPriceSupport{

	@Resource
	private BaseNewSfPriceService baseNewSfPriceService;
	
	@Override
	public List<BaseNewSfPriceVo> findByPage(BaseNewSfPricePageReqVo reqVo) {
		PageEntity<BaseNewSfPrice> pageEntity = BeanUtil.pageConvert(reqVo, BaseNewSfPrice.class);
		List<BaseNewSfPrice> list = baseNewSfPriceService.findByPage(pageEntity);
		List<BaseNewSfPriceVo> voList = BeanUtil.list2list(list, BaseNewSfPriceVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseNewSfPriceVo vo) {
		BaseNewSfPrice baseNewSfPrice = BeanUtil.a2b(vo, BaseNewSfPrice.class);
		baseNewSfPriceService.insert(baseNewSfPrice);
	}

	@Override
	public BaseNewSfPriceVo findById(Integer id) {
		BaseNewSfPrice baseNewSfPrice =  baseNewSfPriceService.findById(id);
		BaseNewSfPriceVo vo = BeanUtil.a2b(baseNewSfPrice, BaseNewSfPriceVo.class);
		return vo;
	}

	@Override
	public void update(BaseNewSfPriceVo vo) {
		BaseNewSfPrice baseNewSfPrice = BeanUtil.a2b(vo, BaseNewSfPrice.class);
		baseNewSfPriceService.update(baseNewSfPrice);	
	}

	@Override
	public void delete(Integer id) {
		baseNewSfPriceService.delete(id);
	}
	
}

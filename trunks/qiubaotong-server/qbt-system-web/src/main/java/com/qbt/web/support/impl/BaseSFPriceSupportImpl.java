package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.BaseSfPrice;
import com.qbt.service.BaseSfPriceService;
import com.qbt.web.pojo.baseSFPrice.BaseSFPricePageReqVo;
import com.qbt.web.pojo.baseSFPrice.BaseSFPriceVo;
import com.qbt.web.support.BaseSFPriceSupport;

@Service
public class BaseSFPriceSupportImpl implements BaseSFPriceSupport{

	@Resource
	private BaseSfPriceService baseSFPriceService;
	
	@Override
	public List<BaseSFPriceVo> findByPage(BaseSFPricePageReqVo reqVo) {
		PageEntity<BaseSfPrice> pageEntity = BeanUtil.pageConvert(reqVo, BaseSfPrice.class);
		List<BaseSfPrice> list = baseSFPriceService.findByPage(pageEntity);
		List<BaseSFPriceVo> voList = BeanUtil.list2list(list, BaseSFPriceVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void deleteById(Integer id) {
		baseSFPriceService.deleteById(id);
	}

	@Override
	public void add(BaseSFPriceVo vo) {
		BaseSfPrice baseSfPrice = BeanUtil.a2b(vo, BaseSfPrice.class);
		baseSFPriceService.insert(baseSfPrice);
	}

	@Override
	public void updateById(BaseSfPrice baseSfPrice) {
		baseSFPriceService.update(baseSfPrice);
	}

}

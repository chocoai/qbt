package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.SaleQrcodeInfo;
import com.qbt.service.SaleQrcodeInfoService;
import com.qbt.web.pojo.saleQrcodeInfo.SaleQrcodeInfoPageReqVo;
import com.qbt.web.pojo.saleQrcodeInfo.SaleQrcodeInfoVo;
import com.qbt.web.support.SaleQrcodeInfoSupport;

@Service
public class SaleQrcodeInfoSupportImpl implements SaleQrcodeInfoSupport{

	@Resource
	private SaleQrcodeInfoService saleQrcodeInfoService;
	
	@Override
	public List<SaleQrcodeInfoVo> findByPage(SaleQrcodeInfoPageReqVo reqVo) {
		PageEntity<SaleQrcodeInfo> pageEntity = BeanUtil.pageConvert(reqVo, SaleQrcodeInfo.class);
		List<SaleQrcodeInfo> list = saleQrcodeInfoService.findByPage(pageEntity);
		List<SaleQrcodeInfoVo> voList = BeanUtil.list2list(list, SaleQrcodeInfoVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.SaleUserType;
import com.qbt.common.util.Arith;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Utils;
import com.qbt.persistent.dto.SaleOrderInfoDto;
import com.qbt.persistent.dto.SaleSubcripbeInfoDto;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.SaleOrderInfoService;
import com.qbt.service.SaleWeixinSubcripbeInfoService;
import com.qbt.web.pojo.salebusiness.SaleOrderResponse;
import com.qbt.web.pojo.salebusiness.SaleReqPage;
import com.qbt.web.pojo.salebusiness.SaleSubcripbeResponse;
import com.qbt.web.support.SalerBusinessSupport;

@Service
public class SalerBusinessSupportImpl implements SalerBusinessSupport {

	@Resource
	private SaleOrderInfoService saleOrderInfoService;
	@Resource
	private SaleWeixinSubcripbeInfoService saleWeixinSubcripbeInfoService;
	
	@Override
	public List<SaleOrderResponse> findOrderByPage(SaleReqPage req) {
		PageEntity<SaleOrderInfoDto> pageEntity = BeanUtil.pageConvert(req, SaleOrderInfoDto.class);
		
		List<SaleOrderInfoDto> list = saleOrderInfoService.reportOrderInfoPage(pageEntity);
		List<SaleOrderResponse> respList = BeanUtil.list2list(list, SaleOrderResponse.class);
		req.setTotalCount(pageEntity.getTotalCount());
		
		return respList;
	}
	

	@Override
	public Map<String, Object> exportSaleOrder(SaleReqPage req, SysUser sysUser) {
		SaleOrderInfoDto query = BeanUtil.a2b(req, SaleOrderInfoDto.class);
		
		PageEntity<SaleOrderInfoDto> pageEntity = new PageEntity<SaleOrderInfoDto>();
		pageEntity.setCondition(query);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		map.put("exportDate", DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01));
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		int settleStatus = req.getSettleStatus() == null?0:req.getSettleStatus();
		map.put("settleStatusVal", settleStatus == 1?"未结算":settleStatus == 2 ?"已结算":"");
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		double totalAmount = 0;
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<SaleOrderInfoDto> list = saleOrderInfoService.reportOrderInfoPage(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(SaleOrderInfoDto s : list){
					data = new HashMap<String, String>();
					data.put("salesmanCode", s.getSalesmanCode());
					data.put("name", s.getName());
					data.put("company", s.getCompany());
					data.put("mobile", s.getMobile());
					data.put("idcard", s.getIdcard());
					data.put("type", SaleUserType.getByType(s.getType()).getDesc());
					data.put("typeValue", Checker.isNotEmpty(s.getTypeValue()) ? Utils.formatNumberByDecimal(s.getTypeValue()) : null);
					data.put("totalOrderAmount",String.valueOf(s.getTotalOrderAmount()));
					data.put("totalOrderNum",String.valueOf(s.getTotalOrderNum()));
					data.put("totalAmount",String.valueOf(s.getTotalAmount()));
					totalAmount = Arith.add(totalAmount, s.getTotalAmount());
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		map.put("totalAmount", totalAmount);
		return map;
	}


	@Override
	public List<SaleSubcripbeResponse> findSubcripbeByPage(SaleReqPage req) {
		PageEntity<SaleSubcripbeInfoDto> pageEntity = BeanUtil.pageConvert(req, SaleSubcripbeInfoDto.class);
		
		List<SaleSubcripbeInfoDto> list = saleWeixinSubcripbeInfoService.reportSubcripbeInfoPage(pageEntity);
		List<SaleSubcripbeResponse> respList = BeanUtil.list2list(list, SaleSubcripbeResponse.class);
		req.setTotalCount(pageEntity.getTotalCount());
		
		return respList;
	}


	@Override
	public Map<String, Object> exportSaleSubcripbe(SaleReqPage req, SysUser sysUser) {
		PageEntity<SaleSubcripbeInfoDto> pageEntity = BeanUtil.pageConvert(req, SaleSubcripbeInfoDto.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		map.put("exportDate", DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01));
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		int settleStatus = req.getSettleStatus() == null?0:req.getSettleStatus();
		map.put("settleStatusVal", settleStatus == 1?"未结算":settleStatus == 2 ?"已结算":"");
		
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		double totalAmount = 0;
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<SaleSubcripbeInfoDto> list = saleWeixinSubcripbeInfoService.reportSubcripbeInfoPage(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(SaleSubcripbeInfoDto s : list){
					data = new HashMap<String, String>();
					data.put("salesmanCode", s.getSalesmanCode());
					data.put("name", s.getName());
					data.put("company", s.getCompany());
					data.put("mobile", s.getMobile());
					data.put("idcard", s.getIdcard());
					data.put("num",String.valueOf(s.getNum()));
					data.put("amount",String.valueOf(s.getAmount()));
					data.put("totalAmount",String.valueOf(s.getTotalAmount()));
					totalAmount = Arith.add(totalAmount, s.getTotalAmount());
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		map.put("totalAmount", totalAmount);
		return map;
	}

}

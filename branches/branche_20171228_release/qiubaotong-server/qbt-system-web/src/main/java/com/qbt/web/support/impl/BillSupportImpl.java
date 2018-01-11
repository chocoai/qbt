package com.qbt.web.support.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.Bill;
import com.qbt.service.BillService;
import com.qbt.web.pojo.bill.BillPageReqVo;
import com.qbt.web.pojo.bill.BillVo;
import com.qbt.web.support.BillSupport;

@Service
public class BillSupportImpl implements BillSupport{
	
	@Resource
	private BillService billService;
	
	
	@Override
	public List<BillVo> findByPage(BillPageReqVo reqVo) {
		PageEntity<Bill> pageEntity = BeanUtil.pageConvert(reqVo, Bill.class);
		List<Bill> list = billService.findByPage(pageEntity);
		List<BillVo> voList = BeanUtil.list2list(list, BillVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}


	@Override
	public BillVo findById(Integer id) {
		Bill bill =billService.findById(id);
		BillVo vo = BeanUtil.a2b(bill, BillVo.class);
		return vo;
	}
	
	public void updateNumberById(Integer id,String number,Integer userId,String userName){
		Bill bill = new Bill();
		bill.setId(id);
		bill.setNumber(number);
		bill.setUpdateTime(new Date());
		bill.setOperater(userId);
		bill.setStatus(2);
		bill.setOperaterName(userName);
		billService.update(bill);
	}
	
	public void updateRemark(BillVo vo){
		Bill bill = new Bill();
		bill.setId(vo.getId());
		bill.setOperater(vo.getUserId());
		bill.setOperaterName(vo.getUserName());
		bill.setRemark(vo.getRemark());
		billService.update(bill);
	}
}

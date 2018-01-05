package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.Bill;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.BillService;
import com.qbt.web.pojo.bill.BillPageReqVo;
import com.qbt.web.pojo.bill.BillVo;
import com.qbt.web.support.BillSupport;

@Service
public class BillSupportImpl implements BillSupport {
	
	@Resource
	private BillService billService;
	

	
	@Override
	public Map<String, Object> export( String title, BillPageReqVo vo) {
		List<BillVo> list = findByPage(vo);
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		if(Checker.isNotEmpty(list)){
			Map<String, String> data = null;
			for(BillVo bill:list){
				data = new HashMap<String, String>();
				data.put("billType", bill.getBillType()==1?"电子":"纸质");
				data.put("number", bill.getNumber());
				data.put("orderNumber", bill.getOrderNumber());
				data.put("price", bill.getPrice()+"");
				data.put("userName", bill.getUserName());
				data.put("createTime", DateUtil.formatDate(bill.getCreateTime(),DateUtil.DATE_TIME_FORMAT_02));
				data.put("updateTime",DateUtil.formatDate(bill.getUpdateTime(),DateUtil.DATE_TIME_FORMAT_02));
				data.put("status", bill.getStatus()==2?"已开票":"未开票");
				data.put("operator", bill.getOperaterName());
				result.add(data);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("list", result);
		return map;
	}
	
	
	public List<BillVo> findByPage(BillPageReqVo reqVo) {
		PageEntity<Bill> pageEntity = BeanUtil.pageConvert(reqVo, Bill.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		List<Bill> list = billService.findByPage(pageEntity);
		List<BillVo> voList = BeanUtil.list2list(list, BillVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}
}

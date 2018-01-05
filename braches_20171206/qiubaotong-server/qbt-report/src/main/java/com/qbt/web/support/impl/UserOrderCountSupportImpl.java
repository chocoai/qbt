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
import com.qbt.common.util.ToolsUtil;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.dto.ReportUserOrderCount;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.ReportOrderService;
import com.qbt.web.pojo.userOrderCount.UserOrderCountRequest;
import com.qbt.web.pojo.userOrderCount.UserOrderCountResponse;
import com.qbt.web.support.UserOrderCountSupport;

@Service
public class UserOrderCountSupportImpl implements UserOrderCountSupport {
	
	@Resource
	private ReportOrderService reportOrderService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, UserOrderCountRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = 0;
		List<UserOrderCountResponse> listMap = new ArrayList<UserOrderCountResponse>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<ReportUserOrderCount> list = reportOrderService.findUserOrderCountByPage(pageEntity);
			if(Checker.isNotEmpty(list)){
				for(ReportUserOrderCount r : list){
					r.setMobile(ToolsUtil.hideMobile(r.getMobile()));//隐藏手机号
				}
			}
			List<UserOrderCountResponse> tolist = BeanUtil.list2list(list, UserOrderCountResponse.class);
			listMap.addAll(tolist);
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("datas", listMap);
		map.put("params", req);
		map.put("operatorName", sysUser.getName());
		return map;
	}

	@Override
	public List<UserOrderCountResponse> findByPage(UserOrderCountRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		
		List<ReportUserOrderCount> list = reportOrderService.findUserOrderCountByPage(pageEntity);
		List<UserOrderCountResponse> respList = BeanUtil.list2list(list, UserOrderCountResponse.class);
		req.setTotalCount(pageEntity.getTotalCount());
		return respList;
	}

}

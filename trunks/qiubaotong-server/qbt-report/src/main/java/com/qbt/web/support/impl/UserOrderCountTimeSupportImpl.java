/**
 * Project Name:qbt-report
 * File Name:UserOrderCountTimeSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2016年11月1日上午10:50:20
 *
*/

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
import com.qbt.common.util.ToolsUtil;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.dto.ReportUserOrderCount;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.ReportOrderService;
import com.qbt.web.pojo.userOrderCountTime.UserOrderCountTimeRequest;
import com.qbt.web.pojo.userOrderCountTime.UserOrderCountTimeResponse;
import com.qbt.web.support.UserOrderCountTimeSupport;

/**
 * ClassName:UserOrderCountTimeSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2016年11月1日 上午10:50:20
 * @author   haungyihao
 * @version  
 * @see 	 
 */
@Service
public class UserOrderCountTimeSupportImpl implements UserOrderCountTimeSupport {
	
	@Resource
	private ReportOrderService reportOrderService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, UserOrderCountTimeRequest req) {
		ReportOrderQuery query = getQueryCondition(req);
		
		PageEntity<ReportOrderQuery> pageEntity = new PageEntity<ReportOrderQuery>();
		pageEntity.setCondition(query);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<ReportUserOrderCount> list = reportOrderService.findUserOrderCountTimeByPage(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(ReportUserOrderCount r : list){
					data = new HashMap<String, String>();
					data.put("openid", r.getOpenid());
					data.put("nickname", r.getNickname());
					data.put("name", r.getName());
					data.put("mobile", ToolsUtil.hideMobile(r.getMobile()));//隐藏手机号
					data.put("orderCount", String.valueOf(r.getOrderCount()));
					data.put("sendSfDate", DateUtil.formatDate(r.getSendSfUserTime(), DateUtil.DATE_FORMAT_01));
					data.put("sendSfTime", r.getSendTimeSection().substring(11));
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("datas", listMap);
		map.put("params", req);
		map.put("operatorName", sysUser.getName());
		return map;
	}

	@Override
	public List<UserOrderCountTimeResponse> findByPage(UserOrderCountTimeRequest req) {
		ReportOrderQuery query = getQueryCondition(req);
		
		PageEntity<ReportOrderQuery> pageEntity = new PageEntity<ReportOrderQuery>();
		pageEntity.setCondition(query);
		pageEntity.setPageNumber(req.getPageNo());
		pageEntity.setPageSize(req.getPageSize());
		
		List<ReportUserOrderCount> list = reportOrderService.findUserOrderCountTimeByPage(pageEntity);
		List<UserOrderCountTimeResponse> respList = new ArrayList<UserOrderCountTimeResponse>();
		if(Checker.isNotEmpty(list)){
			UserOrderCountTimeResponse resp = null;
			for(ReportUserOrderCount o : list){
				resp = BeanUtil.a2b(o, UserOrderCountTimeResponse.class);
				resp.setSendSfDate(DateUtil.formatDate(o.getSendSfUserTime(), DateUtil.DATE_FORMAT_01));
				resp.setSendSfTime(o.getSendTimeSection().substring(11));
				respList.add(resp);
			}
		}
		req.setTotalCount(pageEntity.getTotalCount());
		return respList;
	}
	
	private ReportOrderQuery getQueryCondition(UserOrderCountTimeRequest req) {
		ReportOrderQuery query = new ReportOrderQuery();
		query.setStartDate(req.getStartDate());
		query.setEndDate(req.getEndDate());
		query.setSendSfStartTime(DateUtil.str2Date(req.getSendSfStartTime(), DateUtil.DATE_TIME_FORMAT_04));
		query.setSendSfEndTime(DateUtil.str2Date(req.getSendSfEndTime(), DateUtil.DATE_TIME_FORMAT_04));
		return query;
	}
	
}

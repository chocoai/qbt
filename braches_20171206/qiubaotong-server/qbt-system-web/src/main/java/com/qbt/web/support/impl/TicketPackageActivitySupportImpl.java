package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.TicketPackageActivity;
import com.qbt.service.TicketPackageActivityService;
import com.qbt.web.pojo.ticketPackageActivity.TicketPackageActivityPageReqVo;
import com.qbt.web.pojo.ticketPackageActivity.TicketPackageActivityVo;
import com.qbt.web.support.TicketPackageActivitySupport;

@Service
public class TicketPackageActivitySupportImpl implements
		TicketPackageActivitySupport {

	@Resource
	private TicketPackageActivityService service;
	
	@Override
	public int insert(TicketPackageActivityVo activityVo) {
		
		TicketPackageActivity activity = BeanUtil.a2b(activityVo, TicketPackageActivity.class);
		
		return service.insert(activity);
	}

	@Override
	public List<TicketPackageActivityVo> findByPage(
			TicketPackageActivityPageReqVo vo) {
		
		PageEntity<TicketPackageActivity> pageEntity = BeanUtil.pageConvert(vo, TicketPackageActivity.class);
		
		List<TicketPackageActivity> activityList = service.findByPage(pageEntity);
		List<TicketPackageActivityVo> voList = BeanUtil.list2list(activityList, TicketPackageActivityVo.class);
		
		vo.setTotalCount(pageEntity.getTotalCount());
		
		return voList;
	}

}

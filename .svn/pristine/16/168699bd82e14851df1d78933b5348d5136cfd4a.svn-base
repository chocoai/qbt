package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.UserActivityPackage;
import com.qbt.service.TicketPackageService;
import com.qbt.web.pojo.ticket.TicketPackageAddReqVo;
import com.qbt.web.pojo.ticket.TicketPackagePageReqVo;
import com.qbt.web.pojo.ticket.TicketPackageVo;
import com.qbt.web.support.TicketPackageSupport;

@Service
public class TicketPackageSupportImpl implements TicketPackageSupport {

	@Resource
	TicketPackageService ticketService;
		
	@Override
	public List<TicketPackageVo> findByPage(TicketPackagePageReqVo reqVo) {
		PageEntity<UserActivityPackage> pageEntity = BeanUtil.pageConvert(reqVo, UserActivityPackage.class);
		List<UserActivityPackage> list = ticketService.findByPage(pageEntity);
		
		List<TicketPackageVo> voList = new ArrayList<TicketPackageVo>();
		for(UserActivityPackage act : list){
			TicketPackageVo vo = BeanUtil.a2b(act, TicketPackageVo.class);
			voList.add(vo);
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public TicketPackageVo findById(Integer id) {
		UserActivityPackage ticket = ticketService.findById(id);
		TicketPackageVo vo = BeanUtil.a2b(ticket, TicketPackageVo.class);
		return vo;
	}

	@Override
	public int add(TicketPackageAddReqVo vo) {
		UserActivityPackage ticket = BeanUtil.a2b(vo, UserActivityPackage.class);
		int ticketId = ticketService.insert(ticket);
		
		return ticketId;
	}

	@Override
	public boolean update(TicketPackageVo vo) {
		UserActivityPackage ticketPackage = ticketService.findById(vo.getId());
		if(Checker.isEmpty(ticketPackage)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效的数据");
		}
		
//		ticketPackage.setActivatePhoneNumber(vo.getActivatePhoneNumber());
//		ticketPackage.setActivateTime(vo.getActivateTime());
//		ticketPackage.setActivateUser(vo.getActivateUser());
//		ticketPackage.setActiveStatus(vo.getActiveStatus());
//		ticketPackage.setActivityName(vo.getActivityName());
//		ticketPackage.setCode(vo.getCode());
//		ticketPackage.setCodeStatus(vo.getCodeStatus());
//		ticketPackage.setTicketType(vo.getTicketType());
//		ticketPackage.setEffectiveDay(vo.getEffectiveDay());
//		ticketPackage.setExpirationTime(vo.getExpirationTime());
		ticketPackage.setOperatorId(vo.getOperatorId());
		ticketPackage.setOperatorName(vo.getOperatorName());		
		
		return ticketService.update(ticketPackage) > 0;
	}

}

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.UserActivityPackage;
import com.qbt.service.UserActivityPackageService;
import com.qbt.web.pojo.ticket.UserActivityPackageAddReqVo;
import com.qbt.web.pojo.ticket.UserActivityPackagePageReqVo;
import com.qbt.web.pojo.ticket.UserActivityPackageVo;
import com.qbt.web.support.UserActivityPackageSupport;

@Service
public class UserActivityPackageSupportImpl implements UserActivityPackageSupport {

	@Resource
	UserActivityPackageService ticketService;
		
	@Override
	public List<UserActivityPackageVo> findByPage(UserActivityPackagePageReqVo reqVo) {
		PageEntity<UserActivityPackage> pageEntity = BeanUtil.pageConvert(reqVo, UserActivityPackage.class);
		List<UserActivityPackage> list = ticketService.findByPage(pageEntity);
		
		List<UserActivityPackageVo> voList = new ArrayList<UserActivityPackageVo>();
		for(UserActivityPackage act : list){
			UserActivityPackageVo vo = BeanUtil.a2b(act, UserActivityPackageVo.class);
			voList.add(vo);
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public UserActivityPackageVo findById(Integer id) {
		UserActivityPackage ticket = ticketService.findById(id);
		UserActivityPackageVo vo = BeanUtil.a2b(ticket, UserActivityPackageVo.class);
		return vo;
	}

	@Override
	public int add(UserActivityPackageAddReqVo vo) {
		UserActivityPackage ticket = BeanUtil.a2b(vo, UserActivityPackage.class);
		int ticketId = ticketService.insert(ticket);
		
		return ticketId;
	}

	@Override
	public boolean update(UserActivityPackageVo vo) {
		UserActivityPackage ticketPackage = ticketService.findById(vo.getId());
		if(Checker.isEmpty(ticketPackage)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效的数据");
		}
		
		ticketPackage.setStatus(vo.getStatus());
		ticketPackage.setUpdateTime(new Date());
		ticketPackage.setOperatorId(vo.getOperatorId());
		ticketPackage.setOperatorName(vo.getOperatorName());		
		
		return ticketService.update(ticketPackage) > 0;
	}

}

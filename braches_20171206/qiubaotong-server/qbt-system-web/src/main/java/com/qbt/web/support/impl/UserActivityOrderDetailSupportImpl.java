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
import com.qbt.persistent.entity.UserActivityOrderDetail;
import com.qbt.service.UserActivityOrderDetailService;
import com.qbt.service.UserActivityPackageService;
import com.qbt.service.UserPackageTicketService;
import com.qbt.web.pojo.ticket.UserActivityOrderDetailAddReqVo;
import com.qbt.web.pojo.ticket.UserActivityOrderDetailPageReqVo;
import com.qbt.web.pojo.ticket.UserActivityOrderDetailVo;
import com.qbt.web.support.UserActivityOrderDetailSupport;

@Service
public class UserActivityOrderDetailSupportImpl implements UserActivityOrderDetailSupport {

	@Resource
	UserActivityOrderDetailService userActivityOrderService;
	
	@Resource
	UserActivityPackageService userActivityPackageService;
	
	@Resource
	UserPackageTicketService userPackageTicketService;
	
	@Override
	public List<UserActivityOrderDetailVo> findByPage(UserActivityOrderDetailPageReqVo reqVo) {
		PageEntity<UserActivityOrderDetail> pageEntity = BeanUtil.pageConvert(reqVo, UserActivityOrderDetail.class);
		
		List<UserActivityOrderDetail> list = userActivityOrderService.findByPage(pageEntity);
		List<UserActivityOrderDetailVo> voList = new ArrayList<UserActivityOrderDetailVo>();
		for(UserActivityOrderDetail act : list){
			UserActivityOrderDetailVo vo = BeanUtil.a2b(act, UserActivityOrderDetailVo.class);
			voList.add(vo);
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public UserActivityOrderDetailVo findById(Integer id) {
		UserActivityOrderDetail ticketPackageOrder = userActivityOrderService.findById(id);
		UserActivityOrderDetailVo vo = BeanUtil.a2b(ticketPackageOrder, UserActivityOrderDetailVo.class);
		return vo;
	}

	@Override
	public int add(UserActivityOrderDetailAddReqVo vo) {
		UserActivityOrderDetail order = BeanUtil.a2b(vo, UserActivityOrderDetail.class);
		
		// add order
		int orderId = userActivityOrderService.insert(order);
		
		return orderId;
	}

	@Override
	public boolean update(UserActivityOrderDetailVo vo) {
		UserActivityOrderDetail order = userActivityOrderService.findById(vo.getId());
		if(Checker.isEmpty(order)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效的数据");
		}

		order.setActivatePhoneNumber(vo.getActivatePhoneNumber());
		order.setActivateTime(vo.getActivateTime());
		order.setActivateUser(vo.getActivateUser());
		order.setActiveStatus(vo.getActiveStatus());
		order.setCode(vo.getCode());
		order.setCodeStatus(vo.getCodeStatus());
		order.setExpirationTime(vo.getExpirationTime());
		order.setOrderId(vo.getOrderId());
		order.setPackageType(vo.getPackageType());
		order.setOperatorId(vo.getOperatorId());
		order.setOperatorName(vo.getOperatorName());
		order.setType(vo.getType());
		order.setStatus(vo.getStatus());
		order.setQrCode(vo.getQrCode());
		order.setStatus(vo.getStatus());
		
		return userActivityOrderService.update(order) > 0;
	}

}

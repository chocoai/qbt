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
import com.qbt.persistent.entity.UserPackageTicket;
import com.qbt.persistent.entity.UserActivityPackage;
import com.qbt.persistent.entity.UserActivityOrder;
import com.qbt.service.TicketPackageOrderService;
import com.qbt.service.TicketPackageService;
import com.qbt.service.TicketService;
import com.qbt.web.pojo.ticket.TicketPackageOrderAddReqVo;
import com.qbt.web.pojo.ticket.TicketPackageOrderPageReqVo;
import com.qbt.web.pojo.ticket.TicketPackageOrderVo;
import com.qbt.web.pojo.ticket.TicketPackageVo;
import com.qbt.web.pojo.ticket.TicketVo;
import com.qbt.web.support.TicketPackageOrderSupport;

@Service
public class TicketPackageOrderSupportImpl implements TicketPackageOrderSupport {

	@Resource
	TicketPackageOrderService ticketPackageOrderService;
	
	@Resource
	TicketPackageService ticketPackageService;
	
	@Resource
	TicketService ticketService;
	
	@Override
	public List<TicketPackageOrderVo> findByPage(TicketPackageOrderPageReqVo reqVo) {
		PageEntity<UserActivityOrder> pageEntity = BeanUtil.pageConvert(reqVo, UserActivityOrder.class);
		
		List<UserActivityOrder> list = ticketPackageOrderService.findByPage(pageEntity);
		List<TicketPackageOrderVo> voList = new ArrayList<TicketPackageOrderVo>();
		for(UserActivityOrder act : list){
			TicketPackageOrderVo vo = BeanUtil.a2b(act, TicketPackageOrderVo.class);
			voList.add(vo);
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public TicketPackageOrderVo findById(Integer id) {
		UserActivityOrder ticketPackageOrder = ticketPackageOrderService.findById(id);
		TicketPackageOrderVo vo = BeanUtil.a2b(ticketPackageOrder, TicketPackageOrderVo.class);
		return vo;
	}

	@Override
	public int add(TicketPackageOrderAddReqVo vo) {
		UserActivityOrder order = BeanUtil.a2b(vo, UserActivityOrder.class);
		
		// add order
		int orderId = ticketPackageOrderService.insert(order);
		
		// add package		
		List<TicketPackageVo> tpvos = vo.getTicketPackageVos();
		if(tpvos != null) {
			for(TicketPackageVo tpvo : tpvos) {
				UserActivityPackage ticketPackage = BeanUtil.a2b(tpvo, UserActivityPackage.class);
//				ticketPackage.setOrderId(orderId);
				int packageId = ticketPackageService.insert(ticketPackage);
				
				// add ticket
				List<TicketVo> ticketvos = tpvo.getTicketVos();
				if(ticketvos != null) {
					for(TicketVo ticketvo: ticketvos) {
						UserPackageTicket ticket = BeanUtil.a2b(ticketvo, UserPackageTicket.class);
						ticket.setPackageId(packageId);
						
						ticketService.insert(ticket);
					}
				}
			}
		}
		
		
		// add ticket
		
		return orderId;
	}

	@Override
	public boolean update(TicketPackageOrderVo vo) {
		UserActivityOrder order = ticketPackageOrderService.findById(vo.getId());
		if(Checker.isEmpty(order)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效的数据");
		}
		
		order.setActivityName(vo.getActivityName());
		order.setOperatorId(vo.getOperatorId());
		order.setOperatorName(vo.getOperatorName());
		order.setPayStatus(vo.getPayStatus());
		order.setProxyUser(vo.getProxyUser());
		order.setPurchaser(vo.getPurchaser());
		order.setPurchaserAddress(vo.getPurchaserAddress());
		order.setPurchaserNumber(vo.getPurchaserNumber());
		order.setType(vo.getType());
		order.setStatus(vo.getStatus());
		
		return ticketPackageOrderService.update(order) > 0;
	}

}

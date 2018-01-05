package com.qbt.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.UserActivityOrder;
import com.qbt.persistent.entity.UserActivityOrderDetail;
import com.qbt.persistent.entity.UserPackageTicket;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.UserActivityOrderDetailService;
import com.qbt.service.UserActivityOrderService;
import com.qbt.service.UserPackageTicketService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.pojo.ticket.UserActivityOrderDetailVo;
import com.qbt.web.pojo.ticket.UserActivityOrderVo;
import com.qbt.web.pojo.ticket.UserPackageTicketVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.UserActivityOrderSupport;

@Controller
@RequestMapping("/ticketPackageOrder")
public class TicketPackageOrderController {
	
	@Resource
	private LoginSupport loginSupport;

	@Resource
	private WechatMessageSupport wechatMessageSupport;

	@Resource
	UserActivityOrderService userActivityOrderService;

	@Resource
	private UserWeixinService userWeixinService;
	
	@Resource
	private UserActivityOrderSupport userActivityOrderSupport;
	
	@Resource
	UserActivityOrderDetailService userActivityOrderDetailService;
	
	@Resource
	UserPackageTicketService userPackageTicketService;
	
	@RequestMapping(value = "order", method = RequestMethod.POST)
	public Result<Integer> order(HttpServletRequest request, @RequestBody UserActivityOrder vo) {

		// help this openid to create a order
		String openId = vo.getOpenid();

		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);

			vo.setOperatorId(userWeixin.getId());
			vo.setOperatorName(userWeixin.getName());

			vo.setUserId(userWeixin.getId());

			result.setDatas(userActivityOrderSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "代下单券包异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;

	}
	
	@RequestMapping("detail")
	public Result<UserActivityOrderVo> detail(HttpServletRequest request, Integer id){
		Result<UserActivityOrderVo> result = new Result<UserActivityOrderVo>();
		try {
			
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			int userId = userWeixin.getId();
			
			UserActivityOrderVo userActivityOrderVo = userActivityOrderSupport.findById(id);
			
			if(userActivityOrderVo.getUserId() != userId) {
				LogCvt.error("没有找到对应的订单");
				result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
				result.setMsg("没有找到对应的订单");
				
				return result;
			}
			
			// 获取订单详情
			PageEntity<UserActivityOrderDetail> pageEntity = new PageEntity<UserActivityOrderDetail>();
			UserActivityOrderDetail detailReq = new UserActivityOrderDetail();
			detailReq.setUserId(userActivityOrderVo.getUserId());
			detailReq.setOrderId(userActivityOrderVo.getId());
			pageEntity.setCondition(detailReq);
			
			List<UserActivityOrderDetail> list = userActivityOrderDetailService.findByPage(pageEntity);
			List<UserActivityOrderDetailVo> details = new ArrayList<UserActivityOrderDetailVo>();
			for(UserActivityOrderDetail act : list){
				UserActivityOrderDetailVo vo = BeanUtil.a2b(act, UserActivityOrderDetailVo.class);
				details.add(vo);
			}
			
			userActivityOrderVo.setUserActivityOrderDetailVos(details);
			if(details != null) {
				for(UserActivityOrderDetailVo detail: details) {
					List<UserPackageTicket> ticketList = userPackageTicketService.findTicketsForOrderDetail(detail.getId());
					List<UserPackageTicketVo> tickets = new ArrayList<UserPackageTicketVo>();
					if(ticketList != null) {
						for(UserPackageTicket ticket: ticketList) {
							UserPackageTicketVo vo = BeanUtil.a2b(ticket, UserPackageTicketVo.class);
							tickets.add(vo);
						}
					}
					
					detail.setTicketVos(tickets);
				}
			}
			
			result.setDatas(userActivityOrderVo);
		} catch (Exception e) {
			String errMsg = "查询订单异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}

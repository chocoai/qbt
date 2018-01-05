package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.AddrTypeEnum;
import com.qbt.common.enums.BpsStatus;
import com.qbt.common.enums.DeliveryStatus;
import com.qbt.common.enums.InsuredChannelEnum;
import com.qbt.common.enums.OrderStatus;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.dto.BossOrderInfo;
import com.qbt.persistent.dto.ReportOrderPage;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.MailChannel;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.BaseCourseService;
import com.qbt.service.MailChannelService;
import com.qbt.service.ReportOrderService;
import com.qbt.web.pojo.orderPage.OrderPageRequest;
import com.qbt.web.pojo.orderPage.OrderPageResponse;
import com.qbt.web.support.OrderPageSupport;

@Service
public class OrderPageSupportImpl implements OrderPageSupport {
	
	@Resource
	private ReportOrderService reportOrderService;
	
	@Resource
	private BaseCourseService baseCourseService;
	
	@Resource
	private MailChannelService mailChannelService;
	
	@Override
	public List<OrderPageResponse> findByPage(OrderPageRequest reqVo) {
		PageEntity<ReportOrderPage> pageEntity = BeanUtil.pageConvert(reqVo, ReportOrderPage.class);
		ReportOrderPage condition = pageEntity.getCondition();
		condition.setdBagIsSameAdree(reqVo.getdBagIsSameAdree());
		condition.setjBagIsSameAdree(reqVo.getjBagIsSameAdree());
		List<BossOrderInfo> list = reportOrderService.findByPageReport(pageEntity);
		List<OrderPageResponse> voList = BeanUtil.list2list(list, OrderPageResponse.class);
		if(Checker.isNotEmpty(voList)){
			BaseCourse jCourse = null;
			BaseCourse dCourse = null;
			for(OrderPageResponse vo : voList){
				vo.setUserName(Checker.isNotEmpty(vo.getUserName()) ? vo.getUserName() : vo.getNickname());
				if(Checker.isNotEmpty(vo.getjAddrType()) && AddrTypeEnum.course.getType() == vo.getjAddrType()){
					jCourse = baseCourseService.findById(vo.getjAddrId());
					if(Checker.isNotEmpty(jCourse)){
						vo.setjCourseStatus(jCourse.getStatus());
					}
				}
				if(Checker.isNotEmpty(vo.getdAddrType()) && AddrTypeEnum.course.getType() == vo.getdAddrType()){
					dCourse = baseCourseService.findById(vo.getdAddrId());
					if(Checker.isNotEmpty(dCourse)){
						vo.setdCourseStatus(dCourse.getStatus());
					}
				}
			}
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public Map<String, Object> export(SysUser sysUser, String title, OrderPageRequest req) {
		PageEntity<ReportOrderPage> pageEntity = BeanUtil.pageConvert(req, ReportOrderPage.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("begSendTime", DateUtil.formatDate(req.getBegSendTime(), DateUtil.DATE_FORMAT_02));
		map.put("endSendTime", DateUtil.formatDate(req.getEndSendTime(), DateUtil.DATE_FORMAT_02));
		map.put("deliverStartTime", DateUtil.formatDate(req.getDeliverStartTime(), DateUtil.DATE_FORMAT_02));
		map.put("deliverEndTime", DateUtil.formatDate(req.getDeliverEndTime(), DateUtil.DATE_FORMAT_02));
		map.put("deliveryStatus", req.getDeliveryStatus() !=null ? DeliveryStatus.getDesc(req.getDeliveryStatus()) : "");//物流状态
		map.put("orderStatus", req.getOrderStatus() !=null ? OrderStatus.getByCode(req.getOrderStatus()).getDesc() : "");//订单状态
		map.put("jAddrType", req.getjAddrType() !=null ? (1 == req.getjAddrType() ? "是" : "否") : "");//取包是球场
		map.put("dAddrType", req.getdAddrType() !=null ? (1 == req.getdAddrType() ? "是" : "否") : "");//送包是球场
		map.put("jBagIsSameAdree", req.getjBagIsSameAdree() !=null ? (1 == req.getjBagIsSameAdree() ? "是" : "否") : "否");//取包同地址
		map.put("dBagIsSameAdree", req.getdBagIsSameAdree() !=null ? (1 == req.getdBagIsSameAdree() ? "是" : "否") : "否");//送包同地址
		map.put("insuredChannel", InsuredChannelEnum.getByCode(req.getInsuredChannel()) == null ? "" : InsuredChannelEnum.getByCode(req.getInsuredChannel()).getDesc());
		//获取渠道信息到map里，避免循环查询
		Map<Integer, String> mailChannelMap =new HashMap<Integer, String>();
		List<MailChannel> mailChannelList = mailChannelService.findAll();
		for (MailChannel enty : mailChannelList) {
			mailChannelMap.put(enty.getId(), enty.getChannelName());
		}
		if(Checker.isNotEmpty(req.getMailChannel())){
			map.put("mailChannel", mailChannelMap.get(req.getMailChannel()));//物流渠道筛选
		}else {
			map.put("mailChannel", "");//物流渠道筛选
		}
		
		map.put("operatorName", sysUser != null ? sysUser.getName() : "");
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<BossOrderInfo> list = reportOrderService.findByPageReport(pageEntity);
			List<OrderPageResponse> voList = BeanUtil.list2list(list, OrderPageResponse.class);
			if(Checker.isNotEmpty(voList)){
				Map<String, String> data = null;
				for(OrderPageResponse orderPage : voList){
					data = new HashMap<String, String>();
					data.put("number", orderPage.getNumber());
					data.put("createTime", DateUtil.formatDate(orderPage.getCreateTime(), DateUtil.DATE_TIME_FORMAT_03));
					data.put("sendSfUserTime", DateUtil.formatDate(orderPage.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_03));
					data.put("deliverDate", orderPage.getDeliverDate());
					data.put("mailNo", orderPage.getMailNo());
					data.put("orderStatus", OrderStatus.getByCode(orderPage.getOrderStatus()).getDesc());
					data.put("deliveryStatus", DeliveryStatus.getDesc(orderPage.getDeliveryStatus()));
					data.put("bpsStatus", BpsStatus.getByCode(orderPage.getBpsStatus()).getDesc());
					data.put("userName", orderPage.getUserName());
					
					data.put("jContact", orderPage.getjContact());//寄件人
					data.put("jMobile", orderPage.getjMobile());//寄件人电话
					if(orderPage.getjAddrType() != AddrTypeEnum.address.getType()){
//						data.put("jAddress", orderPage.getjAddrName() + "(" + orderPage.getjTreePath() + "," + orderPage.getjAddress() + ")");
						data.put("jAddress", orderPage.getjAddrName());
					}else{
						data.put("jAddress", orderPage.getjTreePath()+","+orderPage.getjAddress());//寄件地址
					}
					
					data.put("dContact", orderPage.getdContact());//寄件人
					data.put("dMobile", orderPage.getdMobile());//寄件人电话
					if(orderPage.getdAddrType() != AddrTypeEnum.address.getType()){
//						data.put("dAddress", orderPage.getdAddrName() + "(" + orderPage.getdTreePath() + "," + orderPage.getdAddress() + ")");
						data.put("dAddress", orderPage.getdAddrName());
					}else{
						data.put("dAddress", orderPage.getdTreePath()+","+orderPage.getdAddress());//寄件地址
					}
				
					data.put("mailChannel", mailChannelMap.get(orderPage.getMailChannel()));
					data.put("insuredChannel", InsuredChannelEnum.getByCode(orderPage.getInsuredChannel()) == null ? null : InsuredChannelEnum.getByCode(orderPage.getInsuredChannel()).getDesc());
					
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		return map;
	}
	
}

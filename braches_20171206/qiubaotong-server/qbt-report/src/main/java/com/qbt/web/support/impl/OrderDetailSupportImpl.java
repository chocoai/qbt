package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.BooleanUtils;
import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.BpsStatus;
import com.qbt.common.enums.CouponTypeEnum;
import com.qbt.common.enums.DeliveryStatus;
import com.qbt.common.enums.ExpressTypeEnum;
import com.qbt.common.enums.OrderStatus;
import com.qbt.common.enums.RefundStatus;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Utils;
import com.qbt.persistent.dto.ReportOrderDetail;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.entity.OrderRefund;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.OrderRefundService;
import com.qbt.service.ReportOrderService;
import com.qbt.web.pojo.orderDetail.OrderDetailRequest;
import com.qbt.web.pojo.orderDetail.OrderDetailResponse;
import com.qbt.web.support.OrderDetailSupport;

@Service
public class OrderDetailSupportImpl implements OrderDetailSupport {
	
	@Resource
	private ReportOrderService reportOrderService;
	
	@Resource
	private OrderRefundService orderRefundService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, String title, OrderDetailRequest req) {
		ReportOrderQuery query = getQueryCondition(req);
		
		PageEntity<ReportOrderQuery> pageEntity = new PageEntity<ReportOrderQuery>();
		pageEntity.setCondition(query);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		
		//退款信息
		Map<Integer, OrderRefund> refundMap = queryRefundMap(req.getStartDate(), req.getEndDate());
		
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<ReportOrderDetail> list = reportOrderService.findOrderDetails(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(ReportOrderDetail info : list){
					data = new HashMap<String, String>();
					data.put("orderNumber", info.getNumber());//订单编号
					data.put("mailNo", info.getMailNo());//运单号
					data.put("createTime", DateUtil.formatDate(info.getCreateTime(), DateUtil.DATE_TIME_FORMAT_01));//下单时间
					data.put("nickname", info.getUserName());//下单微信用户名
					data.put("sendSfUserTime", DateUtil.formatDate(info.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01));//预约取件时间
					
					data.put("jContact", info.getjContact());//寄件人
					String jInfo = "";
					if(Checker.isNotEmpty(info.getjAddrType())){
						if(info.getjAddrType() == 4){
							jInfo = info.getjTreePath().replaceAll(",", " ") + " " + info.getjAddress();
						}else{
							jInfo = info.getjTreePath().replaceAll(",", " ") + " " + info.getjAddrName();
						}
					}
					data.put("jInfo", jInfo);//寄件信息
					
					data.put("dContact", info.getdContact());//收件人
					String dInfo = "";
					if(Checker.isNotEmpty(info.getdAddrType())){
						if(info.getdAddrType() == 4){
							dInfo = info.getdTreePath().replaceAll(",", " ") + " " + info.getdAddress();
						}else{
							dInfo = info.getdTreePath().replaceAll(",", " ") + " " + info.getdAddrName();
						}
					}
					data.put("dInfo", dInfo);//收件信息
					ExpressTypeEnum expreeType = ExpressTypeEnum.getByType(info.getExpressType());
					data.put("expressType", Checker.isNotEmpty(expreeType) ? expreeType.getDesc() : "");//时效类型
					data.put("amount", Utils.formatNumberByDecimal(info.getAmount()));//实收金额
					data.put("isFavored", Checker.isEmpty(info.getDiscount()) || info.getDiscount() == 0 ? "否" : "是");//是否使用优惠
					CouponTypeEnum couponType = CouponTypeEnum.getByType(info.getCouponType());
					data.put("couponType", Checker.isNotEmpty(couponType) ? couponType.getDesc() : "");//优惠券类型
					data.put("couponCode", info.getCouponCode());//优惠券编码
					data.put("favorableDesc", info.getFavorableDesc());//优惠活动名
					data.put("firstOrder", BooleanUtils.toString(info.getFirstOrder(), "是", "否", "否"));//是否首单客户
					data.put("orderStatus", OrderStatus.getByCode(info.getOrderStatus()).getDesc());//订单状态
					data.put("refundStatus", RefundStatus.getByCode(info.getRefundStatus()).getDesc());//退款状态
					data.put("deliveryStatus", DeliveryStatus.getDesc(info.getDeliveryStatus()));//物流状态
					data.put("bpsStatus", BpsStatus.getByCode(info.getBpsStatus()).getDesc());//顺丰bps状态
					data.put("questionStatus", 1 == info.getQuestionStatus() ? "否" : "是");//是否异常件
					data.put("thirdType", BooleanUtils.toString(1 == info.getThirdType(), "否", "是"));
					//偏远球场费用
					data.put("outRangePrice", Utils.formatNumberByDecimal(info.getjOutRangePrice()+info.getdOutRangePrice()));
					data.put("bagCode", info.getBagCode());
					
					double cancelFee = refundMap.containsKey(info.getId()) ? refundMap.get(info.getId()).getFee() : 0;
					data.put("cancelFee", Utils.formatNumberByDecimal(cancelFee));
					
					Integer urgentFee = info.getUrgentFee();
					data.put("urgentFee", urgentFee == null ? "0" : urgentFee + "");
					
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		return map;
	}

	@Override
	public List<OrderDetailResponse> findByPage(OrderDetailRequest req) {
		ReportOrderQuery query = getQueryCondition(req);
		PageEntity<ReportOrderQuery> pageEntity = new PageEntity<ReportOrderQuery>();
		pageEntity.setCondition(query);
		pageEntity.setPageNumber(req.getPageNo());
		pageEntity.setPageSize(req.getPageSize());
		
		List<ReportOrderDetail> list = reportOrderService.findOrderDetails(pageEntity);
		List<OrderDetailResponse> respList = new ArrayList<OrderDetailResponse>();
		
		if(Checker.isNotEmpty(list)){
			//退款信息
			Map<Integer, OrderRefund> refundMap = queryRefundMap(req.getStartDate(), req.getEndDate());
			
			OrderDetailResponse resp = null;
			for(ReportOrderDetail info : list){
				resp = BeanUtil.a2b(info, OrderDetailResponse.class);
				resp.setFirstOrder(Checker.isEmpty(info.getFirstOrder()) ? false : info.getFirstOrder());
				resp.setIsFavored(!(Checker.isEmpty(info.getDiscount()) || info.getDiscount() == 0));
				//偏远费用字段
				resp.setOutRangePrice(info.getjOutRangePrice()+info.getdOutRangePrice());
				resp.setCancelFee(refundMap.containsKey(info.getId()) ? refundMap.get(info.getId()).getFee() : 0);
				respList.add(resp);
			}
		}
		req.setTotalCount(pageEntity.getTotalCount());
		return respList;
	}
	
	private ReportOrderQuery getQueryCondition(OrderDetailRequest req) {
		ReportOrderQuery query = new ReportOrderQuery();
		query.setStartDate(req.getStartDate());
		query.setEndDate(req.getEndDate());
		query.setOrderStatus(req.getOrderStatus());
		query.setOutRangeType(req.getOutRangeType());
		if(req.getIsFirst() != null && req.getIsFirst() != 0){
			query.setFirstOrder(req.getIsFirst() == 1 ? true : false);
		}
		if(req.getIsFavored() != null && req.getIsFavored() != 0){
			query.setIsFavored(req.getIsFavored() == 1 ? true : false);
		}
		query.setExpressType(req.getExpressType());
		query.setThirdType(req.getThirdType());
		query.setBagCode(req.getBagCode());
		return query;
	}
	
	/**
	 * 
	 * queryRefundMap:(查询订单退款记录).
	 *
	 * @author huangyihao
	 * 2017年10月10日 下午3:34:50
	 * @param startDate
	 * @param endDate
	 * @return
	 *
	 */
	private Map<Integer, OrderRefund> queryRefundMap(Date startDate, Date endDate) {
		List<OrderRefund> refundList = orderRefundService.findByOrderDate(startDate, endDate);
		Map<Integer, OrderRefund> refundMap = new HashMap<Integer, OrderRefund>();
		for(OrderRefund r : refundList) {
			refundMap.put(r.getOrderId(), r);
		}
		return refundMap;
	}
}

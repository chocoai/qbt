package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.OrderStatus;
import com.qbt.common.enums.RefundStatus;
import com.qbt.common.enums.SettleModeEnum;
import com.qbt.common.enums.SettlementStatusEnum;
import com.qbt.common.util.Arith;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Utils;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.dto.ReportPartnerOrder;
import com.qbt.persistent.entity.BaseSettmtAmountConfig;
import com.qbt.persistent.entity.OrderMemo;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.BaseSettmtAmountConfigService;
import com.qbt.service.OrderMemoService;
import com.qbt.service.ReportOrderService;
import com.qbt.web.pojo.orderPartner.OrderPartnerRequest;
import com.qbt.web.pojo.orderPartner.OrderPartnerResponse;
import com.qbt.web.support.OrderPartnerSupport;

@Service
public class OrderPartnerSupportImpl implements OrderPartnerSupport {
	
	@Resource
	private ReportOrderService reportOrderService;
	
	@Resource
	private OrderMemoService orderMemoService;
	
	@Resource
	private BaseSettmtAmountConfigService baseSettmtAmountConfigService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, String title, OrderPartnerRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		
		//客服记录信息
		Map<Integer, List<OrderMemo>> memoMap = queryMemoMap(req.getStartDate(), req.getEndDate());
		
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		double totalAmount = 0;
		double settleTotalAmount = 0;
		double payAmount = 0;
		double settlePayAmount = 0;
		double discount = 0;
		double settleDiscount = 0;
		double settleAmount = 0;
		double unSettleAmount = 0;
		double unSettleFee = 0d;
		double settleFee = 0d;
		SettleModeEnum settleMode = null;
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<ReportPartnerOrder> list = reportOrderService.findPartnerOrders(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(ReportPartnerOrder info : list){
					data = new HashMap<String, String>();
					data.put("createTime", DateUtil.formatDate(info.getCreateTime(), DateUtil.DATE_TIME_FORMAT_03));
					data.put("userName", info.getUserName());
					data.put("orderNumber", info.getNumber());
					data.put("orderStatus", OrderStatus.getByCode(info.getOrderStatus()).getDesc());
					data.put("refundStatus", RefundStatus.getByCode(info.getRefundStatus()).getDesc());
					data.put("handleType", info.getHandleType() == 1 ? "否" : "是");
					data.put("isFavored", Checker.isEmpty(info.getDiscount()) || info.getDiscount() == 0 ? "否" : "是");
					data.put("totalAmount", Utils.formatNumberByDecimal(info.getTotalAmount()));
					data.put("amount", Utils.formatNumberByDecimal(info.getAmount()));
					data.put("discount", Utils.formatNumberByDecimal(info.getDiscount() != null ? info.getDiscount() : 0));
					data.put("favorableDesc", info.getFavorableDesc());
					data.put("couponCode", info.getCouponCode());
					data.put("insuredValue", Utils.formatNumberByDecimal(info.getInsuredValue() != null ? info.getInsuredValue() : 0));
					data.put("insuredRates", info.getInsuredRates() != null ? info.getInsuredRates().toString() : "0");
					data.put("insuredFee", Utils.formatNumberByDecimal(info.getInsuredFee() != null ? info.getInsuredFee() : 0));
					data.put("jContact", info.getjContact());
					String[] jTreePath = info.getjTreePath().split(",");
					for(int i = 0; i < jTreePath.length; i++){
						if(i == 0){
							data.put("jProvince", jTreePath[i]);
						}else if(i == 1){
							data.put("jCity", jTreePath[i]);
						}else if(i == 2){
							data.put("jCountry", jTreePath[i]);
						}
					}	
					String jAddress = "";
					if(info.getjAddrType() == 4){
						jAddress = info.getjAddress();
					}else{
						jAddress = info.getjAddrName();
					}
					data.put("jAddress", jAddress);
					
					data.put("dContact", info.getdContact());
					String[] dTreePath = info.getdTreePath().split(",");
					for(int i = 0; i < dTreePath.length; i++){
						if(i == 0){
							data.put("dProvince", dTreePath[i]);
						}else if(i == 1){
							data.put("dCity", dTreePath[i]);
						}else if(i == 2){
							data.put("dCountry", dTreePath[i]);
						} 
					}
					String dAddress = "";
					if(info.getdAddrType() == 4){
						dAddress = info.getdAddress();
					}else{
						dAddress = info.getdAddrName();
					}
					data.put("dAddress", dAddress);
					data.put("memo", conbineOrderMemo(info.getId(), memoMap));
					data.put("settleRemark", info.getSettleRemark());
					//运单号
					data.put("mailNo", info.getMailNo());
					//拿商户订单号
					data.put("uuid", info.getUuid());
					//拿券面额
					data.put("childAmount", Utils.formatNumberByDecimal(info.getChildAmount() != null ? info.getChildAmount() : 0));
					data.put("thirdName", info.getThirdName());
					SettlementStatusEnum settleState = SettlementStatusEnum.getByCode(info.getSettleState());
					data.put("settleState", Checker.isNotEmpty(settleState) ? settleState.getDesc() : "");
					settleMode = SettleModeEnum.getByCode(info.getSettleModel());
					data.put("settleModel", Checker.isNotEmpty(settleMode) ? settleMode.getDesc() : "");
					switch (settleMode) {
					case advanced_mode:
						data.put("settleModeValue", String.valueOf(info.getSettleModeValue()));
						break;
					case per_percent_mode:
						data.put("settleModeValue", String.format("%.2f%%", info.getSettleModeValue()));
						break;
					case per_rebate_mode:
						data.put("settleModeValue", info.getSettleModeValue() + "元");
						break;
					default:
						break;
					}
					data.put("settleAmount", Utils.formatNumberByDecimal(info.getSettleAmount() != null ? info.getSettleAmount() : 0));
					data.put("settleFee", Utils.formatNumberByDecimal(info.getSettleFee() != null ? info.getSettleFee() : 0));
					listMap.add(data);
					
					//金额汇总信息
					if(SettlementStatusEnum.un_settlement.equals(settleState)){
						totalAmount += info.getTotalAmount();
						payAmount += info.getAmount();
						discount += info.getDiscount();
						if(!SettleModeEnum.advanced_mode.equals(settleMode)){
							unSettleAmount += info.getSettleAmount();
							unSettleFee += info.getSettleFee();
						}
					}else if(SettlementStatusEnum.suc_settlement.equals(settleState)){
						settleTotalAmount += info.getTotalAmount();
						settlePayAmount += info.getAmount();
						settleDiscount += info.getDiscount();
						if(!SettleModeEnum.advanced_mode.equals(settleMode)){
							settleAmount += info.getSettleAmount();
							settleFee += info.getSettleFee();
						}
					}
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		map.put("list", listMap);
		
		double unSettleRate = 0d;
		double settleRate = 0d;
		if(SettleModeEnum.advanced_mode.equals(settleMode)){
			/*
			 * 结算金额计算公式
			 * settleAmount = sum(amount) * (1 - rate/100)
			 */
			
			//未结算
			BaseSettmtAmountConfig unSettleConfig = baseSettmtAmountConfigService.findByAmount(req.getThirdId(), payAmount);
			unSettleRate = Checker.isNotEmpty(unSettleConfig) && Checker.isNotEmpty(unSettleConfig.getRate()) ? unSettleConfig.getRate() : 0;
			unSettleAmount += Arith.mul(payAmount, Arith.sub(1, Arith.div(unSettleRate, 100, 8)));
			unSettleFee += Arith.mul(payAmount, Arith.div(unSettleRate, 100, 8));
			//已结算
			BaseSettmtAmountConfig settleConfig = baseSettmtAmountConfigService.findByAmount(req.getThirdId(), settlePayAmount);
			settleRate = Checker.isNotEmpty(settleConfig) && Checker.isNotEmpty(settleConfig.getRate()) ? settleConfig.getRate() : 0;
			settleAmount += Arith.mul(settlePayAmount, Arith.sub(1, Arith.div(settleRate, 100, 8)));
			settleFee += Arith.mul(settlePayAmount, Arith.div(settleRate, 100, 8));
		}
		
		map.put("totalAmount", Utils.formatNumberByDecimal(totalAmount));
		map.put("settleTotalAmount", Utils.formatNumberByDecimal(settleTotalAmount));
		map.put("payAmount", Utils.formatNumberByDecimal(payAmount));
		map.put("settlePayAmount", Utils.formatNumberByDecimal(settlePayAmount));
		map.put("discount", Utils.formatNumberByDecimal(discount));
		map.put("settleDiscount", Utils.formatNumberByDecimal(settleDiscount));
		map.put("unSettleAmount", Utils.formatNumberByDecimal(unSettleAmount));
		map.put("settleAmount", Utils.formatNumberByDecimal(settleAmount));
		map.put("settleModel", Checker.isNotEmpty(settleMode) ? settleMode.getDesc() : "");
		map.put("unSettleRate", String.format("%.2f%%", unSettleRate));
		map.put("settleRate", String.format("%.2f%%", settleRate));
		map.put("unSettleFee", Utils.formatNumberByDecimal(unSettleFee));
		map.put("settleFee", Utils.formatNumberByDecimal(settleFee));
		return map;
	}
	
	@Override
	public List<OrderPartnerResponse> findByPage(OrderPartnerRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		
		List<ReportPartnerOrder> list = reportOrderService.findPartnerOrders(pageEntity);
		List<OrderPartnerResponse> respList = new ArrayList<OrderPartnerResponse>();
		if(Checker.isNotEmpty(list)){
			//客服记录信息
			Map<Integer, List<OrderMemo>> memoMap = queryMemoMap(req.getStartDate(), req.getEndDate());
			
			OrderPartnerResponse resp = null;
			for(ReportPartnerOrder info : list){
				resp = BeanUtil.a2b(info, OrderPartnerResponse.class);
				resp.setIsFavored(!(Checker.isEmpty(info.getDiscount()) || info.getDiscount() == 0));
				resp.setMemo(conbineOrderMemo(info.getId(), memoMap));
				
				respList.add(resp);
			}
		}
		req.setTotalCount(pageEntity.getTotalCount());
		return respList;
	}
	
	/**
	 * 查询订单客服记录
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Map<Integer, List<OrderMemo>> queryMemoMap(Date startDate, Date endDate){
		List<OrderMemo> memoList = orderMemoService.findMemoByOrderDate(startDate, endDate);
		Map<Integer, List<OrderMemo>> memoMap = new HashMap<Integer, List<OrderMemo>>();
		if(Checker.isNotEmpty(memoList)){
			List<OrderMemo> mList = null;
			for(OrderMemo m : memoList){
				mList = memoMap.containsKey(m.getOrderId()) ? memoMap.get(m.getOrderId()) : new ArrayList<OrderMemo>();
				mList.add(m);
				memoMap.put(m.getOrderId(), mList);
			}
		}
		return memoMap;
	}
	
	/**
	 * 根据订单id组合订单客服记录
	 * @param orderId
	 * @param memoMap
	 * @return
	 */
	private String conbineOrderMemo(int orderId, Map<Integer, List<OrderMemo>> memoMap){
		List<OrderMemo> memos = memoMap.get(orderId);
		StringBuilder orderMemoStr = new StringBuilder();
		if(Checker.isNotEmpty(memos)){
			for (int i = 0; i < memos.size(); i++) {
				OrderMemo orderMemo = memos.get(i);
				if(i == memos.size() - 1){
					orderMemoStr.append(orderMemo.getMemo());
				}else{
					orderMemoStr.append(orderMemo.getMemo()).append("\r\n");
				}
			}
		}
		return orderMemoStr.toString();
	}
	
}

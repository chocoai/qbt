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
import com.qbt.common.enums.OrderStatus;
import com.qbt.common.enums.PaymethodEnum;
import com.qbt.common.enums.RefundStatus;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Utils;
import com.qbt.persistent.dto.ReportOrderAmount;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.entity.MailChannel;
import com.qbt.persistent.entity.OrderCostItem;
import com.qbt.persistent.entity.OrderMemo;
import com.qbt.persistent.entity.OrderRefund;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.MailChannelService;
import com.qbt.service.OrderCostItemService;
import com.qbt.service.OrderMemoService;
import com.qbt.service.OrderRefundService;
import com.qbt.service.ReportOrderService;
import com.qbt.service.SysUserService;
import com.qbt.web.pojo.orderAmount.OrderAmountRequest;
import com.qbt.web.pojo.orderAmount.OrderAmountResponse;
import com.qbt.web.support.OrderAmountSupport;

@Service
public class OrderAmountSupportImpl implements OrderAmountSupport {
	
	@Resource
	private ReportOrderService reportOrderService;

	@Resource
	private OrderMemoService orderMemoService;
	
	@Resource
	private OrderCostItemService orderCostItemService;
	
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private OrderRefundService orderRefundService;
	
	@Resource
	private MailChannelService mailChannelService;

	@Override
	public Map<String, Object> export(SysUser sysUser, String title, OrderAmountRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		
		Map<Integer, String> mailChannelInfo = queryMailChannelInfo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		map.put("mailChannel", mailChannelInfo.get(req.getMailChannel()));
		map.put("operator", sysUser != null ? sysUser.getName() : "");

		// 客服记录信息
		Map<Integer, List<OrderMemo>> memoMap = queryMemoMap(req.getStartDate(), req.getEndDate());
		//费用增减信息
		Map<Integer, List<OrderCostItem>> costItemMap = queryCostItemMap(req.getStartDate(), req.getEndDate());
		//退款信息
		Map<Integer, OrderRefund> refundMap = queryRefundMap(req.getStartDate(), req.getEndDate());
		//客服收款状态描述信息
		Map<Integer, String> kfReceivableStatusMap = kfReceivableStatusDesc();
		
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<ReportOrderAmount> list = reportOrderService.findOrdersAmount(pageEntity);
			if (Checker.isNotEmpty(list)) {
				Map<String, String> data = null;
				for (ReportOrderAmount info : list) {
					data = new HashMap<String, String>();
					data.put("createTime", DateUtil.formatDate(info.getCreateTime(), DateUtil.DATE_TIME_FORMAT_03));
					data.put("userName", info.getUserName());
					data.put("orderNumber", info.getNumber());
					data.put("orderStatus", OrderStatus.getByCode(info.getOrderStatus()).getDesc());
					data.put("refundStatus", RefundStatus.getByCode(info.getRefundStatus()).getDesc());
					data.put("handleType", info.getHandleType() == 1 ? "否" : "是");
					data.put("isFavored", Checker.isEmpty(info.getDiscount()) || info.getDiscount() == 0 ? "否" : "是");
					data.put("totalAmount", Utils.formatNumberByDecimal(info.getTotalAmount()));
					if (info.getThirdType() == 2) {
						data.put("amount", Utils.formatNumberByDecimal(0));
					} else {
						data.put("amount", Utils.formatNumberByDecimal(info.getAmount()));
					}
					data.put("discount",
							Utils.formatNumberByDecimal(info.getDiscount() != null ? info.getDiscount() : 0));
					data.put("favorableDesc", info.getFavorableDesc());
					data.put("couponCode", info.getCouponCode());
					data.put("insuredValue",
							Utils.formatNumberByDecimal(info.getInsuredValue() != null ? info.getInsuredValue() : 0));
					data.put("insuredRates", info.getInsuredRates() != null ? info.getInsuredRates().toString() : "0");
					data.put("insuredFee",
							Utils.formatNumberByDecimal(info.getInsuredFee() != null ? info.getInsuredFee() : 0));
					data.put("jContact", info.getjContact());
					String[] jTreePath = info.getjTreePath().split(",");
					for (int i = 0; i < jTreePath.length; i++) {
						if (i == 0) {
							data.put("jProvince", jTreePath[i]);
						} else if (i == 1) {
							data.put("jCity", jTreePath[i]);
						} else if (i == 2) {
							data.put("jCountry", jTreePath[i]);
						}
					}
					String jAddress = "";
					if (info.getjAddrType() == 4) {
						jAddress = info.getjAddress();
					} else {
						jAddress = info.getjAddrName();
					}
					data.put("jAddress", jAddress);

					data.put("dContact", info.getdContact());
					String[] dTreePath = info.getdTreePath().split(",");
					for (int i = 0; i < dTreePath.length; i++) {
						if (i == 0) {
							data.put("dProvince", dTreePath[i]);
						} else if (i == 1) {
							data.put("dCity", dTreePath[i]);
						} else if (i == 2) {
							data.put("dCountry", dTreePath[i]);
						}
					}
					String dAddress = "";
					if (info.getdAddrType() == 4) {
						dAddress = info.getdAddress();
					} else {
						dAddress = info.getdAddrName();
					}
					data.put("dAddress", dAddress);
					data.put("memo", conbineOrderMemo(info.getId(), memoMap));
					data.put("remark", info.getRemark());
					// 运单号
					data.put("mailNo", info.getMailNo());
					// 拿商户订单号
					data.put("uuid", info.getUuid());
					// 拿券面额
					data.put("childAmount",
							Utils.formatNumberByDecimal(info.getChildAmount() != null ? info.getChildAmount() : 0));
					data.put("thirdType", BooleanUtils.toString(1 == info.getThirdType(), "否", "是"));
					data.put("jOutRangePrice", Utils
							.formatNumberByDecimal(info.getjOutRangePrice() != null ? info.getjOutRangePrice() : 0));
					data.put("dOutRangePrice", Utils
							.formatNumberByDecimal(info.getdOutRangePrice() != null ? info.getdOutRangePrice() : 0));
					data.put("thirdName", info.getThirdName());
					data.put("isVip", BooleanUtils.toString(info.getIsVip(), "是", "否"));
					PaymethodEnum paymethod = PaymethodEnum.getByCode(info.getPayMethod());
					data.put("payMethod", Checker.isNotEmpty(paymethod) ? paymethod.getDesc() : "");
					data.put("kfReceivableStatus", kfReceivableStatusMap.get(info.getKfReceivableStatus()));
					data.put("cwReceivableStatus", info.getCwReceivableStatus() == 1 ? "是" : "否");
					data.put("inputDiscount", Utils.formatNumberByDecimal(info.getInputDiscount()));
					data.put("costItem", conbineOrderCostItem(info.getId(), costItemMap));
					data.put("weixinPayCode", info.getWeixinPayCode());
					data.put("weixinPayCodeUpdateTime", info.getWeixinPayCodeUpdateTime()!=null?DateUtil.formatDateTime(info.getWeixinPayCodeUpdateTime()):"");
				
					if(Checker.isNotEmpty(info.getWeixinPayCodeOperater())){
						SysUser sysuser	=sysUserService.selectById(Integer.parseInt(info.getWeixinPayCodeOperater()));
						data.put("weixinPayCodeOperater", sysuser != null ? sysuser.getName() : "");
					}
					
					double cancelFee = refundMap.containsKey(info.getId()) ? refundMap.get(info.getId()).getFee() : 0;
					data.put("cancelFee", Utils.formatNumberByDecimal(cancelFee));
					
					data.put("mailChannel", mailChannelInfo.get(info.getMailChannel()));
					
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
	public List<OrderAmountResponse> findByPage(OrderAmountRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);

		List<ReportOrderAmount> list = reportOrderService.findOrdersAmount(pageEntity);
		List<OrderAmountResponse> respList = new ArrayList<OrderAmountResponse>();
		if (Checker.isNotEmpty(list)) {
			//客服记录信息
			Map<Integer, List<OrderMemo>> memoMap = queryMemoMap(req.getStartDate(), req.getEndDate());
			//费用增减信息
			Map<Integer, List<OrderCostItem>> costItemMap = queryCostItemMap(req.getStartDate(), req.getEndDate());
			//退款信息
			Map<Integer, OrderRefund> refundMap = queryRefundMap(req.getStartDate(), req.getEndDate());
			
			OrderAmountResponse resp = null;
			for (ReportOrderAmount info : list) {
				resp = BeanUtil.a2b(info, OrderAmountResponse.class);
				resp.setIsFavored(!(Checker.isEmpty(info.getDiscount()) || info.getDiscount() == 0));
				resp.setMemo(conbineOrderMemo(info.getId(), memoMap));
				resp.setCostItem(conbineOrderCostItem(info.getId(), costItemMap));
				if (info.getThirdType() == 2) {
					resp.setAmount(0.0);
				}
				
				if(Checker.isNotEmpty(info.getWeixinPayCodeOperater())){
					SysUser sysuser	=sysUserService.selectById(Integer.parseInt(info.getWeixinPayCodeOperater()));
					resp.setWeixinPayCodeOperater(sysuser != null ? sysuser.getName() : "");
				}
				
				resp.setCancelFee(refundMap.containsKey(info.getId()) ? refundMap.get(info.getId()).getFee() : 0);
				
				respList.add(resp);
			}
		}
		req.setTotalCount(pageEntity.getTotalCount());
		return respList;
	}
	
	private Map<Integer, String> kfReceivableStatusDesc() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "无需收款");
		map.put(1, "是");
		map.put(2, "否");
		return map;
	}
	
	/**
	 * 查询费用增减记录
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Map<Integer, List<OrderCostItem>> queryCostItemMap(Date startDate, Date endDate) {
		List<OrderCostItem> costItemList = orderCostItemService.findCostItemByOrderDate(startDate, endDate);
		Map<Integer, List<OrderCostItem>> costItemMap = new HashMap<Integer, List<OrderCostItem>>();
		if (Checker.isNotEmpty(costItemList)) {
			List<OrderCostItem> mList = null;
			for (OrderCostItem m : costItemList) {
				mList = costItemMap.containsKey(m.getOrderId()) ? costItemMap.get(m.getOrderId()) : new ArrayList<OrderCostItem>();
				mList.add(m);
				costItemMap.put(m.getOrderId(), mList);
			}
		}
		return costItemMap;
	}

	/**
	 * 查询订单客服记录
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Map<Integer, List<OrderMemo>> queryMemoMap(Date startDate, Date endDate) {
		List<OrderMemo> memoList = orderMemoService.findMemoByOrderDate(startDate, endDate);
		Map<Integer, List<OrderMemo>> memoMap = new HashMap<Integer, List<OrderMemo>>();
		if (Checker.isNotEmpty(memoList)) {
			List<OrderMemo> mList = null;
			for (OrderMemo m : memoList) {
				mList = memoMap.containsKey(m.getOrderId()) ? memoMap.get(m.getOrderId()) : new ArrayList<OrderMemo>();
				mList.add(m);
				memoMap.put(m.getOrderId(), mList);
			}
		}
		return memoMap;
	}

	/**
	 * 根据订单id组合订单客服记录
	 * 
	 * @param orderId
	 * @param memoMap
	 * @return
	 */
	private String conbineOrderMemo(int orderId, Map<Integer, List<OrderMemo>> memoMap) {
		List<OrderMemo> memos = memoMap.get(orderId);
		StringBuilder orderMemoStr = new StringBuilder();
		if (Checker.isNotEmpty(memos)) {
			for (int i = 0; i < memos.size(); i++) {
				OrderMemo orderMemo = memos.get(i);
				if (i == memos.size() - 1) {
					orderMemoStr.append(orderMemo.getMemo());
				} else {
					orderMemoStr.append(orderMemo.getMemo()).append("\r\n");
				}
			}
		}
		return orderMemoStr.toString();
	}
	/**
	 * 根据订单id组合费用增减记录
	 * @param orderId
	 * @param costItemMap
	 * @return
	 */
	private String conbineOrderCostItem(int orderId, Map<Integer, List<OrderCostItem>> costItemMap) {
		List<OrderCostItem> costItems = costItemMap.get(orderId);
		StringBuilder orderCostItemsStr = new StringBuilder();
		if (Checker.isNotEmpty(costItems)) {
			for (int i = 0; i < costItems.size(); i++) {
				OrderCostItem orderCostItem = costItems.get(i);
				if (i == costItems.size() - 1) {
					orderCostItemsStr.append("增减项目:"+orderCostItem.getItem()+",金额:"+orderCostItem.getAmount()+",备注:"+orderCostItem.getRemark());
				} else {
					orderCostItemsStr.append("增减项目:"+orderCostItem.getItem()+ ",金额:"+orderCostItem.getAmount()+",备注:"+orderCostItem.getRemark()).append("|");
				}
			}
		}
		return orderCostItemsStr.toString();
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
	
	
	private Map<Integer, String> queryMailChannelInfo(){
		List<MailChannel> mailChanelList = mailChannelService.findAll();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(MailChannel m : mailChanelList) {
			map.put(m.getId(), m.getChannelName());
		}
		return map;
	}
	
}

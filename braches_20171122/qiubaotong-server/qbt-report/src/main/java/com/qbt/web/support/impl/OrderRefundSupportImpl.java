package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Utils;
import com.qbt.persistent.dto.BossOrderRefund;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.OrderRefundService;
import com.qbt.web.pojo.orderRefund.OrderRefundRequest;
import com.qbt.web.pojo.orderRefund.OrderRefundVo;
import com.qbt.web.support.OrderRefundSupport;

@Service
public class OrderRefundSupportImpl implements OrderRefundSupport{

	@Resource
	private OrderRefundService orderRefundService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, String title, OrderRefundRequest req) {
		BossOrderRefund query = new BossOrderRefund();
		query.setStartTime(req.getStartDate());
		query.setEndTime(req.getEndDate());
		query.setStatus(req.getStatus());
		query.setOrderNumber(req.getOrderNumber());
		PageEntity<BossOrderRefund> pageEntity = new PageEntity<BossOrderRefund>();
		pageEntity.setCondition(query);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<BossOrderRefund> list = orderRefundService.findByPage(pageEntity);
			List<OrderRefundVo> voList = BeanUtil.list2list(list, OrderRefundVo.class);
			if(Checker.isNotEmpty(voList)){
				Map<String, String> data = null;
				for(OrderRefundVo oprderRefundVo : voList){
					data = new HashMap<String, String>();
					data.put("orderNumber", oprderRefundVo.getOrderNumber());
					//下单时间
					data.put("orderCreateTime", DateUtil.formatDate(oprderRefundVo.getOrderCreateTime(), DateUtil.DATE_TIME_FORMAT_03));
					//退款时间
					data.put("createTime", DateUtil.formatDate(oprderRefundVo.getCreateTime(), DateUtil.DATE_TIME_FORMAT_03));
					//退款金额
					data.put("amount", Utils.formatNumberByDecimal(oprderRefundVo.getAmount()));
					//实际退款金额
					data.put("realAmount", Utils.formatNumberByDecimal(oprderRefundVo.getRealAmount()));
					//服务费
					data.put("fee", Utils.formatNumberByDecimal(oprderRefundVo.getFee()));
					//用户名
					data.put("userName", oprderRefundVo.getUserName());
					//手机号	
					data.put("mobile", oprderRefundVo.getMobile());
					//订单支付方式
					if(oprderRefundVo.getOrderPayType() == 1){
						data.put("orderPayType", "微信支付");
					}else if(oprderRefundVo.getOrderPayType() == 97){
						data.put("orderPayType", "BOSS代下单");
					}else if(oprderRefundVo.getOrderPayType() == 98){
						data.put("orderPayType", "合作方代下单");
					}else if(oprderRefundVo.getOrderPayType() == 99){
						data.put("orderPayType", "现金券满额支付");
					}
					//状态：1-待处理 2-已处理
					data.put("status", oprderRefundVo.getStatus() == 1 ? "待处理" : "已处理");
					//退款备注
					data.put("remark", oprderRefundVo.getRemark());
					//处理客服
					data.put("kfName", oprderRefundVo.getKfName());
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		return map;
	}
	
}


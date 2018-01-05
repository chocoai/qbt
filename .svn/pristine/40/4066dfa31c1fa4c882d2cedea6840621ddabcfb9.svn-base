package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.PaymethodEnum;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Utils;
import com.qbt.persistent.entity.SysUser;
import com.qbt.persistent.entity.VipOrder;
import com.qbt.service.VipOrderService;
import com.qbt.web.pojo.vipOrder.VipOrderRequest;
import com.qbt.web.support.VipOrderSupport;

@Service
public class VipOrderSupportImpl implements VipOrderSupport{

	@Resource
	private VipOrderService vipOrderService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, String title, VipOrderRequest req) {
		VipOrder query = new VipOrder();
		query.setNumber(req.getNumber());
		query.setVipNo(req.getVipNo());
		query.setName(req.getName());
		query.setUserName(req.getUserName());
		query.setMobile(req.getMobile());
		query.setStartDate(req.getStartDate());
		query.setEndDate(req.getEndDate());
		query.setCardSellStatus(1);
		PageEntity<VipOrder> pageEntity = new PageEntity<VipOrder>();
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
			List<VipOrder> list = vipOrderService.findByPage(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(VipOrder vipOrder : list){
					data = new HashMap<String, String>();
					data.put("number", vipOrder.getNumber());//订单号
					data.put("vipNo", vipOrder.getVipNo());//会员卡号
					data.put("name", vipOrder.getName());//会员卡类型名称
					data.put("userName", vipOrder.getUserName());//用户名 
					data.put("mobile", vipOrder.getMobile());//手机号
					if(Checker.isNotEmpty(vipOrder.getPayAmount())){
						data.put("payAmount", Utils.formatNumberByDecimal(vipOrder.getPayAmount().doubleValue()));//支付金额
					}
					//支付方式表，1-微信支付 2-boss购买 3-支付宝 4-汇款 5-现金
					PaymethodEnum payMethod = PaymethodEnum.getByCode(vipOrder.getPayMethod());
					data.put("payMethod", Checker.isNotEmpty(payMethod) ? payMethod.getDesc() : "");
					data.put("settlementStatus", 1 == vipOrder.getSettlementStatus() ? "已收款": "未收款");//收款状态:1-已收款 2-未收款
					data.put("valid", Utils.formatNumberByDecimal(vipOrder.getValid()));//有效期，单位天
					data.put("payBakNo", vipOrder.getPayBakNo());//第三方支付流水号
					data.put("payNumber", vipOrder.getPayNumber());//商户支付流水号
					data.put("createTime", DateUtil.formatDate(vipOrder.getCreateTime(), DateUtil.DATE_TIME_FORMAT_01));//创建时间
					data.put("vipCardType", 1 == vipOrder.getVipCardType() ? "电子卡" : "实体卡");
					data.put("salesmanName", vipOrder.getSalesmanName()==null ?  "": vipOrder.getSalesmanName());
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		return map;
	}
	
}

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
import com.qbt.persistent.dto.SaleOrderInfoDto;
import com.qbt.persistent.entity.SaleOrderInfo;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.SaleOrderInfoService;
import com.qbt.service.SaleUserService;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderInfoRequest;
import com.qbt.web.support.SaleOrderInfoSupport;

@Service
public class SaleOrderInfoSupportImpl implements SaleOrderInfoSupport{

	@Resource
	private SaleOrderInfoService saleOrderInfoService; 
	
	@Resource
	private SaleUserService saleUserService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, String title, SaleOrderInfoRequest req, String currentDay) {
		PageEntity<SaleOrderInfoDto> pageEntity = BeanUtil.pageConvert(req, SaleOrderInfoDto.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		Map<String, Object> map = new HashMap<String, Object>();
	    SaleUser saleUser = saleUserService.findById(req.getSaleId());
		map.put("title", "(销售人员名字:" + saleUser.getName() +" 销售人员号：" + saleUser.getSalesmanCode() + ")" +title);
		map.put("currentDay", currentDay);
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<SaleOrderInfo> list = saleOrderInfoService.findByPageBySaleId(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				//小计提成
				Double amountSum = 0.0;
				for(SaleOrderInfo saleOrderInfo : list){
					data = new HashMap<String, String>();
					data.put("number", saleOrderInfo.getNumber());
					data.put("createTime", DateUtil.formatDate(saleOrderInfo.getCreateTime(), DateUtil.DATE_TIME_FORMAT_03));
					data.put("orderAmount", Utils.formatNumberByDecimal(saleOrderInfo.getOrderAmount()));
					data.put("amount", Utils.formatNumberByDecimal(saleOrderInfo.getAmount()));
					//1-已签收,  2,3未签收）
					data.put("status", saleOrderInfo.getStatus() == 1 ? "已签收" : "未签收");
					//1-未结算 2-已结算
					data.put("settleStatus", saleOrderInfo.getSettleStatus() == 1 ? "未结算" : "已结算");
					data.put("settleTime", DateUtil.formatDate(saleOrderInfo.getSettleTime(), DateUtil.DATE_TIME_FORMAT_03));
					data.put("sysUserName", saleOrderInfo.getSysUserName());
					
					//支付方式 1-微信 3-支付宝 4-汇款 5-现金
					String settleMethod = "";
					Integer settleMethod1 = saleOrderInfo.getSettleMethod();
					if(Checker.isNotEmpty(settleMethod1)){
						switch (settleMethod1) {
						case 1:
							settleMethod = "微信";
							break;
						case 3:
							settleMethod = "支付宝";
							break;
						case 4:
							settleMethod = "汇款";
							break;
						case 5:
							settleMethod = "现金";
							break;
						default:
							break;
						}
						data.put("settleMethod", settleMethod);
					}else {
						data.put("settleMethod", " ");
					}
					data.put("remark", saleOrderInfo.getRemark());
					amountSum = amountSum + saleOrderInfo.getAmount();
					data.put("amountSum", Utils.formatNumberByDecimal(amountSum));
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		return map;
	}

}

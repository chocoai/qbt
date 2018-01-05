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
import com.qbt.persistent.dto.SaleWeixinSubcripbeInfoDto;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.SaleWeixinSubcripbeInfo;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.SaleUserService;
import com.qbt.service.SaleWeixinSubcripbeInfoService;
import com.qbt.web.pojo.saleWeixinSubcripbeInfo.SaleWeixinSubcripbeInfoRequest;
import com.qbt.web.support.SaleWeixinSubcripbeInfoSupport;

@Service
public class SaleWeixinSubcripbeInfoSupportImpl implements SaleWeixinSubcripbeInfoSupport{

	@Resource
	private SaleWeixinSubcripbeInfoService saleWeixinSubcripbeInfoService;
	
	@Resource
	private SaleUserService saleUserService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, String title, SaleWeixinSubcripbeInfoRequest req, String currentDay) {
		PageEntity<SaleWeixinSubcripbeInfoDto> pageEntity = BeanUtil.pageConvert(req, SaleWeixinSubcripbeInfoDto.class);
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
			List<SaleWeixinSubcripbeInfo> list = saleWeixinSubcripbeInfoService.findByPageBySaleId(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				//小计奖金￥
				Double amountSum = 0.0;
				for(SaleWeixinSubcripbeInfo saleWeixinSubcripbeInfo : list){
					data = new HashMap<String, String>();
					data.put("createTime", DateUtil.formatDate(saleWeixinSubcripbeInfo.getCreateTime(), DateUtil.DATE_TIME_FORMAT_03));
					data.put("nickname", saleWeixinSubcripbeInfo.getNickname());
					data.put("amount", Utils.formatNumberByDecimal(saleWeixinSubcripbeInfo.getAmount()));
					//1-未结算 2-已结算
					data.put("settleStatus", saleWeixinSubcripbeInfo.getSettleStatus() == 1 ? "未结算" : "已结算");
					data.put("settleTime", DateUtil.formatDate(saleWeixinSubcripbeInfo.getSettleTime(), DateUtil.DATE_TIME_FORMAT_03));
					data.put("sysUserName", saleWeixinSubcripbeInfo.getSysUserName());
					//支付方式 1-微信 3-支付宝 4-汇款 5-现金
					String settleMethod = "";
					Integer settleMethod1 = saleWeixinSubcripbeInfo.getSettleMethod();
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
					data.put("remark", saleWeixinSubcripbeInfo.getRemark());
					amountSum = amountSum + saleWeixinSubcripbeInfo.getAmount();
					data.put("amountSum", Utils.formatNumberByDecimal(amountSum));
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		return map;
	}

}

/**
 * Project Name:qbt-report
 * File Name:SaleUserSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年2月8日下午2:15:42
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.SaleUserApplyStatus;
import com.qbt.common.enums.SaleUserFirstType;
import com.qbt.common.enums.SaleUserOrderDayType;
import com.qbt.common.enums.SaleUserType;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Utils;
import com.qbt.persistent.dto.SaleUserDto;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.SaleUserService;
import com.qbt.web.pojo.saleUser.SaleUserExportRequest;
import com.qbt.web.support.SaleUserSupport;

/**
 * ClassName:SaleUserSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月8日 下午2:15:42
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class SaleUserSupportImpl implements SaleUserSupport {
	
	@Resource
	private SaleUserService saleUserService;
	
	@Value("${file_domain}")
	private String fileDomain;
	
	@Override
	public Map<String, Object> exportSaleUser(SaleUserExportRequest req, SysUser sysUser) {
		PageEntity<SaleUserDto> pageEntity = BeanUtil.pageConvert(req, SaleUserDto.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		map.put("exportDate", DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01));
		
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<SaleUserDto> list = saleUserService.findByPage(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(SaleUserDto s : list){
					data = new HashMap<String, String>();
					data.put("salesmanCode", s.getSalesmanCode());
					data.put("name", s.getName());
					data.put("idcardUrl", Checker.isNotEmpty(s.getIdcardUrl()) ? fileDomain + s.getIdcardUrl() : "");
					data.put("company", s.getCompany());
					data.put("mobile", s.getMobile());
					data.put("idcard", s.getIdcard());
					data.put("qrcode", Checker.isNotEmpty(s.getQrcode()) ? fileDomain + s.getQrcode() : "");
					data.put("email", s.getEmail());
					data.put("createTime", DateUtil.formatDate(s.getCreateTime(), DateUtil.DATE_TIME_FORMAT_01));
					data.put("applyStatus", SaleUserApplyStatus.getByStatus(s.getApplyStatus()).getDesc());
					data.put("applyTime", Checker.isNotEmpty(s.getApplyTime()) ? DateUtil.formatDate(s.getApplyTime(), DateUtil.DATE_TIME_FORMAT_01) : null);
					data.put("sysUserName", s.getSysUserName());
					SaleUserType saleUserType = SaleUserType.getByType(s.getType());
					data.put("type", Checker.isNotEmpty(saleUserType) ? saleUserType.getDesc() : null);
					data.put("typeValue", Checker.isNotEmpty(s.getTypeValue()) ? Utils.formatNumberByDecimal(s.getTypeValue()) : null);
					data.put("subscribeValue", Checker.isNotEmpty(s.getSubscribeValue()) ? Utils.formatNumberByDecimal(s.getSubscribeValue()) : null);
					data.put("status", s.getStatus() == 1 ? "有效" : "无效");
					data.put("statusTime", Checker.isNotEmpty(s.getStatusTime()) ? DateUtil.formatDate(s.getStatusTime(), DateUtil.DATE_TIME_FORMAT_01) : null);
					data.put("qrcodeCreateInfoName", s.getQrcodeCreateInfoName());
					SaleUserFirstType firstType = SaleUserFirstType.getByType(s.getFirstType());
					data.put("firstType", Checker.isNotEmpty(firstType) ? firstType.getDesc() : "");
					data.put("firstTypeValue", Checker.isNotEmpty(s.getFirstTypeValue()) ? Utils.formatNumberByDecimal(s.getFirstTypeValue()) : null);
					SaleUserOrderDayType dayType = SaleUserOrderDayType.getByType(s.getOrderDayType());
					data.put("orderDay", Checker.isNotEmpty(dayType) ? dayType.getDesc() : "");
					data.put("orderDayValue", ObjectUtils.toString(s.getOrderDayValue()));
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		map.put("list", listMap);
		return map;
	}
	
}

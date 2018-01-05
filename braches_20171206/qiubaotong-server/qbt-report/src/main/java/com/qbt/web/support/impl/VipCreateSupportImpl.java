/**
 * Project Name:qbt-report
 * File Name:VipCreateSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年1月4日下午2:22:38
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.PaymethodEnum;
import com.qbt.common.enums.VipActivateMethodEnum;
import com.qbt.common.enums.VipActivateStatusEnum;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Utils;
import com.qbt.persistent.entity.SysUser;
import com.qbt.persistent.entity.VipCreate;
import com.qbt.persistent.entity.VipCreateInfo;
import com.qbt.service.VipCreateInfoService;
import com.qbt.service.VipCreateService;
import com.qbt.web.support.VipCreateSupport;

/**
 * ClassName:VipCreateSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月4日 下午2:22:38
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class VipCreateSupportImpl implements VipCreateSupport {
	
	@Resource
	private VipCreateService vipCreateService;
	
	@Resource
	private VipCreateInfoService vipCreateInfoService;
	
	@Override
	public Map<String, Object> exportVipCreateInfo(Integer vipCreateId, SysUser sysUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		VipCreate vipCreate = vipCreateService.findById(vipCreateId);
		map.put("name", vipCreate.getName());
		map.put("number", vipCreate.getNumber());
		map.put("vipTypeName", vipCreate.getVipTypeName());
		map.put("vipTypeValidDay", vipCreate.getVipTypeValidDay().toString());
		map.put("vipTypeAmount", Utils.formatNumberByDecimal(vipCreate.getVipTypeAmount()));
		map.put("optUserName", vipCreate.getOptUserName());
		map.put("endTime", DateUtil.formatDate(vipCreate.getEndTime(), DateUtil.DATE_FORMAT_02));
		
		String createDateStr = DateUtil.formatDate(vipCreate.getCreateTime(), DateUtil.DATE_TIME_FORMAT_03);
		String[] createDateStrs = createDateStr.split(" ");
		map.put("createDate", createDateStrs[0]);
		map.put("createTime", createDateStrs[1]);
		
		String nowStr = DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_03);
		String[] nowStrs = nowStr.split(" ");
		map.put("nowDate", nowStrs[0]);
		map.put("nowTime", nowStrs[1]);
		
		map.put("operator", sysUser.getName());
		
		
		VipCreateInfo condition = new VipCreateInfo();
		condition.setVipCreateId(vipCreateId);
		
		PageEntity<VipCreateInfo> pageEntity = new PageEntity<VipCreateInfo>();
		pageEntity.setCondition(condition);
		
		int pageNo = 0;
		int pageSize = PageEntity.MAX_PAGE_SIZE;
		pageEntity.setPageSize(pageSize);
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		do{
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<VipCreateInfo> list = vipCreateInfoService.findByPage(pageEntity);
			for(VipCreateInfo info : list){
				Map<String, String> data = new HashMap<String, String>();
				data.put("vipNo", info.getVipNo());
				data.put("vipRandom", info.getVipRandom());
				data.put("vipOrderNumber", 	info.getVipOrderNumber());
				data.put("sellStatus", info.getSellStatus() == 1 ? "未售出" : "已售出");
				data.put("payAmount", Checker.isNotEmpty(info.getPayAmount()) ? Utils.formatNumberByDecimal(info.getPayAmount().doubleValue()) : "");
				PaymethodEnum payMethod = PaymethodEnum.getByCode(info.getPayMethod());
				data.put("payMethod", Checker.isNotEmpty(payMethod) ? payMethod.getDesc() : "");
				data.put("activateStatus", VipActivateStatusEnum.getByCode(info.getActivateStatus()).getDesc());
				data.put("activateDate", Checker.isNotEmpty(info.getActivateDate()) ? DateUtil.formatDate(info.getActivateDate(), DateUtil.DATE_FORMAT_02) : "");
				data.put("activateMethod", Checker.isNotEmpty(info.getActivateMethod()) ? VipActivateMethodEnum.getByCode(info.getActivateMethod()).getDesc() : "");
				data.put("status", info.getStatus() == 1 ? "启用" : "禁用");
				listMap.add(data);
			}
		} while (pageNo < pageEntity.getPageCount());
		map.put("list", listMap);
		
		return map;
	}

}

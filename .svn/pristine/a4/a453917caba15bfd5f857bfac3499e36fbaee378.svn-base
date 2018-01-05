/**
 * Project Name:qbt-report
 * File Name:OrderCostItemSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年1月19日下午5:18:01
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
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Utils;
import com.qbt.persistent.dto.ReportOrderCostItem;
import com.qbt.persistent.dto.ReportOrderQuery;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.ReportOrderService;
import com.qbt.web.pojo.orderCostItem.ReportCostItemRequest;
import com.qbt.web.pojo.orderCostItem.ReportCostItemVo;
import com.qbt.web.support.OrderCostItemSupport;

/**
 * ClassName:OrderCostItemSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午5:18:01
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrderCostItemSupportImpl implements OrderCostItemSupport {
	
	@Resource
	private ReportOrderService reportOrderService;
	
	@Override
	public Map<String, Object> export(SysUser sysUser, String title, ReportCostItemRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("startDate", DateUtil.formatDate(req.getStartDate(), DateUtil.DATE_FORMAT_02));
		map.put("endDate", DateUtil.formatDate(req.getEndDate(), DateUtil.DATE_FORMAT_02));
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		map.put("nowaday", DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_03));
		
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<ReportOrderCostItem> list = reportOrderService.findCostItemByPage(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(ReportOrderCostItem i : list){
					data = new HashMap<String, String>();
					data.put("orderId", i.getId() + "");
					String[] createTime = DateUtil.formatDate(i.getCreateTime(), DateUtil.DATE_TIME_FORMAT_01).split(" ");
					data.put("orderDate", createTime[0]);
					data.put("orderTime", createTime[1]);
					data.put("orderNumber", i.getNumber());
					data.put("orderAmount", Utils.formatNumberByDecimal(i.getAmount()));
					PaymethodEnum payMethod = PaymethodEnum.getByCode(i.getPayMethod());
					data.put("payMethod", payMethod != null ? payMethod.getDesc() : "");
					data.put("item", i.getItem());
					data.put("itemAmount", Utils.formatNumberByDecimal(i.getItemAmount()));
					data.put("itemRemark", i.getItemRemark());
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		map.put("list", listMap);
		return map;
	}

	@Override
	public List<ReportCostItemVo> findByPage(ReportCostItemRequest req) {
		PageEntity<ReportOrderQuery> pageEntity = BeanUtil.pageConvert(req, ReportOrderQuery.class);
		
		List<ReportOrderCostItem> list = reportOrderService.findCostItemByPage(pageEntity);
		List<ReportCostItemVo> respList = new ArrayList<ReportCostItemVo>();
		for(ReportOrderCostItem i : list){
			ReportCostItemVo vo = new ReportCostItemVo();
			vo.setOrderId(i.getId());
			vo.setOrderTime(i.getCreateTime());
			vo.setOrderNumber(i.getNumber());
			vo.setOrderAmount(i.getAmount());
			vo.setPayMethod(i.getPayMethod());
			vo.setItem(i.getItem());
			vo.setItemAmount(i.getItemAmount());
			vo.setItemRemark(i.getItemRemark());
			respList.add(vo);
		}
		req.setTotalCount(pageEntity.getTotalCount());
		return respList;
	}

}

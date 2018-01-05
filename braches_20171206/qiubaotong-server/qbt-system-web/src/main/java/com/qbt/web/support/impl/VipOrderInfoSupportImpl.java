/**
 * Project Name:qbt-system-web
 * File Name:VipOrderInfoSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2016年11月4日下午3:25:33
 *
*/

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.dto.VipOrderInfo;
import com.qbt.service.OrderInfoService;
import com.qbt.web.pojo.vipOrderInfo.VipOrderInfoPageReqVo;
import com.qbt.web.pojo.vipOrderInfo.VipOrderInfoVo;
import com.qbt.web.support.VipOrderInfoSupport;

/**
 * ClassName:VipOrderInfoSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2016年11月4日 下午3:25:33
 * @author   haungyihao
 * @version  
 * @see 	 
 */
@Service
public class VipOrderInfoSupportImpl implements VipOrderInfoSupport {
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Override
	public List<VipOrderInfoVo> findByPage(VipOrderInfoPageReqVo reqVo) {
		PageEntity<VipOrderInfo> pageEntity = BeanUtil.pageConvert(reqVo, VipOrderInfo.class);
		List<VipOrderInfo> list = orderInfoService.findVipOrderInfoByPage(pageEntity);
		List<VipOrderInfoVo> voList = BeanUtil.list2list(list, VipOrderInfoVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}

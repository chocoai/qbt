/**
 * Project Name:qbt-system-web
 * File Name:VipCreateInfoSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年1月5日上午10:31:36
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.VipCreateInfo;
import com.qbt.persistent.entity.VipOrder;
import com.qbt.service.VipCreateInfoService;
import com.qbt.service.VipOrderService;
import com.qbt.web.pojo.vipCreateInfo.VipCreateInfoPageReqVo;
import com.qbt.web.pojo.vipCreateInfo.VipCreateInfoUpdateBatch;
import com.qbt.web.pojo.vipCreateInfo.VipCreateInfoVo;
import com.qbt.web.support.VipCreateInfoSupport;

/**
 * ClassName:VipCreateInfoSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月5日 上午10:31:36
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class VipCreateInfoSupportImpl implements VipCreateInfoSupport {
	
	@Resource
	private VipCreateInfoService vipCreateInfoService;
	
	@Resource
	private VipOrderService vipOrderService;
	
	@Override
	public List<VipCreateInfoVo> findByPage(VipCreateInfoPageReqVo reqVo) {
		PageEntity<VipCreateInfo> pageEntity = BeanUtil.pageConvert(reqVo, VipCreateInfo.class);
		List<VipCreateInfo> list = vipCreateInfoService.findByPage(pageEntity);
		List<VipCreateInfoVo> voList = BeanUtil.list2list(list, VipCreateInfoVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public boolean updateBatch(VipCreateInfoUpdateBatch updateBatch) {
		VipCreateInfo vipCreateInfo = BeanUtil.a2b(updateBatch, VipCreateInfo.class);
		vipCreateInfo.setSellStatus(2);//1-未售  2-已售
		vipCreateInfo.setStatus(Checker.isNotEmpty(updateBatch.getStatus()) ? updateBatch.getStatus() : 1);//1-启用 2-禁用
		int result = vipCreateInfoService.updateBatch(vipCreateInfo);
		if(result > 0){
			List<VipCreateInfo> infoList = vipCreateInfoService.findByIds(updateBatch.getIds());
			List<String> numbers = new ArrayList<String>();
			for(VipCreateInfo info : infoList){
				numbers.add(info.getVipOrderNumber());
			}
			VipOrder vipOrder = new VipOrder();
			vipOrder.setNumbers(numbers);
			vipOrder.setPayAmount(vipCreateInfo.getPayAmount());
			vipOrder.setPayMethod(vipCreateInfo.getPayMethod());
			vipOrderService.updateByNumbers(vipOrder);
		}
		return result > 0;
	}

}

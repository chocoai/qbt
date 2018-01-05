/**
 * Project Name:qbt-system-web
 * File Name:VipCreateSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年1月4日上午11:36:34
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RandomProvider;
import com.qbt.persistent.entity.SysUser;
import com.qbt.persistent.entity.VipCreate;
import com.qbt.persistent.entity.VipCreateInfo;
import com.qbt.persistent.entity.VipOrder;
import com.qbt.persistent.entity.VipType;
import com.qbt.service.CommonService;
import com.qbt.service.VipCreateInfoService;
import com.qbt.service.VipCreateService;
import com.qbt.service.VipOrderService;
import com.qbt.service.VipTypeService;
import com.qbt.web.pojo.vipCreate.VipCreateGenerate;
import com.qbt.web.pojo.vipCreate.VipCreatePageReqVo;
import com.qbt.web.pojo.vipCreate.VipCreateVo;
import com.qbt.web.support.VipCreateSupport;

/**
 * ClassName:VipCreateSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月4日 上午11:36:34
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class VipCreateSupportImpl implements VipCreateSupport {
	
	@Resource
	private VipCreateService vipCreateService;
	
	@Resource
	private VipTypeService vipTypeService;
	
	@Resource
	private VipCreateInfoService vipCreateInfoService;
	
	@Resource
	private CommonService commonService;
	
	@Resource
	private VipOrderService vipOrderService;
	
	@Override
	public boolean generateVipCard(VipCreateGenerate generate, SysUser sysUser) {
		VipCreate vipCreate = new VipCreate();
		int existCount = vipCreateService.exist(generate.getName());
		if(existCount > 0){
			throw new BusinessException("发行名称已存在");
		}
		vipCreate.setName(generate.getName());
		vipCreate.setNumber(generate.getNumber());
		vipCreate.setEndTime(generate.getEndTime());
		
		VipType vipType = vipTypeService.findById(generate.getVipTypeId());
		if(Checker.isEmpty(vipType)){
			throw new BusinessException("无效卡类型");
		}
		vipCreate.setVipTypeId(vipType.getId());
		vipCreate.setVipTypeName(vipType.getName());
		vipCreate.setVipTypeAmount(vipType.getAmount().doubleValue());
		vipCreate.setVipTypeValidDay(vipType.getValid());
		
		vipCreate.setOptUserId(sysUser.getId());
		vipCreate.setOptUserName(sysUser.getName());
		
		int vipCreateId = vipCreateService.insert(vipCreate);
		
		List<VipCreateInfo> infoList = new ArrayList<VipCreateInfo>();
		List<VipOrder> orderList = new ArrayList<VipOrder>();
		Integer sellStatus = Checker.isEmpty(generate.getSellStatus()) ? 1 : generate.getSellStatus();//1-未售  2-已售
		for(int i = 0; i < generate.getNumber(); i++){
			VipCreateInfo info = new VipCreateInfo();
			info.setVipCreateId(vipCreateId);
			info.setVipNo(commonService.createVipNo());
			info.setVipRandom(RandomProvider.randomNumeric(4));
			info.setVipOrderNumber(commonService.createVipOrderId());
			info.setPayAmount(generate.getPayAmount());
			info.setPayMethod(generate.getPayMethod());
			info.setSellStatus(sellStatus);//1-未售  2-已售
			info.setActivateStatus(1);//1-未激活 2-已激活
			info.setStatus(2);//1-启用 2-禁用
			infoList.add(info);
			
			// 添加VIP订单记录
			VipOrder vipOrder = new VipOrder();
			vipOrder.setNumber(info.getVipOrderNumber());
			vipOrder.setVipNo(info.getVipNo());
			vipOrder.setUserId(0);
			vipOrder.setPayAmount(info.getPayAmount());
			vipOrder.setPayMethod(info.getPayMethod());
			vipOrder.setVipTypeId(vipCreate.getVipTypeId());
			vipOrder.setName(vipCreate.getVipTypeName());
			vipOrder.setUserName("");
			vipOrder.setMobile("");
			vipOrder.setValidDesc(vipType.getValidDesc());
			vipOrder.setValid(vipCreate.getVipTypeValidDay());
			vipOrder.setSettlementStatus(2);//1-已收款 2-未收款
			vipOrder.setPayId(0);
			vipOrder.setPayNumber("");//商户流水
			vipOrder.setPayBakNo("");
			vipOrder.setVipCardType(2);
			vipOrder.setSalesmanName("");
			orderList.add(vipOrder);
		}
		if(Checker.isNotEmpty(infoList)){
			vipCreateInfoService.insertBatch(infoList);
		}
		if(Checker.isNotEmpty(orderList)){
			vipOrderService.insertBatch(orderList);
		}
		return true;
	}

	@Override
	public List<VipCreateVo> findByPage(VipCreatePageReqVo reqVo) {
		PageEntity<VipCreate> pageEntity = BeanUtil.pageConvert(reqVo, VipCreate.class);
		List<VipCreate> list = vipCreateService.findByPage(pageEntity);
		List<VipCreateVo> voList = BeanUtil.list2list(list, VipCreateVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}

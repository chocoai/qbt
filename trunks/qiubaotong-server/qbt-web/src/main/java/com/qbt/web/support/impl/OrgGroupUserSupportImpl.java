package com.qbt.web.support.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.OrgGroup;
import com.qbt.persistent.entity.OrgGroupUser;
import com.qbt.service.OrgGroupService;
import com.qbt.service.OrgGroupUserService;
import com.qbt.web.pojo.order.OrderOrgVo;
import com.qbt.web.support.OrgGroupUserSupport;

@Service
public class OrgGroupUserSupportImpl implements OrgGroupUserSupport {

	@Resource
	private OrgGroupUserService orgGroupUserService;
	@Resource
	private OrgGroupService orgGroupService;
	
	
	@Override
	public OrderOrgVo jContactIsOrg(String jContact, String jMobile) {
		OrgGroupUser orgGroupUser = orgGroupUserService.findByNameAndMobile(jContact, jMobile);
		OrgGroup orgGroup = null;
		OrderOrgVo vo = new OrderOrgVo();
		//时间比较
		Boolean rightDate = false;
		Boolean orgGroupStutas = false;
		Boolean orgGroupUserStutas = false;
		Date nowDate = new Date();
		if(Checker.isNotEmpty(orgGroupUser)){
			if(orgGroupUser.getStatus() == 1){
				orgGroupUserStutas = true;
			}
			orgGroup = orgGroupService.selectById(orgGroupUser.getOrgId());
		}
		if(Checker.isNotEmpty(orgGroup)){
			//结束时间往后加一天再比较
			Date endDate =  orgGroup.getEndDate();
			Calendar calendar = new  GregorianCalendar(); 
			calendar.setTime(endDate); 
			calendar.add(Calendar.DATE, 1);
			endDate=calendar.getTime();
			if((nowDate.after(orgGroup.getStartDate()) && (nowDate.before(endDate)))){
				rightDate = true;
			}
			if(orgGroup.getStatus()==1){
				orgGroupStutas = true;
			}
		}
		if(Checker.isNotEmpty(orgGroupUser)&&orgGroupUserStutas&&orgGroupStutas&&rightDate){
			vo.setOrgName(orgGroupUser.getOrgName());
			vo.setOrgId(orgGroupUser.getOrgId());
			vo.setOrgShortName(orgGroup.getShortName());
		}else{
			vo.setOrgId(0);
			vo.setOrgName("");
			vo.setOrgShortName("");
		}
		return vo;
	}

}

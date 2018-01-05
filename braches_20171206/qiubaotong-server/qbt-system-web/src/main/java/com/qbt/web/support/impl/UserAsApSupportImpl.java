package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.UserAssistantApplyWX;
import com.qbt.persistent.entity.BaseAirport;
import com.qbt.persistent.entity.BaseBankBranch;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseCourseInfo;
import com.qbt.persistent.entity.BasePartner;
import com.qbt.persistent.entity.BaseSfSite;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.BaseAirportService;
import com.qbt.service.BaseBankBranchService;
import com.qbt.service.BaseCourseInfoService;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BasePartnerService;
import com.qbt.service.BaseSfSiteService;
import com.qbt.service.UserAsApService;
import com.qbt.service.UserAssistantService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.pojo.asAp.UserAsApPageReqVo;
import com.qbt.web.pojo.asAp.UserAsApVo;
import com.qbt.web.pojo.asAp.UserAsUpdateVo;
import com.qbt.web.support.UserAsApSupport;
import com.qbt.wechat.api.WechatApi;

@Service
public class UserAsApSupportImpl implements UserAsApSupport{

	@Resource
	private UserAsApService userAsApService;
	@Resource
	private UserAssistantService userAssistantService;
	@Resource
	private WechatApi wechatApi;
	@Resource
	private UserWeixinService userWeixinService;
	@Resource
	private BaseCourseInfoService baseCourseInfoService;
	@Resource
	private WechatCommonSupport commonSupport;
	@Resource
	private BasePartnerService basePartnerService;
	@Resource
	private BaseCourseService baseCourseService;
	@Resource
	private BaseBankBranchService baseBankBranchService;
	@Resource
	private BaseSfSiteService baseSfSiteService;
	@Resource
	private BaseAirportService baseAirportService;
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	
	@Override
	public List<UserAsApVo> findByPage(UserAsApPageReqVo reqVo) {
		//将要查询条件放进来
		PageEntity<UserAssistantApply> pageEntity = BeanUtil.pageConvert(reqVo, UserAssistantApply.class);
		List<UserAssistantApply> list = userAsApService.findByPage(pageEntity);
		List<UserAsApVo> voList = BeanUtil.list2list(list, UserAsApVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void updateStatus(UserAsUpdateVo u) {
		UserAssistant userAssistant = userAssistantService.findById(u.getAssistantId());
		UserAssistantApply uAsAp = userAsApService.findByAssitantId(userAssistant.getId());
		if(Checker.isEmpty(uAsAp) || Checker.isEmpty(userAssistant)){
			throw new BusinessException("助理数据不完整");
		}
		userAssistant.setMemo(u.getMemo());
		//旅行社被禁用了，对应的球包助理不能启用
		if(userAssistant.getStatus() == 4 && u.getStatus() == 5){
			if(uAsAp.getApplyType() == 8){
				//合作社
				BasePartner basePartner = basePartnerService.findById(uAsAp.getApplyId());
				if(basePartner.getStatus() == 1){
					userAssistant.setStatus(2);
					userAssistantService.updateById(userAssistant);
				}else{
					throw new BusinessException("请将该助理的合作社启用");
				}
			}else if(uAsAp.getApplyType() == 1 || uAsAp.getApplyType() == 2){
				//球场
				BaseCourse baseCourse = baseCourseService.findById(uAsAp.getApplyId());
				if(baseCourse.getIsDelete()){
					throw new BusinessException("该助理的球场被禁用");
				}else{
					userAssistant.setStatus(2);
					userAssistantService.updateById(userAssistant);
				}
			}else if(uAsAp.getApplyType() == 3){
				//银行站点
				BaseBankBranch baseBankBranch = baseBankBranchService.findById(uAsAp.getApplyId());
				if(baseBankBranch.getIsDelete()){
					throw new BusinessException("该助理的银行站点被删除，请启用该银行站点");
				}else{
					userAssistant.setStatus(2);
					userAssistantService.updateById(userAssistant);
				}
			}else if(uAsAp.getApplyType() == 4){
				//顺丰站点
				BaseSfSite baseSfSite = baseSfSiteService.findById(uAsAp.getApplyId());
				if(baseSfSite.getIsDelete()){
					throw new BusinessException("该助理的顺丰站点被删除，请启用该顺丰站点");
				}else{
					userAssistant.setStatus(2);
					userAssistantService.updateById(userAssistant);
				}
			}else if(uAsAp.getApplyType() == 5){
				//顺丰机场
				BaseAirport baseAirport = baseAirportService.findById(uAsAp.getApplyId());
				if(baseAirport.getIsDelete()){
					throw new BusinessException("该助理的顺丰机场被禁用，请启用该顺丰机场");
				}else{
					userAssistant.setStatus(2);
					userAssistantService.updateById(userAssistant);
				}
			}
			
			
		}else{
			userAssistant.setStatus(u.getStatus());
			userAssistantService.updateById(userAssistant);
		}
		//给微信用户发送通知
		if(u.getStatus() == 2 || u.getStatus() == 3){
			UserWeixin userWeixin = userWeixinService.findById(userAssistant.getUserId());
			wechatMessageSupport.assistantApplyNotify(uAsAp, userAssistant, userWeixin.getOpenid());
		}
		//更新球场是否有助理
		if(Checker.isNotEmpty(uAsAp.getApplyType()) && (uAsAp.getApplyType() == 1 || uAsAp.getApplyType() == 2)){
			if(userAssistant.getStatus() == 2){
				BaseCourseInfo info = new BaseCourseInfo();
				info.setCourseId(uAsAp.getApplyId());
				info.setHasAssistant(true);
				baseCourseInfoService.updateByCourseId(info);
			}else if(userAssistant.getStatus() == 3 || userAssistant.getStatus() == 4){
				int count = userAssistantService.queryAssistantByApply(uAsAp.getApplyType(), uAsAp.getApplyId());
				if(count == 0){
					BaseCourseInfo info = new BaseCourseInfo();
					info.setCourseId(uAsAp.getApplyId());
					info.setHasAssistant(false);
					baseCourseInfoService.updateByCourseId(info);
				}
			}
		}
	}

	@Override
	public List<UserAsApVo> list(Integer applyId,int applyType) {
		List<UserAssistantApplyWX> userAssistantApplyWXList = userAsApService.list(applyId,applyType);
		List<UserAsApVo> userAsApVoList = BeanUtil.list2list(userAssistantApplyWXList, UserAsApVo.class);
		return userAsApVoList;
	}

}

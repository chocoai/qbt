
 /**
 * @Title: AssistantServiceImpl.java
 * @Package com.qbt.web.support.impl
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月18日
 * @version V1.0
 **/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.common.enums.ApplyTypeEnum;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.UserAsApService;
import com.qbt.service.UserAssistantService;
import com.qbt.web.pojo.assistant.Assistant;
import com.qbt.web.support.AssistantService;

/**
  * @ClassName: AssistantServiceImpl
  * @Description: TODO
  * @author win10 2016年8月18日
  * @modify win10 2016年8月18日
  */
@Service
public class AssistantServiceImpl implements AssistantService {
	@Resource
	private UserAssistantService userAssistantService;
	
	
	@Resource
	private UserAsApService  userAsApService;
	
	
	@Resource
	private FileuploadScpService fileuploadScpService;
	
	@Resource
	private WechatCommonSupport commonSupport;
	
	

	 /**
	  * @Title: insertOrUpdateAssistant
	  * @Description: TODO
	  * @author: win10 2016年8月18日
	  * @modify: win10 2016年8月18日
	  * @param userWeixin
	  * @param assistant
	  * @return
	  * @see com.qbt.web.support.AssistantService#insertOrUpdateAssistant(com.qbt.persistent.entity.UserWeixin, com.qbt.web.pojo.assistant.Assistant)
	  */
	@Override
	public void insertOrUpdateAssistant(UserWeixin userWeixin, Assistant assistant) {
		UserAssistant userAss=userAssistantService.selectByUserId(userWeixin.getId());
		if(userAss==null){//插入数据
			String[] pics=assistant.getPics();
			
//			if(pics==null||pics.length==0){ 
//				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "助理申请证件上传不能为空");
//			}
			String[] remoteFiles = null;
			if(Checker.isNotEmpty(pics)){
				String accessToken=commonSupport.getAccessToken();
				remoteFiles=fileuploadScpService.imageWeixinDownToScp(pics, accessToken);
			}

			UserAssistant ass=new UserAssistant();
			ass.setCreateTime(new Date());
			ass.setUserId(userWeixin.getId());
			ass.setMobile(assistant.getMobile());
			ass.setName(assistant.getName());
			ass.setEnjoyAssistantFee(false);
			ass.setStatus(1);
			ass.setApplyId(assistant.getApplyId());
			ass.setApplyName(assistant.getApplyName());
			ass.setApplyType(assistant.getApplyType());
			ass.setMemo("球包助理申请");
			
			userAssistantService.inserAssistant(ass);
			int assistantId = ass.getId();
			UserAssistantApply  apply =new UserAssistantApply();
			
			apply.setCreateTime(new Date());
			apply.setAssistantId(assistantId);
			apply.setName(assistant.getName());
			apply.setIdentityCode(Checker.isNotEmpty(assistant.getIdCode()) ? assistant.getIdCode() : "");
			if(Checker.isNotEmpty(remoteFiles)){
				apply.setPhoto1Url(remoteFiles[0]);
				apply.setPhoto2Url(remoteFiles[1]);
			}else{
				apply.setPhoto1Url("");
				apply.setPhoto2Url("");
			}
			apply.setApplyType(assistant.getApplyType());
			//apply.setStatus(1);
			apply.setApplyId(assistant.getApplyId());
			apply.setApplyName(assistant.getApplyName());
			apply.setRemark("");
			userAsApService.insertUserAssistantApply(apply);
		}else{
			//远程上传
			UserAssistantApply userApply=userAsApService.selectById(userAss.getId());
			if(userApply!=null){
				List<String> list=new ArrayList<String>();
				
				if(userApply.getPhoto1Url()!=null&&!"".equals(userApply.getPhoto1Url())){
					list.add(userApply.getPhoto1Url());
				}
				if(userApply.getPhoto2Url()!=null&&!"".equals(userApply.getPhoto2Url())){
					list.add(userApply.getPhoto2Url());
				}
				
				fileuploadScpService.delRemoteFile(list);				
			}
			
			
			String[] pics=assistant.getPics();
//			if(pics==null||pics.length==0){ 
//				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "助理申请证件上传不能为空");
//			}
			String[] remoteFiles=null;
			if(Checker.isNotEmpty(pics)){
				String accessToken=commonSupport.getAccessToken();
				remoteFiles=fileuploadScpService.imageWeixinDownToScp(pics, accessToken);
			}
			
			userAss.setStatus(1);
			userAss.setName(assistant.getName());
			userAss.setMobile(assistant.getMobile());
			userAss.setMemo("球包助理 重新申请");
			userAss.setApplyId(assistant.getApplyId());
			userAss.setApplyName(assistant.getApplyName());
			userAss.setApplyType(assistant.getApplyType());
			userAssistantService.updateById(userAss);
			
			
			UserAssistantApply  apply =new UserAssistantApply();
			
			apply.setCreateTime(new Date());
			apply.setAssistantId(userAss.getId());
			apply.setName(assistant.getName());
			apply.setIdentityCode(Checker.isNotEmpty(assistant.getIdCode()) ? assistant.getIdCode() : "");
			if(Checker.isNotEmpty(remoteFiles)){
				apply.setPhoto1Url(remoteFiles[0]);
				apply.setPhoto2Url(remoteFiles[1]);
			}else{
				apply.setPhoto1Url("");
				apply.setPhoto2Url("");
			}
			apply.setApplyType(assistant.getApplyType());
			//apply.setStatus(1);
			apply.setApplyId(assistant.getApplyId());
			apply.setApplyName(assistant.getApplyName());
			apply.setRemark("");
			userAsApService.updateApplyByAssistantId(apply);
		}
	}



	@Override
	public boolean checkIsPartner(Integer userId) {
		UserAssistantApply apply = userAsApService.findPartnerByUserId(userId, ApplyTypeEnum.partner.getCode());
		return apply == null ? false:true;
	}
}

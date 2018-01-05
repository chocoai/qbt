/**
 * Project Name:qbt-web
 * File Name:SaleUserSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年2月7日下午2:39:51
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.SaleOrderInfoDto;
import com.qbt.persistent.dto.SaleSubcripbeInfoDto;
import com.qbt.persistent.entity.SaleQrcodeInfo;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.SaleOrderInfoService;
import com.qbt.service.SaleQrcodeInfoService;
import com.qbt.service.SaleUserService;
import com.qbt.service.SaleWeixinSubcripbeInfoService;
import com.qbt.sms.api.service.SmsCodeService;
import com.qbt.web.pojo.saleUser.SaleUserApplyVo;
import com.qbt.web.pojo.saleUser.SaleUserOrderRequest;
import com.qbt.web.pojo.saleUser.SaleUserOrderVo;
import com.qbt.web.pojo.saleUser.SaleUserSubcripbeRequest;
import com.qbt.web.pojo.saleUser.SaleUserSubcripbeVo;
import com.qbt.web.pojo.saleUser.SaleUserVo;
import com.qbt.web.support.SaleUserSupport;

/**
 * ClassName:SaleUserSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月7日 下午2:39:51
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class SaleUserSupportImpl implements SaleUserSupport {
	
	@Resource
	private SaleUserService saleUserService;
	
	@Resource
	private SaleQrcodeInfoService saleQrcodeInfoService;
	
	@Resource
	private WechatCommonSupport commonSupport;
	
	@Resource
	private FileuploadScpService fileuploadScpService;
	
	@Resource
	private SmsCodeService smsCodeService;
	
	@Resource
	private SaleOrderInfoService saleOrderInfoService;
	
	@Resource
	private SaleWeixinSubcripbeInfoService saleWeixinSubcripbeInfoService;
	
	@Override
	public SaleUserVo detail(Integer userId) {
		SaleUser user = saleUserService.findByUserId(userId);
		SaleUserVo vo = BeanUtil.a2b(user, SaleUserVo.class);
		return vo;
	}

	@Override
	public boolean apply(UserWeixin userWeixin, SaleUserApplyVo applyVo) {
		SaleQrcodeInfo qrcodeInfo = null;
		
		// 判断销售编号是否已被使用
		if(Checker.isNotEmpty(applyVo.getSalesmanCode())){
			qrcodeInfo = saleQrcodeInfoService.findByCode(applyVo.getSalesmanCode());
			if(Checker.isEmpty(qrcodeInfo)){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "无效工作证号");
			}
			int count = saleUserService.existCode(userWeixin.getId(), applyVo.getSalesmanCode());
			if(count > 0){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "该工作证号已被使用");
			}
		}
		
		smsCodeService.checkSmsCode(applyVo.getMobile(), applyVo.getSmsCode(), applyVo.getSmsToken());
		
		// 查询销售人员信息
		SaleUser saleUser = saleUserService.findByUserId(userWeixin.getId());
		if(Checker.isEmpty(saleUser)){
			saleUser = new SaleUser();
			saleUser.setUserId(userWeixin.getId());
			applyVoToSaleUser(saleUser, applyVo, qrcodeInfo);
			saleUserService.insert(saleUser);
		}else{
			if(saleUser.getApplyStatus() == 2 && saleUser.getStatus() == 1){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "您已成为销售人员, 不能重复申请");
			}
			
			// 删除旧的身份证照片
			List<String> fileList = new ArrayList<String>();
			fileList.add(saleUser.getIdcardUrl());
			fileuploadScpService.delRemoteFile(fileList);
			
			applyVoToSaleUser(saleUser, applyVo, qrcodeInfo);
			
			saleUserService.updateForWechatApply(saleUser);
		}
		
		return true;
	}
	
	
	private void applyVoToSaleUser(SaleUser saleUser, SaleUserApplyVo applyVo, SaleQrcodeInfo qrcodeInfo){
		saleUser.setSalesmanCode(Checker.isNotEmpty(qrcodeInfo) ? qrcodeInfo.getSalesmanCode() : "");
		saleUser.setName(applyVo.getName());
		saleUser.setMobile(applyVo.getMobile());
		saleUser.setIdcard(applyVo.getIdcard());
		saleUser.setCompany(applyVo.getCompany());
		saleUser.setQrcode(Checker.isNotEmpty(qrcodeInfo) ? qrcodeInfo.getQrcode() : "");
		saleUser.setType(Checker.isNotEmpty(qrcodeInfo) && Checker.isNotEmpty(qrcodeInfo.getType()) ? qrcodeInfo.getType() : 1);//0-未知 1-固定金额 2-订单金额比例
		saleUser.setTypeValue(Checker.isNotEmpty(qrcodeInfo) && Checker.isNotEmpty(qrcodeInfo.getTypeValue()) ? qrcodeInfo.getTypeValue() : 0);
		saleUser.setSubscribeValue(Checker.isNotEmpty(qrcodeInfo) && Checker.isNotEmpty(qrcodeInfo.getSubscribeValue()) ? qrcodeInfo.getSubscribeValue() : 0);
		saleUser.setApplyStatus(1);//1-待审核 2-审核通过 3-审核不通过
		saleUser.setStatus(2);//1-有效 2-无效
		saleUser.setFirstType(Checker.isNotEmpty(qrcodeInfo) && Checker.isNotEmpty(qrcodeInfo.getFirstType()) ? qrcodeInfo.getFirstType() : 1);//0-未知 1-固定金额 2-订单金额比例
		saleUser.setFirstTypeValue(Checker.isNotEmpty(qrcodeInfo) && Checker.isNotEmpty(qrcodeInfo.getFirstTypeValue()) ? qrcodeInfo.getFirstTypeValue() : 0);
		saleUser.setOrderDayType(Checker.isNotEmpty(qrcodeInfo) && Checker.isNotEmpty(qrcodeInfo.getOrderDayType()) ? qrcodeInfo.getOrderDayType() : 1);//1-不限 2-有限制天数
		saleUser.setOrderDayValue(Checker.isNotEmpty(qrcodeInfo) && Checker.isNotEmpty(qrcodeInfo.getOrderDayValue()) ? qrcodeInfo.getOrderDayValue() : null);
		
		if(Checker.isNotEmpty(applyVo.getIdcardUrl())){
			String accessToken = commonSupport.getAccessToken();
			String[] remoteFiles = fileuploadScpService.imageWeixinDownToScp(new String[]{applyVo.getIdcardUrl()}, accessToken);
			saleUser.setIdcardUrl(remoteFiles[0]);
		}else{
			saleUser.setIdcardUrl(null);
		}
	}

	@Override
	public String codeCompany(String salesmanCode) {
		SaleQrcodeInfo qrcodeInfo = saleQrcodeInfoService.findByCode(salesmanCode);
		return Checker.isNotEmpty(qrcodeInfo) ? qrcodeInfo.getCompany() : null;
	}

	@Override
	public List<SaleUserOrderVo> orderList(UserWeixin userWeixin, SaleUserOrderRequest req) {
		SaleUser saleUser = saleUserService.findByUserId(userWeixin.getId());
		if(Checker.isEmpty(saleUser)){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效销售人员");
		}
		SaleOrderInfoDto dto = BeanUtil.a2b(req, SaleOrderInfoDto.class);
		dto.setSaleId(saleUser.getId());
		List<SaleOrderInfoDto> list = saleOrderInfoService.wechatUserOrderList(dto);
		List<SaleUserOrderVo> voList = BeanUtil.list2list(list, SaleUserOrderVo.class);
		return voList;
	}

	@Override
	public List<SaleUserSubcripbeVo> subcripbeList(UserWeixin userWeixin, SaleUserSubcripbeRequest req) {
		SaleUser saleUser = saleUserService.findByUserId(userWeixin.getId());
		if(Checker.isEmpty(saleUser)){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效销售人员");
		}
		SaleSubcripbeInfoDto dto = BeanUtil.a2b(req, SaleSubcripbeInfoDto.class);
		dto.setSaleId(saleUser.getId());
		List<SaleSubcripbeInfoDto> list = saleWeixinSubcripbeInfoService.wechatUserSubcripbeList(dto);
		List<SaleUserSubcripbeVo> voList = BeanUtil.list2list(list, SaleUserSubcripbeVo.class);
		return voList;
	}

}

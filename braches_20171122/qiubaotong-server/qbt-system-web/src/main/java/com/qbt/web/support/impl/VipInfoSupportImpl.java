/**
 * Project Name:qbt-system-web
 * File Name:VipInfoSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2016年11月3日下午5:52:31
 *
*/

package com.qbt.web.support.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ApplyTypeEnum;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.enums.PayStatus;
import com.qbt.common.enums.PaymentStatus;
import com.qbt.common.enums.PaymethodEnum;
import com.qbt.common.enums.VipActivateMethodEnum;
import com.qbt.common.enums.VipActivateStatusEnum;
import com.qbt.common.enums.VipInfoStatus;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.exception.WechatException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.persistent.entity.UserImage;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.entity.VipCreate;
import com.qbt.persistent.entity.VipCreateInfo;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.persistent.entity.VipOrder;
import com.qbt.persistent.entity.VipPayment;
import com.qbt.persistent.entity.VipType;
import com.qbt.service.CommonService;
import com.qbt.service.UserAsApService;
import com.qbt.service.UserImageService;
import com.qbt.service.UserWeixinService;
import com.qbt.service.VipCreateInfoService;
import com.qbt.service.VipCreateService;
import com.qbt.service.VipOrderService;
import com.qbt.service.VipPaymentService;
import com.qbt.service.VipTypeService;
import com.qbt.service.VipUserService;
import com.qbt.web.pojo.userImage.UserImageAppointVo;
import com.qbt.web.pojo.vipInfo.ActivateRequest;
import com.qbt.web.pojo.vipInfo.VipInfoPageReqVo;
import com.qbt.web.pojo.vipInfo.VipInfoVo;
import com.qbt.web.pojo.vipInfo.VipUserModifyRequest;
import com.qbt.web.support.VipInfoSupport;

/**
 * ClassName:VipInfoSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2016年11月3日 下午5:52:31
 * @author   haungyihao
 * @version  
 * @see 	 
 */
@Service
public class VipInfoSupportImpl implements VipInfoSupport {
	
	@Resource
	private VipUserService vipUserService;
	@Resource
	private VipTypeService vipTypeService;
	@Resource
	private UserWeixinService userWeixinService;
	@Resource
	private CommonService commonService;
	@Resource
	private VipOrderService  vipOrderService;
	@Resource
	private VipPaymentService vipPaymentService;
	@Resource
	private UserAsApService userAsApService;
	@Resource
	private VipCreateInfoService vipCreateInfoService;
	@Resource
	private VipCreateService vipCreateService;
	@Resource
	private UserImageService userImageService;
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	
	@Override
	public List<VipInfoVo> findByPage(VipInfoPageReqVo reqVo) {
		PageEntity<VipInfo> pageEntity = BeanUtil.pageConvert(reqVo, VipInfo.class);
		List<VipInfo> list = vipUserService.findByPage(pageEntity);
		List<VipInfoVo> voList = BeanUtil.list2list(list, VipInfoVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public VipInfoVo detail(Integer id) {
		VipInfo vipInfo = vipUserService.findById(id);
		VipInfoVo vo = BeanUtil.a2b(vipInfo, VipInfoVo.class);
		return vo;
	}

	@Override
	public boolean updateStatus(Integer id, Integer status) {
		VipInfo vipInfo = vipUserService.findById(id);
		vipInfo.setStatus(status);
		return vipUserService.updateById(vipInfo) > 0;
	}

	
	 /**
	  * @Title: addVipInfo
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月4日
	  * @modify: chenxiaocong 2016年11月4日
	  * @param vipInfo
	  * @return
	  * @see com.qbt.web.support.VipInfoSupport#addVipInfo(com.qbt.persistent.entity.VipInfo)
	  */
	
	@Override
	public boolean addVipInfo(VipInfoVo vipInfoVo) {
		try {  
           VlidationUtil.validate(vipInfoVo);  
       } catch (ValidationException e) {  
    	   throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL,e.getMessage());
	   }
		
		VipInfo vipInfo = null;
		UserWeixin userWeixin = null;
		//判断该用户是否已经绑定会员卡		
		if(vipInfoVo.getOpenId()!=null && (!vipInfoVo.getOpenId().isEmpty())){
			//增加会员信息
			//根据openId 获取会员用户信息
			userWeixin = userWeixinService.findByOpenId(vipInfoVo.getOpenId());
			if(userWeixin==null){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL,"该微信用户不存在");
			}
			
			//检查是否合作社购买，合作社不允许购买
			UserAssistantApply apply = userAsApService.findPartnerByUserId(userWeixin.getId(), ApplyTypeEnum.partner.getCode());
			
			if(apply == null ? false:true){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "合作社机构用户不允许购买会员");
			}
			
		}
		
		//根据会员类型ID获取会员类型信息
		VipType vipTypeInfo = vipTypeService.findById(vipInfoVo.getVipTypeId());
		
		if(vipTypeInfo.getStatus()!=1){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL,"会员类型已被禁用");
		}
		
		vipInfo = new VipInfo();
		
		
		vipInfo.setCreateTime(new Date());
		vipInfo.setUpdateTime(new Date());
		vipInfo.setName(vipTypeInfo.getName());
		vipInfo.setOrderAmount(vipTypeInfo.getOrderAmount().doubleValue());
		vipInfo.setUserName(vipInfoVo.getUserName());
		vipInfo.setMobile(vipInfoVo.getMobile());
		vipInfo.setVipTypeId(vipInfoVo.getVipTypeId());
		//生成编号
		String vipNo;
		try {
			vipNo = commonService.createVipNo();
		} catch (Exception e) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL,"生成会员编号错误");
		}
		
		vipInfo.setVipNo(vipNo);
		
		//有效期
		
		Date validDate  = DateUtil.getPointDate(vipTypeInfo.getValid());
		//格式成 00:00:00秒
		String validDates = DateUtil.formatDate(validDate);
		validDates += " 00:00:00";
		validDate = DateUtil.str2Date(validDates,DateUtil.DATE_TIME_FORMAT_01);
		
		vipInfo.setValidTime(validDate);

		vipInfo.setUpdateMobileCount(0);
		
		if(userWeixin!=null){
			vipInfo.setUserId(userWeixin.getId());
			vipInfo.setOpenId(userWeixin.getOpenid());
			vipInfo.setNickname(userWeixin.getNickname());
		}
		vipInfo.setStatus(VipInfoStatus.normal.getCode());
		vipInfo.setActivateStatus(VipActivateStatusEnum.Yes.getCode());
		vipInfo.setActivateMethod(VipActivateMethodEnum.KF.getCode());
		vipInfo.setUsedOrder(false);
		vipInfo.setOperatorId(vipInfoVo.getOperatorId());
		vipInfo.setOperatorName(vipInfoVo.getOperatorName());
		vipUserService.insert(vipInfo);
		
		//购买订单流水=============================================================================
		VipPayment vipPayment = new VipPayment();
		
		String payno = commonService.createPaymentId();
		vipPayment.setCreateTime(new Date());//创建时间
		vipPayment.setUpdateTime(new Date());//更新时间
		
		vipPayment.setUuid(payno);
		
		vipPayment.setOrderId(0);
		if(userWeixin!=null){
			vipPayment.setUserId(userWeixin.getId());
		}else{
			vipPayment.setUserId(0);
		}
		
		
		vipPayment.setPayAmount(vipTypeInfo.getAmount());//支付金额
		vipPayment.setPayMethod(PaymethodEnum.boss_vip_pay.getCode());//1-微信支付2-boss购买
		
		vipPayment.setStatus(PaymentStatus.success.getCode());//1-预支付 2-支付成功 3-支付失败 4-异常
		vipPayment.setPayStatus(PayStatus.success.getCode());//1-初始化 2-成功 3-失败
		vipPayment.setVipTypeId(vipTypeInfo.getId());//会员类型id
		vipPayment.setName(vipTypeInfo.getName());//会员卡名称
		
		vipPayment.setUserName(vipInfo.getUserName());//用户名
		vipPayment.setMobile(vipInfo.getMobile());//手机号码
		vipPayment.setValidDesc(vipTypeInfo.getValidDesc());//有效期描述
		vipPayment.setValid(vipTypeInfo.getValid());//有效期 ，单位天
		
		vipPaymentService.insert(vipPayment);
		
		//新增完，重新加载出来
		vipPayment = vipPaymentService.findByUuid(payno);
		
		
		//增加购买会员订单==================
		
		VipOrder vipOrder = new VipOrder();
		
		vipOrder.setCreateTime(new Date());
		vipOrder.setUpdateTime(new Date());
		
		String number = commonService.createVipOrderId();
		vipOrder.setNumber(number);
		
		vipOrder.setVipNo(vipInfo.getVipNo());
		vipOrder.setUserId(vipPayment.getUserId());
		vipOrder.setPayAmount(vipPayment.getPayAmount().doubleValue());
		vipOrder.setPayMethod(vipPayment.getPayMethod());
		vipOrder.setName(vipPayment.getName());
		vipOrder.setUserName(vipPayment.getUserName());
		vipOrder.setMobile(vipPayment.getMobile());
		vipOrder.setValidDesc(vipPayment.getValidDesc());
		vipOrder.setVipTypeId(vipTypeInfo.getId());//会员类型id
		vipOrder.setValid(vipPayment.getValid());
		vipOrder.setSettlementStatus(2);
		vipOrder.setPayId(vipPayment.getId());
		vipOrder.setPayNumber(vipPayment.getUuid());//商户流水
		vipOrder.setVipCardType(1);
		vipOrder.setSalesmanName(vipInfoVo.getSalesmanName());
		vipOrderService.insert(vipOrder);
		
		vipOrder = vipOrderService.findByNumber(number);
		
		//重新将订单获取出来，关联至流水表，更新流水表
		
		vipPayment.setUpdateTime(new Date());
		vipPayment.setOrderId(vipOrder.getId());
		
		vipPaymentService.updateById(vipPayment);

		//当客服购买选择微信用户，下推微信通知
		if(userWeixin!=null){
			wechatMessageSupport.vipSuccessPayNotify(vipInfo);
		}
		
		return true;
	}

	@Override
	public void activate(ActivateRequest req) {
		String openId = req.getOpenId();
		String mobile = req.getMobile();
		String userName = req.getUserName();
		String vipNo = req.getVipNo();
		String random = req.getRandom();
		
		VipCreateInfo createInfo = vipCreateInfoService.findByVipNo(req.getVipNo(), req.getRandom());
		if(createInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"输入资料不正确，未能激活会员卡，请重新输入");
		}
		if(createInfo.getActivateStatus().intValue() == VipActivateStatusEnum.Yes.getCode()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"此会员卡已被激活，不能再次激活");
		}
		VipCreate vipCreate = vipCreateService.findById(createInfo.getVipCreateId());
		long nowTime = DateUtil.str2Date(DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_01),  DateUtil.DATE_FORMAT_01).getTime();
		if(nowTime - vipCreate.getEndTime().getTime() > 0 ){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"会员卡已过激活时间");
		}
		
		// 此会员卡已激活
		vipCreateInfoService.updateActivate(vipNo, random,VipActivateMethodEnum.KF.getCode());
		VipType vipType = vipTypeService.findById(vipCreate.getVipTypeId());
		// 添加会员信息
		VipInfo vipInfo = new VipInfo();
		vipInfo.setCreateTime(new Date());
		vipInfo.setUpdateTime(new Date());
		vipInfo.setVipTypeId(vipCreate.getVipTypeId());
		vipInfo.setName(vipCreate.getVipTypeName());
		vipInfo.setOrderAmount(vipType.getOrderAmount().doubleValue());
		vipInfo.setUserName(userName);
		vipInfo.setMobile(mobile);
		vipInfo.setVipNo(vipNo);
		vipInfo.setOpenId(openId);
		
		//有效期
		Date validDate  = DateUtil.getPointDate(vipCreate.getVipTypeValidDay());
		//格式成 00:00:00秒
		String validDates = DateUtil.formatDate(validDate);
		validDates += " 00:00:00";
		validDate = DateUtil.str2Date(validDates,DateUtil.DATE_TIME_FORMAT_01);
		vipInfo.setValidTime(validDate);
		vipInfo.setUpdateMobileCount(0);
		
		//根据微信id找到微信用户信息
		UserWeixin userWeixin = userWeixinService.findByOpenId(openId);
		if(userWeixin!=null){
			vipInfo.setUserId(userWeixin.getId());
			vipInfo.setOpenId(userWeixin.getOpenid());
			vipInfo.setNickname(userWeixin.getNickname());
			if(Checker.isEmpty(userWeixin.getMobile())){
				userWeixin.setMobile(vipInfo.getMobile());
				userWeixin.setName(vipInfo.getUserName());
				userWeixinService.update(userWeixin);
			}
		}
		vipInfo.setStatus(VipInfoStatus.normal.getCode());
		vipInfo.setActivateStatus(VipActivateStatusEnum.Yes.getCode());
		vipInfo.setActivateMethod(VipActivateMethodEnum.KF.getCode());
		vipInfo.setUsedOrder(false);
		vipInfo.setOperatorId(req.getOperatorId());
		vipInfo.setOperatorName(req.getOperatorName());
		vipUserService.insert(vipInfo);
		// 添加VIP订单记录
		VipOrder vipOrder = new VipOrder();
		vipOrder.setNumber(createInfo.getVipOrderNumber());
		vipOrder.setUserId(userWeixin != null ? userWeixin.getId():0);
		vipOrder.setPayMethod(createInfo.getPayMethod());
		vipOrder.setUserName(userName);
		vipOrder.setMobile(mobile);
		vipOrderService.updateByNumber(vipOrder);
	}

	@Override
	public void modify(VipUserModifyRequest req) {
		int id = req.getId();
		String mobile = req.getMobile();
		String userName = req.getUserName();
		
		VipInfo vipInfo = vipUserService.findById(id);
		if(vipInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"会员信息不存在");
		}
		boolean usedOrder = vipInfo.getUsedOrder();
		// 修改手机号
		if(Checker.isNotEmpty(mobile)){
			if(vipInfo.getUpdateMobileCount() >= 1 && usedOrder){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"仅限修改一次手机号");
			}
			vipInfo.setMobile(mobile);
			if(usedOrder){
				vipInfo.setUpdateMobileCount(vipInfo.getUpdateMobileCount()+1);
			}
			vipUserService.updateMobile(vipInfo);
				
		}
		// 修改用户名
		if(Checker.isNotEmpty(userName)){
			if(usedOrder){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"不能修改用户名");
			}
			vipInfo.setUserName(userName);
			vipUserService.updateUserName(vipInfo);
		}
	}

	@Override
	public void updateAppointImage(UserImageAppointVo vo) {
		if(vo.getUserImageId()>0){
			//已经绑定
			UserImage userImages= userImageService.findById(vo.getUserImageId());
			VipInfo vipInfo = new VipInfo();
			vipInfo.setId(vo.getId());
			vipInfo.setUserImgId(vo.getUserImageId());
			vipInfo.setUserImageUrl(userImages.getImageUrl());
			vipUserService.updateById(vipInfo);
		}else{
			//未绑定
			VipInfo vipInfo = new VipInfo();
			vipInfo.setId(vo.getId());
			vipInfo.setUserImageUrl(vo.getImageUrl());
			vipUserService.updateById(vipInfo);
		}
	}

	@Override
	public void updateUserWeixin(Integer userId, Integer id) {
		UserWeixin userWeixin = userWeixinService.findById(userId);
		if(Checker.isNotEmpty(userWeixin)){
			VipInfo vipInfo = new VipInfo();
			vipInfo.setId(id);
			vipInfo.setUserId(userId);
			vipInfo.setOpenId(userWeixin.getOpenid());
			vipInfo.setNickname(userWeixin.getNickname());
			//图片绑定
			VipInfo vipInfo1= vipUserService.findById(id);
			if(Checker.isNotEmpty(vipInfo1.getUserImageUrl())){
				UserImage userImage = new UserImage();
				userImage.setUserId(userId);
				userImage.setImageUrl(vipInfo1.getUserImageUrl());
				userImageService.insert(userImage);
				vipInfo.setUserImgId(userImage.getId());
			}
			vipUserService.updateById(vipInfo);
		}
	}

	@Override
	public void deleteAppointImage(Integer id) {
		VipInfo vipInfo = new VipInfo();
		vipInfo.setId(id);
		vipInfo.setUserImgId(0);
		vipInfo.setUserImageUrl("");
		vipUserService.updateById(vipInfo);
	}
	
}

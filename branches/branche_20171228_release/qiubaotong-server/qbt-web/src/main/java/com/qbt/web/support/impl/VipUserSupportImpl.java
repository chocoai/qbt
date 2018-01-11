
 /**
 * @Title: VipUserSupportImpl.java
 * @Package com.qbt.web.support.impl
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2016年11月3日
 * @version V1.0
 **/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.enums.VipActivateMethodEnum;
import com.qbt.common.enums.VipActivateStatusEnum;
import com.qbt.common.enums.VipInfoStatus;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.UserImage;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.entity.VipCreate;
import com.qbt.persistent.entity.VipCreateInfo;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.persistent.entity.VipOrder;
import com.qbt.persistent.entity.VipPayment;
import com.qbt.persistent.entity.VipType;
import com.qbt.service.CommonService;
import com.qbt.service.UserImageService;
import com.qbt.service.UserWeixinService;
import com.qbt.service.VipCreateInfoService;
import com.qbt.service.VipCreateService;
import com.qbt.service.VipOrderService;
import com.qbt.service.VipTypeService;
import com.qbt.service.VipUserService;
import com.qbt.web.pojo.vip.ActivateRequest;
import com.qbt.web.pojo.vip.VipTypeVo;
import com.qbt.web.pojo.vip.VipUser;
import com.qbt.web.pojo.vip.VipUserModifyImgRequest;
import com.qbt.web.pojo.vip.VipUserModifyRequest;
import com.qbt.web.support.VipUserSupport;

/**
 * VIP会员
  * @ClassName: VipUserSupportImpl
  * @Description: TODO
  * @author chenxiaocong 2016年11月3日
  * @modify chenxiaocong 2016年11月3日
  */
@Service
public class VipUserSupportImpl implements VipUserSupport {

	@Resource
	private  VipUserService vipUserService;
	
	@Resource
	private  VipTypeService vipTypeService;
	
	@Resource
	private CommonService commonService;
	
	@Resource
	private UserWeixinService userWeixinService;
	
	@Resource
	private VipCreateInfoService vipCreateInfoService;
	
	@Resource
	private VipCreateService vipCreateService;
	
	@Resource
	private VipOrderService  vipOrderService;
	
	@Resource
	private UserImageService userImageService;
	
	/**
	 * 根据微信号获取VIP微信用户信息
	 * @Title: findByOpenId
	 * @Description: TODO
	 * @author: chenxiaocong 2016年11月3日
	 * @modify: chenxiaocong 2016年11月3日
	 * @param openId
	 * @return
	 * @see com.qbt.web.support.VipUserSupport#findByOpenId(java.lang.String)
	 */
	@Override
	public List<VipUser> findByOpenId(String openId) {
		List<VipInfo> vipInfo = vipUserService.findByOpenId(openId);
		List<VipUser> vipUserList = BeanUtil.list2list(vipInfo,VipUser.class);
		for(VipUser vipUser : vipUserList){
			vipUser.setVipCardBuyMoney(vipTypeService.findById(vipUser.getVipTypeId()).getAmount().doubleValue());
		}
		return vipUserList;
	}

	
	 /**
	  * 根据vip类型状态获取vip类型列表
	  * @Title: getVipTypeByStaus
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月3日
	  * @modify: chenxiaocong 2016年11月3日
	  * @param status
	  * @return
	  * @see com.qbt.web.support.VipUserSupport#getVipTypeByStaus(int)
	  */
	@Override
	public List<VipTypeVo> getVipTypeByStaus(int status) {
		List<VipType> vipTypeList = vipTypeService.selectByStatus(status);
		List<VipTypeVo> vipTypeVoList = null;
		if(vipTypeList!=null && vipTypeList.size()>0){
			
			vipTypeVoList = new ArrayList<VipTypeVo>();
			
			for(VipType v :vipTypeList){
				VipTypeVo vipTypeVo  = BeanUtil.a2b(v,VipTypeVo.class);
				vipTypeVoList.add(vipTypeVo);
			}
		}
		
		return vipTypeVoList;
	}

	@Override
	public VipType findVipType() {
		// TODO Auto-generated method stub
		return vipTypeService.findOne();
	}
	
	 /**
	  * @Title: addVipInfo
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月4日
	  * @modify: chenxiaocong 2016年11月4日
	  * @param vipPayment
	  * @return
	  * @see com.qbt.web.support.VipUserSupport#addVipInfo(com.qbt.persistent.entity.VipPayment)
	  */
	
	@Override
	public VipInfo addVipInfo(VipPayment vipPayment) {

		VipInfo vipInfo = new VipInfo();
		
		vipInfo.setCreateTime(new Date());
		vipInfo.setUpdateTime(new Date());
		vipInfo.setVipTypeId(vipPayment.getVipTypeId());
		vipInfo.setName(vipPayment.getName());
		
		VipType viptype = vipTypeService.findById(vipPayment.getVipTypeId());
		vipInfo.setOrderAmount(viptype.getOrderAmount().doubleValue());
		vipInfo.setUserName(vipPayment.getUserName());
		vipInfo.setMobile(vipPayment.getMobile());
		
		//生成编号
		String vipNo;
		try {
			vipNo = commonService.createVipNo();
		} catch (Exception e) {
			LogCvt.error("生成会员编号错误"+e.getMessage(),e);
			return null;
		}
		
		vipInfo.setVipNo(vipNo);
				
		
		//有效期
		
		Date validDate  = DateUtil.getPointDate(vipPayment.getValid());
		//格式成 00:00:00秒
		String validDates = DateUtil.formatDate(validDate);
		validDates += " 00:00:00";
		validDate = DateUtil.str2Date(validDates,DateUtil.DATE_TIME_FORMAT_01);
		
		vipInfo.setValidTime(validDate);

		vipInfo.setUpdateMobileCount(0);
		
		//根据微信id找到微信用户信息
		UserWeixin userWeixin = userWeixinService.findById(vipPayment.getUserId());
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
		vipInfo.setActivateMethod(VipActivateMethodEnum.Wechat.getCode());
		vipInfo.setUsedOrder(false);
		
		vipInfo.setUserImgId(vipPayment.getUserImgId());
		vipInfo.setUserImageUrl(vipPayment.getUserImageUrl());
		
		vipUserService.insert(vipInfo);
		
		return vipInfo;
	}

	/**
	 *  更新手机号
	  * @Title: modifyMobile
	  * @Description: TODO
	  * @author: share 2016年11月5日
	  * @modify: share 2016年11月5日
	  * @param mobile
	  * @param openId
	  * @see com.qbt.web.support.VipUserSupport#modifyMobile(java.lang.String, java.lang.String)
	 */
	@Override
	public void modify(VipUserModifyRequest req) {
		Integer vipInfoId = req.getId();
		String openId = req.getOpenId();
		String mobile = req.getMobile();
		String userName = req.getUserName();
		
		VipInfo vipInfo = vipUserService.findById(vipInfoId);
		if(vipInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"你尚未购买会员");
		}
		if(!vipInfo.getOpenId().equals(openId)){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"会员卡信息错误");
		}
		boolean usedOrder = vipInfo.getUsedOrder();
		// 修改手机号
		if(Checker.isNotEmpty(mobile)){
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
	public VipType findVipType(int id) {
		// TODO Auto-generated method stub
		return vipTypeService.findById(id);
	}


	@Override
	public void activate(ActivateRequest req) {
		// TODO Auto-generated method stub
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
		vipCreateInfoService.updateActivate(vipNo, random,VipActivateMethodEnum.Wechat.getCode());
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
		vipInfo.setActivateMethod(VipActivateMethodEnum.Wechat.getCode());
		vipInfo.setUsedOrder(false);
		vipUserService.insert(vipInfo);
		// 添加VIP订单记录
		VipOrder vipOrder = new VipOrder();
		vipOrder.setNumber(createInfo.getVipOrderNumber());
		vipOrder.setUserId(userWeixin.getId());
		vipOrder.setPayMethod(createInfo.getPayMethod());
		vipOrder.setUserName(userName);
		vipOrder.setMobile(mobile);
		vipOrderService.updateByNumber(vipOrder);
	}


	@Override
	public VipUser detail(Integer id) {
		VipInfo info = vipUserService.findById(id);
		VipUser vipUser = BeanUtil.a2b(info, VipUser.class);
		vipUser.setVipCardBuyMoney(vipTypeService.findById(vipUser.getVipTypeId()).getAmount().doubleValue());
		return vipUser;
	}


	@Override
	public boolean modifyImg(VipUserModifyImgRequest req) {
		//根据微信id找到微信用户信息
		UserWeixin userWeixin = userWeixinService.findByOpenId(req.getOpenId());
		
		VipInfo vipInfo = vipUserService.findById(req.getId());
		if(vipInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"你尚未购买会员");
		}
		if(vipInfo.getUserId() != userWeixin.getId()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"会员卡信息错误");
		}
		
		UserImage userImg = userImageService.findById(req.getImgId());
		if(userImg == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"图片不存在");
		}
		if(userImg.getUserId() != userWeixin.getId()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"图片信息错误");
		}
		
		vipInfo.setUserImgId(userImg.getId());
		vipInfo.setUserImageUrl(userImg.getImageUrl());
		return vipUserService.updateImg(vipInfo) > 0;
	}
}
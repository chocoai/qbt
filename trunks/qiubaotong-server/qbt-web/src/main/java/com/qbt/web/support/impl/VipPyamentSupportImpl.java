
 /**
 * @Title: VipPyamentSupportImpl.java
 * @Package com.qbt.web.support.impl
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2016年11月3日
 * @version V1.0
 **/

package com.qbt.web.support.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.enums.PayStatus;
import com.qbt.common.enums.PaymentStatus;
import com.qbt.common.enums.PaymethodEnum;
import com.qbt.common.enums.UnifiedOrderTradeType;
import com.qbt.common.exception.WechatException;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.persistent.entity.UserImage;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.persistent.entity.VipPayment;
import com.qbt.persistent.entity.VipType;
import com.qbt.service.CommonService;
import com.qbt.service.UserImageService;
import com.qbt.service.VipPaymentService;
import com.qbt.service.VipTypeService;
import com.qbt.service.VipUserService;
import com.qbt.web.pojo.vip.VipPayRequest;
import com.qbt.web.support.AssistantService;
import com.qbt.web.support.VipPyamentSupport;
import com.qbt.wechat.api.WechatApi;
import com.qbt.wechat.entity.UnifiedOrderRequest;
import com.qbt.wechat.entity.UnifiedOrderResponse;

/**
  * @ClassName: VipPyamentSupportImpl
  * @Description: TODO
  * @author chenxiaocong 2016年11月3日
  * @modify chenxiaocong 2016年11月3日
  */
@Service
public class VipPyamentSupportImpl implements VipPyamentSupport {

	@Value("${sc.env}")
	private boolean isScEnv = true;
	@Value("${vip_notify_url}")
	private String notifyUrl;
	@Resource
	private WechatApi wechatApi;
	@Resource
	private VipTypeService vipTypeService;
	@Resource
	private VipPaymentService vipPaymentService;
	@Resource
	private CommonService commonService;
	@Resource
	private VipUserService vipUserService;
	@Resource
	private AssistantService assistantService;
	@Resource
	private UserImageService userImageService;
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	
	/**
	 * 购买vip预支付
	  * @Title: vipPay
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月4日
	  * @modify: chenxiaocong 2016年11月4日
	  * @param request
	  * @return
	 */
	public Map<String,String> vipPay(VipPayRequest vipPayRequest) {
		/**
		 * 购买vip订单校验
		 */
		//检查是否合作社购买，合作社不允许购买
		boolean isAssistant =  assistantService.checkIsPartner(vipPayRequest.getUserId());
		
		if(isAssistant){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "合作社机构不允许购买会员");
		}
		
		
		//会员类型校验，根据会员名称或者会员类型详细信息
		int vipTypeId = vipPayRequest.getVipTypeId();
		
		VipType vipTypeInfo = vipTypeService.findById(vipTypeId);
		
		if(vipTypeInfo==null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效的会员类型");
		}
		int typeStatus = vipTypeInfo.getStatus();
		
		if(typeStatus != 1){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效的会员类型");
		}
		
		// 查询会员图片
		UserImage userImage = null;
		if(Checker.isNotEmpty(vipPayRequest.getUserImgId())){
			userImage = userImageService.findById(vipPayRequest.getUserImgId());
			if(userImage == null){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"无效的会员图片");
			}
		}
		
		//判断购买金额是否一致
		BigDecimal price = vipTypeInfo.getAmount();
		if( price.compareTo(vipPayRequest.getPrice())!=0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "支付金额不正确");
		}

		
		int payExpireTime = 15 * 60;
		Date startTime = new Date();
		Date expireTime = new Date(startTime.getTime() + (payExpireTime * 1000));

		String payno = commonService.createPaymentId();
		UnifiedOrderRequest wechatRequest = new UnifiedOrderRequest();
		wechatRequest.setBody("球包通购买会员下单支付");
		wechatRequest.setOutTradeNo(payno);
		if(isScEnv){
			wechatRequest.setTotalFee(String.valueOf(vipPayRequest.getPrice()));
		}else{
			wechatRequest.setTotalFee("0.01");
		}
		
		wechatRequest.setTimeStart(DateUtil.formatDate(startTime, "yyyyMMddHHmmss") );
		wechatRequest.setTimeExpire(DateUtil.formatDate(expireTime, "yyyyMMddHHmmss"));
		wechatRequest.setOpenid(vipPayRequest.getOpenid());
		wechatRequest.setSpbillCreateIp("127.0.0.1");
		//回调地址赋值
		wechatRequest.setNotifyUrl(notifyUrl);

		UnifiedOrderResponse response = wechatApi.unifiedOrder(wechatRequest, UnifiedOrderTradeType.JSAPI);
		
		if("FAIL".equals(response.getReturn_code())){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, response.getReturn_msg());
		}
		
		/**
		 * vip订单组装
		 */
		
		VipPayment vipPayment = new VipPayment();
		
		
		vipPayment.setCreateTime(new Date());//创建时间
		vipPayment.setUpdateTime(new Date());//更新时间
		
		vipPayment.setUuid(payno);
		
		vipPayment.setOrderId(0);
		vipPayment.setUserId(vipPayRequest.getUserId());
		
		vipPayment.setPayAmount(vipPayRequest.getPrice());//支付金额
		vipPayment.setPayMethod(PaymethodEnum.weixin_pay.getCode());//1-微信支付2-boss购买
		
		vipPayment.setStatus(PaymentStatus.ready.getCode());//1-预支付 2-支付成功 3-支付失败 4-异常
		vipPayment.setPayStatus(PayStatus.init.getCode());//1-初始化 2-成功 3-失败
		vipPayment.setVipTypeId(vipTypeInfo.getId());//会员类型id
		vipPayment.setName(vipTypeInfo.getName());//会员卡名称
		
		vipPayment.setUserName(vipPayRequest.getUser_name());//用户名
		vipPayment.setMobile(vipPayRequest.getMobile());//手机号码
		vipPayment.setValidDesc(vipTypeInfo.getValidDesc());//有效期描述
		vipPayment.setValid(vipTypeInfo.getValid());//有效期 ，单位天
		
		vipPayment.setPaySign(wechatRequest.getSign());
		vipPayment.setPrepayId(response.getPrepay_id());
		
		vipPayment.setStartTime(startTime.getTime());
		vipPayment.setExpireTime(expireTime.getTime());
		vipPayment.setPaypackage(JSonUtil.toJSonString(response.getPaypackage()));
		
		vipPayment.setUserImgId(Checker.isNotEmpty(userImage) ? userImage.getId() : null);
		vipPayment.setUserImageUrl(Checker.isNotEmpty(userImage) ? userImage.getImageUrl() : null);
		
		vipPaymentService.insert(vipPayment);
		
		return response.getPaypackage();
	}

	
	 /**
	  * 根据微信支付唯一流水号获取预支付订单信息
	  * @Title: findByUuid
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月4日
	  * @modify: chenxiaocong 2016年11月4日
	  * @param uuid
	  * @return
	  * @see com.qbt.web.support.VipPyamentSupport#findByUuid(java.lang.String)
	  */
	
	@Override
	public VipPayment findByUuid(String uuid) {
		return vipPaymentService.findByUuid(uuid);
	}


	
	 /**
	  * @Title: updateVipPyament
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月4日
	  * @modify: chenxiaocong 2016年11月4日
	  * @param vipPayRequest
	  * @see com.qbt.web.support.VipPyamentSupport#updateVipPyament(com.qbt.web.pojo.vip.VipPayRequest)
	  */
	
	@Override
	public void updateVipPayment(VipPayment vipPayment,VipInfo vipInfo) {
		vipPaymentService.updateById(vipPayment);
		
		//下推微信通知
		wechatMessageSupport.vipSuccessPayNotify(vipInfo);
		
	}
}

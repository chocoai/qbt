package com.qbt.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.qbt.common.enums.SerialTypeEnum;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.RandomProvider;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.ToolsUtil;
import com.qbt.redis.RedisService;
import com.qbt.service.CommonService;

/**
 *  公共组件服务
  * @ClassName: CommonServiceImpl
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
@Service
public class CommonServiceImpl implements CommonService {

	@Resource
	private RedisService redisService;
	
	/**
	 *  订单创建
	  * @Title: createOrderId
	  * @Description: TODO
	  * @author: share 2016年8月13日
	  * @modify: share 2016年8月13日
	  * @return
	  * @see com.qbt.service.CommonService#createOrderId()
	 */
	@Override
	public String createOrderId() {
		String yyymmdd = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYMMDD);
		String key = RedisKeyUtil.serial_number_increment_key(SerialTypeEnum.ORDER_TYPE.getType(), yyymmdd);
		long exists = redisService.setnx(key, "1");
		long number = 1;
		if(exists == 1){
			redisService.setex(key, 25 * 60 * 60, "1");
		}else{
			number = redisService.incr(key);
		}
		return ToolsUtil.createOrderNo("GB",yyymmdd, number);
	}
	
	@Override
	public String createBigOrderId() {
		String yyymmdd = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYMMDD);
		String key = RedisKeyUtil.serial_number_increment_key(SerialTypeEnum.BIG_ORDER_TYPE.getType(), yyymmdd);
		long exists = redisService.setnx(key, "1");
		long number = 1;
		if(exists == 1){
			redisService.setex(key, 25 * 60 * 60, "1");
		}else{
			number = redisService.incr(key);
		}
		return ToolsUtil.createOrderNo("",yyymmdd, number);
	}

	@Override
	public String createPaymentId() {
		String yyymmdd = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYMMDD);
		String key = RedisKeyUtil.serial_number_increment_key(SerialTypeEnum.PAYMENT_TYPE.getType(), yyymmdd);
		long exists = redisService.setnx(key, "1");
		long number = 1;
		if(exists == 1){
			redisService.setex(key, 25 * 60 * 60, "1");
		}else{
			number = redisService.incr(key);
		}
		return ToolsUtil.createNo("",yyymmdd, SerialTypeEnum.PAYMENT_TYPE.getValue(), number);
	}

	@Override
	public String createRefundId() {
		String yyymmdd = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYMMDD);
		String key = RedisKeyUtil.serial_number_increment_key(SerialTypeEnum.REFUND_TYPE.getType(), yyymmdd);
		long exists = redisService.setnx(key, "1");
		long number = 1;
		if(exists == 1){
			redisService.setex(key, 25 * 60 * 60, "1");
		}else{
			number = redisService.incr(key);
		}
		return ToolsUtil.createNo("",yyymmdd, SerialTypeEnum.REFUND_TYPE.getValue(), number);
	}

	@Override
	public String createCouponCode() {
		String redStr = "";
		long l = 0;
		do {
			redStr = RandomProvider.randomNumeric(8);
			l = redisService.putSet(RedisKeyUtil.qbt_coupon_key(), redStr);
		} while (l == 0);
		
		return redStr;
	}
	
	
	@Override
	public String createVipNo() {
		String redStr = "";
		long l = 0;
		do {
			redStr = RandomProvider.randomVip(8);
			l = redisService.putSet(RedisKeyUtil.qbt_vip_no_key(), redStr);
		} while (l == 0);
		
		return redStr;
	}
	
	@Override
	public long lock(String key, String value,int time) {
		long flag = redisService.setnx(key, value);
		if(time == 0){
			time = 5 * 60;
		}
		if(flag == 1){
			redisService.expire(key, time);
		}
		return flag;
	}

	@Override
	public String getLockValue(String key) {
		return redisService.get(key);
	}

	@Override
	public void unlock(String key) {
		redisService.del(key);
	}
	
	
	@Override
	public String createVipOrderId() {
		String yyymmdd = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYMMDD);
		String key = RedisKeyUtil.serial_number_increment_key(SerialTypeEnum.VIP_ORDER_TYPE.getType(), yyymmdd);
		long exists = redisService.setnx(key, "1");
		long number = 1;
		if(exists == 1){
			redisService.setex(key, 25 * 60 * 60, "1");
		}else{
			number = redisService.incr(key);
		}
		return ToolsUtil.createOrderNo("VIP",yyymmdd, number);
	}

	@Override
	public String createQrcodeCapital(Integer salesmanCodeMaxNumInt) {
		String redStr = "";
		redStr = RandomProvider.randomSaleQrcode(2);
		String salesmanCodeNum = StringUtils.leftPad(String.valueOf(salesmanCodeMaxNumInt), 8, '0');
		redStr = redStr + salesmanCodeNum;
		return redStr;
	}
	
	@Override
	public String createCouponCodeActivityCode() {
		String redStr = "";
		redStr = RandomProvider.randomCouponCodeActivityCode(6);
		return redStr;
	}

	@Override
	public String createChannelQrcodeCode() {
		String channelQrcodeCode = "";
		long l = 0;
		do {
			channelQrcodeCode = RandomProvider.randomSaleQrcode(4);
			channelQrcodeCode = channelQrcodeCode + (int)((Math.random()*9+1)*1000);
			l = redisService.putSet(RedisKeyUtil.qbt_channel_qrcode_code_key(), channelQrcodeCode);
		} while (l == 0);
		return channelQrcodeCode;
	}
	
}
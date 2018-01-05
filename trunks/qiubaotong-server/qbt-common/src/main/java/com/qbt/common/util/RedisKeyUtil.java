package com.qbt.common.util;

import java.text.MessageFormat;

import org.apache.commons.lang.ObjectUtils;

public class RedisKeyUtil {

	private static final String DEFAULT_PADDING = "*";
	
	
	/**
	 * 活动缓存
	 */
	private static String Activity_Code_Redis_Key="activity:code:{0}";
	public static String Activity_Code_Redis_Key(String code){
		return MessageFormat.format(Activity_Code_Redis_Key, ObjectUtils.toString(code, DEFAULT_PADDING));
	}
	
	/**
	 * 活动用户指标
	 */
	private static String Activity_UserId_Redis_Key="activity:index:{0}:{1}";
	public static String Activity_UserId_Redis_key(int activityId,int userId){
		return MessageFormat.format(Activity_UserId_Redis_Key, ObjectUtils.toString(activityId, DEFAULT_PADDING),ObjectUtils.toString(userId, DEFAULT_PADDING));
	}
	
	/**
	 * 活动对应的券码缓存
	 */
	private static String Activity_Coupon_Redis_Key="activity:copuon:{0}";
	public static String Activity_Coupon_Redis_Key(int activityId){
		return MessageFormat.format(Activity_Coupon_Redis_Key, ObjectUtils.toString(activityId, DEFAULT_PADDING));
	}
	
	private static String Coupon_Pay_Lock_Redis_Key="activity:copuon:lock:{0}";
	public static String Coupon_Pay_Lock_Redis_Key(String couponCode){
		return MessageFormat.format(Coupon_Pay_Lock_Redis_Key, ObjectUtils.toString(couponCode, DEFAULT_PADDING));
	}
	
	
	
	/**
	 * 短信验证码
	 */
	private static String User_SmsCode_Redis_SmsToke="user:{0}";
	public static String User_SmsCode_Redis_SmsToke(String smsToken){
		return MessageFormat.format(User_SmsCode_Redis_SmsToke, ObjectUtils.toString(smsToken, DEFAULT_PADDING));
	}
	
	/**
	 * 图片短信验证码
	 */
	private static String Captacha_Code_Redis_Toke="qbt:captcha:{0}";
	public static String captacha_Code_Redis_Toke(String token){
		return MessageFormat.format(Captacha_Code_Redis_Toke, ObjectUtils.toString(token, DEFAULT_PADDING));
	}
	
	/**
	 * 联系人Redis
	 */
	private static String User_Contact_Redis_Mobile_key = "user:contact:{0}";
	public static String user_contact_redis_mobile_key(String mobile){
		return MessageFormat.format(User_Contact_Redis_Mobile_key, ObjectUtils.toString(mobile, DEFAULT_PADDING));
	}
	
	/**
	 * 微信用户Redis
	 */
	private static String User_weixin_Redis_openId_key = "user:weixin:{0}";
	public static String user_weixin_redis_openid_key(String openid){
		return MessageFormat.format(User_weixin_Redis_openId_key, ObjectUtils.toString(openid, DEFAULT_PADDING));
	}
	
	/**
	 * 微信用户Token Redis
	 */
	private static String User_weixin_token_Redis_openId_key = "user:weixin:token:{0}";
	private static String User_weixin_token_Redis_UserId_key = "user:weixin:{0}";
	public static String user_weixin_token_redis_openid_key(String token){
		return MessageFormat.format(User_weixin_token_Redis_openId_key, ObjectUtils.toString(token, DEFAULT_PADDING));
	}
	public static String User_weixin_token_Redis_UserId_key(int userId){
		return MessageFormat.format(User_weixin_token_Redis_UserId_key, ObjectUtils.toString(userId, DEFAULT_PADDING));
	}
	
	/**
	 * 微信Accesstoke  Redis
	 */
	private static String Access_token_Redis_key = "weixin:appid:access_token";
	private static String Access_token_Redis_lock_key = "weixin:appid:access_token_lock";
	public static String access_token_Redis_key(){
		return Access_token_Redis_key;
	}
	public static String access_token_Redis_lock_key(){
		return Access_token_Redis_lock_key;
	}
	
	private static String Jsapi_ticket_Redis_key = "weixin:appid:jsapi_ticket";
	private static String Jsapi_ticket_Redis_lock_key = "weixin:appid:jsapi_ticket_lock";
	public static String jsapi_ticket_Redis_key(){
		return Jsapi_ticket_Redis_key;
	}
	public static String jsapi_ticket_Redis_lock_key(){
		return Jsapi_ticket_Redis_lock_key;
	}
	
	/**
	 * 地区Redis
	 */
	private static String Area_Id_Redis_Key = "area:id:{0}";
	private static String Area_Name_Redis_Key = "area:name:{0}";
	public static String Area_Id_Redis_Key(int id){
		return MessageFormat.format(Area_Id_Redis_Key, ObjectUtils.toString(id, DEFAULT_PADDING));
	}
	
	public static String Area_Name_Redis_Key(String name){
		String nameKey = Md5.MD5Encode(name);
		return MessageFormat.format(Area_Name_Redis_Key, ObjectUtils.toString(nameKey, DEFAULT_PADDING));
	}
	
	/**
	 * 轮番广告
	 */
	private static String BaseAdv_Id_Redis_Key = "qbt:baseAdv:id:{0}";
	private static String BaseAdv_T_P_Redis_Key = "qbt:baseAdv:tp:{0}:{1}";
	public static String BaseAdv_Id_Redis_Key(int id){
		return MessageFormat.format(BaseAdv_Id_Redis_Key, ObjectUtils.toString(id, DEFAULT_PADDING));
	}
	
	public static String BaseAdv_T_P_Redis_Key(String type, String position){
		return MessageFormat.format(BaseAdv_T_P_Redis_Key, ObjectUtils.toString(type, DEFAULT_PADDING),ObjectUtils.toString(position, DEFAULT_PADDING));
	}
	
	/**
	 * 合作社
	 */
	private static String Base_partner_Redis_Key = "qbt:basePartner:id:{0}";
	public static String Base_partner_Redis_Key(int id){
		return MessageFormat.format(Base_partner_Redis_Key, ObjectUtils.toString(id, DEFAULT_PADDING));
	}
	
	/**
	 * 保价模板Key
	 */
	private static String Insured_Template_Valid_Key = "insure:template:valid";
	public static String Insured_Template_Valid_Key(){
		return Insured_Template_Valid_Key;
	}
	
	/**
	 * 保价模板Key
	 */
	private static String SF_PRICE_KEY = "sf:price:cityname:{0}:{1}";
	public static String sf_price_key(String startCity,String endCity){
		startCity = Md5.MD5Encode(startCity);
		endCity = Md5.MD5Encode(endCity);
		return MessageFormat.format(SF_PRICE_KEY, ObjectUtils.toString(startCity, DEFAULT_PADDING),ObjectUtils.toString(endCity, DEFAULT_PADDING));
	}
	
	/**
	 * 序列号自增Key
	 */
	private static String serial_number_increment_key = "serial:number:increment_key:{0}:{1}";
	public static String serial_number_increment_key(String type,String yyymmdd){
		return MessageFormat.format(serial_number_increment_key, ObjectUtils.toString(type, DEFAULT_PADDING),ObjectUtils.toString(yyymmdd, DEFAULT_PADDING));
	}
	
	/**
	 * 订单Redis Key
	 */
	private static String order_info_orderid_key = "qbt:order:info:{0}";
	public static String order_info_orderid_key(String orderId){
		return MessageFormat.format(order_info_orderid_key, ObjectUtils.toString(orderId, DEFAULT_PADDING));
	}
	
	/**
	 * 首单缓存
	 */
	private static String order_user_count_userid_key = "qbt:user:order:count:{0}:{1}";
	public static String order_user_count_userid_key(int plattype,int userId){
		return MessageFormat.format(order_user_count_userid_key, ObjectUtils.toString(plattype, DEFAULT_PADDING),ObjectUtils.toString(userId, DEFAULT_PADDING));
	}
	
	
	/**
	 * 订单Redis 订单MQ Key
	 */
	private static String MQ_order_pay_sucess_redis_key = "qbt:order:mq:{0}";
	public static String mq_order_pay_sucess_redis_key(String type){
		return MessageFormat.format(MQ_order_pay_sucess_redis_key, ObjectUtils.toString(type, DEFAULT_PADDING));
	}
	
	/**
	 * 后台用户token
	 */
	private static String sys_user_token = "sys:user:token:{0}";
	public static String sys_user_token_key(String keyV){
		return MessageFormat.format(sys_user_token, ObjectUtils.toString(keyV, DEFAULT_PADDING));
	}
	
	/**
	 * 后台用户redis
	 */
	private static String sys_user_userId = "sys:user:{0}";
	public static String sys_user_userId_key(Integer userId){
		return MessageFormat.format(sys_user_userId, ObjectUtils.toString(userId, DEFAULT_PADDING));
	}
	
	/**
	 * 球场redis
	 */
	private static String base_course_id = "base:course:{0}";
	public static String base_course_id_key(Integer id){
		return MessageFormat.format(base_course_id, ObjectUtils.toString(id, DEFAULT_PADDING));
	}
	
	/**
	 * 机场redis
	 */
	private static String base_airport_id = "base:airport:{0}";
	public static String base_airport_id_key(Integer id){
		return MessageFormat.format(base_airport_id, ObjectUtils.toString(id, DEFAULT_PADDING));
	}
	
	/**
	 * 银行网点redis
	 */
	private static String base_bank_branch_id = "base:bank:branch:{0}";
	public static String base_bank_branch_id_key(Integer id){
		return MessageFormat.format(base_bank_branch_id, ObjectUtils.toString(id, DEFAULT_PADDING));
	}
	
	/**
	 * 顺丰网点redis
	 */
	private static String base_sf_site_id = "base:sf:site:{0}";
	public static String base_sf_site_id_key(Integer id){
		return MessageFormat.format(base_sf_site_id, ObjectUtils.toString(id, DEFAULT_PADDING));
	}
	
	/**
	 * 缓存券码redis
	 */
    private static final String QBT_COUPON_KEY = "qbt:coupon:simple:sequence";
	public static String qbt_coupon_key(){
		return QBT_COUPON_KEY;
	}
	
	/**
	 * 缓存vipNO
	 */
    private static final String QBT_VIP_NO_KEY = "qbt:vip:simple:sequence";
	public static String qbt_vip_no_key(){
		return QBT_VIP_NO_KEY;
	}
	
	/**
	 * 缓存渠道二维码识别码标识
	 */
    private static final String QBT_CHANNEL_QRCODE_CODE_KEY = "qbt:channel:qrcode:code:sequence";
		public static String qbt_channel_qrcode_code_key(){
			return QBT_CHANNEL_QRCODE_CODE_KEY;
	}
	
	
	/**
	 * 球包助理
	 */
	private static String user_assistant_user_key="user:assistant:{0}";
	public static String user_assistant_user_key(int id){
		return MessageFormat.format(user_assistant_user_key, ObjectUtils.toString(id, DEFAULT_PADDING));
	}
	
	/**
	 * 定时同步锁
	 */
	private static String timer_task_lock_key="timer:task:lock:{0}";
	public static String timer_task_lock_key(String value){
		return MessageFormat.format(timer_task_lock_key, ObjectUtils.toString(value, DEFAULT_PADDING));
	}
	
	
	/**
	 * 日语手机号白名单
	 */
	private static String language_mobile_key="language:mobile:key";
	public static String language_mobile_key(){
		return language_mobile_key;
	}
	
	/**
	 * 支付一个大订单多个子订单匹配不同活动
	 */
	private static String pay_order_suborder_activity_key="pay:order:suborder:activity:{0}";
	public static String pay_order_suborder_activity_key(String value){
		return MessageFormat.format(pay_order_suborder_activity_key, ObjectUtils.toString(value, DEFAULT_PADDING));
	}
	
	/**
	 * VIP order cache key
	 */
	private static String pay_vip_order_suborder_key="pay:vip:order:suborder:{0}";
	public static String pay_vip_order_suborder_key(int value){
		return MessageFormat.format(pay_vip_order_suborder_key, ObjectUtils.toString(value, DEFAULT_PADDING));
	}
	
	private static String fiter_same_order_sms_key="sms:fiter:same:order:key:{0}:{1}";
	public static String fiter_same_order_sms_key(int orderId,String value){
		return MessageFormat.format(fiter_same_order_sms_key, ObjectUtils.toString(orderId, DEFAULT_PADDING),ObjectUtils.toString(value, DEFAULT_PADDING));
	}
	
	 /**
	  * bsp地區配置
	 */
	private static String base_sf_bsp_area_config_areaname = "base:sf:bsp:area:config:{0}";
	public static String base_sf_bsp_area_config_areaname_key(String srcCity, String srcCountry){
		String areaName = Md5.MD5Encode(srcCity + srcCountry);
		return MessageFormat.format(base_sf_bsp_area_config_areaname, ObjectUtils.toString(areaName, DEFAULT_PADDING));
	}
	
	/**
	 * BSP网关线路
	 */
	private static String sf_bsp_order_getaway_key = "qbt:sf:bsp:order:getaway_key";
	public static String sf_bsp_order_getaway_key(){
		return sf_bsp_order_getaway_key;
	}
	
	
	/**
	 * Vip微信用户Redis
	 */
	private static String Vip_User_weixin_Redis_openId_key = "vip:user:weixin:{0}";
	public static String vip_user_weixin_redis_openid_key(String openid){
		return MessageFormat.format(Vip_User_weixin_Redis_openId_key, ObjectUtils.toString(openid, DEFAULT_PADDING));
	}
	
	/**
	 * 销售人员二维码生成记录id最大值
	 * Vip微信用户Redis
	 */
	private static String sale_qrcode_create_max_info_key = "qbt:sale:qrcode:create:max_info_key";
	public static String sale_qrcode_create_max_info_key(){
		return sale_qrcode_create_max_info_key;
	}
	
	/*private static String base_bank_branch_id = "base:bank:branch:{0}";
	public static String base_bank_branch_id_key(Integer id){
		return MessageFormat.format(base_bank_branch_id, ObjectUtils.toString(id, DEFAULT_PADDING));
	}*/
	
	private static String salesman_code_key = "qbt:sale:salesman:code:salesman_code_key";
	public static String salesman_code_key(){
		return salesman_code_key;
	}

	private static String base_news_id = "base:news:{0}";
	public static String base_news_id_key(Integer id){
		return MessageFormat.format(base_news_id, ObjectUtils.toString(id, DEFAULT_PADDING));
	}
	
	/**
	 * 最热门的球场key
	 */
	public static String base_course_hot = "qbt:base:course:hot";
	
	/**
	 * 用户订单球场地址
	 */
	private static String qbt_user_order_address_uuid = "qbt:user:order:address:{0}";
	public static String qbt_user_order_address_uuid_key(String uuid){
		return MessageFormat.format(qbt_user_order_address_uuid, ObjectUtils.toString(uuid, DEFAULT_PADDING));
	}
	
	/**
	 * 用户订历史联系人
	 */
	private static String qbt_user_order_contact_uuid = "qbt:user:order:contact:{0}";
	public static String qbt_user_order_contact_uuid_key(String uuid){
		return MessageFormat.format(qbt_user_order_contact_uuid, ObjectUtils.toString(uuid, DEFAULT_PADDING));
	}
	
	/**
	 * 特殊优惠券最大使用次数
	 */
	private static String coupon_code_activity_max = "qbt:coupon:code:activity:max:{0}";
	public static String coupon_code_activity_max_key(String couponCode){
		return MessageFormat.format(coupon_code_activity_max, ObjectUtils.toString(couponCode, DEFAULT_PADDING));
	}
	
	/**
	 * 特殊优惠券使用次数
	 */
	private static String coupon_code_activity_use = "qbt:coupon:code:activity:use:{0}";
	public static String coupon_code_activity_use_key(String couponCode){
		return MessageFormat.format(coupon_code_activity_use, ObjectUtils.toString(couponCode, DEFAULT_PADDING));
	}
	
	/**
	 * 新顺丰价格Key
	 */
	private static String NEW_SF_PRICE_KEY = "new:sf:price:area:{0}:{1}";
	public static String new_sf_price_key(String startArea,String endArea){
		String ecStartArea = Md5.MD5Encode(startArea);
		String ecEndArea = Md5.MD5Encode(endArea);
		return MessageFormat.format(NEW_SF_PRICE_KEY, ObjectUtils.toString(ecStartArea, DEFAULT_PADDING),ObjectUtils.toString(ecEndArea, DEFAULT_PADDING));
	}
	
	/**
	 * 中奖规则Key
	 */
	
	private static String REWARD_ACTITVITY_KEY = "reward:actitvity:{0}:{1}";
	public static String reward_actitvity_key(Integer type,Integer id){
		return MessageFormat.format(REWARD_ACTITVITY_KEY, ObjectUtils.toString(type, DEFAULT_PADDING),ObjectUtils.toString(id, DEFAULT_PADDING));
	}
	
	/**
	 * 邮件code
	 */
	private static String email_template_code = "email:template:{0}";
	public static String email_template_code_key(String code){
		return MessageFormat.format(email_template_code, ObjectUtils.toString(code, DEFAULT_PADDING));
	}
	
	/**
	 * 邮件配置code
	 */
	private static String email_config_code = "email:config:{0}";
	public static String email_config_code_key(String code){
		return MessageFormat.format(email_config_code, ObjectUtils.toString(code, DEFAULT_PADDING));
	}
	
	/**
	 * 系统配置code
	 */
	private static String sys_config_code = "sys:config:{0}";
	public static String sys_config_code_key(String code){
		return MessageFormat.format(sys_config_code, ObjectUtils.toString(code, DEFAULT_PADDING));
	}
}

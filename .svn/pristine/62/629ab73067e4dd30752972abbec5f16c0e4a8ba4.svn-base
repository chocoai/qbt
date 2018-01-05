package com.qbt.service;

public interface CommonService {

	public String createOrderId();

	public String createPaymentId();
	
	public String createTicketPackagePaymentId();

	public String createRefundId();
	
	public String createCouponCode();

	public long lock(String key, String value,int time);

	public String getLockValue(String key);

	public void unlock(String key);

	public String createBigOrderId();
	
	public String createVipOrderId();
	
	public String createVipNo();
	
	//生成销售人员号（前随机两个大写英文字母，后八个随机数字）
	public String createQrcodeCapital(Integer salesmanCodeMaxNumInt);

	//生成优惠码（6位大写字母与数字随机组合）
	public String createCouponCodeActivityCode();
	
	//生成渠道二维码识别码标识（前随机四个大写英文字母，后四个随机数字）
	public String createChannelQrcodeCode();
}

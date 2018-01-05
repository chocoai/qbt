package com.qbt.web.support;

import java.util.Map;

import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.web.pojo.pay.PayRequest;
import com.qbt.wechat.entity.ScanQrcodeRequest;
import com.qbt.wechat.entity.ScanQrcodeResponse;

public interface PaymentSupport {

	public Map<String,String> pay(PayRequest request);
	
	public OrderPayInfo noPay(PayRequest request);
	
	public OrderPayInfo findById(int id);
	
	public OrderPayInfo findByPayno(String payno);
	
	public int updateById(OrderPayInfo payInfo);
	
	public String officialPay(String orderNumber);
	
	public ScanQrcodeResponse scanPay(ScanQrcodeRequest request);

	public Map<String, String> pay(String orderId, String openid);

	public OrderPayInfo noPay(String orderId, String openid);
	
}

/**
 * Project Name:qbt-shansong
 * File Name:ShansongApiImpl.java
 * Package Name:com.qbt.shansong.service.impl
 * Date:2017年2月23日下午4:23:15
 *
*/

package com.qbt.shansong.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.HttpClientUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.Md5;
import com.qbt.shansong.entity.ShansongResponse;
import com.qbt.shansong.entity.orderaccount.OrderAccountRequest;
import com.qbt.shansong.entity.ordercalc.CalcOrderInfo;
import com.qbt.shansong.entity.ordercalc.OrderCalcMerchant;
import com.qbt.shansong.entity.ordercalc.OrderCalcRequest;
import com.qbt.shansong.entity.ordercalc.OrderCalcResult;
import com.qbt.shansong.entity.ordercancel.OrderCancelRequest;
import com.qbt.shansong.entity.ordercancel.OrderCancelResult;
import com.qbt.shansong.entity.orderinfo.OrderInfoRequest;
import com.qbt.shansong.entity.orderinfo.OrderInfoResult;
import com.qbt.shansong.entity.ordertrail.OrderTrailRequest;
import com.qbt.shansong.entity.ordertrail.OrderTrailResult;
import com.qbt.shansong.service.ShansongApi;

/**
 * ClassName:ShansongApiImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午4:23:15
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class ShansongApiImpl implements ShansongApi {
	
	@Value("${partner_no}")
	private String partnerNo;
	
	@Value("${merchant_id}")
	private String merchantId;
	
	@Value("${md5_key}")
	private String md5Key;
	
	@Value("${account_token}")
	private String accountToken;
	
	@Value("${merchant_mobile}")
	private String merchantMobile;
	
	@Value("${merchant_name}")
	private String merchantName;
	
	@Value("${shansong_calc_url}")
	private String shansongCalcUrl;
	
	@Value("${shangsong_order_save_url}")
	private String shangsongOrderSaveUrl;
	
	@Value("${shangsong_order_info_url}")
	private String shangsongOrderInfoUrl;
	
	@Value("${shangsong_trail_url}")
	private String shangsongTrailUrl;
	
	@Value("${shangsong_order_cancel_url}")
	private String shangsongOrderCancelUrl;
	
	@Value("${shangsong_sync_url}")
	private String shangsongSyncUrl;
	
	@Value("${shangsong_account_url}")
	private String shangsongAccountUrl;
	
	@Override
	public ShansongResponse<OrderCalcResult> orderCalc(OrderCalcRequest request) {
		request.setPartnerNo(partnerNo);
		CalcOrderInfo order = request.getOrder();
		OrderCalcMerchant merchant = new OrderCalcMerchant();
		merchant.setId(merchantId);
		merchant.setMobile(merchantMobile);
		merchant.setName(merchantName);
		merchant.setToken(accountToken);
		order.setMerchant(merchant);
		request.setSignature(calSignature(order.getOrderNo()));
		
		String responseStr = HttpClientUtil.httpPost(shansongCalcUrl, JSonUtil.toJSonString(request));
		LogCvt.info("计算费用返回数据: " + responseStr);
		
		ShansongResponse<OrderCalcResult> response = JSonUtil.toObject(responseStr, ShansongResponse.class);
		OrderCalcResult result = null;
		if("OK".equals(response.getStatus())){
			result = BeanUtil.a2b(response.getData(), OrderCalcResult.class);
			response.setData(result);
		}
		return response;
	}

	@Override
	public ShansongResponse<String> orderSave(OrderCalcRequest request) {
		request.setPartnerNo(partnerNo);
		CalcOrderInfo order = request.getOrder();
		OrderCalcMerchant merchant = new OrderCalcMerchant();
		merchant.setId(merchantId);
		merchant.setMobile(merchantMobile);
		merchant.setName(merchantName);
		merchant.setToken(accountToken);
		order.setMerchant(merchant);
		request.setSignature(calSignature(order.getOrderNo()));
		
		String responseStr = HttpClientUtil.httpPost(shangsongOrderSaveUrl, JSonUtil.toJSonString(request));
		LogCvt.info("下单返回数据: " + responseStr);
		
		ShansongResponse<String> response = JSonUtil.toObject(responseStr, ShansongResponse.class);
		String result = null;
		if("OK".equals(response.getStatus())){
			result = response.getData().toString();
			response.setData(result);
		}
		return response;
	}
	
	@Override
	public String calSignature(String orderNo){
		StringBuilder str = new StringBuilder();
		str.append(partnerNo).append(orderNo).append(merchantMobile).append(md5Key);
		String signature = Md5.MD5Encode(str.toString()).toUpperCase();
		return signature;
	}

	@Override
	public ShansongResponse<OrderInfoResult> queryOrderInfo(OrderInfoRequest request) {
		request.setPartnerNo(partnerNo);
		request.setSignature(calSignature(request.getOrderNo()));
		
		String reqUrl = shangsongOrderInfoUrl.replace("{partnerno}", request.getPartnerNo())
						.replace("{orderno}", request.getOrderNo())
						.replace("{mobile}", request.getMobile())
						.replace("{signature}", request.getSignature())
						.replace("{issorderno}", request.getIssOrderNo());
		String responseStr = HttpClientUtil.httpGet(reqUrl);
		LogCvt.info("查询订单返回数据: " + responseStr);
		
		ShansongResponse<OrderInfoResult> response = JSonUtil.toObject(responseStr, ShansongResponse.class);
		OrderInfoResult result = null;
		if("OK".equals(response.getStatus())){
			result = BeanUtil.a2b(response.getData(), OrderInfoResult.class);
			response.setData(result);
		}
		return response;
	}

	@Override
	public ShansongResponse<OrderTrailResult> orderTrail(OrderTrailRequest request) {
		request.setPartnerNo(partnerNo);
		request.setSignature(calSignature(request.getOrderNo()));
		
		String reqUrl = shangsongTrailUrl.replace("{partnerno}", request.getPartnerNo())
						.replace("{orderno}", request.getOrderNo())
						.replace("{mobile}", request.getMobile())
						.replace("{signature}", request.getSignature())
						.replace("{issorderno}", request.getIssOrderNo());
		String responseStr = HttpClientUtil.httpGet(reqUrl);
		LogCvt.info("查询闪送员轨迹返回数据: " + responseStr);
		
		ShansongResponse<OrderTrailResult> response = JSonUtil.toObject(responseStr, ShansongResponse.class);
		OrderTrailResult result = null;
		if("OK".equals(response.getStatus())){
			result = BeanUtil.a2b(response.getData(), OrderTrailResult.class);
			response.setData(result);
		}
		return response;
	}

	@Override
	public ShansongResponse<OrderCancelResult> orderCancel(OrderCancelRequest request) {
		request.setPartnerNo(partnerNo);
		request.setSignature(calSignature(request.getOrderNo()));
		
		String reqUrl = shangsongOrderCancelUrl.replace("{partnerno}", request.getPartnerNo())
						.replace("{orderno}", request.getOrderNo())
						.replace("{mobile}", request.getMobile())
						.replace("{signature}", request.getSignature())
						.replace("{issorderno}", request.getIssOrderNo());
		String responseStr = HttpClientUtil.httpGet(reqUrl);
		LogCvt.info("查询闪送员轨迹返回数据: " + responseStr);
		
		ShansongResponse<OrderCancelResult> response = JSonUtil.toObject(responseStr, ShansongResponse.class);
		OrderCancelResult result = null;
		if("OK".equals(response.getStatus())){
			result = BeanUtil.a2b(response.getData(), OrderCancelResult.class);
			response.setData(result);
		}
		return response;
	}

	@Override
	public ShansongResponse<Double> orderAccount(OrderAccountRequest request) {
		request.setPartnerNo(partnerNo);
		
		String reqUrl = shangsongAccountUrl.replace("{partnerno}", request.getPartnerNo())
						.replace("{mobile}", request.getMobile());
		String responseStr = HttpClientUtil.httpGet(reqUrl);
		LogCvt.info("查询账户余额返回数据: " + responseStr);
		
		ShansongResponse<Double> response = JSonUtil.toObject(responseStr, ShansongResponse.class);
		Double result = null;
		if("OK".equals(response.getStatus())){
			result = Double.valueOf(response.getData().toString());
			response.setData(result);
		}
		return response;
	}
	
}

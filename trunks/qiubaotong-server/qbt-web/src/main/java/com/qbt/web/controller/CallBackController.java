package com.qbt.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.PayStatus;
import com.qbt.common.enums.PaymentStatus;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.StringUtil;
import com.qbt.common.util.XmlUtils;
import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.persistent.entity.VipOrder;
import com.qbt.persistent.entity.VipPayment;
import com.qbt.sf.api.bean.RespErr;
import com.qbt.sf.api.bean.routepush.RoutePushReq;
import com.qbt.sf.api.bean.routepush.RoutePushReqDeliver;
import com.qbt.sf.api.bean.routepush.RoutePushResp;
import com.qbt.sf.api.util.JaxbUtil;
import com.qbt.web.support.OrderSupport;
import com.qbt.web.support.OrderV2Support;
import com.qbt.web.support.OrderWaybillSupport;
import com.qbt.web.support.PaymentSupport;
import com.qbt.web.support.VipOrderSupport;
import com.qbt.web.support.VipPyamentSupport;
import com.qbt.web.support.VipUserSupport;
import com.qbt.wechat.entity.ScanQrcodeRequest;
import com.qbt.wechat.entity.ScanQrcodeResponse;
import com.qbt.wechat.util.XmlUtil;

@Controller
@RequestMapping("/callbak")
public class CallBackController {

	@Resource
	private PaymentSupport paymentSupport;
	@Resource
	private OrderSupport orderSupport;
	@Resource
	private OrderV2Support orderV2Support;
	@Resource
	private OrderWaybillSupport orderWaybillSupport;
	@Resource
	private VipPyamentSupport vipPyamentSupport;
	@Resource
	private VipUserSupport vipUserSupport;
	@Resource
	private VipOrderSupport vipOrderSupport;
	
	/**
	 *  微信支付结果通知
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/wechatpay")
	public void weixinPayReturn(HttpServletRequest request,HttpServletResponse response){
		boolean falg = false;
		try{
			String postStr = this.readStreamParameter(request.getInputStream());
			if (null != postStr) {
				LogCvt.info("微信支付通知结果：" + postStr);
				HashMap reqData = (HashMap)XmlUtil.doXMLParse(postStr);
				String returnCode = reqData.get("return_code").toString();
				if("SUCCESS".equals(returnCode)){
					// 签值校验
//					boolean check = wechatApi.checkSign(reqData, reqData.get("sign").toString());
//					if(!check){
//						LogCvt.info("校验签名失败，检查是否非法通知");
//						return;
//					}
					// 更新支付流水
					OrderPayInfo payment = paymentSupport.findByPayno(reqData.get("out_trade_no").toString());
					if(payment == null){
						LogCvt.info("支付流水不存在，无法更新支付状态");
						return;
					}
					String transaction_id = reqData.get("transaction_id").toString();
					if(transaction_id.equals(payment.getPayBakNo())){
						LogCvt.info("微信重复通知支付成功，此调微信异步信息不与处理："+transaction_id);
						falg = true;
						return;
					}
					
					LogCvt.info("orderid:"+payment.getOrderId());
					payment.setPayBakNo(transaction_id);
					payment.setStatus(PaymentStatus.success.getCode());
					payment.setPayStatus(PayStatus.success.getCode());
					paymentSupport.updateById(payment);
					// 处理订单支付信息状态 
					LogCvt.info("支付订单ID:"+payment.getOrderId());
					orderSupport.paySuccess(payment);
					falg = true;
				}else{
					String returnMsg = reqData.get("return_msg").toString();
					LogCvt.error("微信支付通知支付失败,"+returnMsg);
					falg = true;
				}
				
			}
		}catch(Exception ex){
			LogCvt.error("接收微信处理通知异常...",ex);
			outputResponse(response,"<xml><return_code>FAIL</return_code><return_msg>FAIL</return_msg></xml>");//响 应处理成功
		}finally{
			if(falg){
				LogCvt.info("微支付通知处理成功");
				//响应处理结果 
				outputResponse(response,"<xml><return_code>SUCCESS</return_code><return_msg>OK</return_msg></xml>");//响 应处理成功	
			}else{
				LogCvt.info("微支付通知处理失败");
				outputResponse(response,"<xml><return_code>FAIL</return_code><return_msg>FAIL</return_msg></xml>");//响 应处理成功
			}
		}
	}
	
	
	/**
	 *  微信支付结果通知
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/v2/wechatpay")
	public void weixinPayReturnV2(HttpServletRequest request,HttpServletResponse response){
		boolean falg = false;
		try{
			String postStr = this.readStreamParameter(request.getInputStream());
			if (null != postStr) {
				LogCvt.info("微信支付通知结果：" + postStr);
				HashMap reqData = (HashMap)XmlUtil.doXMLParse(postStr);
				String returnCode = reqData.get("return_code").toString();
				if("SUCCESS".equals(returnCode)){
					// 签值校验
//					boolean check = wechatApi.checkSign(reqData, reqData.get("sign").toString());
//					if(!check){
//						LogCvt.info("校验签名失败，检查是否非法通知");
//						return;
//					}
					// 更新支付流水
					OrderPayInfo payment = paymentSupport.findByPayno(reqData.get("out_trade_no").toString());
					if(payment == null){
						LogCvt.info("支付流水不存在，无法更新支付状态");
						return;
					}
					String transaction_id = reqData.get("transaction_id").toString();
					if(transaction_id.equals(payment.getPayBakNo())){
						LogCvt.info("微信重复通知支付成功，此调微信异步信息不与处理："+transaction_id);
						falg = true;
						return;
					}
					
					LogCvt.info("orderid:"+payment.getOrderId());
					payment.setPayBakNo(transaction_id);
					payment.setStatus(PaymentStatus.success.getCode());
					payment.setPayStatus(PayStatus.success.getCode());
					paymentSupport.updateById(payment);
					// 处理订单支付信息状态 
					LogCvt.info("支付订单ID:"+payment.getOrderId());
					orderV2Support.paySuccess(payment);
					falg = true;
				}else{
					String returnMsg = reqData.get("return_msg").toString();
					LogCvt.error("微信支付通知支付失败,"+returnMsg);
					falg = true;
				}
				
			}
		}catch(Exception ex){
			LogCvt.error("接收微信处理通知异常...",ex);
			outputResponse(response,"<xml><return_code>FAIL</return_code><return_msg>FAIL</return_msg></xml>");//响 应处理成功
		}finally{
			if(falg){
				LogCvt.info("微支付通知处理成功");
				//响应处理结果 
				outputResponse(response,"<xml><return_code>SUCCESS</return_code><return_msg>OK</return_msg></xml>");//响 应处理成功	
			}else{
				LogCvt.info("微支付通知处理失败");
				outputResponse(response,"<xml><return_code>FAIL</return_code><return_msg>FAIL</return_msg></xml>");//响 应处理成功
			}
		}
	}
	
	/**
	 *  微信购买会员支付结构通知
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/wechatVipPay")
	public void weixinVipPayReturn(HttpServletRequest request,HttpServletResponse response){
		boolean falg = false;
		try{
			String postStr = this.readStreamParameter(request.getInputStream());
			if (null != postStr) {
				LogCvt.info("微信支付通知结果：" + postStr);
				HashMap<?,?> reqData = (HashMap<?,?>)XmlUtil.doXMLParse(postStr);
				String returnCode = reqData.get("return_code").toString();
				if("SUCCESS".equals(returnCode)){

					//根据uuid获取原预支付信息流水
					VipPayment vipPayment = vipPyamentSupport.findByUuid(reqData.get("out_trade_no").toString());
					if(vipPayment == null){
						LogCvt.info("支付流水不存在，无法更新支付状态");
						return;
					}
					String transaction_id = reqData.get("transaction_id").toString();
					if(transaction_id.equals(vipPayment.getPayBakNo())){
						LogCvt.info("微信重复通知支付成功，此调微信异步信息不与处理："+transaction_id);
						falg = true;
						return;
					}
					
					//添加VIP用户信息
					VipInfo vipInfo =  vipUserSupport.addVipInfo(vipPayment);
					
					//添加成功订单 vip_order
					
					vipPayment.setPayBakNo(transaction_id);
					
					VipOrder vipOrder = vipOrderSupport.createVipOrder(vipPayment, vipInfo);
					if(vipOrder==null){
						LogCvt.info("微信购买vip订单流水不存在：支付流水号 = "+transaction_id);
						falg = true;
						return;
					}
					
					//修改预支付订单状态
					vipPayment.setPayBakNo(transaction_id);
					vipPayment.setUpdateTime(new Date());
					vipPayment.setOrderId(vipOrder.getId());
					vipPayment.setStatus(PaymentStatus.success.getCode());
					vipPayment.setPayStatus(PayStatus.success.getCode());
					//更新预支付订单信息，并推送微信通知
					vipPyamentSupport.updateVipPayment(vipPayment,vipInfo);
					
					falg = true;
				}else{
					String returnMsg = reqData.get("return_msg").toString();
					LogCvt.error("微信支付通知支付失败,"+returnMsg);
					falg = true;
				}
				
			}
		}catch(Exception ex){
			LogCvt.error("接收微信处理通知异常...",ex);
			outputResponse(response,"<xml><return_code>FAIL</return_code><return_msg>FAIL</return_msg></xml>");//响 应处理成功
		}finally{
			if(falg){
				LogCvt.info("微支付通知处理成功");
				//响应处理结果 
				outputResponse(response,"<xml><return_code>SUCCESS</return_code><return_msg>OK</return_msg></xml>");//响 应处理成功	
			}else{
				LogCvt.info("微支付通知处理失败");
				outputResponse(response,"<xml><return_code>FAIL</return_code><return_msg>FAIL</return_msg></xml>");//响 应处理成功
			}
		}
	}
	
	/**
	 *  顺丰物流推送
	  * @Title: push
	  * @Description: TODO
	  * @author: share 2016年8月17日
	  * @modify: share 2016年8月17日
	  * @param request
	  * @param response
	 */
	@RequestMapping("/route/push")
	public void push(HttpServletRequest request,HttpServletResponse response){
		boolean falg = true;
		try {
			String postStr = this.readStreamParameter(request.getInputStream());
			if(null == postStr) {
				return;
			}
			// content=xx
			postStr = StringUtil.urldecode(postStr).substring(8);
			LogCvt.info("顺丰快递推送："+postStr);
			if(postStr.indexOf("wmsReverseOrderStatusPushRequest")> -1){
				LogCvt.info("不处理的顺丰快递推送<wmsReverseOrderStatusPushRequest>");
			}else{
				RoutePushReq routePushReq = JaxbUtil.converyToJavaBean(postStr, RoutePushReq.class);
				for(RoutePushReqDeliver deliver :routePushReq.getDeliverRoute()){
					orderWaybillSupport.insert(deliver);
				}
			}
			
		}catch(Exception ex){
			LogCvt.error("接收顺丰路由处理通知异常...",ex);
			RoutePushResp resp = new RoutePushResp();
			RespErr error = new RespErr();
			error.setCode("100001");
			error.setValue("系统异常，处理失败");
			resp.setError(error);
			outputResponse(response,JaxbUtil.convertToXml(resp));
		}finally{
			if(falg){
				LogCvt.info("接收顺丰路由处理通知成功");
				//响应处理结果 
				RoutePushResp resp = new RoutePushResp();
				outputResponse(response,JaxbUtil.convertToXml(resp));	
			}else{
				LogCvt.info("接收顺丰路由处理通知失败");
				RoutePushResp resp = new RoutePushResp();
				RespErr error = new RespErr();
				error.setCode("100001");
				error.setValue("系统异常，处理失败");
				resp.setError(error);
				outputResponse(response,JaxbUtil.convertToXml(resp));
			}
		}
	}
	
	/**
	 *  扫码支付异步回调
	  * @Title: qrcodePay
	  * @Description: TODO
	  * @author: share 2017年2月21日
	  * @modify: share 2017年2月21日
	  * @param request
	  * @param response
	 */
	@RequestMapping("/qrcodePay")
	public void qrcodePay(HttpServletRequest request,HttpServletResponse response){
		boolean flag = false;
		ScanQrcodeResponse scanResponse = new ScanQrcodeResponse();
		try {
			String postStr = this.readStreamParameter(request.getInputStream());
			if (null == postStr) {
				return;
			}
			ScanQrcodeRequest scanRequest = XmlUtils.xmlToObj(postStr,ScanQrcodeRequest.class);
			scanResponse = paymentSupport.scanPay(scanRequest);
			flag = true;
		} catch (WechatException e) {
			LogCvt.error(e.getMessage(), e);
			scanResponse.setReturn_msg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			scanResponse.setReturn_msg("处理异常");
		} finally {
			if(!flag){
				scanResponse.setReturn_code("FAIL");
				scanResponse.setResult_code("FAIL");
			}
			LogCvt.info("二维码支付通知处理成功");
			//响应处理结果 
			outputResponse(response, XmlUtils.objToXml(scanResponse, new Class[]{ScanQrcodeResponse.class}));//响 应处理成功	
		}
	}
	

	// 从输入流读取post参数
	private String readStreamParameter(ServletInputStream in) {
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			reader = null;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					LogCvt.error(e.getMessage(), e);
				}
			}
		}
		return buffer.toString();
	}
	// 向请求端发送返回数据

	private void outputResponse(HttpServletResponse response,String data) {
		ServletOutputStream outStream = null;
		try {
			outStream = response.getOutputStream();
			outStream.write(data.getBytes("UTF-8"));
			outStream.flush();
			LogCvt.info("响应数据：" + data);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			if(null != outStream) {
				try {
					outStream.close();
					outStream=null;
				} catch (IOException e) {
					LogCvt.error(e.getMessage(), e);
				}
			}
		}
	}
	
	
}

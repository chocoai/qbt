package com.qbt.wechat.api;

import java.util.HashMap;
import java.util.Map;

import com.qbt.common.enums.UnifiedOrderTradeType;
import com.qbt.wechat.entity.Template;
import com.qbt.wechat.entity.UnifiedOrderRequest;
import com.qbt.wechat.entity.UnifiedOrderResponse;
import com.qbt.wechat.entity.WeChat;
import com.qbt.wechat.entity.WeixinUserInfo;

public interface WechatApi {

	public boolean checkSignature(WeChat weChat);
	
	public String getOauthUrl(String uri);
	
	public Map<String,String> getOpenId(String code);
	
	public WeixinUserInfo getUserInfo(String accessToken,String openid);
	
	public WeixinUserInfo queryUserInfo(String accessToken,String openid);
	
	public UnifiedOrderResponse unifiedOrder(UnifiedOrderRequest request, UnifiedOrderTradeType tradeType);
	
	public boolean checkSign(HashMap<String,String> map,String sign);
	
	public String getJsapiTicket(String accessToken);
	
	public String getAccessToken();
	
	public Map<String, String> jsSdkSignConf(String jsapi_ticket, String url);
	
	public Map<String, String> sendTemplate(Template template,String accessToken,String type);
	
	public String getTicket(String accessToken, String sceneStr);
	
	public String getAuthUrl(Map<String,String> replaceMap);
	
	/**
	 * 获取临时二维码url
	 * @param accessToken
	 * @param sceneId:场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @param expireSeconds:该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	 * @return
	 */
	public String getTemporaryQRCodeUrl(String accessToken, String sceneId, Integer expireSeconds);
	
	public String getBizPayUrl(String productId);
	
	public String sign(HashMap<String,String> signMap);
	
}

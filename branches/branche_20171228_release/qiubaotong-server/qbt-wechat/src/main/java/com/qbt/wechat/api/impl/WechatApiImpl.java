package com.qbt.wechat.api.impl;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qbt.common.enums.UnifiedOrderTradeType;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Arith;
import com.qbt.common.util.HttpClientUtil;
import com.qbt.common.util.HttpsClient;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.SHA1Util;
import com.qbt.common.util.StringUtil;
import com.qbt.wechat.api.WechatApi;
import com.qbt.wechat.entity.Template;
import com.qbt.wechat.entity.UnifiedOrderRequest;
import com.qbt.wechat.entity.UnifiedOrderResponse;
import com.qbt.wechat.entity.WeChat;
import com.qbt.wechat.entity.WeixinUserInfo;
import com.qbt.wechat.util.CommonUtil;
import com.qbt.wechat.util.XmlUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

@Service
public class WechatApiImpl implements WechatApi {

	// 获取授权码url
	@Value("${token}")
	public String token;
	// 获取授权码url
	@Value("${acess_token_url}")
	public String acess_token_url;
	// 获取jsapticket url
	@Value("${jsap_ticket_url}")
	public String jsap_ticket_url;
	@Value("${oauth_uri}")
	public String oauth_uri;
	@Value("${access_token_uri}")
	public String access_token_uri;
	@Value("${unified_order_uri}")
	public String unified_order_uri;
	@Value("${userinfo_uri}")
	public String userinfo_uri;
	@Value("${user_info_get_uri}")
	public String user_info_get_uri;
	@Value("${template_url}")
	public String template_url;
	@Value("${request_uri}")
	public String request_uri;
	@Value("${qrcode_image_url}")
	private String qrcode_image_url;
	@Value("${wechat_request_url}")
	private String wechat_request_url;
	@Value("${biz_pay_url}")
	private String biz_pay_url;
	
	@Value("${domain}")
    public String domain;
	@Value("${appid}")
    public String appid;
    @Value("${secret}")
    public String secret;
    @Value("${mch_id}")
    public String mchId;
    @Value("${notify_url}")
    public String notify_url;
    @Value("${appKey}")
    public String appKey;
    
    @Value("${new_order_tip}")
    public String order_tip_template_id;
    @Value("${order_cancel}")
    public String order_cancel_template_id;
    @Value("${order_cancel_kf}")
    public String order_cancel_kf_template_id;
    @Value("${warn}")
    public String warn_template_id;
    @Value("${coupon_tip}")
    private String coupon_tip_template_id;
    @Value("${assistant_apply}")
	private String assistant_apply_template_id;
    @Value("${order_flow}")
    private String order_flow_template_id;
    @Value("${wait_pay_tip}")
    private String wait_pay_tip_template_id;
    @Value("${vip_success_pay}")
    private String vip_success_pay;
    @Value("${proxy_shopping_cart_tip}")
    private String proxy_shopping_cart_template_id;
    @Value("${scan_subcripe_weixin_tip}")
    private String scan_weixin_tip;
    
    
	@Override
	public String getOauthUrl(String uri) {
		try {
			
			String oauthUri = oauth_uri.replace("{appid}", appid).replace("{uri}", uri);
			
			return oauthUri;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Map<String,String> getOpenId(String code) {
		try {
			String accessTokenUri = access_token_uri.replace("{appid}", appid).replace("{code}", code).replace("{secret}", secret);
			String body = HttpsClient.httpsPost(accessTokenUri);
			return JSonUtil.toObject(body, HashMap.class);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
		return null;
	}
	
	@Override
	public UnifiedOrderResponse unifiedOrder(UnifiedOrderRequest request, UnifiedOrderTradeType tradeType) {
		try {
			XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
			request.setAppid(appid);
			request.setMchId(mchId);
//			request.setNotifyUrl(notify_url);
			request.setTradeType(tradeType.getCode());
			request.setNonceStr(CommonUtil.CreateNoncestr());
			
			//调用统一支付进行预支付
			HashMap<String, String> map=new HashMap<String, String>();
			map.put("appid", appid);
			map.put("mch_id", mchId);
			map.put("nonce_str", request.getNonceStr());
			map.put("body", request.getBody());
			map.put("out_trade_no", request.getOutTradeNo());
			map.put("total_fee", ((int)(Arith.mul(Double.parseDouble(request.getTotalFee()), 100)))+"");
			map.put("spbill_create_ip", request.getSpbillCreateIp());
			map.put("time_start", request.getTimeStart());
			map.put("time_expire", request.getTimeExpire());
			map.put("notify_url", request.getNotifyUrl());
			map.put("trade_type", tradeType.getCode());
			map.put("openid", request.getOpenid());
			if(request.getProductId() != null){
				map.put("product_id", request.getProductId());
			}
			
			request.setSign(CommonUtil.GetMD5Sign(map, appKey));
			map.put("sign", request.getSign());
			xStream.processAnnotations(new Class[]{UnifiedOrderRequest.class});
			String xml = XmlUtil.HashMap2Xml("xml", map);
			LogCvt.info("微信预支付xml:"+xml);
			xml = StringUtil.convertCharset(xml, "UTF-8", "ISO-8859-1");
			String body = HttpsClient.httpsPost(unified_order_uri,xml);
			LogCvt.info("微信预支付body:"+body);
			xStream.processAnnotations(new Class[]{UnifiedOrderResponse.class});
			UnifiedOrderResponse resp = (UnifiedOrderResponse)xStream.fromXML(body);
			
			//生成支付请求
			map=new HashMap<String, String>();
			map.put("appId", appid);
			map.put("timeStamp", Long.toString(new Date().getTime()/1000));
			map.put("nonceStr", CommonUtil.CreateNoncestr());
			map.put("package", "prepay_id="+resp.getPrepay_id());
			map.put("signType", "MD5");
			map.put("paySign", CommonUtil.GetMD5Sign(map, appKey));
			resp.setPaypackage(map);
			return resp;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		return null;
	}

	@Override
	public boolean checkSign(HashMap<String, String> map,String sign) {
		String signStr = CommonUtil.GetMD5Sign(map, appKey);
		LogCvt.info("签名校验："+sign);
		if(signStr.equals(sign)){
			return true;
		}
		return false;
	}

	@Override
	public WeixinUserInfo getUserInfo(String accessToken, String openid) {
		String url = userinfo_uri.replace("{ACCESS_TOKEN}", accessToken).replace("{OPENID}", openid);
		String body = HttpsClient.httpsPost(url);
		return JSonUtil.toObject(body, WeixinUserInfo.class);
	}

	//永久
	@Override
	public String getTicket(String accessToken,String sceneStr) {
		String url = request_uri.replace("TOKEN", accessToken);
		String data = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\":{\"scene\": {\"scene_str\":\""+sceneStr+"\"}}}";;
		String body = HttpsClient.httpsPost(url,data);
		return (String) JSonUtil.toObject(body, Map.class).get("ticket");
	}
	
	@Override
	public String getTemporaryQRCodeUrl(String accessToken, String sceneId, Integer expireSeconds) {
		String temporaryQRCodeUrl = null;
		String url = request_uri.replace("TOKEN", accessToken);
		//临时二维码
		//String data = "{\"expire_seconds\":" + expireSeconds +", \"action_name\":\"QR_SCENE\", \"action_info\":{\"scene\": {\"scene_id\":"+sceneId+"}}}";;
		Map<String, Object> dataMap = new HashMap<String, Object>(); 
		dataMap.put("expire_seconds", expireSeconds);
		dataMap.put("action_name", "QR_SCENE");
		Map<String, String> sceneIdMap = new HashMap<String, String>();
		sceneIdMap.put("scene_id", sceneId);
		Map<String, Object> sceneMap = new HashMap<String, Object>();
		sceneMap.put("scene", sceneIdMap);
		Map<String, Object> actionInfoMap = new HashMap<String, Object>();
		actionInfoMap.put("action_info", sceneMap);
		dataMap.put("action_info", actionInfoMap);
		String data = JSonUtil.toJSonString(dataMap);
		String body = HttpsClient.httpsPost(url,data);
		String ticket = (String) JSonUtil.toObject(body, Map.class).get("ticket");
		temporaryQRCodeUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + ticket ;
		return temporaryQRCodeUrl;
	}
	
	
	@Override
	public WeixinUserInfo queryUserInfo(String accessToken, String openid) {
		String url = user_info_get_uri.replace("{ACCESS_TOKEN}", accessToken).replace("{OPENID}", openid);
		String body = HttpsClient.httpsGet(url);
		return JSonUtil.toObject(body, WeixinUserInfo.class);
	}
	
	/**
	 * 获取凭证授权令牌
	 * 
	 * @Title: getAccessToken
	 * @author: froad-zjz 2013-9-14
	 * @modify: froad-zjz 2013-9-14
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String getAccessToken(){
		String message = null;
		try{
			
			String url = acess_token_url.replace("{APPID}", appid);
			url = url.replace("{APPSECRET}", secret);
			LogCvt.info("获取Access_token请求url：" + url);

			String resp = HttpsClient.httpsPost(url);
			LogCvt.info("获取AccessToken:"+resp);
			Map<String,Object> respMap = JSonUtil.toObject(resp, HashMap.class);

			if (respMap.containsKey("errcode")){
				LogCvt.error("获取accessToken失败[错误码：" + respMap.get("errcode") + " 描述："+ respMap.get("errmsg") + "]");
				return null;
			}
			return respMap.get("access_token").toString();
		}catch (Exception ex){
			LogCvt.error("获取微信公共平台凭证失败",ex);
		}
		return message;
	}
	
	/**
	 *  获取jsapiTicket
	 * @return
	 */
	public String getJsapiTicket(String accessToken){
		String message = null;
		try{
			
			String getUrl = jsap_ticket_url.replace("{ACCESS_TOKEN}", accessToken);
			Map responseMap = JSonUtil.toObject(HttpsClient.httpsPost(getUrl), HashMap.class);

			if (responseMap != null && !responseMap.isEmpty()){
				message = String.valueOf(responseMap.get("ticket"));
			}
		} catch (Exception ex){
			LogCvt.error("获取微信公共平台凭证失败",ex);
		}
		return message;
	}
	
	

    public Map<String, String> jsSdkSignConf(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;
        LogCvt.info("jsConfig:"+string1);

        try{
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (Exception e){
            LogCvt.error(e.getMessage(),e);
        }

        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
    
    /**
     *  短信通知模板
      * @Title: sendTemplate
      * @Description: TODO
      * @author: share 2016年8月15日
      * @modify: share 2016年8月15日
      * @param template
      * @return
      * @see com.qbt.wechat.api.WechatApi#sendTemplate(com.qbt.wechat.entity.Template)
     */
	@Override
	public Map<String, String> sendTemplate(Template template,String accessToken,String type) {
		try {
			if("order".equalsIgnoreCase(type)){
				template.setTemplate_id(order_tip_template_id);
			}else if("orderCancel".equalsIgnoreCase(type)){
				template.setTemplate_id(order_cancel_template_id);
			}else if("orderCancelKf".equalsIgnoreCase(type)){
				template.setTemplate_id(order_cancel_kf_template_id);
			}else if("warn".equalsIgnoreCase(type)){
				template.setTemplate_id(warn_template_id);
			}else if("coupon".equalsIgnoreCase(type)){
				template.setTemplate_id(coupon_tip_template_id);
			}else if("assistantApply".equalsIgnoreCase(type)){
				template.setTemplate_id(assistant_apply_template_id);
			}else if("orderFlow".equalsIgnoreCase(type)){
				template.setTemplate_id(order_flow_template_id);
			}else if("waitPayTip".equalsIgnoreCase(type)){
				template.setTemplate_id(wait_pay_tip_template_id);
			}else if("vipPay".equalsIgnoreCase(type)){
				template.setTemplate_id(vip_success_pay);
			}else if("proxyAddShoppingCart".equals(type)){
				template.setTemplate_id(proxy_shopping_cart_template_id);
			}else if("scan_weixin".equals(type)){
				template.setTemplate_id(scan_weixin_tip);
			}
			
//			String templateUrl = template_url.replace("{ACCESS_TOKEN}", accessToken);
			String json = JSonUtil.toJSonString(template);
			LogCvt.info("["+type+"]微信通知模板："+json);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "WECHAT");
			jsonObj.put("wechatData", JSonUtil.toObject(json, JSONObject.class));
			jsonObj.put("sysId", "qbt");
//			String body = HttpsClient.httpsPost(templateUrl,StringUtil.convertCharset(json, "UTF-8", "ISO-8859-1"));
			String body = HttpClientUtil.httpPost(wechat_request_url, jsonObj.toJSONString());
			LogCvt.debug("response body:"+body);
			return JSonUtil.toObject(body, Map.class);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public boolean checkSignature(WeChat weChat) {
		try {
			String signature = weChat.getSignature(); // 微信加密签名  
	        String timestamp = weChat.getTimestamp(); // 时间戳  
	        String nonce = weChat.getNonce();// 随机数  
	        
	      //1、排序
	        String [] arr = new String[]{token,timestamp,nonce};
	        Arrays.sort(arr);
	        //2、生成新的字符串
	        StringBuffer content = new StringBuffer();
	        for(int i=0;i<arr.length;i++){
	            content.append(arr[i]);
	        }
	        //3、shal加密
	        String temp = SHA1Util.SHA1(content.toString());
	        return temp.equals(signature);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		return false;
        
	}

	@Override
	public String getAuthUrl(Map<String, String> replaceMap) {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={appid}&redirect_uri=http%3A%2F%2F{domain}%2Fview%2F{html}%3Fuid%3D{uid}&response_type=code&scope=snsapi_userinfo&state=0#wechat_redirect";
		for(String key : replaceMap.keySet()){
			url = url.replace("{"+key+"}", replaceMap.get(key));
		}
		url = url.replace("{appid}", appid).replace("{domain}", domain);
		return url;
	}

	@Override
	public String getBizPayUrl(String productId) {
		String payUrl = null;
		try {
			long timeStamp = System.currentTimeMillis() / 1000;
			String nonceStr = CommonUtil.CreateNoncestr();
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("appid", appid);
			map.put("mch_id", mchId);
			map.put("product_id", productId);
			map.put("time_stamp", String.valueOf(timeStamp));
			map.put("nonce_str", nonceStr);
			String sign = CommonUtil.GetMD5Sign(map, appKey);
			
			payUrl = biz_pay_url.replace("{SIGN}", sign).replace("{APPID}", appid).replace("{MCHID}", mchId).replace("{PRODUCTID}", productId).replace("{TIMESTAMP}", String.valueOf(timeStamp)).replace("{NONCESTR}", nonceStr);
			LogCvt.info("生成支付二维码链接: " + payUrl);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		return payUrl;
	}

	@Override
	public String sign(HashMap<String, String> signMap) {
		return CommonUtil.GetMD5Sign(signMap, appKey);
	}

}

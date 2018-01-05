package com.geling.msg.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.geling.msg.entity.RequestType;
import com.geling.msg.entity.email.EmailNotifyRequestEntity;
import com.geling.msg.util.JSonUtil;

public class ServiceTest {
	
	public static void main(String[] args) {
		HttpClient httpClient = null;
		PostMethod postMethod = null;
		String requestUrl = null;
		EmailNotifyRequestEntity emailRequest = null;
		Map<String, String> data = null;
		String requestBody = null;
		ByteArrayRequestEntity requestEntity = null;
		String responseBody = null;

		try {
			requestUrl = "http://127.0.0.1:8080/message-service/email";//开发环境
			
//			// sms
//			smsRequest = new SMSNotifyRequestEntity();
//			smsRequest.setBizCode("1031");
//			smsRequest.setBizId("100001229");
//			data = new HashMap<String, String>();
//			data.put("value", "尊敬的用户，您现在进行注册操作，短信验证码为405300。【方付通】");
//			smsRequest.setData(data);
//			smsRequest.setMerchantCode(802);
//			mobiles = new ArrayList<String>();
//			mobiles.add("13416344823");
//			smsRequest.setMobiles(mobiles);
//			smsRequest.setSmsType(SMSType.REGISTRATION);
//			smsRequest.setTemplateId(0);
			
			// email
			emailRequest = new EmailNotifyRequestEntity();
			emailRequest.setTemplateId(0);
			emailRequest.setSubject("人工处理申诉");
			StringBuilder strb = new StringBuilder();
			strb.append("<div style=\" width: 100%; background: #fff;font: 16px/1.5 Tahoma, 'Microsoft Yahei', 'Simsun'; color: #000;\">");
			strb.append("<div style=\" margin: 0 auto; padding: 0 10px;\">");
			strb.append("<h4>尊敬的会员：</h4><p style=\"text-indent:50px;\">您好！请<a style=\"color:#0033ff;\" href=\"");
			strb.append("http://www.qiubaotong.com");
			strb.append("\">点此链接</a>提交您的相关信息，感谢您的关注与支持! 如果您点击上述链接无效，请把下面的链接复制到浏览器的地址栏中： </p><p><em>");
			strb.append("http://www.qiubaotong.com");
			strb.append("</em></p><p>此信由系统发出，系统不接受回信，因此请勿直接回复。</p></div><div style=\" margin: 0 auto; padding: 0 10px;\">");
			strb.append("<h4>安全使用您的“账户”</h4><p style=\" text-indent: 50px;\">请不要将您的密码使用在其他网站上。</p>");
			strb.append("</div></div>");
			data = new HashMap<String, String>();
			data.put("value", strb.toString());
			emailRequest.setUuid("71c434d50c514e3e8632b0789be8f0b8");
			emailRequest.setData(data);
			emailRequest.setBizCode("1301");
			List<String> recAddress = new ArrayList<String>(); 
			recAddress.add("huangyihao@qiubaotong.com");
			emailRequest.setRecAddress(recAddress);
			List<String> ccAddress = new ArrayList<String>(); 
			emailRequest.setCcAddress(ccAddress);
			emailRequest.setType(RequestType.EMAIL);
			emailRequest.setFromUserName("球包通");
			emailRequest.setBizId("test");
			emailRequest.setPlatform("qbt");
			
			requestBody = JSonUtil.toJSonString(emailRequest);
			System.out.println("Request Body: " + requestBody);
			requestEntity = new ByteArrayRequestEntity(requestBody.getBytes("utf-8"));
			
			postMethod = new PostMethod(requestUrl);
			postMethod.setRequestEntity(requestEntity);
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
			
			httpClient = new HttpClient();
			httpClient.executeMethod(postMethod);
			
			responseBody = postMethod.getResponseBodyAsString();
			
			System.out.println("Response body: " +  responseBody);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

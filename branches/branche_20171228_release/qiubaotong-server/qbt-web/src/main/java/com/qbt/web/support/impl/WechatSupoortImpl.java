package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RandomProvider;
import com.qbt.persistent.entity.BaseWeixinReply;
import com.qbt.persistent.entity.ChannelQrcodeInfo;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.SaleWeixinSubcripbeInfo;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.entity.WeixinReplyArticle;
import com.qbt.service.BaseWeixinReplyService;
import com.qbt.service.ChannelQrcodeInfoService;
import com.qbt.service.SaleUserService;
import com.qbt.service.SaleWeixinSubcripbeInfoService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.pojo.userProxy.UserProxyVo;
import com.qbt.web.support.UserProxySupport;
import com.qbt.web.support.WechatSupoort;
import com.qbt.wechat.api.WechatApi;
import com.qbt.wechat.entity.Article;
import com.qbt.wechat.entity.BaseMessage;
import com.qbt.wechat.entity.NewsMessage;
import com.qbt.wechat.entity.TextMessage;
import com.qbt.wechat.entity.WeixinUserInfo;
import com.qbt.wechat.util.InputMessage;
import com.qbt.wechat.util.MessageUtil;
import com.qbt.wechat.util.OutputMessage;
import com.qbt.wechat.util.SerializeXmlUtil;
import com.thoughtworks.xstream.XStream;

@Service
public class WechatSupoortImpl implements WechatSupoort {
	
	@Resource
	private UserWeixinService userWeixinService;
	@Resource
	private WechatApi wechatApi;
	@Resource
	private WechatCommonSupport commonSupport;
	@Resource
	private BaseWeixinReplyService baseWeixinReplyService;
	@Resource
	private SaleUserService saleUserService;
	@Resource
	private SaleWeixinSubcripbeInfoService saleWeixinSubcripbeInfoService;
	@Value("${file_domain}")
	private String domain;
	@Resource
	private ChannelQrcodeInfoService channelQrcodeInfoService;
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	@Resource
	private UserProxySupport userProxySupport;
	
	
	@Override
	public String processRequest(String xml) {
		// 将POST流转换为XStream对象  
        XStream xs = SerializeXmlUtil.createXstream();
        xs.ignoreUnknownElements();
        xs.processAnnotations(InputMessage.class);  
        xs.processAnnotations(OutputMessage.class);  
        // 将指定节点下的xml节点数据映射为对象  
        xs.alias("xml", InputMessage.class);
        // 将xml内容转换为InputMessage对象  
        InputMessage inputMsg = (InputMessage) xs.fromXML(xml.toString());
        String fromUserName = inputMsg.getFromUserName();// 客户端  
        // 取得消息类型  
        String msgType = inputMsg.getMsgType(); 
        // 根据消息类型获取对应的消息内容  
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT.toString())) {
        	if("二维码".equals(inputMsg.getContent())){
        		return returnQrcodeMessage(inputMsg);
        	}else{
        		return returnMessage(inputMsg);
        	}
        }else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT.toString())) {
        	String openid = fromUserName;
        	if(MessageUtil.EVENT_TYPE_SUBSCRIBE.equals(inputMsg.getEvent())){
        		String etKey = inputMsg.getEventKey();
            	// 通过销售员编号查找销售员人员信息
            	SaleUser saleUser = null;
            	String channelQrcodeCode = null;
            	if(Checker.isNotEmpty(etKey) && etKey.contains("qrscene_")){
            		etKey = etKey.split("qrscene_")[1];
            		if(etKey.length()==10){
            			LogCvt.info("销售员二维码:"+etKey);
                		saleUser = saleUserService.findByCode(etKey);
            		}else if(etKey.length()==8){
            			LogCvt.info("渠道二维码:"+etKey);
            			channelQrcodeCode = etKey;
            			ChannelQrcodeInfo channelQrcodeInfo = channelQrcodeInfoService.findByChannelQrcodeCode(channelQrcodeCode);
            			if(channelQrcodeInfo==null){
            				channelQrcodeCode= "";
            			}else if(channelQrcodeInfo.getStatus() == 2){
            				channelQrcodeCode= "";
            			}
            		}
            	}
            	//保存用户信息
            	UserWeixin user = saveWeixinUser(openid, saleUser, channelQrcodeCode);
            	// 若是代理关注扫描，微信通知
            	if(Checker.isNotEmpty(saleUser)){
            		//销售
            		UserWeixin proxyUser = userWeixinService.findById(saleUser.getUserId());
            		Map<String,String> replaceMap = new HashMap<String,String>();
            		replaceMap.put("html", "agent_v3.html");
            		replaceMap.put("uid", StringUtils.leftPad(String.valueOf(user.getId()), 6, '0'));
            		String url = wechatApi.getAuthUrl(replaceMap);
            		wechatMessageSupport.scanQrcodeNotify(proxyUser, user, url);
            		//保存该销售的客户信息
            		UserProxyVo vo = BeanUtil.a2b(user, UserProxyVo.class);
            		vo.setUserId(user.getId());
            		vo.setProxyUserId(saleUser.getUserId());
            		vo.setOrderDayValue(saleUser.getOrderDayValue());
            		userProxySupport.save(proxyUser, vo);
            		
            	}
            	// 回复关注消息
            	String content = "关注";
            	inputMsg.setContent(content);
            	return returnMessage(inputMsg);
        	}else if(MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals(inputMsg.getEvent())){
        		// 保存用户取消关注信息
            	unsubscribe(openid);
        	}else if(MessageUtil.EVENT_SCAN.equals(inputMsg.getEvent())){
        		// 若是代理关注扫描，微信通知
        		String salesmanCode = inputMsg.getEventKey();
            	// 通过销售员编号查找销售员人员信息
            	SaleUser saleUser = null;
            	if(Checker.isNotEmpty(salesmanCode)){
            		UserWeixin user = userWeixinService.findByOpenId(openid);
            		LogCvt.info("销售员二维码:"+salesmanCode);
        			saleUser = saleUserService.findByCode(salesmanCode);
        			if(saleUser == null)return "";
        			UserWeixin proxyUser = userWeixinService.findById(saleUser.getUserId());
    				Map<String,String> replaceMap = new HashMap<String,String>();
    				//replaceMap.put("html", "agent.html");//原代下单页面
    				replaceMap.put("html", "agent_v3.html");
    				replaceMap.put("uid", StringUtils.leftPad(String.valueOf(user.getId()), 6, '0'));
    				String url = wechatApi.getAuthUrl(replaceMap);
    				wechatMessageSupport.scanQrcodeNotify(proxyUser, user, url);
    				
    				//保存该销售的客户信息
            		UserProxyVo vo = BeanUtil.a2b(user, UserProxyVo.class);
            		vo.setUserId(user.getId());
            		vo.setProxyUserId(saleUser.getUserId());
            		vo.setOrderDayValue(saleUser.getOrderDayValue());
            		userProxySupport.save(proxyUser, vo);
    				
            	}
				
        	}
        }
		return "";
	}

	private String returnMessage(InputMessage inputMsg) {
		String content = inputMsg.getContent();
		BaseWeixinReply reply = baseWeixinReplyService.findByKeyWord(content);
		if(reply == null)reply = baseWeixinReplyService.findByKeyWord("默认");
		String toUserName = inputMsg.getToUserName();// 服务端  
	    String fromUserName = inputMsg.getFromUserName();// 客户端
	    long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间  
	    if(reply != null){
	    	int type = reply.getType();
	    	if(type == 1){
	    		TextMessage textMessage = new TextMessage();
	    		textMessage.setCreateTime(returnTime);
	    		textMessage.setFromUserName(toUserName);
	    		textMessage.setToUserName(fromUserName);
	    		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
	    		textMessage.setContent(reply.getContent());
	    		return MessageUtil.textMessageToXml(textMessage);
	    	}else if(type == 2){
	    		NewsMessage newsMessage = new NewsMessage();
	    		newsMessage.setCreateTime(returnTime);
	    		newsMessage.setFromUserName(toUserName);
	    		newsMessage.setToUserName(fromUserName);
	    		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
	    		List<Article> articleList = new ArrayList<Article>();
	    		for(WeixinReplyArticle articles  : reply.getArticles()){
	    			Article article = new Article();
	    			article.setTitle(articles.getTitle());
	    			String picUrl = articles.getPicurl();
	    			if(picUrl.indexOf("http") > -1){
	    				article.setPicUrl(picUrl);
	    			}else{
	    				article.setPicUrl(domain+picUrl);
	    			}
	    			
	    			article.setUrl(articles.getUrl());
	    			article.setDescription(articles.getDescription());
	    			articleList.add(article);
	    		}
	    		newsMessage.setArticles(articleList);
	    		newsMessage.setArticleCount(newsMessage.getArticles().size());
	    		return MessageUtil.newsMessageToXml(newsMessage);
	    	}
	    }else{
	    	
	    	//消息转发客服
	    	BaseMessage baseMessage = new BaseMessage();
	    	
	    	baseMessage.setCreateTime(returnTime);
	    	baseMessage.setFromUserName(toUserName);
	    	baseMessage.setToUserName(fromUserName);
	    	baseMessage.setMsgType(MessageUtil.TRANSFER_CUSTOMER_SERVICE);
	    	
	    	return MessageUtil.messageToCustomServiceXml(baseMessage);
	    }
		return "";
	}
	
	
	private String returnQrcodeMessage(InputMessage inputMsg) {
		
		String toUserName = inputMsg.getToUserName();// 服务端  
	    String fromUserName = inputMsg.getFromUserName();// 客户端
	    UserWeixin user = userWeixinService.findByOpenId(fromUserName);
	    if(user != null){
	    	SaleUser saleUser = saleUserService.findByUserId(user.getId());
	    	if(saleUser == null 
	    			|| saleUser.getApplyStatus() != 2 //待审核或审核失败
	    			|| saleUser.getStatus() != 1){		//无效的
	    		return returnMessage(inputMsg);
	    	}else{
	    		long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间  
	    		NewsMessage newsMessage = new NewsMessage();
	    		newsMessage.setCreateTime(returnTime);
	    		newsMessage.setFromUserName(toUserName);
	    		newsMessage.setToUserName(fromUserName);
	    		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
	    		List<Article> articleList = new ArrayList<Article>();
    			Article article = new Article();
    			article.setTitle("您的二维码");
    			String picUrl = saleUser.getQrcode();
    			if(picUrl.indexOf("http") > -1){
    				article.setPicUrl(picUrl);
    			}else{
    				article.setPicUrl(domain+picUrl);
    			}
    			
    			article.setUrl(article.getPicUrl());
    			article.setDescription("点击进入查看二维码图片，长按保存到手机相册");
    			articleList.add(article);
	    		newsMessage.setArticles(articleList);
	    		newsMessage.setArticleCount(newsMessage.getArticles().size());
	    		return MessageUtil.newsMessageToXml(newsMessage);
	    	}
	    }else{
	    	return returnMessage(inputMsg);
	    }
	    
	}

	private UserWeixin saveWeixinUser(String openid, SaleUser saleUser, String channelQrcodeCode) {
		int salesmanId = 0;
		String salesmanCode = "";
		if(saleUser != null)salesmanId = saleUser.getId();
		if(saleUser != null)salesmanCode = saleUser.getSalesmanCode();
		UserWeixin user = userWeixinService.findByOpenId(openid);
		// 查询微信用户信息
		WeixinUserInfo userInfo = wechatApi.queryUserInfo(commonSupport.getAccessToken(), openid);
		if(user ==  null){
			user = new UserWeixin();
			user.setAcceptPromotion(true);
			user.setAcceptPush(true);
			user.setCity(userInfo.getCity());
			user.setCounty(userInfo.getCountry());
			user.setCoordsrc("");
			user.setCreateTime(new Date());
			user.setEmail("");
			user.setFirstLetter("");
			user.setHeadImgUrl(userInfo.getHeadimgurl());
			user.setIsValidated(true);
			user.setMobile("");
			user.setNickname(userInfo.getNickname());
			user.setOpenid(openid);
			user.setProvince(userInfo.getProvince());
			user.setSalt(RandomProvider.randomAlphanumericToLowerCase(8));
			user.setSex(Integer.parseInt(userInfo.getSex()));
			user.setSubscribeStatus(1);
			user.setSubscribeTime(new Date());
			user.setSalesmanId(salesmanId);
			user.setSalesmanCode(salesmanCode);
			user.setIsNew(true);
			user.setChannelQrcodeCode(channelQrcodeCode);
			userWeixinService.insert(user);
			if(salesmanId > 0 
					&& saleUser.getSubscribeValue() != null 
					&& saleUser.getSubscribeValue() > 0){
				// 保存信息关注用户奖金记录信息
				SaleWeixinSubcripbeInfo subcripbeInfo = new SaleWeixinSubcripbeInfo();
				subcripbeInfo.setAmount(saleUser.getSubscribeValue());
				subcripbeInfo.setNickname(userInfo.getNickname());
				subcripbeInfo.setSaleId(salesmanId);
				subcripbeInfo.setSettleStatus(1);
				subcripbeInfo.setStatus(1);
				subcripbeInfo.setSubcripbeTime(user.getSubscribeTime());
				subcripbeInfo.setUserId(user.getId());
				saleWeixinSubcripbeInfoService.insert(subcripbeInfo);
			}
		}else{
			// 更新用户信息
			user.setAcceptPush(true);
			user.setCity(userInfo.getCity());
			user.setCounty(userInfo.getCountry());
			user.setHeadImgUrl(userInfo.getHeadimgurl());
			user.setIsValidated(true);
			user.setNickname(userInfo.getNickname());
			user.setProvince(userInfo.getProvince());
			user.setSex(Integer.parseInt(userInfo.getSex()));
			Integer subscribeStatus = user.getSubscribeStatus();
			if(subscribeStatus == 0){
				user.setSalesmanId(salesmanId);
				user.setSalesmanCode(salesmanCode);
			}
			user.setSubscribeStatus(1);
			user.setSubscribeTime(new Date());
			
			userWeixinService.update(user);
			if(subscribeStatus == 0 
					&& salesmanId > 0
					&& saleUser.getSubscribeValue() != null 
					&& saleUser.getSubscribeValue() > 0){
				// 保存信息关注用户奖金记录信息
				SaleWeixinSubcripbeInfo subcripbeInfo = new SaleWeixinSubcripbeInfo();
				subcripbeInfo.setAmount(saleUser.getSubscribeValue());
				subcripbeInfo.setNickname(userInfo.getNickname());
				subcripbeInfo.setSaleId(salesmanId);
				subcripbeInfo.setSettleStatus(1);
				subcripbeInfo.setStatus(1);
				subcripbeInfo.setSubcripbeTime(user.getSubscribeTime());
				subcripbeInfo.setUserId(user.getId());
				saleWeixinSubcripbeInfoService.insert(subcripbeInfo);
			}
		}
		return user;
	}
	
	private void unsubscribe(String openid) {
		UserWeixin user = userWeixinService.findByOpenId(openid);
		// 查询微信用户信息
		if(user !=  null){
			UserWeixin updateUser = new UserWeixin();
			updateUser.setId(user.getId());
			updateUser.setOpenid(user.getOpenid());
			updateUser.setSubscribeStatus(2);
			updateUser.setUnSubscribeTime(new Date());
			userWeixinService.update(updateUser);
		}
	}

}

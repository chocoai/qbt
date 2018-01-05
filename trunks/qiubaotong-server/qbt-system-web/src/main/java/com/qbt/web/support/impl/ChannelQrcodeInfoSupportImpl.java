package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.ChannelQrcodeInfo;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.ChannelQrcodeInfoService;
import com.qbt.service.CommonService;
import com.qbt.web.pojo.channelQrcodeInfo.ChannelQrcodeInfoPageReqVo;
import com.qbt.web.pojo.channelQrcodeInfo.ChannelQrcodeInfoVo;
import com.qbt.web.support.ChannelQrcodeInfoSupport;
import com.qbt.wechat.api.WechatApi;

@Service
public class ChannelQrcodeInfoSupportImpl implements ChannelQrcodeInfoSupport {

	
	@Value("${qrcode_image_url}")
	private String qrcode_image_url;
	@Resource
	private  ChannelQrcodeInfoService channelQrcodeInfoService;
	@Resource
	private CommonService commonService;
	@Resource
	private WechatApi wechatApi;
	@Resource
	private WechatCommonSupport commonSupport;
	@Resource
	private FileuploadScpService fileuploadScpService;
	
	
	@Override
	public List<ChannelQrcodeInfoVo> findByPage(ChannelQrcodeInfoPageReqVo reqVo) {
		PageEntity<ChannelQrcodeInfo> pageEntity = BeanUtil.pageConvert(reqVo, ChannelQrcodeInfo.class);
		List<ChannelQrcodeInfo> list = channelQrcodeInfoService.findByPage(pageEntity);
		List<ChannelQrcodeInfoVo> voList = BeanUtil.list2list(list, ChannelQrcodeInfoVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(ChannelQrcodeInfoVo vo) {
		ChannelQrcodeInfo channelQrcodeInfo = BeanUtil.a2b(vo, ChannelQrcodeInfo.class);
		channelQrcodeInfo.setStatus(1);
		String channelQrcodeCode = commonService.createChannelQrcodeCode();
		channelQrcodeInfo.setChannelQrcodeCode(channelQrcodeCode);
		String accessToken = commonSupport.getAccessToken();
		String ticket = wechatApi.getTicket(accessToken, channelQrcodeCode);
		channelQrcodeInfo.setTicket(ticket);
		//图片scp处理
		String[] requestUrls = new String[1];
		requestUrls[0] = qrcode_image_url+ticket; 
		String[] remoteImageUrl = fileuploadScpService.httpImageDownToScp(requestUrls);
		channelQrcodeInfo.setQrcodeUrl(remoteImageUrl[0]);
		channelQrcodeInfoService.add(channelQrcodeInfo);
	}

	@Override
	public void updateById(ChannelQrcodeInfoVo vo) {
		ChannelQrcodeInfo channelQrcodeInfo = BeanUtil.a2b(vo, ChannelQrcodeInfo.class);
		channelQrcodeInfoService.update(channelQrcodeInfo);	
	}

	@Override
	public void updateStatus(Integer id, int status) {
		channelQrcodeInfoService.updateStatus(id, status);
	}

	@Override
	public ChannelQrcodeInfoVo findById(Integer id) {
		ChannelQrcodeInfo channelQrcodeInfo =  channelQrcodeInfoService.findById(id);
		ChannelQrcodeInfoVo vo = BeanUtil.a2b(channelQrcodeInfo, ChannelQrcodeInfoVo.class);
		return vo;
	}

}

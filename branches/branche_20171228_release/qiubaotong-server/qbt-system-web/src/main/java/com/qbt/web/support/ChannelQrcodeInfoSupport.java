package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.channelQrcodeInfo.ChannelQrcodeInfoPageReqVo;
import com.qbt.web.pojo.channelQrcodeInfo.ChannelQrcodeInfoVo;

public interface ChannelQrcodeInfoSupport {

	List<ChannelQrcodeInfoVo> findByPage(ChannelQrcodeInfoPageReqVo reqVo);

	void add(ChannelQrcodeInfoVo vo);

	void updateById(ChannelQrcodeInfoVo vo);

	void updateStatus(Integer id, int status);

	ChannelQrcodeInfoVo findById(Integer id);

}

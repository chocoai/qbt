package com.qbt.web.pojo.channelQrcodeInfo;

import com.qbt.common.result.Paging;

public class ChannelQrcodeInfoPageReqVo extends Paging {

	//二维码渠道名称
	private String name;

	//识别码标识
    private String channelQrcodeCode;
    
    //备注
    private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChannelQrcodeCode() {
		return channelQrcodeCode;
	}

	public void setChannelQrcodeCode(String channelQrcodeCode) {
		this.channelQrcodeCode = channelQrcodeCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}

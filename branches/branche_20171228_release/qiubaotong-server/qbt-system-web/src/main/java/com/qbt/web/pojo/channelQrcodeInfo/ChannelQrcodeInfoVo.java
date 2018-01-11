package com.qbt.web.pojo.channelQrcodeInfo;

import javax.validation.constraints.NotNull;

public class ChannelQrcodeInfoVo {

	private int id; 
	
	//二维码渠道名称
	@NotNull(message = "二维码渠道名称不能为空")
	private String name;

	//识别码标识
    private String channelQrcodeCode;

    //二维码图片ticket
    private String ticket;

    //二维码url
    private String qrcodeUrl;

    //状态（1-正常 2-无效）
    private Integer status;

    //备注
    private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getQrcodeUrl() {
		return qrcodeUrl;
	}

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

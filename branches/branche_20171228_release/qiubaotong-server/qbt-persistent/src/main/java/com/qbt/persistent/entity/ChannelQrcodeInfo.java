package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class ChannelQrcodeInfo extends BaseEntity {

    private String name;

    private String channelQrcodeCode;

    private String ticket;

    private String qrcodeUrl;

    private Integer status;

    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getChannelQrcodeCode() {
        return channelQrcodeCode;
    }

    public void setChannelQrcodeCode(String channelQrcodeCode) {
        this.channelQrcodeCode = channelQrcodeCode == null ? null : channelQrcodeCode.trim();
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket == null ? null : ticket.trim();
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl == null ? null : qrcodeUrl.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }
}
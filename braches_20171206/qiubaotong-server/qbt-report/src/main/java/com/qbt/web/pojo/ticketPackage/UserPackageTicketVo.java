package com.qbt.web.pojo.ticketPackage;

import com.qbt.persistent.entity.UserPackageTicket;

public class UserPackageTicketVo extends UserPackageTicket{
	
	private static final long serialVersionUID = -6022238541920725356L;
	String imageBaseUrl;
	String sharePageUrl;
	
	public String getImageBaseUrl() {
		return imageBaseUrl;
	}
	public void setImageBaseUrl(String imageBaseUrl) {
		this.imageBaseUrl = imageBaseUrl;
	}
	public String getSharePageUrl() {
		return sharePageUrl;
	}
	public void setSharePageUrl(String sharePageUrl) {
		this.sharePageUrl = sharePageUrl;
	}
	
}

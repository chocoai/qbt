package com.qbt.web.support;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qbt.web.pojo.base.SiteModel;
@Service
public interface SiteSupport {
	
	public List<SiteModel> findSiteList(Integer key);
	
	public String getAddrName(int srcType, int srcId);
	
}

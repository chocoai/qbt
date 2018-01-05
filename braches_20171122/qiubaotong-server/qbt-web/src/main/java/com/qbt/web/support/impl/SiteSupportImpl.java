package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BaseAirport;
import com.qbt.persistent.entity.BaseBankBranch;
import com.qbt.persistent.entity.BasePartner;
import com.qbt.persistent.entity.BaseSfSite;
import com.qbt.service.BaseAirportService;
import com.qbt.service.BaseBankBranchService;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BasePartnerService;
import com.qbt.service.BaseSfSiteService;
import com.qbt.web.pojo.base.SiteModel;
import com.qbt.web.support.SiteSupport;

@Service
public class SiteSupportImpl implements SiteSupport {
	@Resource
	private BaseAirportService baseAirportService;
	@Resource
	private BaseSfSiteService baseSfSiteService;
	@Resource
	private BaseBankBranchService baseBankBranchService;
	@Resource
	private BasePartnerService basePartnerService;
	@Resource
	private BaseCourseService baseCourseService;
	
	
	@Override
	public List<SiteModel> findSiteList(Integer key) {
		List<SiteModel> weiXinBaseModelList = new ArrayList<SiteModel>();
		if(key == 1){
			//机场
			List<BaseAirport> baseAirportList = baseAirportService.findList();
			for (BaseAirport baseAirport : baseAirportList) {
				SiteModel siteModel = new SiteModel();
				siteModel.setId(baseAirport.getId());
				siteModel.setName(baseAirport.getName());
				siteModel.setAddress(baseAirport.getAddress());
				siteModel.setAreaId(baseAirport.getAreaId());
				weiXinBaseModelList.add(siteModel);
			}
		}else if(key == 2){
			//顺丰
			List<BaseSfSite> baseSfSiteList = baseSfSiteService.findList();
			for (BaseSfSite baseSfSite : baseSfSiteList) {
				SiteModel siteModel = new SiteModel();
				siteModel.setId(baseSfSite.getId());
				siteModel.setName(baseSfSite.getName());
				siteModel.setAddress(baseSfSite.getAddress());
				siteModel.setAreaId(baseSfSite.getAreaId());
				weiXinBaseModelList.add(siteModel);
			}
		}else if(key == 3){
			//银行
			List<BaseBankBranch> baseBankBranchList = baseBankBranchService.findList();
			for (BaseBankBranch baseBankBranch : baseBankBranchList) {
				SiteModel siteModel = new SiteModel();
				siteModel.setId(baseBankBranch.getId());
				siteModel.setName(baseBankBranch.getName());
				siteModel.setAddress(baseBankBranch.getAddress());
				siteModel.setAreaId(baseBankBranch.getAreaId());
				weiXinBaseModelList.add(siteModel);
			}
		}else if(key == 4){
			List<BasePartner> partnerList = basePartnerService.findAll(1);
			for (BasePartner basePartner : partnerList) {
				SiteModel siteModel = new SiteModel();
				siteModel.setId(basePartner.getId());
				siteModel.setName(basePartner.getName());
				weiXinBaseModelList.add(siteModel);
			}
		}
		return weiXinBaseModelList;
	}
	
	
	/**
	 *  获取站点名称
	  * @Title: getAddrName
	  * @Description: TODO
	  * @author: share 2016年8月13日
	  * @modify: share 2016年8月13日
	  * @param srcType
	  * @param srcId
	  * @return
	 */
	public String getAddrName(int srcType, int srcId) {
		 String jAddrName = "";
		switch (srcType) {
			case 1:
				jAddrName = baseCourseService.findById(srcId).getName();
				break;
			case 2:
				jAddrName = baseAirportService.findById(srcId).getName();
				break;
			case 3:
				jAddrName = baseBankBranchService.findById(srcId).getName();
				break;
			case 5:
				jAddrName = baseSfSiteService.findById(srcId).getName();
				break;
		}
		return jAddrName;
	}
	
	/*@Resource
	private BaseCourseService baseCourseService;
	
	@Override
	public List<WeiXinBaseCourse> findList(String name,int area_id,float lon,float lat) {
		// TODO Auto-generated method stub
		List<BaseCourse> baseCourseList = baseCourseService.findList(name,area_id, lon, lat);
		//List<WeiXinBaseCourse> weiXinBaseCourseList = baseCourseService.getList(area_id);
		List<WeiXinBaseCourse> weiXinBaseCourseList =  new ArrayList<WeiXinBaseCourse>();
		for (BaseCourse baseCourse : baseCourseList) {
			WeiXinBaseCourse weiXinBaseCourse = new WeiXinBaseCourse();
			weiXinBaseCourse.setId(baseCourse.getId());
			weiXinBaseCourse.setAddress(baseCourse.getAddress());
			weiXinBaseCourse.setName(baseCourse.getName());
			weiXinBaseCourse.setJuli(baseCourse.getJuli()/1000);
			weiXinBaseCourseList.add(weiXinBaseCourse);
		}
		return weiXinBaseCourseList;
	}*/

}

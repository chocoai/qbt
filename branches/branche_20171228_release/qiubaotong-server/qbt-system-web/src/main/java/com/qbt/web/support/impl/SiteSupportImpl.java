package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BaseAirport;
import com.qbt.persistent.entity.BaseBankBranch;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseSfSite;
import com.qbt.service.BaseAirportService;
import com.qbt.service.BaseBankBranchService;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BaseSfSiteService;
import com.qbt.web.pojo.common.SiteVo;
import com.qbt.web.support.SiteSupport;
@Service
public class SiteSupportImpl implements SiteSupport{

	@Resource
	private BaseCourseService baseCourseService;
	@Resource
	private BaseBankBranchService baseBankBranchService;
	@Resource
	private BaseSfSiteService baseSfSiteService;
	@Resource
	private BaseAirportService baseAirportService;
	
	@Override
	public List<SiteVo> list(int type) {
		List<SiteVo> commonVoList = new ArrayList<SiteVo>();
		switch (type) {
		case 1:
			//球场
			List<BaseCourse> baseCourseList  = baseCourseService.list();
			for (BaseCourse baseCourse : baseCourseList) {
				SiteVo SiteVo  = new SiteVo();
				SiteVo.setAddress(baseCourse.getAddress());
				SiteVo.setAreaId(baseCourse.getAreaId());
				SiteVo.setId(baseCourse.getId());
				SiteVo.setName(baseCourse.getName());
				SiteVo.setTreePath(baseCourse.getTreePath());
				commonVoList.add(SiteVo);
			}
			break;
		case 2:
			//银行网点
			List<BaseBankBranch> baseBankBranchList= baseBankBranchService.list();
			for (BaseBankBranch baseBankBranch : baseBankBranchList) {
				SiteVo SiteVo  = new SiteVo();
				SiteVo.setAddress(baseBankBranch.getAddress());
				SiteVo.setAreaId(baseBankBranch.getAreaId());
				SiteVo.setId(baseBankBranch.getId());
				SiteVo.setName(baseBankBranch.getName());
				SiteVo.setTreePath(baseBankBranch.getTreePath());
				commonVoList.add(SiteVo);
			}
			break;
		case 3:
			List<BaseSfSite> baseSfSiteList = baseSfSiteService.list();
			for (BaseSfSite baseSfSite : baseSfSiteList) {
				SiteVo SiteVo  = new SiteVo();
				SiteVo.setAddress(baseSfSite.getAddress());
				SiteVo.setAreaId(baseSfSite.getAreaId());
				SiteVo.setId(baseSfSite.getId());
				SiteVo.setName(baseSfSite.getName());
				SiteVo.setTreePath(baseSfSite.getTreePath());
				commonVoList.add(SiteVo);
			}
			//顺丰站点
			break;
		case 4:
			//机场网点
			List<BaseAirport> baseAirportList = baseAirportService.list();
			for (BaseAirport baseAirport : baseAirportList) {
				SiteVo SiteVo  = new SiteVo();
				SiteVo.setAddress(baseAirport.getAddress());
				SiteVo.setAreaId(baseAirport.getAreaId());
				SiteVo.setId(baseAirport.getId());
				SiteVo.setName(baseAirport.getName());
				SiteVo.setTreePath(baseAirport.getTreePath());
				commonVoList.add(SiteVo);
			}
			break;
		}
		return commonVoList;
	}
	
}

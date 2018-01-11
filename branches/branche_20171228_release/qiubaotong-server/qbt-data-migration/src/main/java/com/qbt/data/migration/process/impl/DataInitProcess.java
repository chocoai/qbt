package com.qbt.data.migration.process.impl;

import com.qbt.common.spring.SpringContextHolder;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.data.migration.utils.DataCacheUtil;
import com.qbt.persistent.entity.BaseAirport;
import com.qbt.persistent.entity.BaseBankBranch;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.BaseSfSite;
import com.qbt.service.BaseAirportService;
import com.qbt.service.BaseBankBranchService;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseSfSiteService;

/**
 *  微信业务
  * @ClassName: AccountProcess
  * @Description: TODO
  * @author share 2016年8月31日
  * @modify share 2016年8月31日
 */
public class DataInitProcess extends AbstractProcess {

	
	
	public DataInitProcess(String name, ProcessServiceConfig config) {
		super(name, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before() {
		
	}

	@Override
	public void process() throws Exception {
		// TODO Auto-generated method stub
		BaseSfAreaService baseSfAreaService = SpringContextHolder.getBean("baseSfAreaServiceImpl");
		BaseCourseService baseCourseService = SpringContextHolder.getBean("baseCourseServiceImpl");
		BaseSfSiteService baseSfSiteService = SpringContextHolder.getBean("baseSfSiteServiceImpl");
		BaseAirportService baseAirportService = SpringContextHolder.getBean("baseAirportServiceImpl");
		BaseBankBranchService baseBankBranchService = SpringContextHolder.getBean("baseBankBranchServiceImpl");
		// 地区
		for(BaseSfArea area : baseSfAreaService.list()){
			if(area.getLevel() == 3){
				DataCacheUtil.putBaseSfAreaMap(areaTreePath(area.getTreePath().substring(0,area.getTreePath().indexOf(","))+","+area.getFullName()), area);
				DataCacheUtil.putBaseSfAreaMap(areaTreePath(area.getTreePath()), area);
			}if(area.getLevel() == 4){
				DataCacheUtil.putBaseSfAreaMap(areaTreePath(area.getTreePath().substring(0, area.getTreePath().length()-1)), area);
				DataCacheUtil.putBaseSfAreaMap(areaTreePath(area.getTreePath()), area);
			}else{
				DataCacheUtil.putBaseSfAreaMap(areaTreePath(area.getTreePath()), area);
			}
			
		}
		// 球场
		for(BaseCourse area : baseCourseService.list()){
			DataCacheUtil.putCourseMap(area.getName(), area);
		}
		// 站点
		for(BaseSfSite area : baseSfSiteService.list()){
			DataCacheUtil.putBaseSfSiteMap(area.getName(), area);
		}
		// 机场
		for(BaseAirport area : baseAirportService.list()){
			DataCacheUtil.putBaseAirportMap(area.getName(), area);
		}
		// 银行网点
		for(BaseBankBranch area : baseBankBranchService.list()){
			DataCacheUtil.putBaseBankBranchMap(area.getName(), area);
		}
	}
	
	private String areaTreePath(String treePath){
		return treePath.replace("市,", ",");
	}
	
	public static void main(String[] args) {
		System.out.println("aaa,bbbb".substring(0,"aaa,bbbb".indexOf(",")));
	}

}

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.Arith;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.ActivityOffConfig;
import com.qbt.persistent.entity.City;
import com.qbt.persistent.entity.CourseAddress;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.service.ActivityOffConfigService;
import com.qbt.service.CityService;
import com.qbt.service.CourseAddressService;
import com.qbt.service.OrderInfoService;
import com.qbt.web.pojo.address.CitiesVo;
import com.qbt.web.pojo.address.CityVo;
import com.qbt.web.pojo.address.CourseAddressInfoVo;
import com.qbt.web.pojo.address.CourseAddressVo;
import com.qbt.web.pojo.address.HistoryOrderCitiesVo;
import com.qbt.web.pojo.address.HistoryOrderCityVo;
import com.qbt.web.pojo.address.ProvinceVo;
import com.qbt.web.pojo.address.ProvincesVo;
import com.qbt.web.support.AddressSupport;

@Service
public class AddressSupportImpl implements AddressSupport {

	@Resource 
	private CityService cityService;
	
	@Resource 
	private CourseAddressService courseAddressService;
	
	@Resource
	private OrderInfoService  orderInfoService;
	
	@Resource
	private ActivityOffConfigService activityOffConfigService;
	

	@Override
	public CourseAddressInfoVo listCourseAddressesInfo(Integer userId,float lon, float lat) {
		
		CourseAddressInfoVo  courseAddresInfo = new CourseAddressInfoVo();
		
		List<CityVo> cityVoList = new ArrayList<CityVo>();
		List<ProvinceVo> provinceVoList = new ArrayList<ProvinceVo>();
		List<HistoryOrderCityVo> historyOrderCityVoList = new ArrayList<HistoryOrderCityVo>();
		
		CitiesVo citiesVo = new CitiesVo();			
		ProvincesVo provincesVo  = new ProvincesVo();		
		HistoryOrderCitiesVo historyOrderCitiesVo  = new HistoryOrderCitiesVo();

		
		List<CourseAddress> courseAddressList = courseAddressService.listCourseAddressesInfo(lon,lat);
		
		List<City> hotCities = cityService.listHotCity();
		
		List<OrderInfo> orderList = orderInfoService.findCourseAddressById(userId);
		
		if(Checker.isNotEmpty(courseAddressList))
		{
			Map<Integer,List<CourseAddressVo>> keymap = new HashMap<Integer,List<CourseAddressVo>>();
			
			List<ActivityOffConfig> courseList = activityOffConfigService.findScopeIdByCourse();
			Set<String> courseSet = new HashSet<String>();
			for(ActivityOffConfig config : courseList){
				courseSet.add(String.valueOf(config.getScopeId()));
			}
			
			for(CourseAddress courseAddress : courseAddressList)
			{
				ProvinceVo proVo = new ProvinceVo();
				CourseAddressVo caVo;
				
				if(Checker.isNotEmpty(keymap.get(courseAddress.getProvinceId())))
				{
					caVo = convertToCourseAddressVo(courseSet, courseAddress);
					keymap.get(courseAddress.getProvinceId()).add(caVo);
					continue;
					
				}
				
				List<CourseAddressVo> courseAddressVoList = new ArrayList<CourseAddressVo>();
				proVo.setId(courseAddress.getProvinceId());				
				proVo.setName(courseAddress.getProvinceName());						
				proVo.setCourseAddressVoList(courseAddressVoList);
				
				caVo = convertToCourseAddressVo(courseSet, courseAddress);
				courseAddressVoList.add(caVo);
				
				provinceVoList.add(proVo);
				keymap.put(proVo.getId(), courseAddressVoList);
				
			}
			
			for(ProvinceVo proVo : provinceVoList)
			{
				
				List<CourseAddressVo> courseAddressVoList = proVo.getCourseAddressVoList();
				
				Collections.sort(courseAddressVoList,new Comparator<CourseAddressVo>() {
					 
		            @Override
		            public int compare(CourseAddressVo o1, CourseAddressVo o2) {
		            	
		            	if(Checker.isEmpty(o1.getJuli()) ||Checker.isEmpty(o2.getJuli()))
		            		return 0;
		            	
		                if (o1.getJuli() < o2.getJuli())
		                    return -1;
		                else if (o1.getJuli() > o2.getJuli())
		                    return 1;
		                else
		                    return o1.getName().compareTo(o2.getName());
		            }
		        });
			}
			
		}	
			

		if(Checker.isNotEmpty(hotCities))
		{
			
			for(City city : hotCities)
			{	
				CityVo cv = new CityVo();
				cv.setId(city.getId());
				cv.setName(city.getName());
				cityVoList.add(cv);
			}	
		}
		
		// 过滤多余的城市id
		List<Integer> idList = new ArrayList<Integer>();
		if(Checker.isNotEmpty(orderList))
		{
			for(OrderInfo orderInfo:orderList)
			{
				if(idList.contains(orderInfo.getOrderId()))
				{
					continue;
				}
				HistoryOrderCityVo hocVo = new HistoryOrderCityVo();
				if(Checker.isNotEmpty(orderInfo.getdTreePath()) && orderInfo.getdTreePath().split(",").length>0)
				{
					hocVo.setCityName(orderInfo.getdTreePath().split(",")[1]);
				}
				else
				{
					hocVo.setCityName(orderInfo.getdTreePath());
				}
				//order id now is the value of city id
				hocVo.setId(orderInfo.getOrderId());
				hocVo.setAdddressType(orderInfo.getdAddrType());
				hocVo.setAddress(orderInfo.getdAddress());
				hocVo.setAddressName(orderInfo.getdAddrName());
				historyOrderCityVoList.add(hocVo);
				idList.add(orderInfo.getOrderId());
			}
		
		}
		
		citiesVo.setCityVoList(cityVoList);
		provincesVo.setProvinceVoList(provinceVoList);
		historyOrderCitiesVo.setHistoryOrderCityVoList(historyOrderCityVoList);
		
		courseAddresInfo.setCitiesVo(citiesVo);
		courseAddresInfo.setProvincesVo(provincesVo);
		courseAddresInfo.setHistoryOrderCitiesVo(historyOrderCitiesVo);
		return courseAddresInfo;
	}


	private CourseAddressVo convertToCourseAddressVo(Set<String> courseSet,
			CourseAddress courseAddress) {
		CourseAddressVo caVo = new CourseAddressVo();
		
		
		// 满减活动标签
		if(courseSet.contains(String.valueOf(courseAddress.getId()))){
			caVo.setActivityType(1);
		}
		caVo.setJuli(courseAddress.getJuli());
		
		double juli = Arith.div(courseAddress.getJuli(), 1000, 2);
		if(juli<1){
			caVo.setJuliStr((int)courseAddress.getJuli()+"米");
		}else{
			caVo.setJuliStr((int)juli+"公里");
		}
		caVo.setId(courseAddress.getId());
		caVo.setAreaId(courseAddress.getAreaId());
		caVo.setAddress(courseAddress.getAddress());
		caVo.setName(courseAddress.getCourseName());
		// 偏远球场信息
		caVo.setIsOutRange(courseAddress.getIsOutRange());
		caVo.setOutRangeTime(courseAddress.getOutRangeTime());
		caVo.setOutRangePrice(courseAddress.getOutRangePrice());
		// 微信提示信息
		caVo.setIsTip(courseAddress.getIsTip());
		caVo.setWechatTip(courseAddress.getWechatTip());
		
		return caVo;
	}


	@Override
	public List<CourseAddressVo> listCourseAddressesInfoByCityId(int id,float lon, float lat) {
		List<CourseAddressVo> courseAddressVolist  = new ArrayList<CourseAddressVo>();
		
		//List<CourseAddress> courseAddressList = courseAddressService.listCourseAddressByCityId(id,lon,lat);
		List<CourseAddress> courseAddressList = courseAddressService.listCourseAddressByCityId(id,lon,lat);
		
		if(Checker.isNotEmpty(courseAddressList))
		{
			Map<Integer,List<CourseAddressVo>> keymap = new HashMap<Integer,List<CourseAddressVo>>();
			
			List<ActivityOffConfig> courseList = activityOffConfigService.findScopeIdByCourse();
			Set<String> courseSet = new HashSet<String>();
			for(ActivityOffConfig config : courseList){
				courseSet.add(String.valueOf(config.getScopeId()));
			}
			
			for(CourseAddress courseAddress : courseAddressList)
			{	
				CourseAddressVo caVo;
				
				if(Checker.isNotEmpty(keymap.get(courseAddress.getId())))
				{
					caVo = convertToCourseAddressVo(courseSet, courseAddress);
					continue;
					
				}
				
				List<CourseAddressVo> courseAddressVoList = new ArrayList<CourseAddressVo>();
				
				caVo = convertToCourseAddressVo(courseSet, courseAddress);
				courseAddressVolist.add(caVo);
				
				
				keymap.put(id, courseAddressVoList);
				
			}
		}	
		
		
		return courseAddressVolist;
	}


	
	
	
	

	
}




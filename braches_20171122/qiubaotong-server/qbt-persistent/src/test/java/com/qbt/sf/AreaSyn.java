package com.qbt.sf;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qbt.SimpleHttpClient;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.StringUtil;
import com.qbt.persistent.entity.BaseArea;
import com.qbt.persistent.mapper.BaseAreaMapper;
import com.qbt.sf.entity.CityVo;

@ContextConfiguration(locations = {"classpath*:context/applicationContext*.xml"}) 
public class AreaSyn extends AbstractJUnit4SpringContextTests {
	
	public static String website= "http://www.sf-express.com/";
	
	@Resource
	private BaseAreaMapper baseAreaMapper;
	
	@Test
	public void syn() {
		List<?> proviceList = getProvince();
		for(Object province : proviceList){
			CityVo provinceVo = JSonUtil.toObject(JSonUtil.toJSonString(province), CityVo.class);
			BaseArea area = baseAreaMapper.findLikeName(provinceVo.getName(),provinceVo.getLevel()-1,0);
			if(StringUtil.isEmpty(area.getSfCode())){
				baseAreaMapper.updateCodeBySf(provinceVo.getName(),provinceVo.getLevel()-1,0, provinceVo.getCode());
			}
			List<?> cityList = getCitys(provinceVo.getCode());
			for(Object city : cityList){
				CityVo cityVo = JSonUtil.toObject(JSonUtil.toJSonString(city), CityVo.class);
				BaseArea cityArea = baseAreaMapper.findLikeName(cityVo.getName(),cityVo.getLevel()-1,area.getId());
				if(cityArea != null && StringUtil.isEmpty(cityArea.getSfCode())){
					baseAreaMapper.updateCodeBySf(cityVo.getName(),cityVo.getLevel()-1,area.getId(), cityVo.getCode());
				}
				if(cityArea != null){
					List<?> countryList = getCounty(cityVo.getCode());
					for(Object country : countryList){
						CityVo countryVo = JSonUtil.toObject(JSonUtil.toJSonString(country), CityVo.class);
						BaseArea countryArea = baseAreaMapper.findLikeName(countryVo.getName(),countryVo.getLevel()-1,cityArea.getId());
						if(countryArea != null && StringUtil.isEmpty(countryArea.getSfCode())){
							baseAreaMapper.updateCodeBySf(countryVo.getName(),countryVo.getLevel()-1,cityArea.getId(), countryVo.getCode());
						}
					}
				}
				
			}
		}
	}
	
	
	public List<?> getProvince(){
		String url = website+"/sf-service-web/service/region/A000086000/subRegions/origins?level=-1&lang=sc&region=cn&translate=";
		String body = SimpleHttpClient.httpGet(url);
		return JSonUtil.toObject(body, List.class);
	}
	
	public List<?> getCitys(String code){
		String url = website+"/sf-service-web/service/region/"+code+"/subRegions/origins??level=2&lang=sc&region=cn&translate=";
		String body = SimpleHttpClient.httpGet(url);
		return JSonUtil.toObject(body, List.class);
	}
	
	public List<?> getCounty(String code){
		String url = website+"/sf-service-web/service/region/"+code+"/subRegions/origins??level=3&lang=sc&region=cn&translate=";
		String body = SimpleHttpClient.httpGet(url);
		return JSonUtil.toObject(body, List.class);
	}
}

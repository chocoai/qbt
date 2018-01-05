package com.qbt.sf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qbt.SimpleHttpClient;
import com.qbt.common.util.JSonUtil;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.mapper.BaseSfAreaMapper;
import com.qbt.sf.entity.CityVo;

@ContextConfiguration(locations = {"classpath*:context/applicationContext*.xml"}) 
public class SfAreaSyn extends AbstractJUnit4SpringContextTests {
	
	public static String website= "http://www.sf-express.com/";
	
	@Resource
	private BaseSfAreaMapper baseSfAreaMapper;
	
	@Test
	public void syn() {
		String chinaCode = "A000086000";
		String gatChinaCode = "A000820000,A000710000,A000810000";
		String code = "A000000000";
		List<?> chinaList = getProvince(code);
		List gatList = new ArrayList();
		int sort = 1;
		for(Object china : chinaList){
			CityVo chinaVo = JSonUtil.toObject(JSonUtil.toJSonString(china), CityVo.class);
			// 港澳台
			if(gatChinaCode.contains(chinaVo.getCode())){
				gatList.add(chinaVo);
			}
			if(!chinaCode.equals(chinaVo.getCode())){
				continue;
			}
			int chinaSuppertId = 0;
			BaseSfArea baseSfArea = cityVo2SfArea(chinaVo, sort,chinaSuppertId);
			baseSfAreaMapper.insert(baseSfArea);
			chinaSuppertId = baseSfArea.getId();
			sort ++;
			List<?> proviceList = getProvince(chinaCode);
			int psort = 1;
			proviceList.addAll(proviceList.size()-1, gatList);
			for(Object province : proviceList){
				CityVo provinceVo = JSonUtil.toObject(JSonUtil.toJSonString(province), CityVo.class);
				baseSfArea = cityVo2SfArea(provinceVo, psort,chinaSuppertId);
				baseSfAreaMapper.insert(baseSfArea);
				int provinceSupperId = baseSfArea.getId();
				psort ++;
				List<?> cityList = getProvince(provinceVo.getCode());
				int csort = 1;
				for(Object city : cityList){
					
					CityVo cityVo = JSonUtil.toObject(JSonUtil.toJSonString(city), CityVo.class);
					baseSfArea = cityVo2SfArea(cityVo, csort,provinceSupperId);
					baseSfAreaMapper.insert(baseSfArea);
					int citySuperId = baseSfArea.getId();
					csort ++;
					List<?> countryList = getProvince(cityVo.getCode());
					int ctsort = 1;
					for(Object country : countryList){
						CityVo countryVo = JSonUtil.toObject(JSonUtil.toJSonString(country), CityVo.class);
						baseSfArea = cityVo2SfArea(countryVo, ctsort,citySuperId);
						baseSfAreaMapper.insert(baseSfArea);
						ctsort ++;
					}
				}
					
			}
			
		}
		
		
	}


	private BaseSfArea cityVo2SfArea(CityVo chinaVo, int sort,int parentId) {
		BaseSfArea baseSfArea = new BaseSfArea();
		baseSfArea.setId(getId(chinaVo.getDistId()));
		baseSfArea.setCode(chinaVo.getCode());
		baseSfArea.setLevel(chinaVo.getLevel());
		baseSfArea.setName(chinaVo.getName());
		baseSfArea.setParentId(parentId);
		baseSfArea.setParentCode(chinaVo.getParentCode());
		baseSfArea.setTreeId("");
		baseSfArea.setTreePath("");
		baseSfArea.setSort(sort);
		return baseSfArea;
	}
	
	public int getId(int id){
		return 1000000+id;
	}
	
	public List<?> getProvince(String code){
		String url = website+"sf-service-web/service/region/"+code+"/subRegions/origins?level=-1&lang=sc&region=cn&translate=";
		System.out.println(url);
		String body = SimpleHttpClient.httpGet(url);
		return JSonUtil.toObject(body, List.class);
	}
	
}

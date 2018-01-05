package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.City;
import com.qbt.persistent.entity.Province;
import com.qbt.service.CityService;
import com.qbt.service.ProvinceService;
import com.qbt.web.pojo.address.CityPageReqVo;
import com.qbt.web.pojo.address.CityVo;
import com.qbt.web.pojo.address.ProvinceVo;
import com.qbt.web.pojo.reminder.ReminderVo;
import com.qbt.web.support.AddressSupport;

@Service
public class AddressSupportImpl implements AddressSupport{

	@Resource 
	private CityService cityService;
	
	@Resource 
	private ProvinceService provinceService;
	
	@Override
	public List<CityVo> getCities(CityPageReqVo reqVo) {
		PageEntity<City> pageEntity = BeanUtil.pageConvert(reqVo, City.class);
		
		List<CityVo> cityVoList = new ArrayList<CityVo>();
		
		List<City> cityList = cityService.getCities(pageEntity);
		
		if(Checker.isNotEmpty(cityList))
		{
			for(City ci : cityList)
			{
				CityVo ciVo = BeanUtil.a2b(ci, CityVo.class);				
				cityVoList.add(ciVo);
			}
		}		
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return cityVoList;
	}

	@Override
	public List<ProvinceVo> getProvinces() {
		
			List<ProvinceVo> provinceVoList = new ArrayList<ProvinceVo>();
			
			List<Province> provinceList = provinceService.getProvinces();
			
			if(Checker.isNotEmpty(provinceList))
			{
				for(Province province : provinceList)
				{
					ProvinceVo proVo = new ProvinceVo();
					
					proVo.setId(province.getId());
					proVo.setCourseAmount(province.getCourseAmount());
					proVo.setName(province.getName());
					proVo.setStatus(province.getStatus());
					proVo.setSortNumber(province.getSortNumber());
					provinceVoList.add(proVo);
				}
			}	
			
		return provinceVoList;
	}

	@Override
	public void update(CityVo Vo) {
				
		City city = new City();
		
		
		
		city.setId(Vo.getId());
		city.setCourseAmount(Vo.getCourseAmount());
		city.setName(Vo.getName());
		city.setStatus(Vo.getStatus());
		
		cityService.delete(city);
		
		cityService.insert(city);
		
	}



	@Override
	public void update(ProvinceVo Vo) {
		
		Province prov = new Province();
		
		prov.setId(Vo.getId());
		prov.setCourseAmount(Vo.getCourseAmount());
		prov.setName(Vo.getName());
		prov.setStatus(Vo.getStatus());
		prov.setSortNumber(Vo.getSortNumber());
		provinceService.delete(prov);
		provinceService.insert(prov);
		
	}

	@Override
	public int insertCity(CityVo Vo) {
	City city = new City();
		
		city.setId(Vo.getId());
		city.setCourseAmount(Vo.getCourseAmount());
		city.setName(Vo.getName());
		city.setStatus(Vo.getStatus());
		
		return cityService.insert(city);
	}

	@Override
	public int insertProvince(ProvinceVo Vo) {
		
		Province prov = new Province();
		prov.setId(Vo.getId());
		prov.setCourseAmount(Vo.getCourseAmount());
		prov.setName(Vo.getName());
		prov.setStatus(Vo.getStatus());
		prov.setSortNumber(Vo.getSortNumber());
		
		return provinceService.insert(prov);
	}

	@Override
	public void deleteAllCities() {
		
		cityService.deleteAll();
	}

	@Override
	public void deleteAllProvinces() {
		provinceService.deleteAll();
	}

	@Override
	public List<CityVo> listHotCities() {
		
		List<CityVo> cityVoList = new ArrayList<CityVo>();
		List<City> cityList = cityService.listHotCity();
		if(Checker.isNotEmpty(cityList))
		{
			for(City city : cityList)
			{
				CityVo ciVo = new CityVo();
				ciVo.setId(city.getId());
				ciVo.setCourseAmount(city.getCourseAmount());
				ciVo.setName(city.getName());
				ciVo.setStatus(city.getStatus());
				cityVoList.add(ciVo);
			}
		}
		
			
		return cityVoList;
	}

}

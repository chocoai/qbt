package com.qbt.web.support;

import java.util.List;


import com.qbt.web.pojo.address.CityPageReqVo;
import com.qbt.web.pojo.address.CityVo;
import com.qbt.web.pojo.address.ProvinceVo;

public interface AddressSupport {

	List<CityVo> getCities(CityPageReqVo reqVo);
	
	List<CityVo> listHotCities();
	
	List<ProvinceVo> getProvinces();
	
	void update(CityVo Vo);
	
	void update(ProvinceVo Vo);
	
	int insertCity(CityVo Vo);
	
	int insertProvince(ProvinceVo Vo);
	
	void deleteAllCities(); 

	void deleteAllProvinces(); 
	
	
}

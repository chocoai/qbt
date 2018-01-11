package com.qbt.web.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.util.Checker;
import com.qbt.web.pojo.address.CityPageReqVo;
import com.qbt.web.pojo.address.CityVo;
import com.qbt.web.pojo.address.ProvinceVo;
import com.qbt.web.support.AddressSupport;


@Controller
@RequestMapping("sysAddress")
public class AddressController {

	@Resource 
	private AddressSupport addressSupport;
	//@RequestBody CityPageReqVo reqVo
	@RequestMapping(value = "cities")
	public PageResult<List<CityVo>> listCitiesInfo(@RequestBody CityPageReqVo reqVo){
		
		PageResult<List<CityVo>> result = new PageResult<List<CityVo>>();
		try
		{
			List<CityVo> cities = addressSupport.getCities(reqVo);
			result.setDatas(cities);
			
			result.setPage(reqVo);
		}catch(Exception e)
		{
			String errMsg = "查找城市异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		
		return result;
	}
	
	
	
	@RequestMapping(value = "hotCities")
	public Result<List<CityVo>> listHotCites(){
		
		Result<List<CityVo>> result = new Result<List<CityVo>>();
		try
		{
			List<CityVo> cities = addressSupport.listHotCities();
			result.setDatas(cities);
			
		}catch(Exception e)
		{
			String errMsg = "查找城市异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		
		return result;
	}
	
	//@RequestBody ProvincePageReqVo reqVo
	@RequestMapping(value = "provinces")
	public PageResult<List<ProvinceVo>> listProvincesInfo(){
		
		PageResult<List<ProvinceVo>> result = new PageResult<List<ProvinceVo>>();
		try
		{
			List<ProvinceVo> provinces = addressSupport.getProvinces();
			Collections.sort(provinces,new Comparator<ProvinceVo>() {
				 
	            @Override
	            public int compare(ProvinceVo o1, ProvinceVo o2) {
	            	
	            	if(Checker.isEmpty(o1.getSortNumber()) ||Checker.isEmpty(o2.getSortNumber()))
	            		return 0;
	            	
	                if (o1.getSortNumber() < o2.getSortNumber())
	                    return -1;
	                else if (o1.getSortNumber() > o2.getSortNumber())
	                    return 1;
	                else
	                    return o1.getName().compareTo(o2.getName());
	            }
	        });
			result.setDatas(provinces);
			//result.setPage(reqVo);
		}catch(Exception e)
		{
			String errMsg = "查找省份异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		
		return result;
	}
	
	
	
	@RequestMapping(value = "updateCity")
	public Result<Boolean> updateCity(@RequestBody CityVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			
				addressSupport.update(vo);
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "提示更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	
	@RequestMapping(value = "updateProvince")
	public Result<Boolean> updateProvince(@RequestBody ProvinceVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
				addressSupport.update(vo);
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "提示更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	
	
	@RequestMapping(value = "updateCities")
	public Result<Boolean> updateCities(@RequestBody List<CityVo> volist){
		Result<Boolean> result = new Result<Boolean>();
		try {		
			addressSupport.deleteAllCities();
			
			for(CityVo vo : volist)
			{
				addressSupport.insertCity(vo);
			}
				
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "提示更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	
	@RequestMapping(value = "updatePovinces")
	public Result<Boolean> updateProvinces(@RequestBody List<ProvinceVo> volist){
		Result<Boolean> result = new Result<Boolean>();
		try {		
				addressSupport.deleteAllProvinces();
				
				for(ProvinceVo vo : volist)
				{
					addressSupport.insertProvince(vo);
				}
				
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "提示更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		
		return result;
	}
	
	

}

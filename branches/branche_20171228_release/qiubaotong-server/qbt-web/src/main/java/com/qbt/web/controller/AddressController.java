package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.address.CourseAddressInfoVo;
import com.qbt.web.pojo.address.CourseAddressVo;
import com.qbt.web.support.AddressSupport;
import com.qbt.web.support.LoginSupport;

@Controller
@RequestMapping("courseAddress")
public class AddressController {

	@Resource
	private AddressSupport addressSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	
	@RequestMapping(value = "list")
	public Result<CourseAddressInfoVo> listCourseAddress(HttpServletRequest request,
			@RequestParam(value="lon", required=false,defaultValue="0") float lon, 
			@RequestParam(value="lat", required=false,defaultValue="0") float lat)
	{
		Result<CourseAddressInfoVo> result = new Result<CourseAddressInfoVo>();
		
		try{
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			
			result.setDatas(addressSupport.listCourseAddressesInfo(userWeixin.getId(),lon,lat));
			//result.setDatas(addressSupport.listCourseAddressesInfo(170,lon,lat));
		}catch(Exception e)
		{
			String errMsg = "查找球场信息异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		
		return result;
	}
		
	@RequestMapping(value = "findByCityId")
	public Result<List<CourseAddressVo>> listCourseAddressByCityId(
			@RequestParam(value="cityId", required=false,defaultValue="0") int cityId,
			@RequestParam(value="lon", required=false,defaultValue="0") float lon, 
			@RequestParam(value="lat", required=false,defaultValue="0") float lat)
	{
		Result<List<CourseAddressVo>> result = new Result<List<CourseAddressVo>>();
		try{
			
			result.setDatas(addressSupport.listCourseAddressesInfoByCityId(cityId,lon,lat));
		}
		catch(Exception e)
		{
			String errMsg = "查找球场信息异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		
		
		return result;
		
	}
	
}

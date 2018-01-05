package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.common.SiteVo;
import com.qbt.web.support.CommonSupport;
import com.qbt.web.support.SiteSupport;

@Controller
@RequestMapping("/common")
public class CommonController {
	
	@Resource
	private CommonSupport commonSupport;
	
	@Resource
	private SiteSupport siteSupport;
	
	@RequestMapping("siteList")
	public Result<List<SiteVo>> siteList(int type){
		Result<List<SiteVo>> result = new Result<List<SiteVo>>();
		List<SiteVo> SiteVoList = siteSupport.list(type);
		result.setDatas(SiteVoList);
		return result;
	}
	
	@RequestMapping(value = "imageUpload", method = RequestMethod.POST)
	public Result<String> imageUpload(@RequestParam(value="image") MultipartFile image){
		Result<String> result = new Result<String>();
		try {
			result.setDatas(commonSupport.imageUpload(image));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg("图片上传失败");
		}
		return result;
	}
	
	@RequestMapping(value = "excelUpload", method = RequestMethod.POST)
	public Result<String> excelUpload(@RequestParam(value="excel") MultipartFile excel){
		Result<String> result = new Result<String>();
		try {
			result.setDatas(commonSupport.excelUpload(excel));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg("excel上传失败");
		}
		return result;
	}
	
}

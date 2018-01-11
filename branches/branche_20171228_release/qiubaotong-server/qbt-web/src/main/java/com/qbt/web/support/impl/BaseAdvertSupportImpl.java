/**
 * Project Name:qbt-web
 * File Name:BaseAdvertSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年10月11日上午10:48:58
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseAdvert;
import com.qbt.persistent.entity.BaseAdvertImage;
import com.qbt.service.BaseAdvertImageService;
import com.qbt.service.BaseAdvertService;
import com.qbt.web.pojo.baseAdvert.BaseAdvertImageVo;
import com.qbt.web.pojo.baseAdvert.BaseAdvertVo;
import com.qbt.web.support.BaseAdvertSupport;

/**
 * ClassName:BaseAdvertSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月11日 上午10:48:58
 * @author   wuwang
 * @version  
 * @see 	 
 */
@Service
public class BaseAdvertSupportImpl implements BaseAdvertSupport {

	@Resource
	private BaseAdvertService baseAdvertService;
	@Resource
	private BaseAdvertImageService baseAdvertImageService;
	
	@Override
	public BaseAdvertVo listByCode(String code, Integer flatType) {
		BaseAdvert baseAdvert = baseAdvertService.listByCode(code, flatType);
		BaseAdvertVo baseAdvertVo = BeanUtil.a2b(baseAdvert, BaseAdvertVo.class);
		if(baseAdvertVo != null) {
		List<BaseAdvertImage> imageList = baseAdvertImageService.findListByAdvertCode(code);
		List<BaseAdvertImageVo> imageVoList = new ArrayList<BaseAdvertImageVo>();
		if(Checker.isNotEmpty(imageList)){
			for (BaseAdvertImage baseAdvertImage : imageList) {
				BaseAdvertImageVo imageVo = new BaseAdvertImageVo();
				imageVo.setImage(baseAdvertImage.getImage());
				imageVo.setNumber(baseAdvertImage.getNumber());
				imageVo.setUrl(baseAdvertImage.getUrl());
				imageVoList.add(imageVo);
			}
		  }
		baseAdvertVo.setImageVoList(imageVoList);
		}
		
		return baseAdvertVo;
	}

}

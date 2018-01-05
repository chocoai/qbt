/**
 * Project Name:qbt-system-web
 * File Name:BaseAdvertSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年10月10日上午10:05:21
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseAdvert;
import com.qbt.persistent.entity.BaseAdvertImage;
import com.qbt.persistent.entity.SysUser;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.BaseAdvertImageService;
import com.qbt.service.BaseAdvertService;
import com.qbt.web.pojo.baseAdvert.BaseAdvertPageReq;
import com.qbt.web.pojo.baseAdvert.BaseAdvertVo;
import com.qbt.web.support.BaseAdvertSupport;

/**
 * ClassName:BaseAdvertSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月10日 上午10:05:21
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
	@Resource
	private FileuploadScpService fileuploadScpService;
	
	@Override
	public List<BaseAdvertVo> findByPage(BaseAdvertPageReq pageReq) {
		PageEntity<BaseAdvert> pageEntity = BeanUtil.pageConvert(pageReq, BaseAdvert.class);
		List<BaseAdvert> list = baseAdvertService.findByPage(pageEntity);
		List<BaseAdvertVo> voList = BeanUtil.list2list(list, BaseAdvertVo.class);
		pageReq.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void updateStatus(Integer id, int status) {
		baseAdvertService.updateStatus(id, status);
	}

	@Override
	public BaseAdvertVo findById(Integer id) {
		BaseAdvert baseAdvert = baseAdvertService.findById(id);
		BaseAdvertVo vo = BeanUtil.a2b(baseAdvert, BaseAdvertVo.class);
		List<BaseAdvertImage> imagelist = baseAdvertImageService.findListByAdvertCode(baseAdvert.getCode());
		if(Checker.isNotEmpty(imagelist)){
			vo.setBaseAdvertImageList(imagelist);
		}
		return vo;
	}

	@Override
	public void update(SysUser sysUser, BaseAdvertVo reqVo) {
		BaseAdvert ba = baseAdvertService.findById(reqVo.getId());
		BaseAdvert baseAdv = new BaseAdvert();
		baseAdv.setId(reqVo.getId());
		baseAdv.setName(reqVo.getName());
		baseAdv.setAdvertDescribe(reqVo.getAdvertDescribe());
		baseAdv.setOpenType(reqVo.getOpenType());
		baseAdv.setRemark(reqVo.getRemark());
		baseAdv.setOperatorId(sysUser.getId());
		baseAdv.setOperatorName(sysUser.getName());
		baseAdvertService.udateById(baseAdv);
		
		//vo
		List<BaseAdvertImage> baseAdvertImageList = reqVo.getBaseAdvertImageList();
		List<String> imageStrVoList = new ArrayList<String>();
		if(Checker.isNotEmpty(baseAdvertImageList)){
			for(BaseAdvertImage baseAdvertImage : baseAdvertImageList){
				imageStrVoList.add(baseAdvertImage.getImage());
			}
		}
		//数据库
		List<BaseAdvertImage> imagelist = baseAdvertImageService.findListByAdvertCode(ba.getCode());
		List<String> imageStrDBList = new ArrayList<String>();
		if(Checker.isNotEmpty(imagelist)){
			for (BaseAdvertImage baseAdvertImage : imagelist) {
				imageStrDBList.add(baseAdvertImage.getImage());
			}
		}
		
		List<String> imageStrDeleteList = new ArrayList<String>();
		for(String imageStrDB : imageStrDBList){
			 Boolean isContain = imageStrVoList.contains(imageStrDB);
			 if(isContain == false){
				 imageStrDeleteList.add(imageStrDB);
			 }
		}
		
		if(Checker.isNotEmpty(imageStrDeleteList)){
			fileuploadScpService.delRemoteFile(imageStrDeleteList);
		}
		
		
		List<BaseAdvertImage> insertImageList = new ArrayList<BaseAdvertImage>();
		for (BaseAdvertImage baseAdvertImage : baseAdvertImageList) {
			BaseAdvertImage insertImage = new BaseAdvertImage();
			insertImage.setAdvertCode(ba.getCode());
			insertImage.setImage(baseAdvertImage.getImage());
			insertImage.setUrl(baseAdvertImage.getUrl());
			insertImage.setOperatorId(sysUser.getId());
			insertImage.setOperatorName(sysUser.getName());
			insertImage.setNumber(baseAdvertImage.getNumber());
			insertImageList.add(insertImage);
		}
		baseAdvertImageService.deleteByAdvertCode(ba.getCode());
		baseAdvertImageService.insertByBatch(insertImageList);
		
	}

	
	
}

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.BaseAdv;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.BaseAdvService;
import com.qbt.web.pojo.baseAdv.BaseAdvPageReqVo;
import com.qbt.web.pojo.baseAdv.BaseAdvVo;
import com.qbt.web.support.BaseAdvSupport;
@Service
public class BaseAdvSupportImpl implements BaseAdvSupport {
	
	@Resource
	private BaseAdvService baseAdvService;
	@Resource
	private FileuploadScpService fileuploadScpService;
	
	@Override
	public void add(BaseAdvVo vo) throws BusinessException {
		BaseAdv baseAdv = BeanUtil.a2b(vo, BaseAdv.class);
		baseAdvService.add(baseAdv);
		
	}

	@Override
	public Boolean delete(Integer id) {
		BaseAdv baseAdv = baseAdvService.findById(id);
		List<String> strList = new ArrayList<String>();
		strList.add(baseAdv.getImage());
		fileuploadScpService.delRemoteFile(strList);
		int i = baseAdvService.delete(baseAdv);
		return i > 0;
	}

	@Override
	public Boolean update(BaseAdvVo reqVo) {
		BaseAdv ba = baseAdvService.findById(reqVo.getId());
		BaseAdv baseAdv = new BaseAdv();
		baseAdv.setId(reqVo.getId());
		baseAdv.setUrl(reqVo.getUrl());
		baseAdv.setType(reqVo.getType());
		baseAdv.setPosition(reqVo.getPosition());
		baseAdv.setNumber(reqVo.getNumber());
		baseAdv.setName(reqVo.getName());
		if(!reqVo.getImage().equals(ba.getImage())){
			List<String> strList = new ArrayList<String>();
			strList.add(ba.getImage());
			fileuploadScpService.delRemoteFile(strList);
		}
		baseAdv.setImage(reqVo.getImage());
		return baseAdvService.updateById(baseAdv) > 0;
	}

	@Override
	public List<BaseAdvVo> findByPage(BaseAdvPageReqVo reqVo) {
		PageEntity<BaseAdv> pageEntity = BeanUtil.pageConvert(reqVo, BaseAdv.class);
		
		List<BaseAdv> list = baseAdvService.findByPage(pageEntity);
		List<BaseAdvVo> voList = BeanUtil.list2list(list, BaseAdvVo.class);
		
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public BaseAdvVo findById(Integer id) {
		BaseAdv baseAdv = baseAdvService.findById(id);
		BaseAdvVo baseAdvVo = BeanUtil.a2b(baseAdv, BaseAdvVo.class);
		return baseAdvVo;
	}


}

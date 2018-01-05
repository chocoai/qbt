package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.BaseSfSite;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseSfSiteService;
import com.qbt.service.UserAssistantService;
import com.qbt.web.pojo.baseSfSite.BaseSfSitePageReqVo;
import com.qbt.web.pojo.baseSfSite.BaseSfSiteVo;
import com.qbt.web.support.BaseSfSiteSupport;

@Service
public class BaseSfSiteSupportImpl implements BaseSfSiteSupport{

	@Resource
	private BaseSfSiteService baseSfSiteService;
	@Resource
	private BaseSfAreaService baseSfAreaService;
	@Resource
	private UserAssistantService userAssistantService;
	
	@Override
	public List<BaseSfSiteVo> findByPage(BaseSfSitePageReqVo reqVo) {
		PageEntity<BaseSfSite> pageEntity = BeanUtil.pageConvert(reqVo, BaseSfSite.class);
		List<BaseSfSite> list = baseSfSiteService.findByPage(pageEntity);
		List<BaseSfSiteVo> voList = BeanUtil.list2list(list, BaseSfSiteVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void updateById(BaseSfSiteVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseSfSite baseSfSite = BeanUtil.a2b(vo, BaseSfSite.class);
		vo.setTreePath(area.getTreePath());
		baseSfSiteService.update(baseSfSite);
	}

	@Override
	public void add(BaseSfSiteVo vo) throws BusinessException{
		BaseSfSite condition = new BaseSfSite();
		condition.setName(vo.getName());
		List<BaseSfSite> qryList = baseSfSiteService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException("名称已被使用");
		}
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseSfSite baseSfSite = BeanUtil.a2b(vo, BaseSfSite.class);
		vo.setTreePath(area.getTreePath());
		baseSfSiteService.add(baseSfSite);
	}

	@Override
	public void deleteById(Integer id) {
		baseSfSiteService.deleteById(id);
	}

	@Override
	public BaseSfSiteVo findById(Integer id) {
		BaseSfSite baseSfSite =  baseSfSiteService.findById(id);
		BaseSfSiteVo baseSfSiteVo = BeanUtil.a2b(baseSfSite, BaseSfSiteVo.class);
		BaseSfArea area = baseSfAreaService.findById(baseSfSite.getAreaId());
		if(Checker.isNotEmpty(area)){
			baseSfSiteVo.setTreeId(area.getTreeId());
		}
		return baseSfSiteVo;
	}

	@Override
	public Boolean delete(Integer id, Boolean isDelete) {
		int result = 0;
		int hasUserAssitant = userAssistantService.queryAssistantByApply(4, id);
		if(hasUserAssitant>0){
			throw new BusinessException("必须先禁用所属的球包助理");
		}else{
			result = baseSfSiteService.deleteById2(id, isDelete);
		}
		return result > 0;
	}

}

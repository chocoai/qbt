package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseBank;
import com.qbt.persistent.entity.BaseInsuredTemplate;
import com.qbt.service.BaseInsuredTemplateService;
import com.qbt.web.pojo.baseInsTemp.BaseInsTempPageReqVo;
import com.qbt.web.pojo.baseInsTemp.BaseInsTempVo;
import com.qbt.web.support.BaseInsTempSupport;

@Service
public class BaseInsTempSupportImpl implements BaseInsTempSupport{
	
	@Resource
	private BaseInsuredTemplateService baseInsuredTemplateService;
	
	@Override
	public List<BaseInsTempVo> findByPage(BaseInsTempPageReqVo reqVo) {
		PageEntity<BaseInsuredTemplate> pageEntity = BeanUtil.pageConvert(reqVo, BaseInsuredTemplate.class);
		List<BaseInsuredTemplate> list = baseInsuredTemplateService.findByPage(pageEntity);
		List<BaseInsTempVo> voList = BeanUtil.list2list(list, BaseInsTempVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void deleteById(Integer id) {
		baseInsuredTemplateService.deleteById(id);
	}
	
	@Override
	public void add(BaseInsTempVo vo) throws BusinessException{
		BaseInsuredTemplate condition = new BaseInsuredTemplate();
		condition.setName(vo.getName());
		List<BaseBank> qryList = baseInsuredTemplateService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException("名称已被使用");
		}
		BaseInsuredTemplate baseInsuredTemplate = BeanUtil.a2b(vo, BaseInsuredTemplate.class);
		baseInsuredTemplateService.insert(baseInsuredTemplate);		
	}
	
	@Override
	public void update(BaseInsTempVo vo) {
		BaseInsuredTemplate baseInsuredTemplate = BeanUtil.a2b(vo, BaseInsuredTemplate.class);
		baseInsuredTemplateService.update(baseInsuredTemplate);
	}
	
	
	
	@Override
	public BaseInsuredTemplate insureValidPrice(double price) {
		BaseInsuredTemplate template = baseInsuredTemplateService.findValid();
		if(template == null){
			throw new BusinessException(ErrorCodeEnum.ERROR_NODB_CONFIG);
		}
		double free = template.getFreeInsured().doubleValue();
		double min = template.getInsuredMinimum().doubleValue();
		double max = template.getInsuredMaximum().doubleValue();
		double rate = template.getInsuredRates().doubleValue();
		if(min > price ){
			new BusinessException(ErrorCodeEnum.ERROR_NODB_CONFIG.getCode(),"保价金额不能小于"+template.getInsuredMinimum().intValue()+"万元");
		}
		if(max < price ){
			new BusinessException(ErrorCodeEnum.ERROR_NODB_CONFIG.getCode(),"保价金额不能大于"+template.getInsuredMaximum().intValue()+"万元");
		}
		return template;
	}

}

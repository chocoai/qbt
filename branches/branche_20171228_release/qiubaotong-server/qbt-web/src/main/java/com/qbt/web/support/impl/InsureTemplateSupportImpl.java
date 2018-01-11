package com.qbt.web.support.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.result.Result;
import com.qbt.common.util.Arith;
import com.qbt.persistent.entity.BaseInsuredTemplate;
import com.qbt.service.BaseInsuredTemplateService;
import com.qbt.web.pojo.base.BaseInsuredTemplateVo;
import com.qbt.web.support.InsureTemplateSupport;

@Service
public class InsureTemplateSupportImpl implements InsureTemplateSupport {

	@Resource
	private BaseInsuredTemplateService baseInsuredTemplateService;
	
	@Override
	public Double insureValidPrice(double price, int rateType) {
		Result<Double> result = new Result<Double>();
		BaseInsuredTemplate template = baseInsuredTemplateService.findValid();
		if(template == null){
			result.setError(ErrorCodeEnum.ERROR_NODB_CONFIG);
			return 0d;
		}
		double free = template.getFreeInsured().doubleValue();
		double min = template.getInsuredMinimum().doubleValue();
		double max = template.getInsuredMaximum().doubleValue();
		double rate = rateType == 1 ? template.getInsuredRates().doubleValue() : template.getInsuredOriginRates().doubleValue();
		if(price < min){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "保价金额不能小于"+template.getInsuredMinimum().intValue()+"万元");
		}
		if(price > max){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "保价金额不能大于"+template.getInsuredMaximum().intValue()+"万元");
		}
		double money = Arith.mul(Arith.mul(price, 10000),rate) - Arith.mul(Arith.mul(free, 10000),rate);
		if(money < 0) money = 0d;
		return money;
	}

	/**
	 *  查询有效费率
	  * @Title: findValid
	  * @Description: TODO
	  * @author: share 2016年9月8日
	  * @modify: share 2016年9月8日
	  * @return
	  * @see com.qbt.web.support.InsureTemplateSupport#findValid()
	 */
	@Override
	public BaseInsuredTemplate findValid() {
		BaseInsuredTemplate template = baseInsuredTemplateService.findValid();
		return template;
	}

	@Override
	public BaseInsuredTemplateVo queryTemplate() {
		BaseInsuredTemplate template = baseInsuredTemplateService.findValid();
		BaseInsuredTemplateVo templateVo = new BaseInsuredTemplateVo();
		templateVo.setMin(template.getInsuredMinimum().doubleValue());
		templateVo.setMax(template.getInsuredMaximum().doubleValue());
		return templateVo;
	}

}

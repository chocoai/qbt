package com.qbt.web.support;

import com.qbt.persistent.entity.BaseInsuredTemplate;
import com.qbt.web.pojo.base.BaseInsuredTemplateVo;

public interface InsureTemplateSupport {
	
	/**
	 * 
	 * insureValidPrice:(计算保价费用).
	 *
	 * @author huangyihao
	 * 2017年6月9日 下午2:24:39
	 * @param price 保价金额(万元)
	 * @param rateType 1-优惠保价率 2-原保价率
	 * @return
	 *
	 */
	public Double insureValidPrice(double price, int rateType);
	
	public BaseInsuredTemplate findValid();
	
	public BaseInsuredTemplateVo queryTemplate();
}

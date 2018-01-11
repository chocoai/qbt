package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseBank;
import com.qbt.service.BaseBankService;
import com.qbt.service.UserAssistantService;
import com.qbt.web.pojo.baseBank.BaseBankPageReqVo;
import com.qbt.web.pojo.baseBank.BaseBankVo;
import com.qbt.web.support.BaseBankSupport;

@Service
public class BaseBankSupportImpl implements BaseBankSupport {

	@Resource
	private BaseBankService baseBankService;
	@Resource
	private UserAssistantService userAssistantService;
	
	@Override
	public List<BaseBankVo> findByPage(BaseBankPageReqVo reqVo) {
		PageEntity<BaseBank> pageEntity = BeanUtil.pageConvert(reqVo, BaseBank.class);
		List<BaseBank> list = baseBankService.findByPage(pageEntity);
		List<BaseBankVo> voList = BeanUtil.list2list(list, BaseBankVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseBankVo vo) throws BusinessException {
		BaseBank condition = new BaseBank();
		condition.setName(vo.getName());
		List<BaseBank> qryList = baseBankService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException("名称已被使用");
		}
		BaseBank baseBank = BeanUtil.a2b(vo, BaseBank.class);
		baseBankService.add(baseBank);
	}

	@Override
	public void updateById(BaseBankVo vo) {
		BaseBank baseBank = BeanUtil.a2b(vo, BaseBank.class);
		baseBankService.updateById(baseBank);
	}

	@Override
	public Boolean delete(Integer id, Boolean isDelete) {
		int result = 0;
		int hasUserAssitant = userAssistantService.queryAssistantByApply(3, id);
		if(hasUserAssitant>0){
			throw new BusinessException("必须先禁用所属的球包助理");
		}else{
			result = baseBankService.deleteById(id, isDelete);
		}
		return result > 0;
	}
}
	


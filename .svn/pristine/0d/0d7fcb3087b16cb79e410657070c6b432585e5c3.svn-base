package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseBankBranch;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.service.BaseBankBranchService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.UserAssistantService;
import com.qbt.web.pojo.baseBankBranch.BaseBankBranchPageReqVo;
import com.qbt.web.pojo.baseBankBranch.BaseBankBranchVo;
import com.qbt.web.support.BaseBankBranchSupport;

@Service
public class BaseBankBranchSupportImpl implements BaseBankBranchSupport {

	@Resource
	private BaseBankBranchService baseBankBranchService; 
	@Resource
	private BaseSfAreaService baseSfAreaService;
	@Resource
	private UserAssistantService userAssistantService;
	
	@Override
	public List<BaseBankBranchVo> findByPage(BaseBankBranchPageReqVo reqVo) {
		PageEntity<BaseBankBranch> pageEntity = BeanUtil.pageConvert(reqVo, BaseBankBranch.class);
		
		List<BaseBankBranch> list = baseBankBranchService.findByPage(pageEntity);
		List<BaseBankBranchVo> voList = BeanUtil.list2list(list, BaseBankBranchVo.class);
		
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseBankBranchVo vo) throws BusinessException {
		BaseBankBranch condition = new BaseBankBranch();
		condition.setName(vo.getName());
		List<BaseBankBranch> qryList = baseBankBranchService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException("网点名称已被使用");
		}
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseBankBranch baseBankBranch = BeanUtil.a2b(vo, BaseBankBranch.class);
		baseBankBranch.setTreePath(area.getTreePath());
		baseBankBranchService.add(baseBankBranch);
	}

	@Override
	public void updateById(BaseBankBranchVo vo) throws BusinessException{
		BaseBankBranch condition = new BaseBankBranch();
		BaseBankBranch b = baseBankBranchService.findById(vo.getId());
		if (!vo.getName().equals(b.getName())) {
			condition.setName(vo.getName());
			List<BaseBankBranch> qryList = baseBankBranchService.findByCondition(condition);
			if (Checker.isNotEmpty(qryList)) {
				throw new BusinessException("网点名称已被使用");
			}
		}
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseBankBranch baseBankBranch = BeanUtil.a2b(vo, BaseBankBranch.class);
		baseBankBranch.setTreePath(area.getTreePath());
		baseBankBranchService.udateById(baseBankBranch);
	}

	@Override
	public void deleteById(Integer id) {
		baseBankBranchService.deleteById(id);
	}

	@Override
	public BaseBankBranchVo findById(Integer id) {
		BaseBankBranch baseBankBranch = baseBankBranchService.findById(id);
		BaseBankBranchVo baseBankBranchVo = BeanUtil.a2b(baseBankBranch, BaseBankBranchVo.class);
		BaseSfArea area = baseSfAreaService.findById(baseBankBranch.getAreaId());
		if(Checker.isNotEmpty(area)){
			baseBankBranchVo.setTreeId(area.getTreeId());
		}
		return baseBankBranchVo;
	}

	@Override
	public Boolean delete(Integer id, Boolean isDelete) {
		int result = 0;
		int hasUserAssitant = userAssistantService.queryAssistantByApply(3, id);
		if(hasUserAssitant>0){
			throw new BusinessException("必须先禁用所属的球包助理");
		}else{
			result = baseBankBranchService.delete(id, isDelete);
		}
		return result > 0;
	}

}

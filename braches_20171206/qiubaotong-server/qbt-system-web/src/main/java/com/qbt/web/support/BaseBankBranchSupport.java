package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.baseBankBranch.BaseBankBranchPageReqVo;
import com.qbt.web.pojo.baseBankBranch.BaseBankBranchVo;

public interface BaseBankBranchSupport {

	List<BaseBankBranchVo> findByPage(BaseBankBranchPageReqVo reqVo);

	void add(BaseBankBranchVo vo) throws BusinessException ;

	void updateById(BaseBankBranchVo vo) throws BusinessException;

	void deleteById(Integer id);

	BaseBankBranchVo findById(Integer id);

	Boolean delete(Integer id, Boolean isDelete);

}

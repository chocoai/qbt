package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.userAddress.UserAddressPageReqVo;
import com.qbt.web.pojo.userAddress.UserAddressVo;

public interface UserAddressSupport {
	
	/**
	 * 根据用户分页查询地址列表
	 * @param reqVo
	 * @return
	 */
	List<UserAddressVo> findByPage(UserAddressPageReqVo reqVo);

	int add(UserAddressVo vo) throws BusinessException;

	List<UserAddressVo> findListByUserId(UserAddressPageReqVo reqVo);

}

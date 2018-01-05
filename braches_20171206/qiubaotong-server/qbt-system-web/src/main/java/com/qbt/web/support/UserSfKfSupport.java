package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.sfkf.UserSfKfPageReqVo;
import com.qbt.web.pojo.sfkf.UserSfKfVo;

public interface UserSfKfSupport {
	
	/**
	 * 分页查询顺丰客服
	 * @param reqVo
	 * @return
	 */
	List<UserSfKfVo> findByPage(UserSfKfPageReqVo reqVo);
	
	/**
	 * 新增顺丰客服
	 * @param vo
	 * @return
	 */
	int add(UserSfKfVo vo) throws BusinessException;
	
	/**
	 * 删除顺丰客服
	 * @param id
	 */
	boolean delete(Integer id);
	
	/**
	 * 查询顺丰客服列表
	 * @return
	 */
	List<UserSfKfVo> list();
}

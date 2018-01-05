package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.sfkf.UserKfTimeRangeMapVo;
import com.qbt.web.pojo.sfkf.UserKfTimeRangeVo;

public interface UserKfTimeRangeSupport {
	
	/**
	 * 查询所有顺丰客服服务时间
	 * @return key:星期, value:顺丰客服服务时间集合
	 */
	List<UserKfTimeRangeMapVo> findAllMap();
	
	/**
	 * 根据id删除顺丰客服服务时间
	 * @param id
	 */
	boolean deleteById(Integer id);
	
	/**
	 * 新增顺丰客服服务时间
	 * @param vo
	 * @return
	 */
	int add(UserKfTimeRangeVo vo) throws BusinessException;
}

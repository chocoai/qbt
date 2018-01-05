/**
 * Project Name:qbt-persistent
 * File Name:BasePopUpConfigServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年1月16日下午4:45:52
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BasePopUpConfig;
import com.qbt.persistent.mapper.BasePopUpConfigMapper;
import com.qbt.service.BasePopUpConfigService;

/**
 * ClassName:BasePopUpConfigServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月16日 下午4:45:52
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BasePopUpConfigServiceImpl implements BasePopUpConfigService {
	
	@Resource
	private BasePopUpConfigMapper basePopUpConfigMapper;
	
	@Override
	public int insert(BasePopUpConfig basePopUpConfig) {
		basePopUpConfigMapper.insert(basePopUpConfig);
		return basePopUpConfig.getId();
	}

	@Override
	public BasePopUpConfig findById(Integer id) {
		return basePopUpConfigMapper.selectById(id);
	}

	@Override
	public int insertBatch(List<BasePopUpConfig> configs) {
		return basePopUpConfigMapper.insertBatch(configs);
	}

	@Override
	public int deleteByPopUpId(Integer popUpId) {
		return basePopUpConfigMapper.deleteByPopUpId(popUpId);
	}

	@Override
	public List<BasePopUpConfig> findByPopUpId(Integer popUpId) {
		return basePopUpConfigMapper.findByPopUpId(popUpId);
	}

}

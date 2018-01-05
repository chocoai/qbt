/**
 * Project Name:qbt-persistent
 * File Name:OrgGroupAmountConfigServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年8月1日下午2:45:46
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrgGroupAmountConfig;
import com.qbt.persistent.mapper.OrgGroupAmountConfigMapper;
import com.qbt.service.OrgGroupAmountConfigService;

/**
 * ClassName:OrgGroupAmountConfigServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月1日 下午2:45:46
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrgGroupAmountConfigServiceImpl implements OrgGroupAmountConfigService {
	
	@Resource
	private OrgGroupAmountConfigMapper orgGroupAmountConfigMapper;
	
	@Override
	public int insert(OrgGroupAmountConfig orgGroupAmountConfig) {
		orgGroupAmountConfigMapper.insert(orgGroupAmountConfig);
		return orgGroupAmountConfig.getId();
	}

	@Override
	public OrgGroupAmountConfig selectById(Integer id) {
		return orgGroupAmountConfigMapper.selectById(id);
	}

	@Override
	public int updateById(OrgGroupAmountConfig orgGroupAmountConfig) {
		return orgGroupAmountConfigMapper.updateById(orgGroupAmountConfig);
	}

	@Override
	public List<OrgGroupAmountConfig> selectByOrgId(Integer orgId) {
		return orgGroupAmountConfigMapper.selectByOrgId(orgId);
	}

	@Override
	public int deleteByOrgId(Integer orgId) {
		return orgGroupAmountConfigMapper.deleteByOrgId(orgId);
	}

	@Override
	public int insertByBatch(List<OrgGroupAmountConfig> configs) {
		return orgGroupAmountConfigMapper.insertByBatch(configs);
	}

	@Override
	public List<OrgGroupAmountConfig> list() {
		return orgGroupAmountConfigMapper.list();
	}

	@Override
	public OrgGroupAmountConfig selectProperAmountConfig(Double amount,  Integer orgId) {
		return orgGroupAmountConfigMapper.selectProperAmountConfig(amount, orgId);
	}

}

/**
 * Project Name:qbt-persistent
 * File Name:BaseAdvertServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年10月10日上午10:19:17
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseAdvert;
import com.qbt.persistent.mapper.BaseAdvertMapper;
import com.qbt.service.BaseAdvertService;

/**
 * ClassName:BaseAdvertServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月10日 上午10:19:17
 * @author   wuwang
 * @version  
 * @see 	 
 */
@Service
public class BaseAdvertServiceImpl implements BaseAdvertService{

	@Resource
	private BaseAdvertMapper baseAdvertMapper;
	
	@Override
	public List<BaseAdvert> findByPage(PageEntity<BaseAdvert> pageEntity) {
		return baseAdvertMapper.findByPage(pageEntity);
	}

	@Override
	public void updateStatus(Integer id, int status) {
		baseAdvertMapper.updateStatus(id, status);
	}

	@Override
	public BaseAdvert findById(Integer id) {
		return baseAdvertMapper.findById(id);
	}

	@Override
	public void udateById(BaseAdvert baseAdv) {
		baseAdvertMapper.updateById(baseAdv);
	}

	@Override
	public BaseAdvert listByCode(String code, Integer flatType) {
		return baseAdvertMapper.listByCode(code, flatType);
	}

}

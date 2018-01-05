/**
 * Project Name:qbt-persistent
 * File Name:BaseSfTimeServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年4月6日上午10:12:26
 *
*/

package com.qbt.service.impl;

import java.util.List;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseSfTime;
import com.qbt.persistent.mapper.BaseSfTimeMapper;
import com.qbt.service.BaseSfTimeService;

/**
 * ClassName:BaseSfTimeServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年4月6日 上午10:12:26
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BaseSfTimeServiceImpl implements BaseSfTimeService {
	
	@Resource
	private BaseSfTimeMapper baseSfTimeMapper;
	
	@Override
	public int insert(BaseSfTime baseSfTime) {
		baseSfTimeMapper.insert(baseSfTime);
		return baseSfTime.getId();
	}

	@Override
	public BaseSfTime findById(Integer id) {
		return baseSfTimeMapper.selectById(id);
	}

	@Override
	public int updateById(BaseSfTime baseSfTime) {
		return baseSfTimeMapper.updateById(baseSfTime);
	}

	@Override
	public List<BaseSfTime> findByPage(PageEntity<BaseSfTime> pageEntity) {
		return baseSfTimeMapper.findByPage(pageEntity);
	}
	
	public BaseSfTime findByDate(Date date) {
		return baseSfTimeMapper.selectByDate(date);
	}

	@Override
	public void deleteById(Integer id) {
		baseSfTimeMapper.deleteById(id);
	}

	@Override
	public List<BaseSfTime> findByCondition(BaseSfTime condition) {
		return baseSfTimeMapper.findByCondition(condition);
	}

}

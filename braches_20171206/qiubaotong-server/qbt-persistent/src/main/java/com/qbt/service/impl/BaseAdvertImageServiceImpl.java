/**
 * Project Name:qbt-persistent
 * File Name:BaseAdvertImageServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年10月10日上午11:53:11
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BaseAdvertImage;
import com.qbt.persistent.mapper.BaseAdvertImageMapper;
import com.qbt.service.BaseAdvertImageService;

/**
 * ClassName:BaseAdvertImageServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月10日 上午11:53:11
 * @author   wuwang
 * @version  
 * @see 	 
 */
@Service
public class BaseAdvertImageServiceImpl implements BaseAdvertImageService{

	@Resource
	private BaseAdvertImageMapper baseAdvertImageMapper; 
	
	@Override
	public List<BaseAdvertImage> findListByAdvertCode(String advertCode) {
		return baseAdvertImageMapper.findListByAdvertCode(advertCode);
	}

	@Override
	public void deleteByAdvertCode(String advertCode) {
		baseAdvertImageMapper.deleteByAdvertCode(advertCode);
	}

	@Override
	public void insertByBatch(List<BaseAdvertImage> insertImageList) {
		baseAdvertImageMapper.insertByBatch(insertImageList);
	}

}

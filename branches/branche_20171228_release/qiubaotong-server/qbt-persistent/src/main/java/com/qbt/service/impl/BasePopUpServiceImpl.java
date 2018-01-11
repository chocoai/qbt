/**
 * Project Name:qbt-persistent
 * File Name:BasePopUpServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年1月16日下午4:43:14
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BasePopUp;
import com.qbt.persistent.mapper.BasePopUpMapper;
import com.qbt.service.BasePopUpService;

/**
 * ClassName:BasePopUpServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月16日 下午4:43:14
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BasePopUpServiceImpl implements BasePopUpService {
	
	@Resource
	private BasePopUpMapper basePopUpMapper;
	
	@Override
	public int insert(BasePopUp basePopUp) {
		basePopUpMapper.insert(basePopUp);
		return basePopUp.getId();
	}

	@Override
	public BasePopUp findById(Integer id) {
		return basePopUpMapper.selectById(id);
	}

	@Override
	public int updateById(BasePopUp basePopUp) {
		return basePopUpMapper.updateById(basePopUp);
	}

	@Override
	public int deleteById(Integer id) {
		return basePopUpMapper.deleteById(id);
	}

	@Override
	public List<BasePopUp> findByPage(PageEntity<BasePopUp> pageEntity) {
		return basePopUpMapper.findByPage(pageEntity);
	}

	@Override
	public List<BasePopUp> query(BasePopUp popUp) {
		// TODO Auto-generated method stub
		return basePopUpMapper.query(popUp);
	}

}

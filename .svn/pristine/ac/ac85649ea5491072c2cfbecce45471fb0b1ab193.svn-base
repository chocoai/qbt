package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.SupLanguageMobile;
import com.qbt.service.SupLanguageMobileService;
import com.qbt.web.pojo.languageMobile.LanguageMobilePageReqVo;
import com.qbt.web.pojo.languageMobile.LanguageMobileVo;
import com.qbt.web.support.LanguageMobileSupport;

@Service
public class LanguageMobileSupportImpl implements LanguageMobileSupport {
	
	@Resource
	private SupLanguageMobileService supLanguageMobileService;
	
	@Override
	public int add(LanguageMobileVo vo) {
		//手机号重复性校验
		boolean flag = supLanguageMobileService.exists(vo.getMobile());
		if(flag){
			throw new BusinessException("手机号已存在");
		}
		SupLanguageMobile slm = BeanUtil.a2b(vo, SupLanguageMobile.class);
		return supLanguageMobileService.insert(slm);
	}

	@Override
	public boolean delete(String mobile) {
		return supLanguageMobileService.delete(mobile) > 0;
	}

	@Override
	public List<LanguageMobileVo> findByPage(LanguageMobilePageReqVo reqVo) {
		PageEntity<SupLanguageMobile> pageEntity = BeanUtil.pageConvert(reqVo, SupLanguageMobile.class);
		List<SupLanguageMobile> list = supLanguageMobileService.findByPage(pageEntity);
		List<LanguageMobileVo> voList = BeanUtil.list2list(list, LanguageMobileVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}

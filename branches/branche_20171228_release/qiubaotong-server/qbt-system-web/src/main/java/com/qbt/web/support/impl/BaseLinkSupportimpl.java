package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseLink;
import com.qbt.service.BaseLinkService;
import com.qbt.web.pojo.baselink.BaseLinkPageReqVo;
import com.qbt.web.pojo.baselink.BaseLinkVo;
import com.qbt.web.support.BaseLinkSupport;

@Service
public class BaseLinkSupportimpl implements BaseLinkSupport {

	@Resource
	private BaseLinkService baseLinkService;

	@Override
	public List<BaseLinkVo> findByPage(BaseLinkPageReqVo reqVo) {
		PageEntity<BaseLink> pageEntity = BeanUtil.pageConvert(reqVo, BaseLink.class);

		List<BaseLink> list = baseLinkService.findByPage(pageEntity);
		List<BaseLinkVo> voList = BeanUtil.list2list(list, BaseLinkVo.class);
		
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseLinkVo vo) {
		BaseLink base = new BaseLink();
		base.setName(vo.getName());
		List<BaseLink> Blist= baseLinkService.findByCondition(base);
		if (Checker.isNotEmpty(Blist)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(),"该链接名称已经被使用");
		}
		BaseLink baseLink = BeanUtil.a2b(vo, BaseLink.class);
		baseLinkService.add(baseLink);
	}

	@Override
	public void update(BaseLinkVo vo) {
		BaseLink baseLink = BeanUtil.a2b(vo, BaseLink.class);
		baseLinkService.updateById(baseLink);

	}

	@Override
	public BaseLinkVo findById(Integer id) {
		BaseLink baseLink = baseLinkService.findById(id);
		BaseLinkVo baseLinkVo = BeanUtil.a2b(baseLink, BaseLinkVo.class);
		return baseLinkVo;
	}

	@Override
	public void delete(Integer id) {
		baseLinkService.delete(id);
	}

	@Override
	public List<BaseLinkVo> list() {
		List<BaseLink> list = baseLinkService.list();
		List<BaseLinkVo> voList = BeanUtil.list2list(list, BaseLinkVo.class);
		return voList;
	}

}

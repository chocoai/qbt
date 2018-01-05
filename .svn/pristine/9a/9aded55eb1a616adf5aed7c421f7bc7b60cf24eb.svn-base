package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.UserKf;
import com.qbt.service.UserKfService;
import com.qbt.web.pojo.kf.UserKfPageReqVo;
import com.qbt.web.pojo.kf.UserKfVo;
import com.qbt.web.support.UserKfSupport;

@Service
public class UserKfSupportImpl implements UserKfSupport {
	
	@Resource
	private UserKfService userKfService;
	
	@Override
	public int add(UserKfVo vo) {
		UserKf userKf = BeanUtil.a2b(vo, UserKf.class);
		UserKf condition = new UserKf();
		condition.setUserId(vo.getUserId());
		condition.setType(vo.getType());
		List<UserKf> userKfList = userKfService.findByCondition(condition);
		if(Checker.isNotEmpty(userKfList)){
			throw new BusinessException("用户id或类型不能重复");
		}
		return userKfService.insert(userKf);
	}

	@Override
	public boolean delete(Integer id) {
		return userKfService.delete(id) > 0;
	}

	@Override
	public boolean updateById(UserKfVo vo) {
		UserKf userKf = BeanUtil.a2b(vo, UserKf.class);
		return userKfService.updateById(userKf) > 0;
	}

	@Override
	public UserKfVo findById(Integer id) {
		UserKf kf = userKfService.selectById(id);
		UserKfVo vo = BeanUtil.a2b(kf, UserKfVo.class);
		return vo;
	}

	@Override
	public List<UserKfVo> findByPage(UserKfPageReqVo reqVo) {
		PageEntity<UserKf> pageEntity = BeanUtil.pageConvert(reqVo, UserKf.class);
		List<UserKf> list = userKfService.findByPage(pageEntity);
		List<UserKfVo> voList = BeanUtil.list2list(list, UserKfVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.UserSfKf;
import com.qbt.service.UserKfTimeRangeService;
import com.qbt.service.UserSfKfService;
import com.qbt.web.pojo.sfkf.UserSfKfPageReqVo;
import com.qbt.web.pojo.sfkf.UserSfKfVo;
import com.qbt.web.support.UserSfKfSupport;

@Service
public class UserSfKfSupportImpl implements UserSfKfSupport {
	
	@Resource
	private UserSfKfService userSfKfService;
	
	@Resource
	private UserKfTimeRangeService userKfTimeRangeService;
	
	@Override
	public List<UserSfKfVo> findByPage(UserSfKfPageReqVo reqVo) {
		PageEntity<UserSfKf> pageEntity = BeanUtil.pageConvert(reqVo, UserSfKf.class);
		List<UserSfKf> list = userSfKfService.findByPage(pageEntity);
		List<UserSfKfVo> voList = BeanUtil.list2list(list, UserSfKfVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public int add(UserSfKfVo vo) throws BusinessException {
		//查询有无重复的客服姓名或手机号
		int count = userSfKfService.isExist(vo.getName(), vo.getMobile());
		if(count > 0){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "已存在该客服或手机");
		}
		UserSfKf kf = BeanUtil.a2b(vo, UserSfKf.class);
		int id = userSfKfService.insert(kf);
		return id;
	}

	@Override
	public boolean delete(Integer id) {
		int result = userSfKfService.delete(id);
		if(result > 0){
			userKfTimeRangeService.deleteByServiceId(id);
			return true;
		}
		return false;
	}

	@Override
	public List<UserSfKfVo> list() {
		List<UserSfKf> list = userSfKfService.findAll();
		List<UserSfKfVo> voList = BeanUtil.list2list(list, UserSfKfVo.class);
		return voList;
	}

}

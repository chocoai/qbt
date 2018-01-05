package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseBallTeam;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.service.BaseBallTeamService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.web.pojo.baseBallTeam.BaseBallTeamPageReqVo;
import com.qbt.web.pojo.baseBallTeam.BaseBallTeamVo;
import com.qbt.web.support.BaseBallTeamSupport;

@Service
public class BaseBallTeamSupportImpl implements BaseBallTeamSupport{

	@Resource
	private BaseBallTeamService baseBallTeamService;
	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Override
	public List<BaseBallTeamVo> findByPage(BaseBallTeamPageReqVo reqVo) {
		PageEntity<BaseBallTeam> pageEntity = BeanUtil.pageConvert(reqVo, BaseBallTeam.class);
		List<BaseBallTeam> list = baseBallTeamService.findByPage(pageEntity);
		List<BaseBallTeamVo> voList = BeanUtil.list2list(list, BaseBallTeamVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseBallTeamVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseBallTeam baseBallTeam = BeanUtil.a2b(vo, BaseBallTeam.class);
		baseBallTeam.setTreePath(area.getTreePath());
		baseBallTeamService.add(baseBallTeam);
		
	}

	@Override
	public void updateById(BaseBallTeamVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseBallTeam baseBallTeam = BeanUtil.a2b(vo, BaseBallTeam.class);
		baseBallTeam.setTreePath(area.getTreePath());
		baseBallTeamService.update(baseBallTeam);
		
	}

	@Override
	public BaseBallTeamVo findById(Integer id) {
		BaseBallTeam baseTeachCenter =  baseBallTeamService.findById(id);
		BaseBallTeamVo vo = BeanUtil.a2b(baseTeachCenter, BaseBallTeamVo.class);
		BaseSfArea area = baseSfAreaService.findById(baseTeachCenter.getAreaId());
		if(Checker.isNotEmpty(area)){
			vo.setTreeId(area.getTreeId());
		}
		return vo;
	}

	@Override
	public void deleteById(Integer id) {
		baseBallTeamService.deleteById(id);
	}

}

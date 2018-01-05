package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseAirport;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.service.BaseAirportService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.UserAssistantService;
import com.qbt.web.pojo.airport.AirportPageReqVo;
import com.qbt.web.pojo.airport.BaseAirportVo;
import com.qbt.web.support.AirportSupport;

@Service
public class AirportSupportImpl implements AirportSupport {

	@Resource
	private BaseAirportService baseAirportService;
	
	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Resource
	private UserAssistantService userAssistantService;
	
	@Override
	public List<BaseAirportVo> findByPage(AirportPageReqVo reqVo) {
		PageEntity<BaseAirport> pageEntity = BeanUtil.pageConvert(reqVo, BaseAirport.class);
		
		List<BaseAirport> list = baseAirportService.findByPage(pageEntity);
		List<BaseAirportVo> voList = BeanUtil.list2list(list, BaseAirportVo.class);
		
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public BaseAirportVo findById(Integer id) {
		BaseAirport baseAirport = baseAirportService.findById(id);
		BaseAirportVo vo = BeanUtil.a2b(baseAirport, BaseAirportVo.class);
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isNotEmpty(area)){
			vo.setTreeId(area.getTreeId());
		}
		return vo;
	}

	@Override
	public int add(BaseAirportVo vo) throws BusinessException {
		//查询是否重名
		BaseAirport condition = new BaseAirport();
		condition.setName(vo.getName());
		List<BaseAirport> qryList = baseAirportService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException("机场名称已被使用");
		}
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		
		BaseAirport baseAirport = BeanUtil.a2b(vo, BaseAirport.class);
		baseAirport.setTreePath(area.getTreePath());
		return baseAirportService.insert(baseAirport);
	}

	@Override
	public boolean update(BaseAirportVo vo) throws BusinessException {
		BaseAirport query = baseAirportService.findById(vo.getId());
		if(Checker.isNotEmpty(query)){
			if(!query.getName().equals(vo.getName())){
				//查询是否重名
				BaseAirport condition = new BaseAirport();
				condition.setName(vo.getName());
				List<BaseAirport> qryList = baseAirportService.findByCondition(condition);
				if(Checker.isNotEmpty(qryList)){
					throw new BusinessException("机场名称已被使用");
				}
			}
			
			BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
			if(Checker.isEmpty(area)){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
			}
			
			BaseAirport baseAirport = BeanUtil.a2b(vo, BaseAirport.class);
			baseAirport.setTreePath(area.getTreePath());
			return baseAirportService.update(baseAirport) > 0;
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		return baseAirportService.deleteById(id) > 0;
	}

	@Override
	public Boolean deleteById(Integer id, Boolean isDelete) {
		int result = 0;
		int hasUserAssitant = userAssistantService.queryAssistantByApply(5, id);
		if(hasUserAssitant>0){
			throw new BusinessException("必须先禁用所属的球包助理");
		}else{
			result = baseAirportService.delete(id, isDelete);
		}
		return result > 0;
	}

}

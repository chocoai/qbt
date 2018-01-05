package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.UserKfTimeRange;
import com.qbt.service.UserKfTimeRangeService;
import com.qbt.web.pojo.sfkf.UserKfTimeRangeMapVo;
import com.qbt.web.pojo.sfkf.UserKfTimeRangeVo;
import com.qbt.web.support.UserKfTimeRangeSupport;

@Service
public class UserKfTimeRangeSupportImpl implements UserKfTimeRangeSupport {
	
	@Resource
	private UserKfTimeRangeService userKfTimeRangeService;
	
	@Override
	public List<UserKfTimeRangeMapVo> findAllMap() {
		List<UserKfTimeRange> list = userKfTimeRangeService.findAll();
		Map<Integer, List<UserKfTimeRangeVo>> map = new TreeMap<Integer, List<UserKfTimeRangeVo>>();
		List<UserKfTimeRangeMapVo> voList = new ArrayList<UserKfTimeRangeMapVo>();
		if(Checker.isNotEmpty(list)){
			List<UserKfTimeRangeVo> uList = null;
			UserKfTimeRangeVo vo = null;
			for(UserKfTimeRange u : list){
				uList = 
						map.containsKey(u.getWeekDay()) ? map.get(u.getWeekDay()) : new ArrayList<UserKfTimeRangeVo>();
				vo = BeanUtil.a2b(u, UserKfTimeRangeVo.class);
				uList.add(vo);
				map.put(u.getWeekDay(), uList);
			}
			
			UserKfTimeRangeMapVo mapVo = null;
			for(Integer week : map.keySet()){
				mapVo = new UserKfTimeRangeMapVo();
				mapVo.setWeekDay(week);
				mapVo.setItems(map.get(week));
				voList.add(mapVo);
			}
		}
		return voList;
	}

	@Override
	public boolean deleteById(Integer id) {
		return userKfTimeRangeService.deleteById(id) > 0;
	}

	@Override
	public int add(UserKfTimeRangeVo vo)  throws BusinessException {
		UserKfTimeRange condition = new UserKfTimeRange();
		condition.setWeekDay(vo.getWeekDay());
		List<UserKfTimeRange> weekDayList = userKfTimeRangeService.findByCondition(condition);
		//初始化时间标记数组
		boolean[] timeArray = new boolean[24];
		//根据查询结果标记数组
		if(Checker.isNotEmpty(weekDayList)){
			for(UserKfTimeRange u : weekDayList){
				for(int i = u.getBegin(); i < u.getEnd(); i++){
					timeArray[i] = true;
				}
			}
		}
		
		for(int i = vo.getBegin(); i < vo.getEnd(); i++){
			if(timeArray[i]){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "时间段重合");
			}
		}
		
		UserKfTimeRange tr = BeanUtil.a2b(vo, UserKfTimeRange.class);
		return userKfTimeRangeService.insert(tr);
	}
	
	
}

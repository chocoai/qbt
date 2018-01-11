/**
 * Project Name:qbt-system-web
 * File Name:PopUpSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年1月17日上午10:56:13
 *
*/

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BasePopUp;
import com.qbt.persistent.entity.BasePopUpConfig;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BasePopUpConfigService;
import com.qbt.service.BasePopUpService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.web.pojo.popUp.PopUpConfigVo;
import com.qbt.web.pojo.popUp.PopUpDetailVo;
import com.qbt.web.pojo.popUp.PopUpPageReqVo;
import com.qbt.web.pojo.popUp.PopUpVo;
import com.qbt.web.support.PopUpSupport;

/**
 * ClassName:PopUpSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月17日 上午10:56:13
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class PopUpSupportImpl implements PopUpSupport {
	
	@Resource
	private BasePopUpService basePopUpService;
	
	@Resource
	private BasePopUpConfigService basePopUpConfigService;
	
	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Resource
	private BaseCourseService baseCourseService;
	
	@Override
	public List<PopUpVo> findByPage(PopUpPageReqVo reqVo) {
		PageEntity<BasePopUp> pageEntity = BeanUtil.pageConvert(reqVo, BasePopUp.class);
		List<BasePopUp> list = basePopUpService.findByPage(pageEntity);
		List<PopUpVo> voList = BeanUtil.list2list(list, PopUpVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public PopUpDetailVo detail(Integer id) {
		BasePopUp popUp = basePopUpService.findById(id);
		PopUpDetailVo detailVo = BeanUtil.a2b(popUp, PopUpDetailVo.class);
		List<BasePopUpConfig> configList = basePopUpConfigService.findByPopUpId(id);
		List<PopUpConfigVo> configVoList = BeanUtil.list2list(configList, PopUpConfigVo.class);
		detailVo.setConfigs(configVoList);
		return detailVo;
	}

	@Override
	public boolean add(PopUpDetailVo vo) {
		BasePopUp popUp = BeanUtil.a2b(vo, BasePopUp.class);
		popUp.setStatus(1);//1-启用 2-禁用
		int popUpId = basePopUpService.insert(popUp);
		
		if(popUpId > 0 && vo.getConditionType() != 1){
			List<BasePopUpConfig> configList = BeanUtil.list2list(vo.getConfigs(), BasePopUpConfig.class);
			for(BasePopUpConfig c : configList){
				c.setPopUpId(popUpId);
				c.setPopUpName(popUp.getName());
				c.setConditionType(popUp.getConditionType());
				if(vo.getConditionType() == 2){
					// 球场
					BaseCourse course = baseCourseService.findById(c.getConditionId());
					c.setConditionName(course.getName());
				}else if(vo.getConditionType() == 3){
					// 地区
					BaseSfArea area = baseSfAreaService.findById(c.getConditionId());
					c.setConditionName(area.getTreePath());
				}
			}
			if(Checker.isNotEmpty(configList)){
				basePopUpConfigService.insertBatch(configList);
			}
		}
		return popUpId > 0;
	}

	@Override
	public boolean update(PopUpDetailVo vo) {
		BasePopUp popUp = BeanUtil.a2b(vo, BasePopUp.class);
		basePopUpService.updateById(popUp);
		if(vo.getConditionType() != 1){
			basePopUpConfigService.deleteByPopUpId(vo.getId());
			List<BasePopUpConfig> configList = BeanUtil.list2list(vo.getConfigs(), BasePopUpConfig.class);
			for(BasePopUpConfig c : configList){
				c.setPopUpId(vo.getId());
				c.setPopUpName(popUp.getName());
				c.setConditionType(popUp.getConditionType());
				if(vo.getConditionType() == 2){
					// 球场
					BaseCourse course = baseCourseService.findById(c.getConditionId());
					c.setConditionName(course.getName());
				}else if(vo.getConditionType() == 3){
					// 地区
					BaseSfArea area = baseSfAreaService.findById(c.getConditionId());
					c.setConditionName(area.getTreePath());
				}
			}
			if(Checker.isNotEmpty(configList)){
				basePopUpConfigService.insertBatch(configList);
			}
		}
		return true;
	}

	@Override
	public boolean delete(Integer id) {
		int result1 = basePopUpConfigService.deleteByPopUpId(id);
		int result2 = basePopUpService.deleteById(id);
		return result1 + result2 > 0;
	}

	@Override
	public boolean updateStatus(PopUpVo vo) {
		BasePopUp popUp = new BasePopUp();
		popUp.setId(vo.getId());
		popUp.setStatus(vo.getStatus());
		return basePopUpService.updateById(popUp) > 0;
	}

}

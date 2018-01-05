package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.BasePopUp;
import com.qbt.service.BasePopUpService;
import com.qbt.web.pojo.weixin.PopRequestVo;
import com.qbt.web.pojo.weixin.PopResponseVo;
import com.qbt.web.support.BasePopUpSupport;


@Service
public class BasePopUpSupportImpl implements BasePopUpSupport {

	@Resource
	private BasePopUpService basePopUpService;
	
	@Override
	public List<PopResponseVo> query(PopRequestVo vo) {
		// TODO Auto-generated method stub
		BasePopUp popUp = new BasePopUp();
		popUp.setConditionType(vo.getType());
		popUp.setPlatform(vo.getPlatform());
		if(vo.getType() > 1){
			popUp.setId(vo.getId());
		}
		return BeanUtil.list2list(basePopUpService.query(popUp), PopResponseVo.class);
	}

}

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.result.Paging;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.BaseBspAreaConfig;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.service.BaseBspAreaConfigService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.web.pojo.bspAreaConfig.BspAreaConfigVo;
import com.qbt.web.support.BspAreaConfigSupport;

@Service
public class BspAreaConfigSupportImpl implements BspAreaConfigSupport {
	
	@Resource
	private BaseBspAreaConfigService baseBspAreaConfigService;
	
	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Override
	public List<BspAreaConfigVo> findByPage(Paging paging) {
		PageEntity<BaseBspAreaConfig> pageEntity = BeanUtil.pageConvert(paging, BaseBspAreaConfig.class);
		List<BaseBspAreaConfig> list = baseBspAreaConfigService.findByPage(pageEntity);
		List<BspAreaConfigVo> voList = BeanUtil.list2list(list, BspAreaConfigVo.class);
		paging.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public int add(BspAreaConfigVo vo) {
		BaseBspAreaConfig config = new BaseBspAreaConfig();
		//源地区
		BaseSfArea srcCity = baseSfAreaService.findById(vo.getSrcAreaId());
		config.setSrcProvince(srcCity.getTreePath().split(",")[0]);
		config.setSrcCity(srcCity.getFullName());
		config.setSrcCountry(vo.getSrcCountry());
		//目标地区
		BaseSfArea destCity = baseSfAreaService.findById(vo.getDestAreaId());
		config.setDestProvince(destCity.getTreePath().split(",")[0]);
		config.setDestCity(destCity.getFullName());
		config.setDestCountry(vo.getDestCountry());
		return baseBspAreaConfigService.insert(config);
	}

	@Override
	public boolean delete(Integer id) {
		return baseBspAreaConfigService.deleteById(id) > 0;
	}

}

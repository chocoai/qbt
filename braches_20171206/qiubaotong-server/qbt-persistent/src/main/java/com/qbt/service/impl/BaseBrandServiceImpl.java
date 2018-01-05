package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossBaseBrand;
import com.qbt.persistent.entity.BaseBrand;
import com.qbt.persistent.mapper.BaseBrandMapper;
import com.qbt.service.BaseBrandService;

@Service
public class BaseBrandServiceImpl implements BaseBrandService {
	
	@Resource
	private BaseBrandMapper baseBrandMapper;
	
	@Override
	public int insert(BaseBrand baseBrand) {
		baseBrandMapper.insert(baseBrand);
		return baseBrand.getId();
	}

	@Override
	public BaseBrand selectById(Integer id) {
		return baseBrandMapper.selectById(id);
	}

	@Override
	public int updateById(BaseBrand baseBrand) {
		if(baseBrand.getId() > 0){
			return baseBrandMapper.updateById(baseBrand);
		}
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		return baseBrandMapper.deleteById(id);
	}

	@Override
	public List<BossBaseBrand> findByPage(PageEntity<BossBaseBrand> pageEntity) {
		return baseBrandMapper.findByPage(pageEntity);
	}

	@Override
	public int isExist(String bagNo, String rfidNo) {
		return baseBrandMapper.isExist(bagNo, rfidNo);
	}

}

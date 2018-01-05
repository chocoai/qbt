package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.OutRangeAddress;
import com.qbt.persistent.mapper.OutRangeAddressMapper;
import com.qbt.service.OutRangeAddressService;

@Service
public class OutRangeAddressServiceImpl implements OutRangeAddressService{

	@Resource
	private OutRangeAddressMapper outRangeAddressMapper;
	
	@Override
	public List<OutRangeAddress> findByPage(PageEntity<OutRangeAddress> pageEntity) {
		return outRangeAddressMapper.findByPage(pageEntity);
	}

	@Override
	public void insert(OutRangeAddress outRangeAddress) {
		outRangeAddressMapper.insert(outRangeAddress);
	}

	@Override
	public OutRangeAddress findByAreaId(Integer areaId,String adress) {
		OutRangeAddress entity = outRangeAddressMapper.findByAreaId(areaId);
		if(Checker.isNotEmpty(entity)) {
			if(StringUtils.isEmpty(entity.getAddress())){
				return entity;
			}else{
				String arrayString= entity.getAddress();
				String[]  array = arrayString.split(",");
				for(String str  :array){
					if(adress.contains(str)){
						return entity;
					}
				}
			}
		}
		return null;
	}
	public OutRangeAddress findById(Integer id) {
		return outRangeAddressMapper.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		outRangeAddressMapper.deleteById(id);
	}

	@Override
	public void updateById(OutRangeAddress outRangeAddress) {
		outRangeAddressMapper.updateById(outRangeAddress);
	}

	@Override
	public List<OutRangeAddress> findByCondition(OutRangeAddress condition) {
		// TODO Auto-generated method stub
		return outRangeAddressMapper.findByCondition(condition);
	}

}

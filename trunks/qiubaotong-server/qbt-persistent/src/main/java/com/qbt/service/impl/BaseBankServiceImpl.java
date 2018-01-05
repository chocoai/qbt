package com.qbt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseBank;
import com.qbt.persistent.mapper.BaseBankMapper;
import com.qbt.service.BaseBankService;

@Service
public class BaseBankServiceImpl implements BaseBankService{

	@Resource
	private BaseBankMapper baseBankMapper;
	
	@Override
	public List<BaseBank> findByPage(PageEntity<BaseBank> pageEntity) {
		// TODO Auto-generated method stub
		return baseBankMapper.findByPage(pageEntity);
	}

	@Override
	public void add(BaseBank baseBank) {
		// TODO Auto-generated method stub
		baseBankMapper.insert(baseBank);
	}

	@Override
	public void updateById(BaseBank baseBank) {
		// TODO Auto-generated method stub
		baseBankMapper.updateByPrimaryKeySelective(baseBank);
	}

	@Override
	public List<BaseBank> findByCondition(BaseBank condition) {
		// TODO Auto-generated method stub
		return baseBankMapper.findByCondition(condition);
	}

	@Override
	public int deleteById(Integer id, Boolean isDelete) {
		// TODO Auto-generated method stub
		return baseBankMapper.deleteById(id, isDelete);
	}

	@Override
	public BaseBank findById(Integer id) {
		return baseBankMapper.selectByPrimaryKey(id);
	}

}

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.mapper.DataMigrationMapper;
import com.qbt.service.DataMigrationService;


@Service
public class DataMigrationServiceImpl implements DataMigrationService {

	@Resource
	private DataMigrationMapper dataMigrationMapper;
	
	@Override
	public int insert(DataMigration data) {
		// TODO Auto-generated method stub
		return dataMigrationMapper.insert(data);
	}

	@Override
	public List<DataMigration> findByType(int type) {
		// TODO Auto-generated method stub
		return dataMigrationMapper.findByType(type);
	}

	@Override
	public int delete(int type) {
		// TODO Auto-generated method stub
		return dataMigrationMapper.delete(type);
	}

}

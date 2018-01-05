package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.DataMigration;

public interface DataMigrationService {

	int insert(DataMigration data);
	
	List<DataMigration> findByType(int type);
	
	int delete(int type);
	
}

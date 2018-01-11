package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.DataMigration;

public interface DataMigrationMapper {

	
	int insert(DataMigration data);
	
	List<DataMigration> findByType(int type);

	int delete(int type);
	
}

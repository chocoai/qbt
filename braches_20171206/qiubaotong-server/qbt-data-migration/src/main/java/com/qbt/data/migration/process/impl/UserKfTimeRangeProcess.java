package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.ServiceTimeRange;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.UserKfTimeRange;
import com.qbt.service.DataMigrationService;
import com.qbt.service.UserKfTimeRangeService;

public class UserKfTimeRangeProcess extends AbstractProcess {

	private Map<Integer, Integer> userMap = new HashMap<Integer, Integer>();
	
	public UserKfTimeRangeProcess(String name, ProcessServiceConfig config) {
		super(name, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before() {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 清除历史ID兑换数据
		dataMigrationService.delete(TableTypes.User_Kf_Time_Range.getType());
		List<DataMigration> userList = dataMigrationService.findByType(TableTypes.User_Sf_Kf.getType());
		if(Checker.isNotEmpty(userList)){
			for(DataMigration d : userList){
				userMap.put(d.getOldId(), d.getNewId());
			}
		}
	}

	@Override
	public void process() throws Exception {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		//new
		UserKfTimeRangeService userKfTimeRangeService = SpringContextHolder.getBean("userKfTimeRangeServiceImpl");
		while(rs.next()){ 
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			//old
			ServiceTimeRange serviceTimeRange = JSonUtil.toObject(JSonUtil.toJSonString(rowMap), ServiceTimeRange.class);
			//new
			UserKfTimeRange userKfTimeRange  = new UserKfTimeRange();
			userKfTimeRange.setWeekDay(serviceTimeRange.getDay());
			userKfTimeRange.setBegin(serviceTimeRange.getBegin());
			userKfTimeRange.setEnd(serviceTimeRange.getEnd());
			//map
			userKfTimeRange.setServiceId(userMap.containsKey(serviceTimeRange.getService_id().intValue()) ? userMap.get(serviceTimeRange.getService_id().intValue()) : 0);
			userKfTimeRangeService.insert(userKfTimeRange);
			
			DataMigration data = new DataMigration();
			data.setOldId(serviceTimeRange.getId());
			data.setNewId(userKfTimeRange.getId());
			data.setType(TableTypes.User_Kf_Time_Range.getType());
			dataMigrationService.insert(data);
		}
	
	}
}

package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.AssistantFee;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.UserAssistantFee;
import com.qbt.service.DataMigrationService;
import com.qbt.service.UserAssistantFeeService;

public class UserAssistantFeeProcess extends AbstractProcess{

	private Map<Integer, Integer> userMap = new HashMap<Integer, Integer>();
	
	private Map<Integer, Integer> orderMap = new HashMap<Integer, Integer>();
	
	public UserAssistantFeeProcess(String name, ProcessServiceConfig config) {
		super(name, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before() {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 清除历史ID兑换数据
		dataMigrationService.delete(TableTypes.User_Assistant_Fee.getType());
		List<DataMigration> userList = dataMigrationService.findByType(TableTypes.User_Assistant.getType());
		if(Checker.isNotEmpty(userList)){
			for(DataMigration d : userList){
				userMap.put(d.getOldId(), d.getNewId());
			}
		}
		
		List<DataMigration> dataMap = dataMigrationService.findByType(TableTypes.order.getType());
		if(Checker.isNotEmpty(dataMap)){
			for(DataMigration d : dataMap){
				orderMap.put(d.getOldId(), d.getNewId());
			}
		}
		
	}

	@Override
	public void process() throws Exception {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		//new
		UserAssistantFeeService userAssistantFeeService = SpringContextHolder.getBean("userAssistantFeeServiceImpl");
		while(rs.next()){ 
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			//old
			AssistantFee assistantFee = JSonUtil.toObject(JSonUtil.toJSonString(rowMap), AssistantFee.class);
			//new
			UserAssistantFee userAssistantFee  = new UserAssistantFee();
			userAssistantFee.setCreateTime(assistantFee.getCreated_at());
			userAssistantFee.setOrderId(orderMap.containsKey(assistantFee.getOrder_id().intValue()) ? orderMap.get(assistantFee.getOrder_id().intValue()) : 0);
			userAssistantFee.setFee(assistantFee.getFee());
			userAssistantFee.setPaid(assistantFee.getPaid());
			userAssistantFee.setType(assistantFee.getType().intValue());
			userAssistantFee.setAssistantId(userMap.containsKey(assistantFee.getCourse_user_id().intValue()) ? userMap.get(assistantFee.getCourse_user_id().intValue()) : 0);
			userAssistantFeeService.inserAssistant(userAssistantFee);
			DataMigration data = new DataMigration();
			data.setOldId(assistantFee.getId());
			data.setNewId(userAssistantFee.getId());
			data.setType(TableTypes.User_Assistant_Fee.getType());
			dataMigrationService.insert(data);
		}
	
	}
}

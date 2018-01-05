package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.Map;

import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.CustomerService;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.UserKf;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.DataMigrationService;
import com.qbt.service.UserKfService;
import com.qbt.service.UserWeixinService;

public class UserKfProcess extends AbstractProcess{

	public UserKfProcess(String name, ProcessServiceConfig config) {
		super(name, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before() {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 清除历史ID兑换数据
		dataMigrationService.delete(TableTypes.User_Kf.getType());
	}

	@Override
	public void process() throws Exception {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		UserWeixinService userWeixinService = SpringContextHolder.getBean("userWeixinServiceImpl");
		//new
		UserKfService userKfService = SpringContextHolder.getBean("userKfServiceImpl");
		while(rs.next()){ 
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			//old
			CustomerService customerService = JSonUtil.toObject(JSonUtil.toJSonString(rowMap), CustomerService.class);
			//new
			UserKf userKf  = new UserKf();
			userKf.setCreateTime(customerService.getCreated_at());
			userKf.setName(customerService.getName());
			UserWeixin userWeixin = userWeixinService.findByOpenId(customerService.getOpen_id());
			userKf.setUserId(userWeixin.getId());
			userKf.setMobile(customerService.getMobile());
			userKf.setLevel(customerService.getLevel());
			userKf.setDesc(customerService.getDesc());
			userKf.setType(0);
			userKfService.insert(userKf);
			
			DataMigration data = new DataMigration();
			data.setOldId(customerService.getId());
			data.setNewId(userKf.getId());
			data.setType(TableTypes.User_Kf.getType());
			dataMigrationService.insert(data);
		}
	
	}
}

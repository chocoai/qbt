package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.Map;

import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.CustomerService;
import com.qbt.data.migration.pgsql.entity.Service;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.UserKf;
import com.qbt.persistent.entity.UserSfKf;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.DataMigrationService;
import com.qbt.service.UserKfService;
import com.qbt.service.UserSfKfService;
import com.qbt.service.UserWeixinService;

public class UserSfKfProcess extends AbstractProcess {

	public UserSfKfProcess(String name, ProcessServiceConfig config) {
		super(name, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before() {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 清除历史ID兑换数据
		dataMigrationService.delete(TableTypes.User_Sf_Kf.getType());
		
	}

	@Override
	public void process() throws Exception {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		//new
		UserSfKfService userSfKfService = SpringContextHolder.getBean("userSfKfServiceImpl");
		while(rs.next()){ 
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			//old
			Service service = JSonUtil.toObject(JSonUtil.toJSonString(rowMap), Service.class);
			//new
			UserSfKf userSfKf  = new UserSfKf();
			userSfKf.setCreateTime(service.getCreated_at());
			userSfKf.setName(service.getName());
			userSfKf.setMobile(service.getMobile().substring(0, 10));
			userSfKfService.insert(userSfKf);
			
			DataMigration data = new DataMigration();
			data.setOldId(service.getId());
			data.setNewId(userSfKf.getId());
			data.setType(TableTypes.User_Sf_Kf.getType());
			dataMigrationService.insert(data);
		}
	}

}

package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.AssistantApply;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.data.migration.utils.DataCacheUtil;
import com.qbt.persistent.entity.BaseAirport;
import com.qbt.persistent.entity.BaseBankBranch;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseSfSite;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.service.DataMigrationService;
import com.qbt.service.UserAsApService;

/**
 * 助理申请
 * @author wuwang
 *
 */
public class UserAssistantApplyProcess extends AbstractProcess{

	private Map<Integer, Integer> userMap = new HashMap<Integer, Integer>();
	
	public UserAssistantApplyProcess(String name, ProcessServiceConfig config) {
		super(name, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before() {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 清除历史ID兑换数据
		dataMigrationService.delete(TableTypes.User_Assistant_Apply.getType());
		List<DataMigration> userList = dataMigrationService.findByType(TableTypes.User_Assistant.getType());
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
		UserAsApService userAsApService = SpringContextHolder.getBean("userAsApServiceImpl");
		while(rs.next()){ 
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String dataJson = JSonUtil.toJSonString(rowMap);
			LogCvt.info(dataJson);
			//old
			AssistantApply assistantApply = JSonUtil.toObject(dataJson, AssistantApply.class);
			//new
			UserAssistantApply userAssistantApply  = new UserAssistantApply();
			userAssistantApply.setCreateTime(assistantApply.getCreated_at());
			userAssistantApply.setAssistantId(userMap.containsKey(assistantApply.getAssistant_id().intValue()) ? userMap.get(assistantApply.getAssistant_id().intValue()) : 0);
			userAssistantApply.setName(assistantApply.getName());
			userAssistantApply.setIdentityCode(assistantApply.getIdentity_code());
			userAssistantApply.setPhoto1Url(assistantApply.getPhoto1_url());
			userAssistantApply.setPhoto2Url(assistantApply.getPhoto2_url());
			userAssistantApply.setApplyType(assistantApply.getApply_type());
			
			BaseCourse baseCourse  = DataCacheUtil.getCourseMap(assistantApply.getApply_name());
			if(baseCourse == null){
				LogCvt.error("名称为：" + assistantApply.getName() + "的助理申请的球场获取失败。无需迁移此记录");
				continue;
			}
			userAssistantApply.setApplyId(baseCourse.getId());
			userAssistantApply.setApplyName(assistantApply.getApply_name());
			userAssistantApply.setRemark(assistantApply.getRemark());
			userAsApService.insertUserAssistantApply(userAssistantApply);
			
			DataMigration data = new DataMigration();
			data.setOldId(assistantApply.getId());
			data.setNewId(userAssistantApply.getId());
			data.setType(TableTypes.User_Assistant_Apply.getType());
			dataMigrationService.insert(data);
			
		}
	
	}
}

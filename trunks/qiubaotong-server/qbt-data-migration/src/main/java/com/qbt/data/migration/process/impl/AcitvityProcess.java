package com.qbt.data.migration.process.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.Activity;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.service.ActivityService;
import com.qbt.service.CommonService;
import com.qbt.service.DataMigrationService;

/**
 *  订单操作人日志
  * @ClassName: OrderOperateLogProcess
  * @Description: TODO
  * @author share 2016年9月6日
  * @modify share 2016年9月6日
 */
public class AcitvityProcess extends AbstractProcess {

	public AcitvityProcess(String name, ProcessServiceConfig config) {
		super(name, config);
	}

	@Override
	public void before() {
	}

	@Override
	public void process() throws Exception {
		ActivityService activityService = SpringContextHolder.getBean("activityServiceImpl");
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		dataMigrationService.delete(TableTypes.activity.getType());
		CommonService commonService = SpringContextHolder.getBean("commonServiceImpl");
		
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			Activity act = JSonUtil.toObject(json, Activity.class);
			
				com.qbt.persistent.entity.Activity activity = new com.qbt.persistent.entity.Activity();
				activity.setCode((act.getCode() == null ||"".equals(act.getCode()))?commonService.createCouponCode():act.getCode());
				activity.setCreateTime(act.getCreated_at());
				activity.setDesc(act.getDesc());
				activity.setStartTime(act.getActivity_start_time()==null?new Date():act.getActivity_start_time());
				activity.setEndTime(act.getActivity_end_time()==null?new Date():act.getActivity_end_time());
				activity.setMaxPerOne(act.getMax_per_one()==null?0:act.getMax_per_one());
				activity.setName(act.getName());
				activity.setRuleId(0);
				activity.setRuleName("历史无规则");
				activity.setStatus(1);
				activity.setUpdateTime(act.getCreated_at()==null?new Date():act.getCreated_at());
				activityService.insert(activity);
				
				DataMigration data = new DataMigration();
				data.setOldId(act.getId());
				data.setNewId(activity.getId());
				data.setType(TableTypes.activity.getType());
				dataMigrationService.insert(data);
		}
	}
	

}

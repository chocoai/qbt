package com.qbt.data.migration.process.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.DelaySendOrderTask;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.OrderDelayTask;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.service.DataMigrationService;
import com.qbt.service.OrderDelayTaskService;
import com.qbt.service.OrderInfoService;

/**
 *  延迟下单任务表
  * @ClassName: OrderDelayTaskProcess
  * @Description: TODO
  * @author share 2016年9月6日
  * @modify share 2016年9月6日
 */
public class OrderDelayTaskProcess extends AbstractProcess {

	private Map<String,Integer> orderMap = new HashMap<String, Integer>();
	
	public OrderDelayTaskProcess(String name, ProcessServiceConfig config) {
		super(name, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before() {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 订单数据迁移
		List<DataMigration> userList = dataMigrationService.findByType(TableTypes.order.getType());
		for(DataMigration user : userList){
			orderMap.put(String.valueOf(user.getOldId()), user.getNewId());
		}
	}

	@Override
	public void process() throws Exception {
		// TODO Auto-generated method stub
		OrderDelayTaskService orderDelayTaskService = SpringContextHolder.getBean("orderDelayTaskServiceImpl");
		OrderInfoService orderInfoService = SpringContextHolder.getBean("orderInfoServiceImpl");
		
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			DelaySendOrderTask task = JSonUtil.toObject(json, DelaySendOrderTask.class);
			Integer newOrderId = orderMap.get(String.valueOf(task.getOrder_id()));
			if(newOrderId == null){
				LogCvt.error("订单延迟任务，新订单ID无法查询:"+task.getOrder_id());
				continue;
			}
			
			OrderInfo orderInfo = orderInfoService.findById(newOrderId);
			Date dd = DateUtil.calDateOfDay(orderInfo.getCreateTime(),-3);
			Date delayTime = DateUtil.str2Date(DateUtil.formatDate(dd, DateUtil.DATE_FORMAT_01)+" 08:00:00",DateUtil.DATE_TIME_FORMAT_01);
			OrderDelayTask orderDelayTask = new OrderDelayTask();
			orderDelayTask.setCreateTime(task.getCreated_at());
			orderDelayTask.setDelayTime(delayTime);
			orderDelayTask.setOrderId(newOrderId);
			orderDelayTask.setStatus(1);
			orderDelayTask.setUpdateTime(task.getCreated_at());
			orderDelayTask.setReason("");
			orderDelayTaskService.insert(orderDelayTask);
		}
	}
	

}

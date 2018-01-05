package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.OperateLog;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.OrderOperateLog;
import com.qbt.service.DataMigrationService;
import com.qbt.service.OrderOperateLogService;

/**
 *  订单操作人日志
  * @ClassName: OrderOperateLogProcess
  * @Description: TODO
  * @author share 2016年9月6日
  * @modify share 2016年9月6日
 */
public class OrderOperateLogProcess extends AbstractProcess {

	private Map<String,Integer> orderMap = new HashMap<String, Integer>();
	
	public OrderOperateLogProcess(String name, ProcessServiceConfig config) {
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
		OrderOperateLogService orderOperateLogService = SpringContextHolder.getBean("orderOperateLogServiceImpl");
		
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			OperateLog log = JSonUtil.toObject(json, OperateLog.class);
			Integer newOrderId = orderMap.get(String.valueOf(log.getOrder_id()));
			if(newOrderId == null){
				LogCvt.error("订单日志:"+log.getOrder_id());
				continue;
			}
			OrderOperateLog orderLog = new OrderOperateLog();
			orderLog.setCreateTime(log.getCreated_at());
			orderLog.setAction(log.getAction());
			orderLog.setDescription(log.getDescription());
			orderLog.setOperatorId(log.getOperator_id());
			orderLog.setOperatorName(log.getOperator_name());
			orderLog.setOperatorType(log.getOperator_type());
			orderLog.setOrderId(newOrderId);
			orderLog.setUpdateTime(log.getCreated_at());
			
			orderOperateLogService.insert(orderLog);
		}
	}
	

}

package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.Task;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.OrderExceptionBook;
import com.qbt.service.DataMigrationService;
import com.qbt.service.OrderExceptionBookService;

/**
 *  订单信息物流表
  * @ClassName: OrderWayBillProcess
  * @Description: TODO
  * @author share 2016年9月6日
  * @modify share 2016年9月6日
 */
public class OrderExceptionBookProcess extends AbstractProcess {

	private Map<String,Integer> orderMap = new HashMap<String, Integer>();
	
	public OrderExceptionBookProcess(String name, ProcessServiceConfig config) {
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
		OrderExceptionBookService orderExceptionBookService = SpringContextHolder.getBean("orderExceptionBookServiceImpl");
		
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			Task  task = JSonUtil.toObject(json, Task.class);
			Integer newOrderId = orderMap.get(String.valueOf(task.getOrder_id()));
			if(newOrderId == null){
				LogCvt.error("订单异常登记，新订单ID无法查询:"+task.getOrder_id());
				continue;
			}
			OrderExceptionBook orderException = new OrderExceptionBook();
			orderException.setCreateTime(task.getCreated_at());
			orderException.setDescription(task.getDescription());
			orderException.setIsDealed(task.getIs_dealed());
			orderException.setOrderId(newOrderId);
			orderException.setOrderNumber(task.getOrder_number());
			orderException.setOrderStatus(task.getOrder_status());
			orderException.setRemark(task.getRemark());
			orderException.setSysUserId(task.getAccout_id());
			orderException.setType(task.getType());
			orderException.setUserName(task.getAccout_name());
			orderException.setUpdateTime(task.getCreated_at());
			
			orderExceptionBookService.insert(orderException);
		}
	}
	

}

package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.Memo;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.OrderMemo;
import com.qbt.service.DataMigrationService;
import com.qbt.service.OrderMemoService;

/**
 *  延迟下单任务表
  * @ClassName: OrderDelayTaskProcess
  * @Description: TODO
  * @author share 2016年9月6日
  * @modify share 2016年9月6日
 */
public class OrderMemoProcess extends AbstractProcess {

	private Map<String,Integer> orderMap = new HashMap<String, Integer>();
	
	public OrderMemoProcess(String name, ProcessServiceConfig config) {
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
		OrderMemoService orderMemoService = SpringContextHolder.getBean("orderMemoServiceImpl");
		
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			Memo memo = JSonUtil.toObject(json, Memo.class);
			Integer newOrderId = orderMap.get(String.valueOf(memo.getOrder_id()));
			if(newOrderId == null){
				LogCvt.error("订单客服记录，新订单ID无法查询:"+memo.getOrder_id());
				continue;
			}
			OrderMemo orderMemo = new OrderMemo();
			orderMemo.setAccountId(memo.getAccount_id());
			orderMemo.setAccountName(memo.getAccount_name());
			orderMemo.setMemo(memo.getMemo());
			orderMemo.setOrderId(newOrderId);
			orderMemo.setCreateTime(memo.getCreated_at());
			orderMemo.setUpdateTime(memo.getCreated_at());
			
			orderMemoService.insert(orderMemo);
		}
	}
	

}

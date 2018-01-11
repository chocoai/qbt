package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.MD5Util;
import com.qbt.common.util.StringUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.Route;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderWaybill;
import com.qbt.service.DataMigrationService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderWaybillService;

/**
 *  订单信息物流表
  * @ClassName: OrderWayBillProcess
  * @Description: TODO
  * @author share 2016年9月6日
  * @modify share 2016年9月6日
 */
public class OrderWayBillProcess extends AbstractProcess {

	private Map<String,Integer> orderMap = new HashMap<String, Integer>();
	
	public OrderWayBillProcess(String name, ProcessServiceConfig config) {
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
		OrderWaybillService orderWaybillService = SpringContextHolder.getBean("orderWaybillServiceImpl");
		OrderInfoService orderInfoService = SpringContextHolder.getBean("orderInfoServiceImpl");
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			Route  route = JSonUtil.toObject(json, Route.class);
			Integer newOrderId = orderMap.get(String.valueOf(route.getOrder_id()));
			if(newOrderId == null){
				LogCvt.error("物流订单，新订单ID无法查询:"+route.getOrder_id());
				continue;
			}
			String mailNo = route.getMail_no();
			if(StringUtil.isEmpty(mailNo)){
				OrderInfo orderInfo = orderInfoService.findById(newOrderId);
				mailNo = orderInfo.getMailNo();
				if(StringUtil.isEmpty(mailNo)){
					LogCvt.error("物流订单，新订单运单号为空:"+newOrderId);
					continue;
				}
			}
			OrderWaybill waybill = new OrderWaybill();
			waybill.setAcceptAddress(route.getAccept_address());
			waybill.setAcceptTime(DateUtil.str2Date(route.getAccept_time(), DateUtil.DATE_TIME_FORMAT_01) );
			waybill.setMailNo(mailNo);
			waybill.setOpCode(route.getOp_code());
			waybill.setOrderId(newOrderId);
			waybill.setRemark(route.getRemark());
			String sfId = MD5Util.MD5(route.getMail_no() + route.getAccept_time() + route.getOp_code());
			waybill.setSfId(sfId);
			orderWaybillService.insert(waybill);
		}
	}
	

}

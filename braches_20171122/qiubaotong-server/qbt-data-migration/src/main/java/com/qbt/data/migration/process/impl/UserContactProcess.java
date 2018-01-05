package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.UserContact;
import com.qbt.service.OrderInfoService;
import com.qbt.service.UserContactService;

public class UserContactProcess extends AbstractProcess {

	public UserContactProcess(String name, ProcessServiceConfig config) {
		super(name, config);
	}

	@Override
	public void before() {
//		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
//		// 清除历史ID兑换数据
//		dataMigrationService.delete(TableTypes.user_contact.getType());
	}

	@Override
	public void process() throws Exception {
//		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		UserContactService userContactService = SpringContextHolder.getBean("userContactServiceImpl");
		OrderInfoService orderInfoService = SpringContextHolder.getBean("orderInfoServiceImpl");
		
		/*while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel, new String(rs.getObject(columnLabel) != null ? rs.getObject(columnLabel).toString().getBytes() : "".getBytes(), "utf8"));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			Contact contact = JSonUtil.toObject(json, Contact.class);
			
			UserContact uContact = new UserContact();
			uContact.setName(contact.getName());
			uContact.setMobile(contact.getMobile());
			uContact.setIsDelete(contact.getDeleted_at() != null ? true : false);
			int newId = userContactService.insert(uContact);
			
			DataMigration data = new DataMigration();
			data.setOldId(contact.getId());
			data.setNewId(newId);
			data.setType(TableTypes.user_contact.getType());
			dataMigrationService.insert(data);
		}*/
		
		List<OrderInfo> orderList = orderInfoService.findAllContactInfo();
		if(Checker.isEmpty(orderList)){
			return;
		}
		UserContact jContact = null;
		UserContact dContact = null;
		for(OrderInfo order : orderList){
			UserContact qJContact = userContactService.findByMobile(order.getjMobile());
			if(Checker.isEmpty(qJContact)){
				jContact = new UserContact();
				jContact.setName(order.getjContact());
				jContact.setMobile(order.getjMobile());
				jContact.setIsDelete(false);
				jContact.setType(order.getOrderStatus() == 1 ? 0 : 1);
				userContactService.insert(jContact);
			}else if(qJContact.getType() == 0 && order.getOrderStatus() != 1){
				qJContact.setType(1);
				userContactService.updateById(qJContact);
			}
			
			UserContact qdContact = userContactService.findByMobile(order.getdMobile());
			if(Checker.isEmpty(qdContact)){
				dContact = new UserContact();
				dContact.setName(order.getdContact());
				dContact.setMobile(order.getdMobile());
				dContact.setIsDelete(false);
				dContact.setType(order.getOrderStatus() == 1 ? 0 : 1);
				userContactService.insert(dContact);
			}else if(qdContact.getType() == 0 && order.getOrderStatus() != 1){
				qdContact.setType(1);
				userContactService.updateById(qdContact);
			}
		}
	}

}

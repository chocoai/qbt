package com.geling.dao.impl;

import java.sql.SQLException;
import java.util.Date;

import com.geling.dao.SmsDao;
import com.geling.db.helper.JdbcHelper;
import com.geling.msg.entity.sms.SMSNotifyRequestEntity;
import com.geling.msg.logback.LogCvt;

public class SmsDaoImpl implements SmsDao {

	private static final String table = "sms_message";
	private static final String add_colums = "request_time,update_time,uuid,request_status,mobiles,sms_templateId,sms_data,platform";
	
	private static final String insert_sql = "insert into " + table + " (" + add_colums + ") values (?,?,?,?,?,?,?,?)";
	@Override
	public int insert(SMSNotifyRequestEntity entity) {
		LogCvt.debug("insert SMS log");
		Object[] paramters = new Object[8];
		paramters[0] = entity.getRequestTime();
		paramters[1] = entity.getUpdateTime();
		paramters[2] = entity.getUuid();
		paramters[3] = entity.getRequestStatus();
		paramters[4] = entity.getMobiles();
		paramters[5] = entity.getSmsTemplateId();
		paramters[6] = entity.getSmsText();//JSonUtil.toJSonString(entity.getSmsData());
		paramters[7] = entity.getPlatform();
 		try {
			JdbcHelper.insertWithReturnPrimeKey(insert_sql, paramters);
		} catch (SQLException e) {
			LogCvt.error(e.getMessage(), e);
		}
		return 1;
	}

	private static final String update_sql = "update " + table + " set update_time = ?,request_status = ?,status_msg=?,status_code = ?,message_sid = ?,date_created=? where uuid = ?";
	@Override
	public void update(SMSNotifyRequestEntity smsRequest) {
		Object[] paramters = new Object[7];
		paramters[0] = new Date();
		paramters[1] = smsRequest.getRequestStatus();
		paramters[2] = smsRequest.getStatusMsg();
		paramters[3] = smsRequest.getStatusCode();
		paramters[4] = smsRequest.getMessageSid();
		paramters[5] = smsRequest.getDateCreated();
		paramters[6] = smsRequest.getUuid();
		try {
			JdbcHelper.update(update_sql, paramters);
		} catch (SQLException e) {
			LogCvt.error(e.getMessage(), e);
		}
	}
	
	private static final String query_uuid_sql = "select count(1) from " + table + " where uuid = ?";
	@Override
	public int countByUuid(String uuid) {
		LogCvt.debug("query sms log");
		int count = 0;
		try {
			Object result = JdbcHelper.getSingle(query_uuid_sql, uuid);
			if(result!=null)
				count = Integer.valueOf(result.toString());
			
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
		return count;
	}
	
}

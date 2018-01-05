package com.geling.dao.impl;

import java.sql.SQLException;
import java.util.Date;

import com.geling.dao.EmailDao;
import com.geling.db.helper.JdbcHelper;
import com.geling.msg.entity.RequestConstant;
import com.geling.msg.entity.email.EmailNotifyRequestEntity;
import com.geling.msg.logback.LogCvt;
import com.geling.util.JSonUtil;

public class EmailDaoImpl implements EmailDao {

	
	private static final String table = "email_message";
//	private static final String colums_1 = "id,request_time,update_time,uuid,request_status,from_address,from_user_name,rec_address,cc_address,subject,attachments,data,platform";
//	private static final String colums_2 = "id,request_time requestTime,update_time updateTime,uuid,request_status requestStatus,from_address fromAddress,from_user_name fromUserName,rec_address recAddress,cc_address ccAddress,subject,attachments,data,platform";
	private static final String add_colums = "request_time,update_time,uuid,request_status,from_address,from_user_name,rec_address,cc_address,subject,attachments,data,platform";
	
	private static final String insert_sql = "insert into " + table + " (" + add_colums + ") values (?,?,?,?,?,?,?,?,?,?,?,?)";
	@Override
	public int insert(EmailNotifyRequestEntity entity) {
		LogCvt.debug("insert email log");
		Object[] paramters = new Object[12];
		paramters[0] = entity.getRequestTime();
		paramters[1] = entity.getUpdateTime();
		paramters[2] = entity.getUuid();
		paramters[3] = entity.getRequestStatus();
		paramters[4] = entity.getFromAddress();
		paramters[5] = entity.getFromUserName();
		paramters[6] = JSonUtil.toJSonString(entity.getRecAddress());
		paramters[7] = JSonUtil.toJSonString(entity.getCcAddress());
		paramters[8] = entity.getSubject();
		paramters[9] = JSonUtil.toJSonString(entity.getAttachments());
		paramters[10] = entity.getData().get(RequestConstant.STREAM_NOTIFY_KEY);
		paramters[11] = entity.getPlatform();
		try {
			JdbcHelper.insertWithReturnPrimeKey(insert_sql, paramters);
		} catch (SQLException e) {
			LogCvt.error(e.getMessage(), e);
		}
		return 1;
	}

	private static final String update_sql = "update " + table + " set update_time = ?,request_status = ?,rec_address = ?,cc_address = ? where uuid = ?";
	@Override
	public void update(EmailNotifyRequestEntity mailRequest) {
		Object[] paramters = new Object[5];
		paramters[0] = new Date();
		paramters[1] = mailRequest.getRequestStatus();
		paramters[2] = JSonUtil.toJSonString(mailRequest.getRecAddress());
		paramters[3] = JSonUtil.toJSonString(mailRequest.getCcAddress());
		paramters[4] = mailRequest.getUuid();
		try {
			JdbcHelper.update(update_sql, paramters);
		} catch (SQLException e) {
			LogCvt.error(e.getMessage(), e);
		}
	}
	
	private static final String query_uuid_sql = "select count(1) from " + table + " where uuid = ?";
	@Override
	public int countByUuid(String uuid) {
		LogCvt.debug("query email log");
		int count = 0;
//		EmailNotifyRequestEntity entity = null;
		try {
			Object result = JdbcHelper.getSingle(query_uuid_sql, uuid);
			count = Integer.valueOf(result.toString());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
		return count;
	}
	
}

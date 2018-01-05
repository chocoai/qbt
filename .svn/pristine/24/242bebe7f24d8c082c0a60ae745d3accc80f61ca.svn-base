package com.qbt.data.migration.process.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.UserCourse;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.data.migration.utils.DataCacheUtil;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.service.DataMigrationService;
import com.qbt.service.UserAsApService;
import com.qbt.service.UserAssistantService;

/**
 * 用户助理迁移
 * @author wuwang
 *
 */
public class UserAssistantProcess extends AbstractProcess{

	private Map<Integer, Integer> userMap = new HashMap<Integer, Integer>();
	
	public UserAssistantProcess(String name, ProcessServiceConfig config) {
		super(name, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before() {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 清除历史ID兑换数据
		dataMigrationService.delete(TableTypes.User_Assistant.getType());
		//微信用户id map
		List<DataMigration> userList = dataMigrationService.findByType(TableTypes.User_Weixin.getType());
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
		UserAssistantService userAssistantService = SpringContextHolder.getBean("userAssistantServiceImpl");
		UserAsApService userAsApService = SpringContextHolder.getBean("userAsApServiceImpl");
		
		while(rs.next()){ 
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String dataJson = JSonUtil.toJSonString(rowMap);
			LogCvt.info(dataJson);
			//old
			UserCourse userCourse = JSonUtil.toObject(dataJson, UserCourse.class);
			
			if(userCourse.getCourse_id() == 0){
				LogCvt.error("球场助理球场ID为0，不迁移此数据.");
				continue;
			}
			
			//new
			UserAssistant userAssistant  = new UserAssistant();
			userAssistant.setCreateTime(userCourse.getCreated_at());
			int userId = 0;
			try {
			    String sql = "select u.id as user_id from \"user\" u left join user_course uc on u.openid=uc.openid where u.openid='" + userCourse.getOpenid()+"'";
				Statement stat = connection.createStatement();
				ResultSet rs = stat.executeQuery(sql);
				if(rs.next()){
					userId = (Integer) rs.getObject("user_id");
				}
			} catch (Exception e) {
				// TODO: handle exception
				LogCvt.error("sql出错：" + e);
			}
			userAssistant.setUserId(userMap.containsKey(userId) ? userMap.get(userId) : 0);
			if(!userMap.containsKey(userId)){
				LogCvt.error("在旧user表，找不到名为\"" + userCourse.getName() +"\"球包助理的用户id,该球包助理的openid为：" + userCourse.getOpenid());
				continue;
			}
			userAssistant.setName(userCourse.getName());
			userAssistant.setEmail(userCourse.getEmail());
			
			int status = 0;
			String memo = null;
			Statement stat = null;
			ResultSet rs = null;
			String applayName = "";
			try {
				String sql = "select aa.status as status,aa.reject_reason as memo from assistant_apply aa left join user_course uc on aa.assistant_id=uc.id where uc.id='" + userCourse.getId()+"'";
				stat = connection.createStatement();
				rs = stat.executeQuery(sql);
				if(rs.next()){
					status = rs.getInt("status");
					memo = rs.getString("memo");
				}else{
					rs.close();
					
					sql = "select id,name from course where id="+userCourse.getCourse_id();
					LogCvt.info("查询球场sql:"+sql);
					rs = stat.executeQuery(sql);
					if(rs.next()){
						applayName = rs.getString("name");
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				LogCvt.error(e.getMessage(),e);
			}finally{
				if(rs != null && !rs.isClosed())rs.close();
				if(stat != null)stat.close();
			}
			userAssistant.setMobile(userCourse.getMobile());
			userAssistant.setPassword(userCourse.getPassword());
			userAssistant.setSalt(userCourse.getSalt());
			userAssistant.setEnjoyAssistantFee(false);
			userAssistant.setMemo(memo);
			if(status == 0){
				userAssistant.setStatus(2);
			}else{
				userAssistant.setStatus(status);
			}
			userAssistantService.inserAssistant(userAssistant);
			if(status == 0){
				LogCvt.error("球包助理补充申请数据："+applayName);
				// 补充审核表数据
				UserAssistantApply userAssistantApply  = new UserAssistantApply();
				
				BaseCourse course = DataCacheUtil.getCourseMap(applayName);
				if(course == null){
					LogCvt.error("助理迁移，球场未能找到："+applayName);
				}
				userAssistantApply.setApplyId(course.getId());
				userAssistantApply.setApplyName(applayName);
				userAssistantApply.setApplyType(1);
				userAssistantApply.setAssistantId(userAssistant.getId());
				userAssistantApply.setCreateTime(userCourse.getCreated_at());
				userAssistantApply.setIdentityCode("");
				userAssistantApply.setName(userCourse.getName());
				userAssistantApply.setPhoto1Url("");
				userAssistantApply.setPhoto2Url("");
				userAssistantApply.setRemark("历史无申请记录，补录");
				userAssistantApply.setUpdateTime(userCourse.getCreated_at());
				userAsApService.insertUserAssistantApply(userAssistantApply);
			}
			DataMigration data = new DataMigration();
			data.setOldId(userCourse.getId());
			data.setNewId(userAssistant.getId());
			data.setType(TableTypes.User_Assistant.getType());
			dataMigrationService.insert(data);
		}
		
	}
}

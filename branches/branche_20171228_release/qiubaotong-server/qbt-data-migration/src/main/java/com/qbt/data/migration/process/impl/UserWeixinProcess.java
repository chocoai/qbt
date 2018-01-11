package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.User;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.DataMigrationService;
import com.qbt.service.UserWeixinService;

/**
 *  微信业务
  * @ClassName: AccountProcess
  * @Description: TODO
  * @author share 2016年8月31日
  * @modify share 2016年8月31日
 */
public class UserWeixinProcess extends AbstractProcess {

	
	
	public UserWeixinProcess(String name, ProcessServiceConfig config) {
		super(name, config);
	}

	@Override
	public void before() {
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 清除历史ID兑换数据
		dataMigrationService.delete(TableTypes.User_Weixin.getType());
	}

	@Override
	public void process() throws Exception {
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		UserWeixinService userWeixinService = SpringContextHolder.getBean("userWeixinServiceImpl");
		Set<String> openidSet = new HashSet<String>();
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			User weixin = JSonUtil.toObject(json, User.class);
			
			UserWeixin user = new UserWeixin();
			if(Checker.isEmpty(weixin.getOpenid()) || !openidSet.add(weixin.getOpenid())){
				continue;
			}
			user.setAcceptPromotion(true);
			user.setAcceptPush(true);
			user.setCity(weixin.getCity());
			user.setCoordsrc(weixin.getCoordsrc());
			user.setCounty(weixin.getCounty());
			user.setCreateTime(weixin.getCreated_at());
			user.setEmail(weixin.getEmail());
			user.setFirstLetter(weixin.getFirst_letter());
			user.setHeadImgUrl(weixin.getHead_img_url());
			user.setIsValidated(true);
			user.setLastlat(String.valueOf(weixin.getLastlat()));
			user.setLastlon(String.valueOf(weixin.getLastlon()));
			user.setMobile(weixin.getMobile());
			user.setName(weixin.getName());
			user.setNickname(weixin.getNickname());
			user.setOpenid(weixin.getOpenid());
			user.setPassword(weixin.getPassword());
			user.setProvince(weixin.getProvince());
			user.setSalt(weixin.getSalt());
			user.setSex(weixin.getSex() != null?(int)weixin.getSex():1);
			
			userWeixinService.insert(user);
			
			DataMigration data = new DataMigration();
			data.setOldId(weixin.getId());
			data.setNewId(user.getId());
			data.setType(TableTypes.User_Weixin.getType());
			dataMigrationService.insert(data);
		}
	}

}

package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.Qbp;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.BaseBrand;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.service.BaseBrandService;
import com.qbt.service.DataMigrationService;

public class BaseBrandProcess extends AbstractProcess {

	private Map<Integer, Integer> contactMap = new HashMap<Integer, Integer>();
	
	public BaseBrandProcess(String name, ProcessServiceConfig config) {
		super(name, config);
	}

	@Override
	public void before() {
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 清除历史ID兑换数据
		dataMigrationService.delete(TableTypes.base_brand.getType());
		//联系人关系map
		List<DataMigration> contactList = dataMigrationService.findByType(TableTypes.user_contact.getType());
		if(Checker.isNotEmpty(contactList)){
			for(DataMigration d : contactList){
				contactMap.put(d.getOldId(), d.getNewId());
			}
		}
	}

	@Override
	public void process() throws Exception {
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		BaseBrandService baseBrandService = SpringContextHolder.getBean("baseBrandServiceImpl");
		
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel, new String(rs.getObject(columnLabel) != null ? rs.getObject(columnLabel).toString().getBytes() : "".getBytes(), "utf8"));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			Qbp qbp = JSonUtil.toObject(json, Qbp.class);
			
			BaseBrand brand = new BaseBrand();
			brand.setBagNo(qbp.getBag_no());
			brand.setRfidNo(qbp.getRfid_no());;
			brand.setRemark(qbp.getRemark());
			changeState(qbp, brand);
			if(Checker.isNotEmpty(qbp.getSender_id())){
				if(contactMap.containsKey(qbp.getSender_id().intValue())){
					brand.setContactId(contactMap.get(qbp.getSender_id().intValue()));
				}else{
					brand.setContactId(0);
					LogCvt.error("旧表qbp id[" + qbp.getId() + "]找不到对应联系人：旧联系人ID[" + qbp.getSender_id() + "]");
				}
			}else{
				brand.setContactId(0);
			}
			int newId = baseBrandService.insert(brand);
			
			DataMigration data = new DataMigration();
			data.setOldId(qbp.getId());
			data.setNewId(newId);
			data.setType(TableTypes.base_brand.getType());
			dataMigrationService.insert(data);
		}
	}
	
	private void changeState(Qbp qbp, BaseBrand brand){
		//旧表状态：0-无效 1-有效
		//新表状态：1-有效 2-无效
		brand.setState(qbp.getState() == 1 ? 1 : 2);
	}
	
}

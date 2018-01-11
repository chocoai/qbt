package com.qbt.data.migration.process.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.SfQbtPrice;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.BaseSfPrice;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.service.BaseSfPriceService;
import com.qbt.service.DataMigrationService;

public class BaseSfPriceProcess extends AbstractProcess {

	public BaseSfPriceProcess(String name, ProcessServiceConfig config) {
		super(name, config);
	}

	@Override
	public void before() {
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 清除历史ID兑换数据
		dataMigrationService.delete(TableTypes.sf_price.getType());
	}

	@Override
	public void process() throws Exception {
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		BaseSfPriceService baseSfPriceService = SpringContextHolder.getBean("baseSfPriceServiceImpl");
		
		while (rs.next()) {
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel, new String(rs.getObject(columnLabel) != null ? rs.getObject(columnLabel).toString().getBytes() : "".getBytes(), "utf8"));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			SfQbtPrice sfQbtPrice = JSonUtil.toObject(json, SfQbtPrice.class);
			
			BaseSfPrice price = new BaseSfPrice();
			price.setStartProvince(sfQbtPrice.getStart_province());
			price.setStartCity(sfQbtPrice.getStart_city());
			price.setEndProvince(sfQbtPrice.getEnd_province());
			price.setEndCity(sfQbtPrice.getEnd_city());
			price.setCichenSfPrice(new BigDecimal(sfQbtPrice.getCichen_sf_price()));
			price.setCichenQbtPrice(new BigDecimal(sfQbtPrice.getCichen_qbt_price()));
			price.setCichenFirstPrice(new BigDecimal(sfQbtPrice.getCichen_first_price()));
			price.setCichenSecondPrice(new BigDecimal(sfQbtPrice.getCichen_second_price()));
			price.setCiriSfPrice(new BigDecimal(sfQbtPrice.getCiri_first_price()));
			price.setCiriQbtPrice(new BigDecimal(sfQbtPrice.getCiri_qbt_price()));
			price.setCiriFirstPrice(new BigDecimal(sfQbtPrice.getCiri_first_price()));
			price.setCiriSecondPrice(new BigDecimal(sfQbtPrice.getCiri_second_price()));
			price.setJiriSfPrice(new BigDecimal(sfQbtPrice.getJiri_sf_price()));
			price.setJiriQbtPrice(new BigDecimal(sfQbtPrice.getJiri_qbt_price()));
			price.setJiriFirstPrice(new BigDecimal(sfQbtPrice.getJiri_first_price()));
			price.setJiriSecondPrice(new BigDecimal(sfQbtPrice.getJiri_second_price()));
			price.setGeriSfPrice(new BigDecimal(sfQbtPrice.getGeri_sf_price()));
			price.setGeriQbtPrice(new BigDecimal(sfQbtPrice.getGeri_qbt_price()));
			price.setGeriFirstPrice(new BigDecimal(sfQbtPrice.getGeri_first_price()));
			price.setGeriSecondPrice(new BigDecimal(sfQbtPrice.getGeri_second_price()));
			int newId = baseSfPriceService.insert(price);
			
			DataMigration data = new DataMigration();
			data.setOldId(sfQbtPrice.getId());
			data.setNewId(newId);
			data.setType(TableTypes.sf_price.getType());
			dataMigrationService.insert(data);
		}
	}

}

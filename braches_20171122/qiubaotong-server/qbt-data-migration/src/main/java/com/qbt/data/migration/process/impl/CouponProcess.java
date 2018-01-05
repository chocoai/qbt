package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.Coupon;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.service.CommonService;
import com.qbt.service.CouponService;
import com.qbt.service.DataMigrationService;

/**
 *  订单操作人日志
  * @ClassName: OrderOperateLogProcess
  * @Description: TODO
  * @author share 2016年9月6日
  * @modify share 2016年9月6日
 */
public class CouponProcess extends AbstractProcess {
	
	private Map<String,Integer> userMap = new HashMap<String, Integer>();
	private Map<String,Integer> activityMap = new HashMap<String, Integer>();

	public CouponProcess(String name, ProcessServiceConfig config) {
		super(name, config);
	}

	@Override
	public void before() {
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		dataMigrationService.delete(TableTypes.coupon.getType());
		// 获取券ID数据
		List<DataMigration> couponList = dataMigrationService.findByType(TableTypes.activity.getType());
		for(DataMigration user : couponList){
			activityMap.put(String.valueOf(user.getOldId()), user.getNewId());
		}
		// 获取微信用户数据
		List<DataMigration> userList = dataMigrationService.findByType(TableTypes.User_Weixin.getType());
		for(DataMigration user : userList){
			userMap.put(String.valueOf(user.getOldId()), user.getNewId());
		}
	}

	@Override
	public void process() throws Exception {
		CouponService couponService = SpringContextHolder.getBean("couponServiceImpl");
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		CommonService commonService = SpringContextHolder.getBean("commonServiceImpl");
		Map<String,String> libaocodeMap = new HashMap<String, String>();
		
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			Coupon act = JSonUtil.toObject(json, Coupon.class);
			
//			try {
				com.qbt.persistent.entity.Coupon coupon = new com.qbt.persistent.entity.Coupon();
				Integer activityId = activityMap.get(String.valueOf(act.getActivity_id()));
				if(activityId == null){
					LogCvt.error("未能找到对应的活动ID："+act.getActivity_id());
					continue;
				}
				Integer li_bao_id = act.getLi_bao_id();
				String code = act.getCode();
				String childCode = act.getCode();
				if(li_bao_id != null){
					String libaoId = String.valueOf(li_bao_id);
					if(libaocodeMap.containsKey(libaoId)){
						code = libaocodeMap.get(libaoId);
					}else{
						code = commonService.createCouponCode();
						libaocodeMap.put(libaoId, code);
					}
				}
				// 是否被用户认领
				Boolean is_claim = act.getIs_claim();
				Integer claim_user_id = userMap.get(act.getClaim_user_id());
				String claim_user_name = act.getClaim_user_name();
				// 是否分发
				Boolean is_distribute = act.getIs_distribute();
				Integer distribute_user_id = userMap.get(act.getDistribute_user_id());
				String distribute_user_name = act.getDistribute_user_name();
				Boolean valid = act.getValid();

				int status = 1;//1-未使用 2-已使用
				int claim_type =  0;//0-未领取 1-用户领取 2-后台分发;
				Integer user_id = 0;
				String user_name = "";
				if(!valid){
					status = 2;
				}
				if(is_claim!=null && is_claim){
					claim_type = 1;
					user_id = claim_user_id;
					user_name = claim_user_name;
				}
				if(is_distribute!=null && is_distribute){
					claim_type = 2;
					user_id = distribute_user_id;
					user_name = distribute_user_name;
				}
				double limitAmount = 0;
				Integer xian_jin_type = act.getXian_jin_type(); //1为通用劵，2为特殊劵
				if(xian_jin_type == null)xian_jin_type = 2;
				
				double amount = act.getAmount();
				double discount = act.getDiscount() == null?0:act.getDiscount();
				Double speciaAmount = act.getSpecial_amount();
				Double amountDenomination = act.getAmount_denomination();
				if(discount > 0){
					amount = discount;
				}else if(speciaAmount !=null && speciaAmount > 0){
					amount = speciaAmount;
				}else if(amountDenomination !=null && amountDenomination > 0){
					amount = amountDenomination;
				}
				
				if(amount == 0){
					LogCvt.error("历史券金额为0:"+code);
				}
				
				if(xian_jin_type == 1){
					if(amount == 10){
						limitAmount = 50;
					}else if(amount == 20){
						limitAmount = 100;
					}else if(amount == 30){
						limitAmount = 200;
					}else if(amount == 50){
						limitAmount = 300;
					}else if(amount == 100){
						limitAmount = 500;
					}else{
						LogCvt.error("未知通用券金额："+amount);
					}
				}
				
				coupon.setActivityId(activityId);
				coupon.setAmount(amount);
				coupon.setChildAmount(amount);
				coupon.setChildCode(childCode);
				coupon.setClaimType(claim_type);
				coupon.setCode(code);
				coupon.setCreateTime(act.getCreated_at());
				coupon.setDescription(act.getDescription());
				coupon.setLimitAmount(limitAmount);
				coupon.setStatus(status);
				coupon.setType(1);
				coupon.setUpdateTime(act.getCreated_at());
				coupon.setUserId(user_id==null?0:user_id);
				coupon.setUserName(user_name);
				couponService.insert(coupon);
				
				DataMigration data = new DataMigration();
				data.setOldId(act.getId());
				data.setNewId(coupon.getId());
				data.setType(TableTypes.coupon.getType());
				dataMigrationService.insert(data);
//			} catch (Exception e) {
//				LogCvt.error(e.getMessage(),e);
//			}
		}
	}
	

}

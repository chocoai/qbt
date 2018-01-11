package com.qbt.data.migration.process.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.Coupon;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.redis.RedisService;
import com.qbt.service.CouponService;
import com.qbt.service.DataMigrationService;

/**
 *  订单操作人日志
  * @ClassName: OrderOperateLogProcess
  * @Description: TODO
  * @author share 2016年9月6日
  * @modify share 2016年9月6日
 */
public class CouponBuUserIdProcess extends AbstractProcess {
	
	private Map<String,Integer> userMap = new HashMap<String, Integer>();
	private Map<String,Integer> couponMap = new HashMap<String, Integer>();
	private Map<String,Integer> activityMap = new HashMap<String, Integer>();

	public CouponBuUserIdProcess(String name, ProcessServiceConfig config) {
		super(name, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before() {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 获取券ID数据
		List<DataMigration> couponList = dataMigrationService.findByType(TableTypes.coupon.getType());
		for(DataMigration user : couponList){
			couponMap.put(String.valueOf(user.getOldId()), user.getNewId());
		}
		// 获取券ID数据
		List<DataMigration> activityList = dataMigrationService.findByType(TableTypes.activity.getType());
		for(DataMigration user : activityList){
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
		// TODO Auto-generated method stub
		CouponService couponService = SpringContextHolder.getBean("couponServiceImpl");
		RedisService redisService = SpringContextHolder.getBean("redisManager");
		int count = 0;
		while(rs.next()){
			count ++;
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
				
				// 是否被用户认领
				Boolean is_claim = act.getIs_claim();
				Integer claim_user_id = userMap.get(String.valueOf(act.getClaim_user_id()));
				// 是否分发
				Boolean is_distribute = act.getIs_distribute();
				Integer distribute_user_id = userMap.get(String.valueOf(act.getDistribute_user_id()));

				Integer user_id = 0;
				if(is_claim!=null && is_claim){
					user_id = claim_user_id;
				}
				if(is_distribute!=null && is_distribute){
					user_id = distribute_user_id;
				}
				
				Integer couponId = couponMap.get(String.valueOf(act.getId()));
				
				com.qbt.persistent.entity.Coupon newCoupon = couponService.findById(couponId);
				if(newCoupon == null){
					LogCvt.error("不能找到券ID:"+couponId);
				}
				if(user_id == null || user_id == 0){
					LogCvt.error("不能找用户ID:"+user_id);
					continue;
				}
				LogCvt.info("=================>"+user_id+",couponId:"+couponId);
				//检查券是否已被领取
//				String couponKey = RedisKeyUtil.Activity_Coupon_Redis_Key(newCoupon.getActivityId());
//				if(redisService.lrem(couponKey, 0, newCoupon.getCode()) != 0){
//					LogCvt.info("已从redis队列拿走用户的领取券："+coupon.getCode());
//				}
				com.qbt.persistent.entity.Coupon update = new com.qbt.persistent.entity.Coupon();
				update.setId(newCoupon.getId());
				update.setUserId(user_id);
				couponService.updateUserById(update);
				
//			} catch (Exception e) {
//				// TODO: handle exception
//				LogCvt.error(e.getMessage(),e);
//			}
		}
		
		LogCvt.info("count:"+count);
	}
	

}

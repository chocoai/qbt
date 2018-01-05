package com.qbt.data.migration.process.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qbt.common.enums.DeliveryStatus;
import com.qbt.common.enums.OrderSource;
import com.qbt.common.enums.OrderStatus;
import com.qbt.common.enums.RefundStatus;
import com.qbt.common.enums.SfBpsStatus;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.Arith;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.Order;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.data.migration.utils.DataCacheUtil;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.OrderCoupon;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.DataMigrationService;
import com.qbt.service.OrderCouponService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.UserWeixinService;

/**
 *  订单迁移
  * @ClassName: OrderProcess
  * @Description: TODO
  * @author share 2016年9月5日
  * @modify share 2016年9月5日
 */
public class OrderProcess extends AbstractProcess {

	private Map<String,Integer> userMap = new HashMap<String, Integer>();
	private Map<String,Integer> couponMap = new HashMap<String, Integer>();
	
	public OrderProcess(String name, ProcessServiceConfig config) {
		super(name, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before() {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 清除历史数据
		dataMigrationService.delete(TableTypes.order.getType());
		// 获取微信用户数据
		List<DataMigration> userList = dataMigrationService.findByType(TableTypes.User_Weixin.getType());
		for(DataMigration user : userList){
			userMap.put(String.valueOf(user.getOldId()), user.getNewId());
		}
		// 获取券ID数据
		List<DataMigration> couponList = dataMigrationService.findByType(TableTypes.coupon.getType());
		for(DataMigration user : couponList){
			couponMap.put(String.valueOf(user.getOldId()), user.getNewId());
		}
	}

	@Override
	public void process() throws Exception {
		// TODO Auto-generated method stub
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		OrderInfoService orderInfoService = SpringContextHolder.getBean("orderInfoServiceImpl");
		UserWeixinService userWeixinService = SpringContextHolder.getBean("userWeixinServiceImpl");
		OrderCouponService orderCouponService = SpringContextHolder.getBean("orderCouponServiceImpl");
		
		Set<Integer> userSet = new HashSet<Integer>();
		
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			Order order = JSonUtil.toObject(json, Order.class);
			// 订单信息
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setCreateTime(order.getCreated_at());
			orderInfo.setUpdateTime(order.getCreated_at());
			Integer newUserId = userMap.get(String.valueOf(order.getUser_id()));
			if(newUserId == null){
				LogCvt.error("订单记录无对应的用户："+order.getUser_id()+",订单ID："+order.getId());
				newUserId = 0;
			}
			orderInfo.setUserId(newUserId);
			orderInfo.setNumber(order.getNumber());
			orderInfo.setAmount(order.getAmount());
			orderInfo.setTotalAmount(order.getTotal_amount());
			orderInfo.setMailNo(order.getMail_no());
			/**
			 *  orderAllStatus[0] = order_status;
				orderAllStatus[1] = refund_status;
				orderAllStatus[2] = delivery_status;
				orderAllStatus[3] = bps_status;
				orderAllStatus[4] = handle_type;
				orderAllStatus[5] = question_status;
			 */
			Integer[] orderStatus = statusConvert(order);
			
			orderInfo.setOrderStatus(orderStatus[0]);
			orderInfo.setRefundStatus(orderStatus[1]);
			orderInfo.setDeliveryStatus(orderStatus[2]);
			orderInfo.setBpsStatus(orderStatus[3]);
			orderInfo.setHandleType(orderStatus[4]);
			orderInfo.setQuestionStatus(orderStatus[5]);
			orderInfo.setHandleType(orderStatus[4]);
			orderInfo.setOrderSource(OrderSource.weixin.getCode());
			orderInfo.setSendSfUserTime(DateUtil.str2Date(order.getSend_start_time()+":00", DateUtil.DATE_TIME_FORMAT_01));
			if(orderInfo.getSendSfUserTime() == null){
				orderInfo.setSendSfUserTime(orderInfo.getCreateTime());
			}
			orderInfo.setFreight(order.getFreight());
			orderInfo.setInsuredFee(order.getInsured_fee());
			orderInfo.setInsuredValue(order.getInsured_value());
			orderInfo.setExpressType(order.getExpress_type());
			orderInfo.setDeliverDate(order.getDeliver_date()+" "+order.getDeliver_time()+":00");
			orderInfo.setSendTimeSection(order.getSend_time_section());
			orderInfo.setInsuredFee(order.getInsured_fee());
			orderInfo.setInsuredRates(order.getInsured_rates());
			Double insureValue = order.getInsured_value();
			if(insureValue == null){
				insureValue = 0d;
			}else{
				insureValue = Arith.div(order.getInsured_value(),10000);
			}
			orderInfo.setInsuredValue(insureValue);
			if(order.getIs_paid() != null && order.getIs_paid()){
				orderInfo.setDiscount(Arith.sub(order.getTotal_amount(), order.getAmount())); 
				orderInfo.setPayId(0);
				orderInfo.setPayTime(order.getPaid_at());
			}else{
				orderInfo.setDiscount(0d);
			}
				
			// 寄件信息
			orderInfo.setjAddrType(getAddrType(order.getJ_addr_type()));
			orderInfo.setjAddress(order.getJ_address());
			if(order.getJ_course_id() > 0){
				orderInfo.setjAddrType(1);
				orderInfo.setjAddrId(getAddrCourseId(order.getJ_course_name()));
				orderInfo.setjAddrName(order.getJ_course_name());
			}else{
				orderInfo.setjAddrId(getAddrId(orderInfo.getjAddrType(), order.getJ_place_name()));
				orderInfo.setjAddrName(order.getJ_place_name());
			}
			if(orderInfo.getjAddrName() == null){
				orderInfo.setjAddrName("");
			}
			
			String jtreePath = order.getJ_province()+","+order.getJ_city()+","+order.getJ_county();
			orderInfo.setjAreaId(getAreaId(jtreePath));
			orderInfo.setjContact(order.getJ_contact());
			orderInfo.setjMobile(order.getJ_mobile().length() > 11?order.getJ_mobile().substring(0, 10):order.getJ_mobile());
			orderInfo.setjTreePath(jtreePath);
			// 收件信息
			orderInfo.setdAddrType(getAddrType(order.getD_addr_type()));
			orderInfo.setdAddress(order.getD_address());
			if(order.getD_course_id()>0){
				orderInfo.setdAddrType(1);
				orderInfo.setdAddrId(getAddrCourseId(order.getD_course_name()));
				orderInfo.setdAddrName(order.getD_course_name());
			}else{
				orderInfo.setdAddrId(getAddrId(orderInfo.getdAddrType(), order.getD_place_name()));
				orderInfo.setdAddrName(order.getD_place_name());
			}
			if(orderInfo.getdAddrName() == null){
				orderInfo.setdAddrName("");
			}
			
			String dtreePath = order.getD_province()+","+order.getD_city()+","+order.getD_county();
			orderInfo.setdAreaId(getAreaId(dtreePath));
			orderInfo.setdContact(order.getD_contact());
			orderInfo.setdMobile(order.getD_mobile().length() > 11?order.getD_mobile().substring(0, 10):order.getD_mobile());
			orderInfo.setdTreePath(dtreePath);
			// other
			orderInfo.setIsHelped(order.getIs_helped()==null?false:order.getIs_helped());
			orderInfo.setIsDelete(order.getDeleted_at()!=null?true:false);
			orderInfo.setIsHandleQuestion(true);
			orderInfo.setRemark(order.getRemark());
			UserWeixin userWeixin = userWeixinService.findById(orderInfo.getUserId());
			orderInfo.setOpenid(userWeixin != null?userWeixin.getOpenid():"");
			if(orderInfo.getOrderStatus().intValue() == OrderStatus.pay_succ.getCode()){
				if(userSet.contains(orderInfo.getUserId())){
					orderInfo.setFirstOrder(false);
				}else{
					orderInfo.setFirstOrder(true);
				}
				orderInfo.setFirstOrder(false);
			}
			/**
			 * 券信息处理
			 */
			Integer couponId = couponMap.get(String.valueOf(order.getGroup_coupon_id()));
			String couponCode = order.getGroup_coupon_code();
			Double discount = order.getDiscount();
			orderInfo.setCouponCode(couponCode);
			orderInfo.setCouponId(couponId);
//			orderInfo.setDiscount(discount);
			orderInfoService.inser(orderInfo);
			
			if(couponId !=null){
				/**
				 * 添加订单消费券记录
				 */
				int activityId = 0;
				String activityName = "";
				int type = 0;
				try {
					String sql = "select c.*,a.name as activity_name from coupon c left join activity a on c.activity_id=a.id where c.id="+order.getGroup_coupon_id()+"";
					Statement stat = connection.createStatement();
					ResultSet rs = stat.executeQuery(sql);
					if(rs.next()){
						activityId = rs.getInt("activity_id");
						activityName = rs.getString("activity_name");
						type = rs.getInt("type");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					rs.close();
				}
				
				OrderCoupon orderCoupon = new OrderCoupon();
				orderCoupon.setActivityId(activityId);
				orderCoupon.setActivityName(activityName);
				orderCoupon.setAmount(discount);
				orderCoupon.setBalance(0);
				orderCoupon.setCode(couponCode);
				orderCoupon.setCouponId(couponId);
				orderCoupon.setCreateTime(order.getCreated_at());
				orderCoupon.setOrderId(orderInfo.getId());
				orderCoupon.setStatus(1);
				orderCoupon.setType(type);
				orderCoupon.setUpdateTime(order.getCreated_at());
				orderCoupon.setUserId(orderInfo.getUserId());
				orderCoupon.setUserName(userWeixin != null?userWeixin.getNickname():"");
				orderCouponService.insert(orderCoupon);;
			}
			
			DataMigration data = new DataMigration();
			data.setOldId(order.getId());
			data.setNewId(orderInfo.getId());
			data.setType(TableTypes.order.getType());
			dataMigrationService.insert(data);
		}
	}
	
	/**
	 *  订单状态转换
	  * @Title: statusConvert
	  * @Description: TODO
	  * @author: share 2016年9月5日
	  * @modify: share 2016年9月5日
	  * @param status
	  * @return
	 */
	private Integer[] statusConvert(Order order){
		Integer[] orderAllStatus = new Integer[6];
		/*状态
		-1:未知;
		1:待付款;
		2:等待顺丰上门收件;
		3:快递员正在派件，待签收;
		4:已签收，从顺丰路由获取的已签收状态;
		5:取消订单，交易关闭;
		6:已付款，(作废，已付款专门有个字段is_paid);
		7:球场人员正常签收,球场签收并核对无误;
		8:球场人员问题签收,协调处理后球场已签收;
		9:球场人员确认发出球包，(已送离球场);
		10:客服设置球包异常;
		11:球包已经移送到『出发台』;
		12:球场启运的订单支付后或VIP确认后，订单状态置为『取包处』;
		13:快递员已取件，运输途中(顺丰路由自动提醒);
		14:下发顺丰SBP成功，拿到运单号，等待顺丰确认;
		15:微信支付失败;
		16:顺丰BSP下单失败;
		17:顺丰BSP下单成功后，顺丰小弟判定地址错误不可收派;
		18:顺丰派单失败暂不用到订单状态中，会通知客服处理;
		19:VIP订单待确认;
		20:VIP订单已确认;
		21:联系顺丰排查原因中暂不用;
		22:失败原因已确认
		23:顺丰已取件(客服手动变更);
		24:取件失败暂不用;
		25:球场已确认待签收;
		26:待退款;
		27:异常结单;
		101:临时使用，删除状态，仅程序内部使用，不可将订单状态变更为此状态;
		102:临时使用，纸质订单状态，仅程序内部使用，不可将订单状态变更为此状态*/
		int order_status = 1;
		int refund_status = 1;
		int delivery_status = 1;
		int bps_status = 1;
		int handle_type = 1;
		int question_status = 1;
		switch (order.getStatus()) {
		case -1:
			break;
		case 1:// 1:待付款;
			break;
		case 2:// 2：等待顺丰上门收件;
			order_status = OrderStatus.pay_succ.getCode();
			refund_status = RefundStatus.refund_normal.getCode();
			delivery_status = DeliveryStatus.wait_sf_recive.getCode();
			bps_status = SfBpsStatus.sucess.getCode();
			handle_type = 1;
			break;
		case 3:// 快递员正在派件，待签收;
			order_status = OrderStatus.pay_succ.getCode();
			refund_status = RefundStatus.refund_normal.getCode();
			delivery_status = DeliveryStatus.delivery_ing.getCode();
			bps_status = SfBpsStatus.sucess.getCode();
			handle_type = 1;
			break;
		case 4:// 已签收，从顺丰路由获取的已签收状态;
			order_status = OrderStatus.pay_succ.getCode();
			refund_status = RefundStatus.refund_normal.getCode();
			delivery_status = DeliveryStatus.signed.getCode();
			bps_status = SfBpsStatus.sucess.getCode();
			handle_type = 1;
			break;
		case 5:// 取消订单，交易关闭;
			if(order.getIs_paid() != null && order.getIs_paid()){
				refund_status = RefundStatus.refund_sucess.getCode();
				bps_status = SfBpsStatus.sucess.getCode();
			}else{
				refund_status = RefundStatus.refund_normal.getCode();
				bps_status = SfBpsStatus.un_send.getCode();
			}
			order_status = OrderStatus.user_close.getCode();
			delivery_status = DeliveryStatus.un_send_sf.getCode();
			handle_type = 1;
			break;
		case 6:// 已付款，(作废，已付款专门有个字段is_paid);
			order_status = OrderStatus.pay_succ.getCode();
			refund_status = RefundStatus.refund_normal.getCode();
			delivery_status = DeliveryStatus.signed.getCode();
			bps_status = SfBpsStatus.sucess.getCode();
			handle_type = 1;
			break;
		case 7:// 球场人员正常签收,球场签收并核对无误;
			order_status = OrderStatus.pay_succ.getCode();
			refund_status = RefundStatus.refund_normal.getCode();
			delivery_status = DeliveryStatus.signed.getCode();
			bps_status = SfBpsStatus.sucess.getCode();
			handle_type = 1;
			break;
		case 8:// :球场人员问题签收,协调处理后球场已签收;
			order_status = OrderStatus.pay_succ.getCode();
			refund_status = RefundStatus.refund_normal.getCode();
			delivery_status = DeliveryStatus.signed.getCode();
			bps_status = SfBpsStatus.sucess.getCode();
			handle_type = 1;
			question_status = 2;
			break;
		case 9:// 客服设置球包异常;
			order_status = OrderStatus.pay_succ.getCode();
			refund_status = RefundStatus.refund_normal.getCode();
			delivery_status = DeliveryStatus.kf_confirm_recived.getCode();
			bps_status = SfBpsStatus.sucess.getCode();
			handle_type = 1;
			break;
		case 13:// 快递员已取件，运输途中(顺丰路由自动提醒);
			order_status = OrderStatus.pay_succ.getCode();
			refund_status = RefundStatus.refund_normal.getCode();
			delivery_status = DeliveryStatus.transport_ing.getCode();
			bps_status = SfBpsStatus.sucess.getCode();
			handle_type = 1;
			break;
		case 14:// 下发顺丰SBP成功，拿到运单号，等待顺丰确认;
			order_status = OrderStatus.pay_succ.getCode();
			refund_status = RefundStatus.refund_normal.getCode();
			delivery_status = DeliveryStatus.wait_sf_recive.getCode();
			bps_status = SfBpsStatus.sucess.getCode();
			handle_type = 1;
			break;
		case 22:// 客户取消已支付订单  --  用户/客服                 
			refund_status = RefundStatus.refund_sucess.getCode();
			bps_status = SfBpsStatus.sucess.getCode();
			order_status = OrderStatus.kf_close.getCode();
			delivery_status = DeliveryStatus.un_send_sf.getCode();
			handle_type = 1;
			break;
		case 23:// 顺丰已取件(客服手动变更);
			order_status = OrderStatus.pay_succ.getCode();
			refund_status = RefundStatus.refund_normal.getCode();
			delivery_status = DeliveryStatus.kf_confirm_recived.getCode();
			bps_status = SfBpsStatus.sucess.getCode();
			handle_type = 1;
			break;
		case 30: // 已完成退款到客户
			order_status = OrderStatus.kf_close.getCode();
			refund_status = RefundStatus.refund_sucess.getCode();
			delivery_status = DeliveryStatus.un_send_sf.getCode();
			bps_status = SfBpsStatus.un_send.getCode();
			handle_type = 1;
			break;
		default:
			LogCvt.error("订单状态变迁，未处理的订单状态："+order.getId()+",状态："+order.getStatus());
			break;
		}
		orderAllStatus[0] = order_status;
		orderAllStatus[1] = refund_status;
		orderAllStatus[2] = delivery_status;
		orderAllStatus[3] = bps_status;
		orderAllStatus[4] = handle_type;
		orderAllStatus[5] = question_status;
		return orderAllStatus;
	}
	
	/**
	 * 寄件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
	  * @Title: getAddrType
	  * @Description: TODO
	  * @author: share 2016年9月5日
	  * @modify: share 2016年9月5日
	  * @param addr_type
	  * @return
	 */
	private int getAddrType(String addr_type){
		if(addr_type == null)return 0;
		addr_type = addr_type.trim();
		if("address".equals(addr_type)){
			return 4;
		}else if("airport".equals(addr_type)){
			return 2;
		}else if("bank".equals(addr_type)){
			return 3;
		}else if("course".equals(addr_type)){
			return 1;
		}else if("sf".equals(addr_type)){
			return 5;
		}
		return 0;
	}
	
	/**
	 *  获取地址ID
	  * @Title: getAddrId
	  * @Description: TODO
	  * @author: share 2016年9月5日
	  * @modify: share 2016年9月5日
	  * @param addrType
	  * @param addrName
	  * @return
	 */
	public int getAddrId(int addrType,String addrName){
		int addrId = 0;
		try {
			if(addrType == 1){
				addrId = DataCacheUtil.getCourseMap(addrName).getId();
			}else if(addrType == 2){
				addrId = DataCacheUtil.getBaseAirportMap(addrName).getId();
			}else if(addrType == 3){
				addrId = DataCacheUtil.getBaseBankBranchMap(addrName).getId();
			}else if(addrType == 5){
				addrId = DataCacheUtil.getBaseSfSiteMap(addrName).getId();
			}
		} catch (Exception e) {
			LogCvt.error("未能找到名称对应的ID:"+addrName);
		}
		return addrId;
	}
	
	public int getAddrCourseId(String addrName){
		int addrId = 0;
		try {
			addrId = DataCacheUtil.getCourseMap(addrName).getId();
		} catch (Exception e) {
			LogCvt.error("未能找到名称对应的ID:"+addrName);
		}
		return addrId;
	}
	
	public int getAreaId(String addrName){
		int addrId = 0;
		try {
			return DataCacheUtil.getBaseSfAreaMap(addrName.replace("市,", ",")).getId();
		} catch (Exception e) {
			LogCvt.error("未能找到名称对应的ID:"+addrName);
		}
		return addrId;
	}

}

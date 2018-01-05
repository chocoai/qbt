package com.qbt.timer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.logback.LogCvt;

/**
 *  业务跑批
  * @ClassName: AutoWechatService
  * @Description: TODO
  * @author share 2014-1-3
  * @modify share 2014-1-3
 */
@Service("autoService")
public class AutoService {
	
	@Resource(name="orderDelayTimerService")
	private TimerService orderDelayTimerService;
	
	@Resource(name="closeOrderTimerService")
	private TimerService closeOrderTimerService;
	
	@Resource(name="orderRouteTimerService")
	private TimerService orderRouteTimerService;
	
	@Resource(name="orderConfirmTimerService")
	private TimerService orderConfirmTimerService;
	
	@Resource(name="orderSendTimerService")
	private TimerService orderSendTimerService;
	
	@Resource(name="orderTimeoutSendTimerService")
	private TimerService orderTimeoutSendTimerService;
	
	@Resource(name="orderTimeoutDeliverTimerService")
	private TimerService orderTimeoutDeliverTimerService;
	
	@Resource(name="taskFlowCleanTimerService")
	private TimerService taskFlowCleanTimerService;
	
	@Resource(name="expireCouponTimerService")
	private TimerService expireCouponTimerService;
	
	@Resource(name="orderReminderDeliverTimerService")
	private TimerService orderReminderDeliverTimerService;
	
	@Resource(name="wechatUserSubcripbeTimerService")
	private TimerService wechatUserSubcripbeTimerService;
	
	@Resource(name="baseNewsReadTimesTimerService")
	private TimerService baseNewsReadTimesTimerService;

	@Resource(name="afterHalfhourProxyUnpayService")
	private TimerService afterHalfhourProxyUnpayService;
	
	@Resource(name="afterOnehourProxyUnpayService")
	private TimerService afterOnehourProxyUnpayService;
	
	@Resource(name="sfExpressLogCleanTimerService")
	private TimerService sfExpressLogCleanTimerService;
	
	@Resource(name="closeOrderForOfficialTimerService")
	private TimerService closeOrderForOfficialTimerService;
	
	@Resource(name="userOrderRouteTimerService")
	private TimerService userOrderRouteTimerService;
	
	@Resource(name="saleUserQrcodeComposeImageService")
	private TimerService saleUserQrcodeComposeImageService;
	
	@Resource(name="orderAutoConfirmTimerService")
	private TimerService orderAutoConfirmTimerService;
	
	
	/**
	 *  自动检查延迟下单信息
	  * @Title: autoSynCinemaTimer
	  * @Description: TODO
	  * @author: share 2016年8月19日
	  * @modify: share 2016年8月19日
	 */
	public void autoOrderDelayTimer(){
		try{
			LogCvt.info("....自动检查延迟下单信息..[START]...");
			orderDelayTimerService.run();
			LogCvt.info("....自动检查延迟下单信息..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 定时关单
	 */
	public void autoCloseOrderTimer(){
		try{
			LogCvt.info("....定时关闭订单..[START]...");
			closeOrderTimerService.run();
			LogCvt.info("....定时关闭订单..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 定时查询顺丰物流信息
	 */
	public void autoOrderRouteTimer(){
		try{
			LogCvt.info("....定时查询物流信息..[START]...");
			orderRouteTimerService.run();
			LogCvt.info("....定时查询物流信息..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 确认当天新下单是否能运送
	 */
	public void autoOrderConfirmTimer(){
		try{
			LogCvt.info("....定时确认订单..[START]...");
			orderConfirmTimerService.run();
			LogCvt.info("....定时确认订单..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 客服确认预约取件两小时内顺丰人员是否上门取件
	 */
	public void autoOrderSendTimer(){
		try{
			LogCvt.info("....定时确认预约取件..[START]...");
			orderSendTimerService.run();
			LogCvt.info("....定时确认预约取件..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 客服确认预约取件超时
	 */
	public void autoOrderTimeoutSendTimer(){
		try{
			LogCvt.info("....定时确认预约取件超时..[START]...");
			orderTimeoutSendTimerService.run();
			LogCvt.info("....定时确认预约取件超时..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 客服确认球包预计到达超时
	 */
	public void autoOrderTimeoutDeliverTimer(){
		try{
			LogCvt.info("....定时确认球包预计到达超时..[START]...");
			orderTimeoutDeliverTimerService.run();
			LogCvt.info("....定时确认球包预计到达超时..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 定时清除订单客服跟踪表记录
	 */
	public void autoTaskFlowCleanTimer(){
		try{
			LogCvt.info("....定时清除订单客服跟踪表记录..[START]...");
			taskFlowCleanTimerService.run();
			LogCvt.info("....定时清除订单客服跟踪表记录..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 券过期定时提醒
	 */
	public void autoExpireCouponTimer(){
		try{
			LogCvt.info("....定时提醒券过期..[START]...");
			expireCouponTimerService.run();
			LogCvt.info("....定时提醒券过期..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 球包预计到达时间前两个小时未被签收,提醒客服
	 */
	public void autoOrderReminderDeliverTimer(){
		try{
			LogCvt.info("....定时提醒球包两小时后预计到达..[START]...");
			orderReminderDeliverTimerService.run();
			LogCvt.info("....定时提醒球包两小时后预计到达..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 
	 * autoWechatUserSubcripbeTimer:(定时更新微信用户关注状态).
	 *
	 * @author huangyihao
	 * 2017年2月9日 下午1:58:50
	 *
	 */
	public void autoWechatUserSubcripbeTimer(){
		try{
			LogCvt.info("....定时更新微信用户关注状态..[START]...");
			wechatUserSubcripbeTimerService.run();
			LogCvt.info("....定时更新微信用户关注状态..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 每天定时从redis拿官网新闻阅读数更新到数据库
	 */
	public void autoBaseNewsReadTimesTimer(){
		try{
			LogCvt.info("....定时更新官网新闻阅读量..[START]...");
			baseNewsReadTimesTimerService.run();
			LogCvt.info("....定时更新官网新闻阅读量..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}

	public void autoAfterHalfhourProxyUnpayTimer(){
		try{
			LogCvt.info("....定时当代下订单于下单时间30分钟后未支付，发手机短信至该客户手机号或该销售..[START]...");
			afterHalfhourProxyUnpayService.run();
			LogCvt.info("....定时当代下订单于下单时间30分钟后未支付，发手机短信至该客户手机号或该销售..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	

	public void autoAfterOnehourProxyUnpayTimer(){
		try{
			LogCvt.info("....定时当代下订单于下单时间60分钟后未支付，发手机短信至团队秘书(销售人员)手机号..[START]...");
			afterOnehourProxyUnpayService.run();
			LogCvt.info("....定时当代下订单于下单时间60分钟后未支付，发手机短信至团队秘书(销售人员)手机号..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	
	public void autoSfExpressLogCleanTimer(){
		try{
			LogCvt.info("....定时清除顺丰发送日志..[START]...");
			sfExpressLogCleanTimerService.run();
			LogCvt.info("....定时清除顺丰发送日志..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 官网定时关单
	 */
	public void autoCloseOrderForOfficialTimer(){
		try{
			LogCvt.info("....官网定时关闭订单..[START]...");
			closeOrderForOfficialTimerService.run();
			LogCvt.info("....官网定时关闭订单..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 用户订单地址统计过渡
	  * @Title: userRouteTimer
	  * @Description: TODO
	  * @author: chenxiaocong 2017年3月12日
	  * @modify: chenxiaocong 2017年3月12日
	 */
	public void autoUserOrderRouteTimer(){
		try{
			LogCvt.info("....用户订单地址统计过渡..[START]...");
			userOrderRouteTimerService.run();
			LogCvt.info("....用户订单地址统计过渡..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 销售二维码历史数据图片合成
	 * @author wuwang
	 */
	public void autoSaleUserQrcodeComposeImageTimer(){
		try{
			LogCvt.info("....销售二维码历史数据图片合成..[START]...");
			saleUserQrcodeComposeImageService.run();
			LogCvt.info("....销售二维码历史数据图片合成..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
	/**
	 * 订单签收7天后自动设置为已确认收包
	 */
	public void autoOrderConfirmReceiveTimer(){
		try{
			LogCvt.info("....订单签收7天后自动设置为已确认收包..[START]...");
			orderAutoConfirmTimerService.run();
			LogCvt.info("....订单签收7天后自动设置为已确认收包..[END]...");
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}
}

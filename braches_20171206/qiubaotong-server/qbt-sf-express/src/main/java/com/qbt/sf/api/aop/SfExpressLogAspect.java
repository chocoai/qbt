/**
 * Project Name:qbt-sf-express
 * File Name:SfExpressLogAspect.java
 * Package Name:com.qbt.sf.api.aop
 * Date:2017年3月6日下午2:38:06
 *
*/

package com.qbt.sf.api.aop;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.CollectionsUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.BaseSfExpressLog;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseSfExpressLogService;
import com.qbt.sf.api.bean.delivertm.Address;
import com.qbt.sf.api.bean.delivertm.DeliverTmReq;
import com.qbt.sf.api.bean.delivertm.DeliverTmResp;
import com.qbt.sf.api.bean.order.OrderReq;
import com.qbt.sf.api.bean.order.OrderReqOrder;
import com.qbt.sf.api.bean.order.OrderResp;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseReq;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseReqOrder;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseResp;
import com.qbt.sf.api.bean.website.DeliverReq;
import com.qbt.sf.api.bean.website.DeliverResp;
import com.qbt.sf.api.util.JaxbUtil;

/**
 * ClassName:SfExpressLogAspect
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月6日 下午2:38:06
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Aspect
@Component
public class SfExpressLogAspect {
	
	@Resource
	private BaseSfExpressLogService baseSfExpressLogService;
	
	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Pointcut("execution(* com.qbt.sf.api.service.SFExpressApiService.deliverTmService(..))")
	public void deliverTmServiceLog(){}
	
	@AfterReturning(value = "deliverTmServiceLog()", returning="returnValue")
	public void afterDeliverTmServiceLog(JoinPoint joinPoint, Object returnValue){
		LogCvt.info("=====顺丰时效查询接口aop日志记录开始=====");
		//获取方法名  
        String methodName = joinPoint.getSignature().getName();  
		
		//获取请求参数
		Object[] args = joinPoint.getArgs();
		DeliverTmReq req = BeanUtil.a2b(args[0], DeliverTmReq.class);
		//关键字集合
		Set<String> keywordList = new LinkedHashSet<String>();
		Address srcAddress = req.getBody().getDeliverTmRequest().getSrcAddress();
		keywordList.add(srcAddress.getProvince());
		keywordList.add(srcAddress.getCity());
		keywordList.add(srcAddress.getDistrict());
		keywordList.add(srcAddress.getAddress());
		Address destAddress = req.getBody().getDeliverTmRequest().getDestAddress();
		keywordList.add(destAddress.getProvince());
		keywordList.add(destAddress.getCity());
		keywordList.add(destAddress.getDistrict());
		keywordList.add(destAddress.getAddress());
		
		//获取返回参数
		DeliverTmResp resp = BeanUtil.a2b(returnValue, DeliverTmResp.class);
		
		BaseSfExpressLog log = new BaseSfExpressLog();
		log.setServiceName(methodName);
		log.setRequestBody(JaxbUtil.convertToXml(req));
		log.setResponseBody(Checker.isNotEmpty(resp) ? Checker.isNotEmpty(resp) ? JaxbUtil.convertToXml(resp) : "" : "");
		log.setKeyword(CollectionsUtil.listToStr(keywordList, "|"));
		log.setStatus(Checker.isNotEmpty(resp) && "OK".equals(resp.getHead()) ? 1 : 2);
		baseSfExpressLogService.insert(log);
		LogCvt.info("=====顺丰时效查询接口aop日志记录结束=====");
	}
	
	@Pointcut("execution(* com.qbt.sf.api.service.SFExpressApiService.deliverTmServiceBySfWebSite(..))")
	public void deliverTmServiceBySfWebSiteLog(){}
	
	@AfterReturning(value = "deliverTmServiceBySfWebSiteLog()", returning="returnValue")
	public void afterDeliverTmServiceBySfWebSiteLogLog(JoinPoint joinPoint, Object returnValue){
		LogCvt.info("=====顺丰官网时效查询接口aop日志记录开始=====");
		//获取方法名  
        String methodName = joinPoint.getSignature().getName();  
		
		//获取请求参数
		Object[] args = joinPoint.getArgs();
		DeliverReq req = BeanUtil.a2b(args[0], DeliverReq.class);
		//关键字集合
		Set<String> keywordList = new LinkedHashSet<String>();
		BaseSfArea srcArea = baseSfAreaService.findById(req.getSrcAreaId());
		if(Checker.isNotEmpty(srcArea)){
			String[] srcTreePaths = srcArea.getTreePath().split(",");
			for(String srcTreePath : srcTreePaths){
				keywordList.add(srcTreePath);
			}
		}
		BaseSfArea destArea = baseSfAreaService.findById(req.getDestAreaId());
		if(Checker.isNotEmpty(destArea)){
			String[] destTreePaths = destArea.getTreePath().split(",");
			for(String destTreePath : destTreePaths){
				keywordList.add(destTreePath);
			}
		}
		
		//获取返回参数
		List<DeliverResp> resp = JSonUtil.toArray(JSonUtil.toJSonString(returnValue), DeliverResp.class);
		
		BaseSfExpressLog log = new BaseSfExpressLog();
		log.setServiceName(methodName);
		log.setRequestBody(JSonUtil.toJSonString(req));
		log.setResponseBody(JSonUtil.toJSonString(resp));
		log.setKeyword(CollectionsUtil.listToStr(keywordList, "|"));
		log.setStatus(Checker.isNotEmpty(resp) ? 1 : 2);
		baseSfExpressLogService.insert(log);
		LogCvt.info("=====顺丰官网时效查询接口aop日志记录结束=====");
	}
	
	@Pointcut("execution(* com.qbt.sf.api.service.SFExpressApiService.orderService(..))")
	public void orderServiceLog(){}
	
	@AfterReturning(value = "orderServiceLog()", returning="returnValue")
	public void afterOrderServiceLog(JoinPoint joinPoint, Object returnValue){
		LogCvt.info("=====顺丰正向下单接口aop日志记录开始=====");
		//获取方法名  
        String methodName = joinPoint.getSignature().getName();  
		
		//获取请求参数
		Object[] args = joinPoint.getArgs();
		OrderReq req = BeanUtil.a2b(args[0], OrderReq.class);
		//关键字集合
		Set<String> keywordList = new LinkedHashSet<String>();
		OrderReqOrder orderReqOrder = req.getBody().getOrder();
		keywordList.add(orderReqOrder.getOrderid());
		
		//获取返回参数
		OrderResp resp = BeanUtil.a2b(returnValue, OrderResp.class);
		boolean isSucc = Checker.isNotEmpty(resp) && "OK".equals(resp.getHead());
		if(isSucc){
			keywordList.add(resp.getDeliverOrder().get(0).getMailno());
		}
		
		BaseSfExpressLog log = new BaseSfExpressLog();
		log.setServiceName(methodName);
		log.setRequestBody(JaxbUtil.convertToXml(req));
		log.setResponseBody(Checker.isNotEmpty(resp) ? JaxbUtil.convertToXml(resp) : "");
		log.setKeyword(CollectionsUtil.listToStr(keywordList, "|"));
		log.setStatus(isSucc ? 1 : 2);
		baseSfExpressLogService.insert(log);
		LogCvt.info("=====顺丰正向下单接口aop日志记录结束=====");
	}
	
	@Pointcut("execution(* com.qbt.sf.api.service.SFExpressApiService.orderReverseService(..))")
	public void orderReverseServiceLog(){}
	
	@AfterReturning(value = "orderReverseServiceLog()", returning="returnValue")
	public void afterOrderReverseServiceLog(JoinPoint joinPoint, Object returnValue){
		LogCvt.info("=====顺丰逆向下单接口aop日志记录开始=====");
		//获取方法名  
        String methodName = joinPoint.getSignature().getName();  
		
		//获取请求参数
		Object[] args = joinPoint.getArgs();
		OrderReverseReq req = BeanUtil.a2b(args[0], OrderReverseReq.class);
		//关键字集合
		Set<String> keywordList = new LinkedHashSet<String>();
		OrderReverseReqOrder orderReverseReqOrder = req.getBody().getOrder();
		keywordList.add(orderReverseReqOrder.getOrderid());
		
		//获取返回参数
		OrderReverseResp resp = BeanUtil.a2b(returnValue, OrderReverseResp.class);
		boolean isSucc = Checker.isNotEmpty(resp) && "OK".equals(resp.getHead());
		if(isSucc){
			keywordList.add(resp.getDeliverOrder().get(0).getMailno());
		}
		
		BaseSfExpressLog log = new BaseSfExpressLog();
		log.setServiceName(methodName);
		log.setRequestBody(JaxbUtil.convertToXml(req));
		log.setResponseBody(Checker.isNotEmpty(resp) ? JaxbUtil.convertToXml(resp) : "");
		log.setKeyword(CollectionsUtil.listToStr(keywordList, "|"));
		log.setStatus(isSucc ? 1 : 2);
		baseSfExpressLogService.insert(log);
		LogCvt.info("=====顺丰逆向下单接口aop日志记录结束=====");
	}
	
	
}

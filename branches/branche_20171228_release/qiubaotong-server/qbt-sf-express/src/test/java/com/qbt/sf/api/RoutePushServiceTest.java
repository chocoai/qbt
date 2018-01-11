/**
 * @Title: DeliverTmServiceTest.java
 * @Package com.qbt.sf.api
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月5日
 * @version V1.0
 **/

package com.qbt.sf.api;

import org.junit.Test;

import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.StringUtil;
import com.qbt.sf.api.bean.routepush.RoutePushReq;
import com.qbt.sf.api.bean.routepush.RoutePushReqDeliver;
import com.qbt.sf.api.util.JaxbUtil;

/**
  * @ClassName: DeliverTmServiceTest
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
  */

public class RoutePushServiceTest {

	@Test
	public void routePushService() throws Exception{
		
//		SFExpressApiService xx=new SFExpressApiServiceImpl();
//		WaybillRoute waybillRoute = new WaybillRoute ();
//		waybillRoute.setId(1004936106408L);
//		waybillRoute.setMailno("444003079772");
//		waybillRoute.setOrderid("TE201500106");
//		waybillRoute.setAcceptTime("2015-01-04 17:42:00");
//		waybillRoute.setAcceptAddress("深圳");
//		waybillRoute.setRemark("上门收件");
//		waybillRoute.setOpCode("50");
//		
//		
//		RoutePushReqBody body = new RoutePushReqBody();
//		body.setWaybillRoute(waybillRoute);
//		WayBillRouteReq req=new WayBillRouteReq();
//		req.setHead("SHGLXX");
//		req.setBody(body);
//		
//		WayBillRouteResp resp=xx.routePushService(req);
//		System.out.println(resp);
	}
	
	
	/*
	@Test
	public void test(){
		String xml="<?xml version='1.0' encoding='UTF-8'?>"+
	"<Response service=\"DeliverTmService\">"+
	"<Head>OK</Head>"+
	"<Body>"+
	"<DeliverTmResponse>"+
	"<DeliverTm business_type_desc=\"电商特惠\" deliver_time=\"2016-08-07 20:00:00,2016-08-07 20:00:00\" business_type=\"3\"/>"+
	"<DeliverTm business_type_desc=\"顺丰次日\" deliver_time=\"2016-08-07 20:00:00,2016-08-07 20:00:00\" business_type=\"1\"/>"+
	"<DeliverTm business_type_desc=\"电商速配\" deliver_time=\"2016-08-07 20:00:00,2016-08-07 20:00:00\" business_type=\"7\"/>"+
	"<DeliverTm business_type_desc=\"生鲜速配\" deliver_time=\"2016-08-07 20:00:00,2016-08-07 20:00:00\" business_type=\"15\"/>"+
	"<DeliverTm business_type_desc=\"顺丰隔日\" deliver_time=\"2016-08-08 20:00:00,2016-08-08 20:00:00\" business_type=\"2\"/>"+
	"</DeliverTmResponse>"+
	"</Body>"+
	"</Response>";
		
		
	DeliverTmResp resp = JaxbUtil.converyToJavaBean(xml, DeliverTmResp.class);
		System.out.println(resp);
		

		DeliverTmResp  xx=new DeliverTmResp();
		xx.setHead("OK");
		xx.setService("DeliverTmService");
		
		DeliverTmRespBody body=new DeliverTmRespBody();
		
		DeliverTmRespDeliver deliver=new DeliverTmRespDeliver();
				
		deliver.setBusiness_type("3");
		deliver.setBusiness_type_desc("电商特惠");
		deliver.setDeliver_time("2016-08-07 20:00:00,2016-08-07 20:00:00");
		
		
		DeliverTmRespDeliver deliver1=new DeliverTmRespDeliver();
		
		deliver1.setBusiness_type("3");
		deliver1.setBusiness_type_desc("电商特惠");
		deliver1.setDeliver_time("2016-08-07 20:00:00,2016-08-07 20:00:00");;
		
		List list=new ArrayList();
		list.add(deliver);
		list.add(deliver1);
		
		body.setDeliverTm(list);
		
		xx.setBody(body);
		
		System.out.println(JaxbUtil.convertToXml(xx));
		

		System.out.println(JaxbUtil.converyToJavaBean(JaxbUtil.convertToXml(xx), DeliverTmResp.class));
		
	}
	*/
	
	
	public static void main(String[] args) {
		String xml= "content=%3C%3Fxml+version%3D%271.0%27+encoding%3D%27UTF-8%27%3F%3E%3CRequest+service%3D%22RoutePushService%22+lang%3D%22zh-CN%22%3E%3CBody%3E%3CWaybillRoute+id%3D%2210049610355297%22+mailno%3D%22444739949795%22+orderid%3D%22QBT20160824100000002%22+acceptTime%3D%222016-08-24+00%3A00%3A00%22+acceptAddress%3D%22%E6%B7%B1%E5%9C%B3%E5%B8%82%22+remark%3D%22%E9%A1%BA%E4%B8%B0%E9%80%9F%E8%BF%90+%E5%B7%B2%E6%94%B6%E5%8F%96%E5%BF%AB%E4%BB%B6%22+opCode%3D%2250%22%2F%3E%3CWaybillRoute+id%3D%2210444739949701%22+mailno%3D%22444739949795%22+orderid%3D%22QBT20160824100000002%22+acceptTime%3D%222016-08-23+14%3A55%3A23%22+acceptAddress%3D%22%E6%B7%B1%E5%9C%B3%E5%B8%82%22+remark%3D%22-%22+opCode%3D%2250%22%2F%3E%3C%2FBody%3E%3C%2FRequest%3E";
		String postStr = StringUtil.urldecode(xml).substring(8);
		System.out.println(postStr);
		RoutePushReq routePushReq = JaxbUtil.converyToJavaBean(postStr, RoutePushReq.class);
		
		System.out.println(routePushReq.getDeliverRoute().size());
		for(RoutePushReqDeliver deliver :routePushReq.getDeliverRoute()){
			System.out.println(JSonUtil.toJSonString(deliver));
		}
	}

}

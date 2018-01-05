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

import com.qbt.sf.api.bean.SfExpressBean;
import com.qbt.sf.api.bean.delivertm.Address;
import com.qbt.sf.api.bean.delivertm.DeliverTmReq;
import com.qbt.sf.api.bean.delivertm.DeliverTmReqBody;
import com.qbt.sf.api.bean.delivertm.DeliverTmReqDeliver;
import com.qbt.sf.api.bean.delivertm.DeliverTmResp;
import com.qbt.sf.api.bean.orderzd.OrderZDReq;
import com.qbt.sf.api.bean.orderzd.OrderZDReqDeliver;
import com.qbt.sf.api.bean.orderzd.OrderZDReqBody;
import com.qbt.sf.api.bean.orderzd.OrderZDResp;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.service.SFExpressApiServiceImpl;

/**
  * @ClassName: DeliverTmServiceTest
  * @Description: TODO
  * @author win8 2016年8月6日
  * @modify win8 2016年8月6日
  */

public class OrderZDServiceTest {

	@Test
	public void orderZDService() throws Exception{
		
		SFExpressApiService xx=new SFExpressApiServiceImpl();
		/*SfExpressBean param=new SfExpressBean();
		param.setCheckWord("0P6m2kS55YORklfw");
		param.setUrl("http://bspoisp.sit.sf-express.com:11080/bsp-oisp/sfexpressService");*/
		
		OrderZDReqDeliver orderZDReq=new OrderZDReqDeliver();
		orderZDReq.setOrderid("TE201500104");
		orderZDReq.setParcel_quantity(2);
		
		OrderZDReqBody body=new OrderZDReqBody();
		body.setOrderZDReq(orderZDReq);
		OrderZDReq req = new OrderZDReq();
		req.setHead("SHGLXX");
		req.setBody(body);
		
		OrderZDResp resp=xx.orderZDService(req);
		System.out.println(resp);
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

}

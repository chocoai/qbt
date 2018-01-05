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

import com.qbt.sf.api.bean.identity.IdentityReq;
import com.qbt.sf.api.bean.identity.IdentitySearchReqBody;
import com.qbt.sf.api.bean.identity.IdentitySearchReqDeliver;
import com.qbt.sf.api.bean.identity.IdentitySearchResp;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.service.SFExpressApiServiceImpl;

/**
  * @ClassName: DeliverTmServiceTest
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
  */

public class IdentitySearchServiceTest {

	@Test
	public void identitySearchService() throws Exception{
		
		SFExpressApiService xx=new SFExpressApiServiceImpl();
		
		IdentitySearchReqDeliver deliver=new IdentitySearchReqDeliver();
		deliver.setName("候小姐");
		deliver.setPhone("13900010002");
		
		IdentitySearchReqBody body=new IdentitySearchReqBody();
		body.setIdentitySearchRequest(deliver);
		IdentityReq req=new IdentityReq();
		req.setHead("SHGLXX");
		req.setBody(body);
		
		IdentitySearchResp resp=xx.identitySearchService(req);
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

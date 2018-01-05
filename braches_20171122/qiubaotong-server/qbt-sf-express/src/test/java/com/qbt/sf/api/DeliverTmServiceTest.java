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
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.service.SFExpressApiServiceImpl;

/**
  * @ClassName: DeliverTmServiceTest
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
  */

public class DeliverTmServiceTest {

	@Test
	public void deliverTmService() throws Exception{
		
		SFExpressApiService xx=new SFExpressApiServiceImpl();
		/*SfExpressBean param=new SfExpressBean();
		param.setCheckWord("0P6m2kS55YORklfw");
		param.setUrl("http://bspoisp.sit.sf-express.com:11080/bsp-oisp/sfexpressService");*/
		DeliverTmReqDeliver deliver=new DeliverTmReqDeliver();
		deliver.setBusiness_type("2");
		deliver.setWeight("18");
		deliver.setConsigned_time("2016-08-07 11:23:54");
		
		Address src=new Address();
		src.setProvince("上海");
		src.setCity("上海市");
		src.setDistrict("浦东新区");
		src.setAddress("浦东机场2号航站楼国际到达出口（A2）顺丰柜台，机场行李寄放处");
		
		Address dest=new Address();
		dest.setProvince("广东");
		dest.setCity("珠海市");
		dest.setDistrict("香洲区");
		dest.setAddress("兴业路223号农商金融大厦1");
		
		deliver.setSrcAddress(src);
		deliver.setDestAddress(dest);
		DeliverTmReqBody body=new DeliverTmReqBody();
		body.setDeliverTmRequest(deliver);
		DeliverTmReq req=new DeliverTmReq();
		req.setHead("SHGLXX");
		req.setBody(body);
		
		DeliverTmResp resp=xx.deliverTmService(req);
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

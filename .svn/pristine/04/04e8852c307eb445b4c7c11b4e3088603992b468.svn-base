/**
 * @Title: OrderServiceTest.java
 * @Package com.froad.iamp.xml2bean.api
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016�?8�?4�?
 * @version V1.0
**/

package com.qbt.sf.api;


import org.junit.Test;

import com.qbt.sf.api.bean.ordersearch.OrderSearchReq;
import com.qbt.sf.api.bean.ordersearch.OrderSearchReqBody;
import com.qbt.sf.api.bean.ordersearch.OrderSearchReqOrder;
import com.qbt.sf.api.bean.ordersearch.OrderSearchResp;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.service.SFExpressApiServiceImpl;

/**
  * @ClassName: OrderSearchServiceTest
  * @Description: TODO
  * @author wuwang-win8 2016年8月5日
  * @modify wuwang-win18 2016年8月5日
 */
public class OrderSearchServiceTest {
    
    @Test  
    public void showMarshaller()  {  
    	SFExpressApiService xx=new SFExpressApiServiceImpl();
    	
    	OrderSearchReqOrder order =new OrderSearchReqOrder();
    	order.setOrderid("TE20150104");
		
    	OrderSearchReqBody body=new OrderSearchReqBody();
		body.setOrder(order);
		OrderSearchReq req=new OrderSearchReq();
		req.setHead("SHGLXX");
		req.setBody(body);
		
		OrderSearchResp resp = null;
		try {
			resp = xx.orderSearchService(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(resp);
    }  
    
}

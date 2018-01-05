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

import com.qbt.sf.api.bean.delivertm.Address;
import com.qbt.sf.api.bean.delivertm.DeliverTmReq;
import com.qbt.sf.api.bean.delivertm.DeliverTmReqBody;
import com.qbt.sf.api.bean.delivertm.DeliverTmReqDeliver;
import com.qbt.sf.api.bean.delivertm.DeliverTmResp;
import com.qbt.sf.api.bean.orderfilterpush.OrderFilterPushRepOrder;
import com.qbt.sf.api.bean.orderfilterpush.OrderFilterPushReq;
import com.qbt.sf.api.bean.orderfilterpush.OrderFilterPushReqBody;
import com.qbt.sf.api.bean.orderfilterpush.OrderFilterPushResp;
import com.qbt.sf.api.bean.orderfilterpush.OrderFilterPushRespErr;
import com.qbt.sf.api.bean.orderfilterresult.OrderFilterResultResp;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.service.SFExpressApiServiceImpl;
import com.qbt.sf.api.util.JaxbUtil;

/**
  * @ClassName: OrderFilterPushServiceTest（ 人工筛单结果推送接口）
  * @Description: TODO
  * @author wuwang-win8 2016年8月4日
  * @modify wuwang-win8 2016年8月4日
 */
public class OrderFilterPushServiceTest {
    
    @Test  
    public void showMarshaller()  {  

		SFExpressApiService xx=new SFExpressApiServiceImpl();
		
		OrderFilterPushRepOrder order =new OrderFilterPushRepOrder();
        order.setFilterResult(2);
        order.setDestCode("E462");
		
		OrderFilterPushReqBody body = new OrderFilterPushReqBody();
		body.setOrderFilterPush(order);
		OrderFilterPushReq req=new OrderFilterPushReq();
		req.setHead("SHGLXX");
		req.setBody(body);
		
		OrderFilterResultResp resp = null;
		try {
			resp = xx.orderFilterPushService(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(resp);
       /* OrderFilterPushReq req=new OrderFilterPushReq();
        req.setHead("BSPdevelop");
        OrderFilterPushReqBody body=new OrderFilterPushReqBody();
        OrderFilterPushRepOrder order =new OrderFilterPushRepOrder();
        order.setFilterResult(2);
        order.setDestCode("E462");
        body.setOrderFilterPush(order);
        req.setBody(body);
        String str = JaxbUtil.convertToXml(req);  
        System.out.println(str);  */
    }  
    
    
/*    @Test  
    public void showMarshaller1()  {  
        OrderFilterPushResp resp = new OrderFilterPushResp();
        
        OrderFilterPushRespErr err=new OrderFilterPushRespErr();
        err.setCode("xxx");
        resp.setError(err);
        resp.setHead("ERR");
          
        String str = JaxbUtil.convertToXml(resp);  
        System.out.println(str);  
    } */ 

}

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
import com.qbt.sf.api.bean.orderconfirm.OrderConfirmRespErr;
import com.qbt.sf.api.bean.route.RouteRepOrder;
import com.qbt.sf.api.bean.route.RouteReq;
import com.qbt.sf.api.bean.route.RouteReqBody;
import com.qbt.sf.api.bean.route.RouteResp;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.service.SFExpressApiServiceImpl;
import com.qbt.sf.api.util.JaxbUtil;

/**
  * @ClassName:RouteServiceTest（路由推送接口）
  * @Description: TODO
  * @author wuwang-win8 2016年8月4日
  * @modify wuwang-win8 2016年8月4日
 */
public class RouteServiceTest {
    
    @Test  
    public void showMarshaller()  {  
    	
    	SFExpressApiService xx=new SFExpressApiServiceImpl();
    	
    	RouteRepOrder order =new RouteRepOrder();
        order.setTracking_type(1);
        order.setTracking_number("E7889770");
		
		RouteReqBody body=new RouteReqBody();
		body.setRoute(order);
		RouteReq req=new RouteReq();
		req.setHead("SHGLXX");
		req.setBody(body);
		
		RouteResp resp;
		try {
			resp = xx.routeService(req);
			System.out.println(resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    	/*SFExpressApiService xx=new SFExpressApiServiceImpl();
		
		RouteRepOrder order =new RouteRepOrder();
        order.setTracking_type(1);
        order.setTracking_number("E7889770");
		
        RouteReqBody body=new RouteReqBody();
        body.setRoute(order);
		
        WayBillRouteResp req=new WayBillRouteResp();
        req.setHead("SHGLXX");
        req.setBody(body);
		
        
        WayBillRouteResp resp;
		try {
			resp = xx.routePushService(req);
			System.out.println(resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*DeliverTmResp resp=xx.deliverTmService(req, param);
		System.out.println(resp);*/
    	
       /* RouteReq req=new RouteReq();
        req.setHead("BSPdevelop");
        
        RouteReqBody body=new RouteReqBody();
        RouteRepOrder order =new RouteRepOrder();
        order.setTracking_type(1);
        order.setTracking_number("E7889770");
        body.setRoute(order);
        req.setBody(body);
        String str = JaxbUtil.convertToXml(req);  
        System.out.println(str);  */
    }  
    
    
    @Test  
    public void showMarshaller1()  {  
        RouteResp resp=new RouteResp();
        
        OrderConfirmRespErr err=new OrderConfirmRespErr();
        err.setCode("xxx");
        resp.setError(err);
        resp.setHead("ERR");
          
        String str = JaxbUtil.convertToXml(resp);  
        System.out.println(str);  
    }  

}

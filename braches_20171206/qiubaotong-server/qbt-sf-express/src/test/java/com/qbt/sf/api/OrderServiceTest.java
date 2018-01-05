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

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.qbt.sf.api.bean.order.OrderCargo;
import com.qbt.sf.api.bean.order.OrderReq;
import com.qbt.sf.api.bean.order.OrderReqBody;
import com.qbt.sf.api.bean.order.OrderReqOrder;
import com.qbt.sf.api.bean.order.OrderResp;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.service.SFExpressApiServiceImpl;

/**
  * @ClassName: OrderServiceTest
  * @Description: TODO
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */
public class OrderServiceTest {
    
    @Test  
    public void showMarshaller()  {  
    	SFExpressApiService xx=new SFExpressApiServiceImpl();
		/*SfExpressBean param=new SfExpressBean();
		param.setCheckWord("0P6m2kS55YORklfw");
		param.setUrl("http://bspoisp.sit.sf-express.com:11080/bsp-oisp/sfexpressService");*/
		
    	OrderReqOrder order=new OrderReqOrder();
    	order.setOrderid("TE20150104");
        order.setBrand("xx");
        order.setMailno("223");
		
        List<OrderCargo> list=new ArrayList<OrderCargo>();
        
        OrderCargo cargo=new OrderCargo();
        cargo.setAmount("cargo1");
        cargo.setName("test1");
        
        OrderCargo cargo1=new OrderCargo();
        cargo1.setAmount("cargo2");
        cargo1.setName("test2");
        list.add(cargo);
        list.add(cargo1);
        order.setCargoList(list);
        
		
        OrderReqBody body=new OrderReqBody();
		body.setOrder(order);
		
		OrderReq req=new OrderReq();
		req.setHead("SHGLXX");
		req.setBody(body);
		
		OrderResp resp;
		try {
			resp = xx. orderService(req);
			System.out.println(resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    	
    	
    	
        /*OrderReq req=new OrderReq();
        req.setHead("BSPdevelop");
        
        OrderReqBody body=new OrderReqBody();
        OrderReqOrder order =new OrderReqOrder();
        order.setOrderid("TE20150104");
        order.setBrand("xx");
        order.setMailno("223");
        
        
        List<OrderCargo> list=new ArrayList<OrderCargo>();
        
        OrderCargo cargo=new OrderCargo();
        cargo.setAmount("cargo1");
        cargo.setName("test1");
        
        OrderCargo cargo1=new OrderCargo();
        cargo1.setAmount("cargo2");
        cargo1.setName("test2");
        list.add(cargo);
        list.add(cargo1);
        order.setCargoList(list);
        
        
        body.setOrder(order);
        
        req.setBody(body);
          
        String str = JaxbUtil.convertToXml(req);  
        System.out.println(str); */ 
    }  
    
    
   /* @Test  
    public void showMarshaller1()  {  
        OrderResp resp=new OrderResp();
        
        OrderRespErr err=new OrderRespErr();
        err.setCode("xxx");
       resp.setError(err);
       resp.setHead("ERR");
          
        String str = JaxbUtil.convertToXml(resp);  
        System.out.println(str);  
    }  */

}

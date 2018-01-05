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
import com.qbt.sf.api.bean.orderconfirm.OrderConfirmOption;
import com.qbt.sf.api.bean.orderconfirm.OrderConfirmRepOrder;
import com.qbt.sf.api.bean.orderconfirm.OrderConfirmReq;
import com.qbt.sf.api.bean.orderconfirm.OrderConfirmReqBody;
import com.qbt.sf.api.bean.orderconfirm.OrderConfirmResp;
import com.qbt.sf.api.bean.orderconfirm.OrderConfirmRespErr;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.service.SFExpressApiServiceImpl;
import com.qbt.sf.api.util.JaxbUtil;

/**
  * @ClassName: OrderConfirmServiceTest（订单确认/取消接口）
  * @Description: TODO
  * @author wuwang-win8 2016年8月4日
  * @modify wuwang-win8 2016年8月4日
 */
public class OrderConfirmServiceTest {
    
    @Test  
    public void showMarshaller()  {  
    	SFExpressApiService xx=new SFExpressApiServiceImpl();
    	
    	 OrderConfirmRepOrder order =new OrderConfirmRepOrder();
    	 order.setOrderid("TE201500104");
         order.setMailno("444003078326");
         order.setDealtype(1);
         
         OrderConfirmOption orderConfirmOption= new OrderConfirmOption();
         orderConfirmOption.setWeight(3);
         orderConfirmOption.setVolume("33");
         
        /* OrderConfirmExtra extra = new OrderConfirmExtra();
         extra.setE1("abc");
         extra.setE2("abc");*/
         
         order.setOrderConfirmOption(orderConfirmOption);
         
         OrderConfirmReqBody body=new OrderConfirmReqBody();
         body.setOrderConfirm(order);
        /* body.setExtra(extra);*/
         
         OrderConfirmReq req=new OrderConfirmReq();
         req.setHead("SHGLXX");
         req.setBody(body);
         
         OrderConfirmResp resp;
		try {
			resp = xx.orderConfirmService(req);
			System.out.println(resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        /*OrderConfirmReq req=new OrderConfirmReq();
        req.setHead("BSPdevelop");
        
        OrderConfirmReqBody body=new OrderConfirmReqBody();
        OrderConfirmRepOrder order =new OrderConfirmRepOrder();
        order.setMailno("223");
        order.setDealtype(0);
        
       //List<OrderCargo> list=new ArrayList<OrderCargo>();
         List<OrderConfirmOption> list=new ArrayList<OrderConfirmOption>();
        
        OrderConfirmOption OrderConfirmOption= new OrderConfirmOption();
        //可选就不设值了
        
        list.add(OrderConfirmOption);
        order.setOrderConfirmOptionList(list);
        
        
        body.setOrderConfirm(order);
        
        req.setBody(body);
          
        String str = JaxbUtil.convertToXml(req);  
        System.out.println(str);  */
    }  
    
    
    @Test  
    public void showMarshaller1()  {  
        OrderConfirmResp resp=new OrderConfirmResp();
        
        OrderConfirmRespErr err=new OrderConfirmRespErr();
        err.setCode("xxx");
        resp.setError(err);
        resp.setHead("ERR");
          
        String str = JaxbUtil.convertToXml(resp);  
        System.out.println(str);  
    }  

}

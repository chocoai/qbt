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

import com.qbt.sf.api.bean.SfExpressBean;
import com.qbt.sf.api.bean.orderfilter.OrderFilterOption;
import com.qbt.sf.api.bean.orderfilter.OrderFilterRepOrder;
import com.qbt.sf.api.bean.orderfilter.OrderFilterReq;
import com.qbt.sf.api.bean.orderfilter.OrderFilterReqBody;
import com.qbt.sf.api.bean.orderfilter.OrderFilterResp;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.service.SFExpressApiServiceImpl;

/**
  * @ClassName: OrderFilterServiceTest（订单筛选接口）
  * @Description: TODO
  * @author wuwang-win8 2016年8月4日
  * @modify wuwang-win8 2016年8月4日
 */
public class OrderFilterServiceTest {
    
    @Test  
    public void showMarshaller()  {  
    	
    	SFExpressApiService xx=new SFExpressApiServiceImpl();
    	
		OrderFilterRepOrder order =new OrderFilterRepOrder();
		order.setOrderid("TE201407020016");
        order.setFilter_type(1);
        order.setD_address("广东省深圳市福田区新洲十一街万基商务大厦。");
        
        
        List<OrderFilterOption> list=new ArrayList<OrderFilterOption>();
        
        OrderFilterOption OrderFilterOption= new OrderFilterOption();
        OrderFilterOption.setJ_tel("4001118851");
        OrderFilterOption.setJ_address("广东省深圳市福田区万基商务大厦A  座10F");
        OrderFilterOption.setD_tel("15818539050");
        OrderFilterOption.setJ_custid("0123456789");
        
        
        list.add(OrderFilterOption);
        order.setOrderFilterOption(list);
        
        OrderFilterReqBody body=new OrderFilterReqBody();
        body.setOrderFilter(order);
        
        OrderFilterReq req=new OrderFilterReq();
		req.setHead("BSPdevelop");
		req.setBody(body);
		
		OrderFilterResp resp;
		try {
			resp = xx.orderFilterService(req);
			System.out.println(resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }  
    
}

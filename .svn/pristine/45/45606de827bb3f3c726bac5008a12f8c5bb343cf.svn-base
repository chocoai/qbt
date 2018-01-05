/**
 * @Title: QueryFreightServiceTest.java
 * @Package com.qbt.sf.api
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win8 2016年8月5日
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
import com.qbt.sf.api.bean.queryfreight.QueryFreightReq;
import com.qbt.sf.api.bean.queryfreight.QueryFreightReqBody;
import com.qbt.sf.api.bean.queryfreight.QueryFreightReqDeliver;
import com.qbt.sf.api.bean.queryfreight.QueryFreightResp;
import com.qbt.sf.api.bean.scope.ScopeReq;
import com.qbt.sf.api.bean.scope.ScopeReqBody;
import com.qbt.sf.api.bean.scope.ScopeReqDeliver;
import com.qbt.sf.api.bean.scope.ScopeResp;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.service.SFExpressApiServiceImpl;

/**
  * @ClassName: QueryFreightServiceTest
  * @Description: TODO
  * @author wuwang win8 2016年8月6日
  * @modify wuwang win8 2016年865日
  */

public class QueryFreightServiceTest {

	@Test
	public void QueryFreightService() throws Exception{
		SFExpressApiService xx=new SFExpressApiServiceImpl();
		
		QueryFreightReqDeliver queryFreightReqDeliver=new QueryFreightReqDeliver();
		queryFreightReqDeliver.setSource_province("广东省");
		queryFreightReqDeliver.setAme_source_city_n("珠海市");
		queryFreightReqDeliver.setDest_province("福建省");
		queryFreightReqDeliver.setE_dest_city_nam("厦门市");
		
		QueryFreightReqBody body=new QueryFreightReqBody();
		body.setQueryFreightReqDeliver(queryFreightReqDeliver);
		QueryFreightReq req=new QueryFreightReq();
		req.setHead("SHGLXX");
		req.setBody(body);
		
		QueryFreightResp resp=xx.queryFreightService(req);
		System.out.println(resp);
		
		
		
		/*SFExpressApiService xx=new SFExpressApiServiceImpl();
		
		QueryFreightReqDeliver deliver=new QueryFreightReqDeliver();
		deliver.setSource_province("广东省");
		deliver.setAme_source_city_n("珠海市");
		deliver.setDest_province("福建省");
		deliver.setE_dest_city_nam("厦门市");
		
		
		QueryFreightReqBody body=new QueryFreightReqBody();
		body.setQueryFreightReqDeliver(deliver);
		QueryFreightReq req=new QueryFreightReq();
		req.setHead("SHGLXX");
		req.setBody(body);
		
		QueryFreightResp resp=xx.queryFreightService(req);
		System.out.println(resp);*/
	}
	
}

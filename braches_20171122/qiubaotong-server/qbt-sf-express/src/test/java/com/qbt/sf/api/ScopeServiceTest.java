/**
 * @Title: ScopeServiceTest.java
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
import com.qbt.sf.api.bean.scope.ScopeReq;
import com.qbt.sf.api.bean.scope.ScopeReqBody;
import com.qbt.sf.api.bean.scope.ScopeReqDeliver;
import com.qbt.sf.api.bean.scope.ScopeResp;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.service.SFExpressApiServiceImpl;

/**
  * @ClassName: DeliverTmServiceTest
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
  */

public class ScopeServiceTest {

	@Test
	public void scopeService() throws Exception{
		
		SFExpressApiService xx=new SFExpressApiServiceImpl();
		
		ScopeReqDeliver scopeReqDeliver=new ScopeReqDeliver();
		scopeReqDeliver.setCustid("7551234567");
		
		ScopeReqBody body=new ScopeReqBody();
		body.setScopeReqDeliver(scopeReqDeliver);;
		ScopeReq req=new ScopeReq();
		req.setHead("SHGLXX");
		req.setBody(body);
		
		ScopeResp resp=xx.scopeService(req);
		System.out.println(resp);
	}
	
}

package com.qtb.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qbt.common.exception.WechatException;
import com.qbt.common.util.JSonUtil;
import com.qbt.sf.api.bean.RespErr;
import com.qbt.sf.api.bean.delivertm.Address;
import com.qbt.sf.api.bean.delivertm.DeliverTmReq;
import com.qbt.sf.api.bean.delivertm.DeliverTmReqBody;
import com.qbt.sf.api.bean.delivertm.DeliverTmReqDeliver;
import com.qbt.sf.api.bean.delivertm.DeliverTmResp;
import com.qbt.sf.api.service.SFExpressApiService;

@ContextConfiguration(locations = {"classpath*:context/applicationContext*.xml"}) 
public class SfBspDevlier extends AbstractJUnit4SpringContextTests {

	@Resource
	private SFExpressApiService sfExpressApiService;
	
	@Test
	public void testBsp() {
		
		// 计算顺丰预计到达时间
		DeliverTmReq req = new DeliverTmReq();
		
		DeliverTmReqBody body = new DeliverTmReqBody();
		DeliverTmReqDeliver deliverTmRequest = new DeliverTmReqDeliver();
		String consigneTime = "2017-02-3 09:00:00";
		
		deliverTmRequest.setConsigned_time(consigneTime);
		deliverTmRequest.setWeight("18");
		
		Address srcAddress = new Address();
		srcAddress.setAddress("测试");
		srcAddress.setProvince("广东省");
		srcAddress.setCity("湛江市");
		srcAddress.setDistrict("湛江经济开发区");
		deliverTmRequest.setSrcAddress(srcAddress);
		
		Address destAddress = new Address();
		destAddress.setAddress("测试");
		destAddress.setProvince("浙江省");
		destAddress.setCity("温州市");
		destAddress.setDistrict("苍南县");
		deliverTmRequest.setDestAddress(destAddress);
		
		body.setDeliverTmRequest(deliverTmRequest);
		req.setBody(body);
		DeliverTmResp resp = null;
				
		try {
			resp = sfExpressApiService.deliverTmService(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RespErr err = resp.getError();
		if(err != null && err.getCode()!=""){
			throw new WechatException(err.getCode(), err.getValue());
		}
		
		System.out.println(JSonUtil.toJSonString(resp));
	}
}

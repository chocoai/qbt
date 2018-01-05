package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.sf.DeliverRequest;
import com.qbt.web.pojo.sf.DeliverResponse;
import com.qbt.web.pojo.sf.DeliverV2Response;

public interface SfExpressSupport {

	public List<DeliverResponse> query_sf_expect_recive_time(DeliverRequest request);
	
	public double query_sf_expect_price(DeliverRequest request);
	
	public List<DeliverV2Response> query_sf_expect_recive_time_v2(DeliverRequest request);
	
	public double query_sf_expect_price_v2(DeliverRequest request);
}

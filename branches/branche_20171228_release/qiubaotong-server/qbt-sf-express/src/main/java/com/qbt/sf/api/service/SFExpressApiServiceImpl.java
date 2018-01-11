package com.qbt.sf.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.StringUtil;
import com.qbt.sf.api.bean.delivertm.DeliverTmReq;
import com.qbt.sf.api.bean.delivertm.DeliverTmResp;
import com.qbt.sf.api.bean.identity.IdentityReq;
import com.qbt.sf.api.bean.identity.IdentitySearchResp;
import com.qbt.sf.api.bean.order.OrderReq;
import com.qbt.sf.api.bean.order.OrderResp;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseReq;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseResp;
import com.qbt.sf.api.bean.orderconfirm.OrderConfirmReq;
import com.qbt.sf.api.bean.orderconfirm.OrderConfirmResp;
import com.qbt.sf.api.bean.orderfilter.OrderFilterReq;
import com.qbt.sf.api.bean.orderfilter.OrderFilterResp;
import com.qbt.sf.api.bean.orderfilterpush.OrderFilterPushReq;
import com.qbt.sf.api.bean.orderfilterresult.OrderFilterResultResp;
import com.qbt.sf.api.bean.ordersearch.OrderSearchReq;
import com.qbt.sf.api.bean.ordersearch.OrderSearchResp;
import com.qbt.sf.api.bean.orderzd.OrderZDReq;
import com.qbt.sf.api.bean.orderzd.OrderZDResp;
import com.qbt.sf.api.bean.queryfreight.QueryFreightReq;
import com.qbt.sf.api.bean.queryfreight.QueryFreightResp;
import com.qbt.sf.api.bean.route.RouteReq;
import com.qbt.sf.api.bean.route.RouteResp;
import com.qbt.sf.api.bean.scope.ScopeReq;
import com.qbt.sf.api.bean.scope.ScopeResp;
import com.qbt.sf.api.bean.website.DeliverReq;
import com.qbt.sf.api.bean.website.DeliverResp;
import com.qbt.sf.api.util.HttpXmlClient;
import com.qbt.sf.api.util.JaxbUtil;
import com.qbt.sf.api.util.SfExpressEncrypt;

@Service
public class SFExpressApiServiceImpl implements SFExpressApiService {
	
	
	
	@Value("${sf_url}")
    public String url;
	@Value("${sf_website_url}")
    public String sf_website_url;
    @Value("${checkWord}")
    public String checkWord;
    @Value("${custid}")
    public String custid;
    @Value("${bspcode}")
    public String bspcode;
	
	/**
	 * @Title: orderService
	 * @Description:下订单接口
	 * @author: win10 2016年8月5日
	 * @modify: win10 2016年8月5日
	 * @param req
	 * @param param
	 * @return
	 * @throws Exception
	 * @see com.qbt.sf.api.service.SFExpressApiService#orderService(com.qbt.sf.api.bean.order.OrderReq,
	 *      com.qbt.sf.api.bean.SfExpressBean)
	 */
	@Override
	public OrderResp orderService(OrderReq req) throws Exception {
		req.getBody().getOrder().setCustid(custid);
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);
		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);
		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		OrderResp resp = JaxbUtil.converyToJavaBean(result, OrderResp.class);

		return resp;
	}

	/**
	 * @Title: orderConfirmService
	 * @Description: 订单确认/取消接口
	 * @author: win10 2016年8月5日
	 * @modify: win10 2016年8月5日
	 * @param req
	 * @param param
	 * @return
	 * @throws Exception
	 * @see com.qbt.sf.api.service.SFExpressApiService#orderConfirmService(com.qbt.sf.api.bean.orderconfirm.OrderConfirmReq,
	 *      com.qbt.sf.api.bean.SfExpressBean)
	 */
	@Override
	public OrderConfirmResp orderConfirmService(OrderConfirmReq req) throws Exception {
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);

		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);

		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		OrderConfirmResp resp = JaxbUtil.converyToJavaBean(result, OrderConfirmResp.class);

		return resp;
	}

	/**
	 * @Title: orderSearchService
	 * @Description: 订单结果查询接口
	 * @author: win10 2016年8月5日
	 * @modify: win10 2016年8月5日
	 * @param req
	 * @param param
	 * @return
	 * @throws Exception
	 * @see com.qbt.sf.api.service.SFExpressApiService#orderSearchService(com.qbt.sf.api.bean.ordersearch.OrderSearchReq,
	 *      com.qbt.sf.api.bean.SfExpressBean)
	 */

	@Override
	public OrderSearchResp orderSearchService(OrderSearchReq req) throws Exception {
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);
		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);
		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		OrderSearchResp resp = JaxbUtil.converyToJavaBean(result, OrderSearchResp.class);

		return resp;
	}

	/**
	 * @Title: orderFilterService
	 * @Description: 订单筛选接口
	 * @author: win10 2016年8月5日
	 * @modify: win10 2016年8月5日
	 * @param req
	 * @param param
	 * @return
	 * @throws Exception
	 * @see com.qbt.sf.api.service.SFExpressApiService#orderFilterService(com.qbt.sf.api.bean.orderfilter.OrderFilterReq,
	 *      com.qbt.sf.api.bean.SfExpressBean)
	 */

	@Override
	public OrderFilterResp orderFilterService(OrderFilterReq req) throws Exception {
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);
		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);
		System.out.println("verifyCode::" + verifyCode);
		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		OrderFilterResp resp = JaxbUtil.converyToJavaBean(result, OrderFilterResp.class);

		return resp;
	}

	/**
	 * @Title: orderFilterPushService
	 * @Description: 人工筛但结果推送接口
	 * @author: win10 2016年8月5日
	 * @modify: win10 2016年8月5日
	 * @param req
	 * @param param
	 * @return
	 * @throws Exception
	 * @see com.qbt.sf.api.service.SFExpressApiService#orderFilterPushService(com.qbt.sf.api.bean.orderfilterresult.OrderFilterResultReq,
	 *      com.qbt.sf.api.bean.SfExpressBean)
	 */

	@Override
	public OrderFilterResultResp orderFilterPushService(OrderFilterPushReq req)
			throws Exception {
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);
		/*String checkWord = param.getCheckWord();
		String url = param.getUrl();*/
		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);

		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		OrderFilterResultResp resp = JaxbUtil.converyToJavaBean(result, OrderFilterResultResp.class);

		return resp;
		
	}

	/**
	 * @Title: routeService
	 * @Description: 路由查询接口
	 * @author: win10 2016年8月5日
	 * @modify: win10 2016年8月5日
	 * @param req
	 * @param param
	 * @return
	 * @throws Exception
	 * @see com.qbt.sf.api.service.SFExpressApiService#routeService(com.qbt.sf.api.bean.route.RouteReq,
	 *      com.qbt.sf.api.bean.SfExpressBean)
	 */

	@Override
	public RouteResp routeService(RouteReq req) throws Exception {
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);
		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);

		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		RouteResp resp = JaxbUtil.converyToJavaBean(result, RouteResp.class);

		return  resp;
	}


	/**
	 * @Title: deliverTmService
	 * @Description: 时效查询接口
	 * @author: win10 2016年8月5日
	 * @modify: win10 2016年8月5日
	 * @param req
	 * @param param
	 * @return
	 * @throws Exception
	 * @see com.qbt.sf.api.service.SFExpressApiService#deliverTmService(com.qbt.sf.api.bean.delivertm.DeliverTmReq,
	 *      com.qbt.sf.api.bean.SfExpressBean)
	 */

	@Override
	public DeliverTmResp deliverTmService(DeliverTmReq req) throws Exception {
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);
		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);
		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		DeliverTmResp resp = JaxbUtil.converyToJavaBean(result, DeliverTmResp.class);

		return  resp;
	}

	/**
	 * @Title: scopeService
	 * @Description: 产品及增值服务查询接口
	 * @author: win10 2016年8月5日
	 * @modify: win10 2016年8月5日
	 * @param req
	 * @param param
	 * @return
	 * @throws Exception
	 * @see com.qbt.sf.api.service.SFExpressApiService#scopeService(com.qbt.sf.api.bean.scope.ScopeReq,
	 *      com.qbt.sf.api.bean.SfExpressBean)
	 */

	@Override
	public ScopeResp scopeService(ScopeReq req) throws Exception {
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);
		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);

		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		ScopeResp resp = JaxbUtil.converyToJavaBean(result, ScopeResp.class);

		return  resp;
	}

	/**
	 * @Title: orderZDService
	 * @Description: 子单号申请接口
	 * @author: win10 2016年8月5日
	 * @modify: win10 2016年8月5日
	 * @param req
	 * @param param
	 * @return
	 * @throws Exception
	 * @see com.qbt.sf.api.service.SFExpressApiService#orderZDService(com.qbt.sf.api.bean.orderzd.OrderZDReqDeliver,
	 *      com.qbt.sf.api.bean.SfExpressBean)
	 */

	@Override
	public OrderZDResp orderZDService(OrderZDReq req) throws Exception {
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);
		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);

		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		OrderZDResp resp = JaxbUtil.converyToJavaBean(result, OrderZDResp.class);

		return  resp;
	}

	/**
	 * @Title: identitySearchService
	 * @Description: 身份证图片查询接口
	 * @author: win10 2016年8月5日
	 * @modify: win10 2016年8月5日
	 * @param req
	 * @param param
	 * @return
	 * @throws Exception
	 * @see com.qbt.sf.api.service.SFExpressApiService#identitySearchService(com.qbt.sf.api.bean.identity.IdentityReq,
	 *      com.qbt.sf.api.bean.SfExpressBean)
	 */

	@Override
	public IdentitySearchResp identitySearchService(IdentityReq req) throws Exception {
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);
		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);

		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		IdentitySearchResp resp = JaxbUtil.converyToJavaBean(result, IdentitySearchResp.class);

		return  resp;
	}

	
	 /**
	  * @Title: queryFreightService
	  * @Description: 标准运费查询接口
	  * @author: win10 2016年8月5日
	  * @modify: win10 2016年8月5日
	  * @param req
	  * @param param
	  * @return
	  * @throws Exception
	  * @see com.qbt.sf.api.service.SFExpressApiService#queryFreightService(com.qbt.sf.api.bean.queryfreight.QueryFreightReq, com.qbt.sf.api.bean.SfExpressBean)
	  */
	
	@Override
	public QueryFreightResp queryFreightService(QueryFreightReq req) throws Exception {
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);
		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);

		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		QueryFreightResp resp = JaxbUtil.converyToJavaBean(result, QueryFreightResp.class);

		return  resp;
	}

	/**
	 *  查询顺丰官网实时价格
	  * @Title: deliverTmServiceBySfWebSite
	  * @Description: TODO
	  * @author: share 2016年8月23日
	  * @modify: share 2016年8月23日
	  * @param deliverReq
	  * @return
	 * @throws Exception 
	  * @see com.qbt.sf.api.service.SFExpressApiService#deliverTmServiceBySfWebSite(com.qbt.sf.api.bean.website.DeliverReq)
	 */
	@Override
	public List<DeliverResp> deliverTmServiceBySfWebSite(DeliverReq deliverReq) throws Exception {
		// 组包发送
		String srcCode = deliverReq.getSrcCode();
		String destCode = deliverReq.getDestCode();
		String time = deliverReq.getTime();
		
		StringBuilder sb = new StringBuilder(sf_website_url);
		sb.append("?origin=").append(srcCode);
		sb.append("&dest=").append(destCode);
		sb.append("&parentOrigin=").append(srcCode);
		sb.append("&parentDest=").append(destCode);
		sb.append("&weight=18");
		sb.append("&time=").append(StringUtil.urlencode((time+"+08:00").replace(" ", "T")));
		sb.append("&volume=0").append("&queryType=2").append("&lang=sc").append("&region=cn").append("&translate=");
		LogCvt.info("请求顺丰官网接口："+sb.toString());
		String result = HttpXmlClient.get(sb.toString());
		if(StringUtil.isEmpty(result))return null;
		List<?> deliveList = JSonUtil.toObject(result, List.class);
		List<DeliverResp> deliverResp = new ArrayList<DeliverResp>();
		Set<String> typeSet = new HashSet<String>();
		for(Object json : deliveList){
			DeliverResp resp = JSonUtil.toObject(JSonUtil.toJSonString(json), DeliverResp.class);
			// 过滤超过已过最晚收件时间
			if(resp.getAddTime()==null || "null".equals(resp.getAddTime()) || typeSet.contains(resp.getBusinessType())){
				continue;
			}
			typeSet.add(resp.getBusinessType());
			deliverResp.add(resp);
		}
		deliveList.clear();
		return deliverResp;
	}

	@Override
	public OrderReverseResp orderReverseService(OrderReverseReq req) throws Exception {
		req.getBody().getOrder().setCustid(custid);
		req.setHead(bspcode);
		String xml = JaxbUtil.convertToXml(req);

		String verifyCode = SfExpressEncrypt.md5EncryptAndBase64(xml, checkWord);

		// 组包发送
		Map<String, String> params = new HashMap<String, String>();
		params.put("xml", xml);
		params.put("verifyCode", verifyCode);

		String result = HttpXmlClient.post(url, params);
		OrderReverseResp resp = JaxbUtil.converyToJavaBean(result, OrderReverseResp.class);

		return resp;
	}

}

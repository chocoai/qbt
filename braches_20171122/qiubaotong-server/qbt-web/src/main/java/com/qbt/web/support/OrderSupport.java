package com.qbt.web.support;

import java.util.List;

import com.qbt.common.result.Paging;
import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.assistant.AssistantDelivery;
import com.qbt.web.pojo.assistant.AssistantOrder;
import com.qbt.web.pojo.order.BigOrderDetail;
import com.qbt.web.pojo.order.CommentRequest;
import com.qbt.web.pojo.order.HistoryOrderAddressVo;
import com.qbt.web.pojo.order.OfficialOrderConfirm;
import com.qbt.web.pojo.order.OrderCommentInfo;
import com.qbt.web.pojo.order.OrderConfirm;
import com.qbt.web.pojo.order.OrderDetail;
import com.qbt.web.pojo.order.OrderDetailV2;
import com.qbt.web.pojo.order.OrderDetailWaybill;
import com.qbt.web.pojo.order.OrderPageRequest;

public interface OrderSupport {

	public String orderCreate(OrderConfirm orderInfo);
	
	public OrderDetail orderDetail(int userId, String orderId);
	
	public OrderDetail orderDetail(int applyId, int applyType, String orderId);

	public List<OrderDetail> orderList(OrderPageRequest order);

	public void paySuccess(OrderPayInfo payment);
	
	public void delete(Integer id, String orderId);

	public void cancel(Integer id, String orderId);

	public List<OrderDetail> queryAssistantOrder(AssistantOrder assistant);
    
	public void delivery(UserWeixin userWeixin,AssistantDelivery assistantDelivery);
	
	public void receiver(UserWeixin userWeixin,AssistantDelivery assistantDelivery);

	public OrderDetail queryKeyword(String keyword);
	
	public void addComment(UserWeixin userWeixin, CommentRequest req);
	
	public List<OrderCommentInfo> commentList(Paging page);
	
	public OrderCommentInfo findByOrderNumber(String orderNumber);

	public OrderDetail lastOrder(Integer userId,Integer proxyUserId);
 
	public List<OrderDetail> queryPartnerOrder(OrderPageRequest order);
	
	public List<OrderDetail> trackOrder(int userId, String keyword);

	public List<OrderDetail> orderSubList(String orderId);
	
	public OrderDetailWaybill trackOrder(String keyword);
	
	public String officialOrderCreate(OfficialOrderConfirm orderConfirm);
	
	public BigOrderDetail officialUnpayOrderDetail(String orderNumber);
	
	public void confirm(Integer id);
	
	public List<OrderDetailV2> findForBill(Integer userId);
	
	public List<HistoryOrderAddressVo> findAddressHistory(Integer userId);
}

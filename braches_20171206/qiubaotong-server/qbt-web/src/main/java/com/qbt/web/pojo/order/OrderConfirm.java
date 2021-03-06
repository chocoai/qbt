package com.qbt.web.pojo.order;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.qbt.web.pojo.sf.DeliverRequest;


/**
 * 订单下单信息
  * @ClassName: OrderConfirm
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
public class OrderConfirm extends DeliverRequest {
	
	/**
	 * 地区编码，可以反推出省市区信息
	 */
	private int dest_area_id;
	
	/**
	 * 用户ID
	 */
	private int userId;
	
	/**
	 * 1-course球场，2-airport机场,3-bank银行,4-address个人地址
	 */
	@NotNull(message = "寄件地址类型不能为空")
	private Integer src_type;
	
	private int src_id;
	
	/**
	 * 寄件人手机号
	 */
	@NotNull(message = "寄件人手机号不能为空")
	private String src_moibile;
	
	/**
	 * 寄件人姓名
	 */
	@NotNull(message = "寄件人姓名不能为空")
	private String src_name;
	
	
	/**
	 * 1-course球场，2-airport机场,3-bank银行,4-address个人地址
	 */
	@NotNull(message = "收件人姓名不能为空")
	private Integer dest_type;
	
	/**
	 * 收件类型ID
	 */
	private int dest_id;
	
	/**
	 * 收件人手机号
	 */
	@NotNull(message = "收件人手机号不能为空")
	private String dest_moibile;
	
	/**
	 * 收件人姓名
	 */
	@NotNull(message = "收件人姓名不能为空")
	private String dest_name;
	
	/**
	 * 订单金额
	 */
	@Min(value=0,message="订单金额不能为0")
	private int price;
	
	/**
	 * 保价金额
	 */
	@Min(value=0,message="保价金额不能为0")
	private int insure_price;
	
	@NotNull(message = "预计到达时间不能为空")
	private String deliver_time;
	
	/**
	 * 下单数量
	 */
	private int quantity = 1;
	
	// 微信用户名
	private String userName;
	
	private String openid;
	/**
	 * 1-正常下单 2-代下单
	 */
	private int create_method = 1;
	
	/**
	 *  代理下单人ID
	 */
	private int proxyUserId;
	
	private int proxySelfUserId;
	
	private String proxyOpenid;
	
	/**
	 * V2 UI改版新增的字段信息
	 */
	// 1-优惠券优惠 2-会员卡优惠
	private int discountType;
	

	// 优惠券号
	private String coupCode;
	// 会员卡号
	private String[] vipCodes;
	
	private String remark;
	// 打球时间
    private String playTime;
    
    //群优惠id
    private Integer orgId;

	// 券包使用券
	private Integer packageTicketId;
	
	
	public Integer getPackageTicketId() {
		return packageTicketId;
	}

	public void setPackageTicketId(Integer packageTicketId) {
		this.packageTicketId = packageTicketId;
	}



	public int getDest_area_id() {
		return dest_area_id;
	}



	public void setDest_area_id(int dest_area_id) {
		this.dest_area_id = dest_area_id;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public Integer getSrc_type() {
		return src_type;
	}



	public void setSrc_type(Integer src_type) {
		this.src_type = src_type;
	}



	public int getSrc_id() {
		return src_id;
	}



	public void setSrc_id(int src_id) {
		this.src_id = src_id;
	}



	public String getSrc_moibile() {
		return src_moibile;
	}



	public void setSrc_moibile(String src_moibile) {
		this.src_moibile = src_moibile;
	}



	public String getSrc_name() {
		return src_name;
	}



	public void setSrc_name(String src_name) {
		this.src_name = src_name;
	}



	public Integer getDest_type() {
		return dest_type;
	}



	public void setDest_type(Integer dest_type) {
		this.dest_type = dest_type;
	}



	public int getDest_id() {
		return dest_id;
	}



	public void setDest_id(int dest_id) {
		this.dest_id = dest_id;
	}



	public String getDest_moibile() {
		return dest_moibile;
	}



	public void setDest_moibile(String dest_moibile) {
		this.dest_moibile = dest_moibile;
	}



	public String getDest_name() {
		return dest_name;
	}



	public void setDest_name(String dest_name) {
		this.dest_name = dest_name;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getInsure_price() {
		return insure_price;
	}



	public void setInsure_price(int insure_price) {
		this.insure_price = insure_price;
	}



	public String getDeliver_time() {
		return deliver_time;
	}



	public void setDeliver_time(String deliver_time) {
		this.deliver_time = deliver_time;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getOpenid() {
		return openid;
	}



	public void setOpenid(String openid) {
		this.openid = openid;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getCreate_method() {
		return create_method;
	}



	public void setCreate_method(int create_method) {
		this.create_method = create_method;
	}



	public int getProxyUserId() {
		return proxyUserId;
	}



	public void setProxyUserId(int proxyUserId) {
		this.proxyUserId = proxyUserId;
	}



	public String getProxyOpenid() {
		return proxyOpenid;
	}



	public void setProxyOpenid(String proxyOpenid) {
		this.proxyOpenid = proxyOpenid;
	}



	public int getProxySelfUserId() {
		return proxySelfUserId;
	}



	public void setProxySelfUserId(int proxySelfUserId) {
		this.proxySelfUserId = proxySelfUserId;
	}



	public int getDiscountType() {
		return discountType;
	}



	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}



	public String getCoupCode() {
		return coupCode;
	}



	public void setCoupCode(String coupCode) {
		this.coupCode = coupCode;
	}



	public String[] getVipCodes() {
		return vipCodes;
	}



	public void setVipCodes(String[] vipCodes) {
		this.vipCodes = vipCodes;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getPlayTime() {
		return playTime;
	}



	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}



	public Integer getOrgId() {
		return orgId;
	}



	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

}

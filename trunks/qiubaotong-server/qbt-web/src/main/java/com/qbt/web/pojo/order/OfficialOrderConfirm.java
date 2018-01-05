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
public class OfficialOrderConfirm extends DeliverRequest {
	
	
	/**
	 * 1:表示“标准快递” o 2:表示“顺丰特惠” o 5:表示“顺丰次晨” o 6:表示“即日件”
	 */
	@NotNull(message="顺丰速运类型不能为空")
	private String business_type;
	
	private String weight = "18";
	
	/**
	 * 寄件时间,格式为 YYYY-MM-DD HH24:MM:SS,示例 2013-12-27 17:54:20
	 */
	@NotNull(message="预约取件时间不能为空")
	private String consigned_time;
	
	/**
	 * 地址
	 */
	@NotNull(message="寄件地址不能为空")
	private String src_address;
	
	/**
	 * 地区编码，可以反推出省市区信息
	 */
	@Min(value=0,message="寄件地址id不能为空")
	private int src_area_id;
	
	/**
	 * 寄件球场ID
	 */
	private int src_course_id;
	
	/**
	 * 地址
	 */
	@NotNull(message="收件地址不能为空")
	private String dest_address;
	
	/**
	 * 地区编码，可以反推出省市区信息
	 */
	@Min(value=0,message="收件id不能为空")
	private int dest_area_id;
	
	/**
	 * 收件球场ID
	 */
	private int dest_course_id;
	
	
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
	 * 保价金额
	 */
	@Min(value=0,message="保价金额不能为0")
	private int insure_price;
	
	@NotNull(message = "预计到达时间不能为空")
	private String deliver_time;
	
	private double freight;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 语言
	 */
	private String langName;
	/**
	 * 下单数量
	 */
	private int quantity = 1;
	
	@NotNull(message = "手机号不能为空")
	private String mobile;
	
	@NotNull(message = "短信验证码不能为空")
	private String smsCode;
	
	@NotNull(message = "短信验证token不能为空")
	private String smsToken;
	// 打球时间
    private String playTime;
	
	public int getDest_area_id() {
		return dest_area_id;
	}


	public void setDest_area_id(int dest_area_id) {
		this.dest_area_id = dest_area_id;
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



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getBusiness_type() {
		return business_type;
	}



	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}



	public String getWeight() {
		return weight;
	}



	public void setWeight(String weight) {
		this.weight = weight;
	}



	public String getConsigned_time() {
		return consigned_time;
	}



	public void setConsigned_time(String consigned_time) {
		this.consigned_time = consigned_time;
	}



	public String getSrc_address() {
		return src_address;
	}



	public void setSrc_address(String src_address) {
		this.src_address = src_address;
	}


	
	public int getSrc_area_id() {
		return src_area_id;
	}



	public void setSrc_area_id(int src_area_id) {
		this.src_area_id = src_area_id;
	}



	public int getSrc_course_id() {
		return src_course_id;
	}



	public void setSrc_course_id(int src_course_id) {
		this.src_course_id = src_course_id;
	}



	public String getDest_address() {
		return dest_address;
	}



	public void setDest_address(String dest_address) {
		this.dest_address = dest_address;
	}



	public int getDest_course_id() {
		return dest_course_id;
	}



	public void setDest_course_id(int dest_course_id) {
		this.dest_course_id = dest_course_id;
	}



	public double getFreight() {
		return freight;
	}



	public void setFreight(double freight) {
		this.freight = freight;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getLangName() {
		return langName;
	}



	public void setLangName(String langName) {
		this.langName = langName;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getSmsCode() {
		return smsCode;
	}


	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}


	public String getSmsToken() {
		return smsToken;
	}


	public void setSmsToken(String smsToken) {
		this.smsToken = smsToken;
	}


	public String getPlayTime() {
		return playTime;
	}


	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	
}

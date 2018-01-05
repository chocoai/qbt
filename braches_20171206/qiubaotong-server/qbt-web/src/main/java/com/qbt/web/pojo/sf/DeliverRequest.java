package com.qbt.web.pojo.sf;

import javax.validation.constraints.NotNull;

public class DeliverRequest {

	/**
	 * 1:表示“标准快递” o 2:表示“顺丰特惠” o 5:表示“顺丰次晨” o 6:表示“即日件” 3:加急
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
	 * 省
	 */
	private String src_province;
	
	/**
	 * 市
	 */
	private String src_city;
	
	/**
	 * 区
	 */
	private String src_district;
	
	/**
	 * 地址
	 */
	@NotNull(message="寄件地址不能为空")
	private String src_address;
	
	/**
	 * 地区编码
	 */
	private String src_code;
	
	/**
	 * 地区编码，可以反推出省市区信息
	 */
	private int src_area_id;
	
	/**
	 * 寄件球场ID
	 */
	private int src_course_id;
	
	/**
	 * 省
	 */
	private String dest_province;
	
	/**
	 * 市
	 */
	private String dest_city;
	
	/**
	 * 区
	 */
	private String dest_district;
	
	/**
	 * 地址
	 */
	@NotNull(message="收件地址不能为空")
	private String dest_address;
	
	/**
	 * 地区编码
	 */
	private String dest_code;
	
	/**
	 * 地区编码，可以反推出省市区信息
	 */
	private int dest_area_id;
	
	/**
	 * 收件球场ID
	 */
	private int dest_course_id;

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

	public String getSrc_province() {
		return src_province;
	}

	public void setSrc_province(String src_province) {
		this.src_province = src_province;
	}

	public String getSrc_city() {
		return src_city;
	}

	public void setSrc_city(String src_city) {
		this.src_city = src_city;
	}

	public String getSrc_district() {
		return src_district;
	}

	public void setSrc_district(String src_district) {
		this.src_district = src_district;
	}

	public String getSrc_address() {
		return src_address;
	}

	public void setSrc_address(String src_address) {
		this.src_address = src_address;
	}

	public String getSrc_code() {
		return src_code;
	}

	public void setSrc_code(String src_code) {
		this.src_code = src_code;
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

	public String getDest_province() {
		return dest_province;
	}

	public void setDest_province(String dest_province) {
		this.dest_province = dest_province;
	}

	public String getDest_city() {
		return dest_city;
	}

	public void setDest_city(String dest_city) {
		this.dest_city = dest_city;
	}

	public String getDest_district() {
		return dest_district;
	}

	public void setDest_district(String dest_district) {
		this.dest_district = dest_district;
	}

	public String getDest_address() {
		return dest_address;
	}

	public void setDest_address(String dest_address) {
		this.dest_address = dest_address;
	}

	public String getDest_code() {
		return dest_code;
	}

	public void setDest_code(String dest_code) {
		this.dest_code = dest_code;
	}

	public int getDest_area_id() {
		return dest_area_id;
	}

	public void setDest_area_id(int dest_area_id) {
		this.dest_area_id = dest_area_id;
	}

	public int getDest_course_id() {
		return dest_course_id;
	}

	public void setDest_course_id(int dest_course_id) {
		this.dest_course_id = dest_course_id;
	}

}

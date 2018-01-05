package com.qbt.web.pojo.sf;

import com.qbt.common.util.DateUtil;

public class DeliverV2Response implements Comparable<DeliverV2Response>{
	//1-次日达 2-隔日达 5-次晨达 3-加急
	private String business_type;
	
	private String business_type_desc;
	
	private String deliver_time;
	
	private double sf_price;
	
	private double origin_price;
	
	private double out_range_price;
	
	private String describe;
	
	public String getBusiness_type() {
		return business_type;
	}

	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}

	public String getBusiness_type_desc() {
		return business_type_desc;
	}

	public void setBusiness_type_desc(String business_type_desc) {
		this.business_type_desc = business_type_desc;
	}

	public String getDeliver_time() {
		return deliver_time;
	}

	public void setDeliver_time(String deliver_time) {
		this.deliver_time = deliver_time;
	}

	public double getSf_price() {
		return sf_price;
	}

	public void setSf_price(double sf_price) {
		this.sf_price = sf_price;
	}
	
	public double getOrigin_price() {
		return origin_price;
	}

	public void setOrigin_price(double origin_price) {
		this.origin_price = origin_price;
	}

	public double getOut_range_price() {
		return out_range_price;
	}

	public void setOut_range_price(double out_range_price) {
		this.out_range_price = out_range_price;
	}
	
	

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public int compareTo(DeliverV2Response resp) {
		Long curtime = DateUtil.str2Date(this.getDeliver_time(), DateUtil.DATE_TIME_FORMAT_01).getTime() - (long)this.getSf_price();
		Long datetime = DateUtil.str2Date(resp.getDeliver_time(), DateUtil.DATE_TIME_FORMAT_01).getTime() - (long)resp.getSf_price();
		return curtime.compareTo(datetime);
	}
	
}

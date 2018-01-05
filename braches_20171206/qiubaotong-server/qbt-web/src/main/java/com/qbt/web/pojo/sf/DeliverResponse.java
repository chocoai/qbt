package com.qbt.web.pojo.sf;

import com.qbt.common.util.DateUtil;

public class DeliverResponse implements Comparable<DeliverResponse>{
	
	private String business_type;
	
	private String business_type_desc;
	
	private String deliver_time;
	
	private double sf_price;
	
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

	@Override
	public int compareTo(DeliverResponse resp) {
		Long curtime = DateUtil.str2Date(this.getDeliver_time(), DateUtil.DATE_TIME_FORMAT_01).getTime() - (long)this.getSf_price();
		Long datetime = DateUtil.str2Date(resp.getDeliver_time(), DateUtil.DATE_TIME_FORMAT_01).getTime() - (long)resp.getSf_price();
		return curtime.compareTo(datetime);
	}
	
	public static void main(String[] args) {

	}
	
	
}

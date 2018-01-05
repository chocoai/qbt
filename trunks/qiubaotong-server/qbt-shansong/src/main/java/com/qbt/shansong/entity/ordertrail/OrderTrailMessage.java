/**
 * Project Name:qbt-shansong
 * File Name:OrderTrailMessage.java
 * Package Name:com.qbt.shansong.entity.ordertrail
 * Date:2017年2月24日上午11:03:00
 *
*/

package com.qbt.shansong.entity.ordertrail;
/**
 * ClassName:OrderTrailMessage
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月24日 上午11:03:00
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderTrailMessage {
	
	private Double lat;
	
	private Double lng;
	
	private String time;

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}

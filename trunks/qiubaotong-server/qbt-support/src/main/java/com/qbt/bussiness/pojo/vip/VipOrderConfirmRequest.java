/**
 * Project Name:qbt-web
 * File Name:VipOrderConfirmRequest.java
 * Package Name:com.qbt.web.pojo.vip
 * Date:2017年2月20日下午2:53:50
 *
*/

package com.qbt.bussiness.pojo.vip;
/**
 * ClassName:VipOrderConfirmRequest
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月20日 下午2:53:50
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class VipOrderConfirmRequest {
	
	private String jMobile;
	
	private String dMobile;
	
	private String jName;
	
	private String dName;
	
	private String consignedTime;
	
	/**
	 * 寄件球场ID
	 */
	private int srcCourseId;
	
	/**
	 * 收件球场ID
	 */
	private int destCourseId;
	
	private int num;//	球包数量
	
	private Integer userId;
	
	private int src_area_id;
	
	private String src_address;
	
	private int  dest_area_id;
	
	private String dest_address;

	public String getjMobile() {
		return jMobile;
	}

	public void setjMobile(String jMobile) {
		this.jMobile = jMobile;
	}

	public String getdMobile() {
		return dMobile;
	}

	public void setdMobile(String dMobile) {
		this.dMobile = dMobile;
	}

	public String getjName() {
		return jName;
	}

	public void setjName(String jName) {
		this.jName = jName;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getConsignedTime() {
		return consignedTime;
	}

	public void setConsignedTime(String consignedTime) {
		this.consignedTime = consignedTime;
	}

	public int getSrcCourseId() {
		return srcCourseId;
	}

	public void setSrcCourseId(int srcCourseId) {
		this.srcCourseId = srcCourseId;
	}

	public int getDestCourseId() {
		return destCourseId;
	}

	public void setDestCourseId(int destCourseId) {
		this.destCourseId = destCourseId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getSrc_area_id() {
		return src_area_id;
	}

	public void setSrc_area_id(int src_area_id) {
		this.src_area_id = src_area_id;
	}

	public String getSrc_address() {
		return src_address;
	}

	public void setSrc_address(String src_address) {
		this.src_address = src_address;
	}

	public int getDest_area_id() {
		return dest_area_id;
	}

	public void setDest_area_id(int dest_area_id) {
		this.dest_area_id = dest_area_id;
	}

	public String getDest_address() {
		return dest_address;
	}

	public void setDest_address(String dest_address) {
		this.dest_address = dest_address;
	}

}

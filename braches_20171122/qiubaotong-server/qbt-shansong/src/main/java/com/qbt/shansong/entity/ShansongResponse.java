/**
 * Project Name:qbt-shansong
 * File Name:OrderCalcResponse.java
 * Package Name:com.qbt.shansong.entity.ordercalc
 * Date:2017年2月23日下午2:48:34
 *
*/

package com.qbt.shansong.entity;
/**
 * ClassName:ShansongResponse
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午2:48:34
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class ShansongResponse<T> {
	
	private String status;
	
	private String errMsg;
	
	private Integer errCode;
	
	private T data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}

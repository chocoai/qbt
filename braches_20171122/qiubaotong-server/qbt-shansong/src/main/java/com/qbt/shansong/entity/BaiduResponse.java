/**
 * Project Name:qbt-shansong
 * File Name:BaiduResponse.java
 * Package Name:com.qbt.shansong.entity
 * Date:2017年2月23日下午2:55:02
 *
*/

package com.qbt.shansong.entity;

/**
 * ClassName:BaiduResponse
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午2:55:02
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class BaiduResponse<T> {
	
	//返回结果状态值， 成功返回0
	private Integer status;
		
	//错误信息描述
	private String msg;
		
	//返回结果
	private T result;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
}

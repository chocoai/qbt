package com.qbt.common.exception;

import com.qbt.common.enums.ErrorCodeEnum;

public class BusinessException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 错误码
	 */
	private String code;
	
	/**
	 * 错误信息
	 */
	private String msg;
	
	public BusinessException(){
		super();
	}
	
	public BusinessException(ErrorCodeEnum e){
		super(e.getMsg());
		this.code = e.getCode();
		this.msg = e.getMsg();
	}
	
	public BusinessException(String msg){
		super(msg);
		this.code = ErrorCodeEnum.ERROR_SYS.getCode();
		this.msg = msg;
	}
	
	 public BusinessException(ErrorCodeEnum code,String msg) {
	        super(msg);
	        this.code = code.getCode();
	        this.msg = msg;
	    }
	
	public BusinessException(String code,String msg){
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

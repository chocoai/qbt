package com.qbt.common.result;

import com.qbt.common.enums.ErrorCodeEnum;

public class Result<T> {
	
	private String code = "0000";
	
	private String msg  = "ok";
	
	private T  datas;
	
	public Result(){
		
	}
	
	public Result(String code,String msg){
		this.code = code;
		this.msg = code;
	}
	
	public Result(ErrorCodeEnum errEnum){
		this.code = errEnum.getCode();
		this.msg = errEnum.getMsg();
	}
	
	public Result(ErrorCodeEnum errEnum,String msg){
		this.code = errEnum.getCode();
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

	public T getDatas() {
		return datas;
	}

	public void setDatas(T datas) {
		this.datas = datas;
	}

	public void setError(ErrorCodeEnum errEnum){
		this.code = errEnum.getCode();
		this.msg = errEnum.getMsg();
	}
	
}

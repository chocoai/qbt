package com.qbt.common.enums;

public enum ErrorCodeEnum {

	ERROR_SUCCESS("0000","ok"), 

	ERROR_AUTH("0001", "授权过期"), 
	ERROR("1000", "请求参数错误"), 
	ERROR_NODB_CONFIG("1001", "记录未配置"), 
	ERROR_VALID_FAIL("1002", "参数校验不通过"), 
	ERROR_IFC("1003", "顺丰接口调用异常"),
	
	ERROR_TIMEOUT("7001","登录超时,请重新登录"),
	ERROR_CHECK_TOKEN_OUT("7002","您的账号已经在其他地方登录，为确保账号安全请立即修改密码"),
	ERROR_SYS_USER_NOT_EXST("7003","后台用户不存在"),
	ERROR_SYS_USER_IS_DELETE("7004","后台用户已被禁用"),
	ERROR_SYS_USER_PWD("7005", "手机号或密码错误"),
	
	ERROR_SYS("9999", "系统异常")
	;

	String code;
	String msg;

	private ErrorCodeEnum(String code, String msg) {
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

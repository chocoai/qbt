package com.qbt.common.exception;

import com.qbt.common.enums.ErrorCodeEnum;

public class WechatException extends BaseException {

	private static final long serialVersionUID = 5658988410818130989L;

	private String code;
	private String msg;
	
	public WechatException() {
        super();
    }
    
    public WechatException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public WechatException(Throwable cause) {
        super(cause);
    }
    
    public WechatException(String message) {
        super(message);
        this.code = ErrorCodeEnum.ERROR_VALID_FAIL.getCode();
        this.msg = message;
    }
    
    public WechatException(ErrorCodeEnum code) {
        super(code.getMsg());
        this.code = code.getCode();
        this.msg = code.getMsg();
    }
    
    public WechatException(ErrorCodeEnum code,String msg) {
        super(msg);
        this.code = code.getCode();
        this.msg = msg;
    }
    
    public WechatException(String code,String msg) {
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

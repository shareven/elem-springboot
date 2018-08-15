package com.xie.elem.utils;

public class MyException extends RuntimeException {
	private Integer code;
	private Boolean success;
	private String msg;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public MyException(Integer code, Boolean success, String msg) {
		this.code = code;
		this.success = success;
		this.msg = msg;
	}

}

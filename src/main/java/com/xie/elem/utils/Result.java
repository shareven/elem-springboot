package com.xie.elem.utils;

public class Result {
	private Integer code = 200;
	private Boolean success = true;
	private String msg = "操作成功！";
	private Object data;

	/* 无参构造器 */
	public Result() {
		super();
	}

	public Result(Boolean success) {
		super();
		this.success = success;
		if (success == false) {
			this.msg = "操作失败！";
		}
	}

	public Result(Boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	public Result(String msg, Object data) {
		super();
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public Boolean getSuccess() {
		return success;
	}


	public void setSuccess(Boolean success) {
		this.success = success;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}

}

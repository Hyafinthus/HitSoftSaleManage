package com.hit.soft.domain;

import java.util.List;

public class JsonStaff {
	private int code = 0;
	private String msg = "";
	private int count;
	private List<Staff> data;
	
	public JsonStaff(int count, List<Staff> data) {
		super();
		this.count = count;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Staff> getData() {
		return data;
	}

	public void setData(List<Staff> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonStaff [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	
}

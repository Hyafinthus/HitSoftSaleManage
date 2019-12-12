package com.hit.soft.domain;

import java.util.List;

public class JsonOrder {
	private int code = 0;
	private String msg = "";
	private int count;
	private List<Order> data;
	
	public JsonOrder(int count, List<Order> data) {
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

	public List<Order> getData() {
		return data;
	}

	public void setData(List<Order> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonOrder [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	
}

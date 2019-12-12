package com.hit.soft.domain;

import java.util.List;

public class JsonProduct {
	private int code = 0;
	private String msg = "";
	private int count;
	private List<Product> data;
	
	public JsonProduct(int count, List<Product> data) {
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

	public List<Product> getData() {
		return data;
	}

	public void setData(List<Product> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonProduct [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	
}

package com.hit.soft.domain;

import java.util.List;

public class JsonProductDepot {
	private int code = 0;
	private String msg = "";
	private int count;
	private List<ProductDepot> data;
	
	public JsonProductDepot(int count, List<ProductDepot> data) {
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

	public List<ProductDepot> getData() {
		return data;
	}

	public void setData(List<ProductDepot> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonProductDepot [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	
}

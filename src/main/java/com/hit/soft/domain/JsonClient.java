package com.hit.soft.domain;

import java.util.List;

public class JsonClient {
	private int code = 0;
	private String msg = "";
	private int count;
	private List<Client> data;
	
	public JsonClient(int count, List<Client> data) {
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

	public List<Client> getData() {
		return data;
	}

	public void setData(List<Client> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonClient [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	
}

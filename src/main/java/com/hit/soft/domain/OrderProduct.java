package com.hit.soft.domain;

import java.util.HashMap;
import java.util.Map;

public class OrderProduct {
	private String create_time;
	private int client_id;
	private String client_name;
	private Map<Product, Integer> products = new HashMap<Product, Integer>();
	
	public OrderProduct() {
		super();
	}

	// 开单时
	public OrderProduct(String create_time, int client_id, Map<Product, Integer> products) {
		super();
		this.create_time = create_time;
		this.client_id = client_id;
		this.products = products;
	}

	// 审核时
	public OrderProduct(String create_time, String client_name, Map<Product, Integer> products) {
		super();
		this.create_time = create_time;
		this.client_name = client_name;
		this.products = products;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrderProduct [create_time=" + create_time + ", client_id=" + client_id + ", client_name=" + client_name
				+ ", products=" + products + "]";
	}
	
}

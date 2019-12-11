package com.hit.soft.domain;

import java.util.HashMap;
import java.util.Map;

public class OrderProduct {
	private String create_time;
	private int client_id;
	private Map<Product, Integer> products = new HashMap<Product, Integer>();
	
	public OrderProduct() {
		super();
	}

	public OrderProduct(String create_time, int client_id, Map<Product, Integer> products) {
		super();
		this.create_time = create_time;
		this.client_id = client_id;
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

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrderProduct [create_time=" + create_time + ", client_id=" + client_id + ", products=" + products + "]";
	}
	
	
}

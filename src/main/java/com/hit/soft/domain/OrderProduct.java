package com.hit.soft.domain;

import java.util.List;

public class OrderProduct {
	private int order_id;
	private String create_time;
	private int client_id;
	private String client_name;
	private List<Product> products;
	
	public OrderProduct() {
		super();
	}

	// 开单时
	public OrderProduct(String create_time, int client_id, List<Product> products) {
		super();
		this.create_time = create_time;
		this.client_id = client_id;
		this.products = products;
	}

	// 审核时
	public OrderProduct(int order_id, String create_time, String client_name, List<Product> products) {
		super();
		this.order_id = order_id;
		this.create_time = create_time;
		this.client_name = client_name;
		this.products = products;
	}
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrderProduct [order_id=" + order_id + ", create_time=" + create_time + ", client_id=" + client_id
				+ ", client_name=" + client_name + ", products=" + products + "]";
	}

	
	
}

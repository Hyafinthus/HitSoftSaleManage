package com.hit.soft.domain;

public class Order {
	private int order_id;
	private String create_time;
	private String pay_time;
	private String return_time;
	private int client_id;
	private String client_name;
	private double order_sale_price;
	private double order_purchase_price;
	private double order_profit;
	private String state;
	private int wholesale_order;
	
	public Order() {
		super();
	}

	public Order(int order_id, String create_time, String pay_time, String return_time, int client_id,
			String client_name, double order_sale_price, double order_purchase_price, double order_profit, String state,
			int wholesale_order) {
		super();
		this.order_id = order_id;
		this.create_time = create_time;
		this.pay_time = pay_time;
		this.return_time = return_time;
		this.client_id = client_id;
		this.client_name = client_name;
		this.order_sale_price = order_sale_price;
		this.order_purchase_price = order_purchase_price;
		this.order_profit = order_profit;
		this.state = state;
		this.wholesale_order = wholesale_order;
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

	public String getPay_time() {
		return pay_time;
	}

	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}

	public String getReturn_time() {
		return return_time;
	}

	public void setReturn_time(String return_time) {
		this.return_time = return_time;
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

	public double getOrder_sale_price() {
		return order_sale_price;
	}

	public void setOrder_sale_price(double order_sale_price) {
		this.order_sale_price = order_sale_price;
	}

	public double getOrder_purchase_price() {
		return order_purchase_price;
	}

	public void setOrder_purchase_price(double order_purchase_price) {
		this.order_purchase_price = order_purchase_price;
	}

	public double getOrder_profit() {
		return order_profit;
	}

	public void setOrder_profit(double order_profit) {
		this.order_profit = order_profit;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getWholesale_order() {
		return wholesale_order;
	}

	public void setWholesale_order(int wholesale_order) {
		this.wholesale_order = wholesale_order;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", create_time=" + create_time + ", pay_time=" + pay_time
				+ ", return_time=" + return_time + ", client_id=" + client_id + ", client_name=" + client_name
				+ ", order_sale_price=" + order_sale_price + ", order_purchase_price=" + order_purchase_price
				+ ", order_profit=" + order_profit + ", state=" + state + ", wholesale_order=" + wholesale_order + "]";
	}
	
}

package com.hit.soft.domain;

public class Order {
	private int order_id;
	private String create_datatime;
	private String pay_datetime;
	private String return_datetime;
	private int client_id;
	private double order_sale_price;
	private double order_purchase_price;
	private double order_profit;
	private String state;
	private int wholesale_order;
	
	public Order() {
		super();
	}

	public Order(int order_id, String create_datatime, String pay_datetime, String return_datetime, int client_id,
			double order_sale_price, double order_purchase_price, double order_profit, String state,
			int wholesale_order) {
		super();
		this.order_id = order_id;
		this.create_datatime = create_datatime;
		this.pay_datetime = pay_datetime;
		this.return_datetime = return_datetime;
		this.client_id = client_id;
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

	public String getCreate_datatime() {
		return create_datatime;
	}

	public void setCreate_datatime(String create_datatime) {
		this.create_datatime = create_datatime;
	}

	public String getPay_datetime() {
		return pay_datetime;
	}

	public void setPay_datetime(String pay_datetime) {
		this.pay_datetime = pay_datetime;
	}

	public String getReturn_datetime() {
		return return_datetime;
	}

	public void setReturn_datetime(String return_datetime) {
		this.return_datetime = return_datetime;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
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
		return "Order [order_id=" + order_id + ", create_datatime=" + create_datatime + ", pay_datetime=" + pay_datetime
				+ ", return_datetime=" + return_datetime + ", client_id=" + client_id + ", order_sale_price="
				+ order_sale_price + ", order_purchase_price=" + order_purchase_price + ", order_profit=" + order_profit
				+ ", state=" + state + ", wholesale_order=" + wholesale_order + "]";
	}
	
}

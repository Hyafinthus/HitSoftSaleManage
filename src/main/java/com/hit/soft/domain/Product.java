package com.hit.soft.domain;

public class Product {
	private int product_id;
	private String product_name;
	private String type;
	private String unit;
	private double purchase_price;
	private double wholesale_price;
	private double retail_price;
	
	public Product() {
		super();
	}

	public Product(int product_id, String product_name, String type, String unit, double purchase_price,
			double wholesale_price, double retail_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.type = type;
		this.unit = unit;
		this.purchase_price = purchase_price;
		this.wholesale_price = wholesale_price;
		this.retail_price = retail_price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(double purchase_price) {
		this.purchase_price = purchase_price;
	}

	public double getWholesale_price() {
		return wholesale_price;
	}

	public void setWholesale_price(double wholesale_price) {
		this.wholesale_price = wholesale_price;
	}

	public double getRetail_price() {
		return retail_price;
	}

	public void setRetail_price(double retail_price) {
		this.retail_price = retail_price;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", type=" + type + ", unit="
				+ unit + ", purchase_price=" + purchase_price + ", wholesale_price=" + wholesale_price
				+ ", retail_price=" + retail_price + "]";
	}


}

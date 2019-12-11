package com.hit.soft.domain;

public class ProductDepot {
	private int product_id;
	private String product_name;
	private String type;
	private String unit;
	private String depot_name;
	private int count;
	
	public ProductDepot() {
		super();
	}

	public ProductDepot(int product_id, String product_name, String type, String unit, String depot_name, int count) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.type = type;
		this.unit = unit;
		this.depot_name = depot_name;
		this.count = count;
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

	public String getDepot_name() {
		return depot_name;
	}

	public void setDepot_name(String depot_name) {
		this.depot_name = depot_name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ProductDepot [product_id=" + product_id + ", product_name=" + product_name + ", type=" + type
				+ ", unit=" + unit + ", depot_name=" + depot_name + ", count=" + count + "]";
	}
	
	
}

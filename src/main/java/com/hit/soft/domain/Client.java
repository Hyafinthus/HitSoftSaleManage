package com.hit.soft.domain;

public class Client {
	private int client_id;
	private String client_name;
	private String sex;
	private String phone;
	private String address;
	private double wallet;
	private int wholesale_client;
	private int retail_client;
	
	public Client() {
		super();
	}

	public Client(int client_id, String client_name, String sex, String phone, String address, double wallet,
			int wholesale_client, int retail_client) {
		super();
		this.client_id = client_id;
		this.client_name = client_name;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.wallet = wallet;
		this.wholesale_client = wholesale_client;
		this.retail_client = retail_client;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public int getWholesale_client() {
		return wholesale_client;
	}

	public void setWholesale_client(int wholesale_client) {
		this.wholesale_client = wholesale_client;
	}

	public int getRetail_client() {
		return retail_client;
	}

	public void setRetail_client(int retail_client) {
		this.retail_client = retail_client;
	}

	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", client_name=" + client_name + ", sex=" + sex + ", phone=" + phone
				+ ", address=" + address + ", wallet=" + wallet + ", wholesale_client=" + wholesale_client
				+ ", retail_client=" + retail_client + "]";
	}
	
}

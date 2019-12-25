package com.hit.soft.domain;

public class Client {
	private int client_id;
	private String client_name;
	private String sex;
	private String phone;
	private String address;
	private double wallet;
	
	public Client() {
		super();
	}

	public Client(int client_id, String client_name, String sex, String phone, String address, double wallet) {
		super();
		this.client_id = client_id;
		this.client_name = client_name;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.wallet = wallet;
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

	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", client_name=" + client_name + ", sex=" + sex + ", phone=" + phone
				+ ", address=" + address + ", wallet=" + wallet + "]";
	}
	
}

package com.hit.soft.domain;

public class Staff {
	private int staff_id;
	private String staff_name;
	private String role;
	private String pass;
	
	public Staff() {
		super();
	}

	public Staff(int staff_id, String staff_name, String role, String pass) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.role = role;
		this.pass = pass;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Staff [staff_id=" + staff_id + ", staff_name=" + staff_name + "]";
	}
	
}

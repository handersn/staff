package com.staffmanager.domain;

import java.io.Serializable;

public class Staff implements Serializable{
	private static final long serialVersionUID = 1L;

	protected int eno; 
	protected String position;
	protected String name;
	protected String email;
	protected int phone;
	
	@Override
	public String toString() {
		return "Staff [eno=" + eno + ", position=" + position + ", name="
				+ name + ", email=" + email + ", phone=" + phone + "]";
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
}

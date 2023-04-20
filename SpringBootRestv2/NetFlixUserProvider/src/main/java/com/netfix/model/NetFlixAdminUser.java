package com.netfix.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class NetFlixAdminUser {
	
	private Integer uid;
	
	@Size(min=3,message="Name should be having atleast 3 charecters")
	private String uname;
	@Past(message="post of date must not be in past")
	private LocalDate dop;

	public NetFlixAdminUser() {
		super();
	}

	public NetFlixAdminUser(Integer uid, String uname, LocalDate dop) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.dop = dop;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public LocalDate getDop() {
		return dop;
	}

	public void setDop(LocalDate dop) {
		this.dop = dop;
	}

	@Override
	public String toString() {
		return "NetFlixAdminUser [uid=" + uid + ", uname=" + uname + ", dop=" + dop + "]";
	}
	
	
	

}

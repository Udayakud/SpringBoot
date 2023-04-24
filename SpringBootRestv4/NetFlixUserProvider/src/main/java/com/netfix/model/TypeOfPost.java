package com.netfix.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class TypeOfPost {

	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=10)
	private String dis;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private NetFlixAdminUser nau;

	public TypeOfPost(Integer id, String dis) {
		super();
		this.id = id;
		this.dis = dis;
	}

	public TypeOfPost() {
		super();
	}

	public NetFlixAdminUser getNau() {
		return nau;
	}

	public void setNau(NetFlixAdminUser nau) {
		this.nau = nau;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDis() {
		return dis;
	}

	public void setDis(String dis) {
		this.dis = dis;
	}
	
	
	
}

package com.extract.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
@Embeddable
public class ManagersPrimaryKey implements Serializable {
	@NotNull
	@Column(name = "domain")
	private String domain;
	@NotNull
	@Column(name = "id")
	private int id;
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}

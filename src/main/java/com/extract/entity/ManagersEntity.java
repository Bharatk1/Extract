package com.extract.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "managers")

public class ManagersEntity implements Serializable  {
	@EmbeddedId
	private ManagersPrimaryKey mpk;
	
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	@NotNull
	@Column(name = "age")
	private int age;
	@Column(name = "office")
	private String office;
	
	public String getFirst_name() {
		return firstName;
	}
	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}
	public String getLast_name() {
		return lastName;
	}
	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	
	
	
	
	

}

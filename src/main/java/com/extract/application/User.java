package com.extract.application;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customers")
	public class User implements Serializable {
	   
	    @Id
	    private int id;
	    
	    private String name;

	    private int age;
	    
	    private String address;
	    @JsonIgnore
	    private double salary;

	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", salary=" + salary
					+ "]";
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}	
		
		


}

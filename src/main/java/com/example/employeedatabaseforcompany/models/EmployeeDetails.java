package com.example.employeedatabaseforcompany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity 
public class EmployeeDetails {

	@Id
	private int emp_id;
	private String name;
	private String city;
	
	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeDetails(int emp_id, String name, String city) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.city = city;
	}

	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}

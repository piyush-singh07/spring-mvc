package com.utc.dip;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude(value=Include.NON_NULL)
public class Employee {
	
	@JsonProperty("EMPLOYEE IDENTITY")
	private String emp_id;
	@JsonProperty("EMPLOYEE NAME")
	private String emp_name;
	private Float emp_salary;
	private Address emp_address;
	private String[] emp_hobbies;
	@JsonProperty(access=Access.READ_ONLY)
	private long emp_contact;
	private Boolean isEmployee;
	
	public Boolean getIsEmployee() {
		return isEmployee;
	}
	@JsonSetter("isAnEmployee")
	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Float getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(Float emp_salary) {
		this.emp_salary = emp_salary;
	}
	public Address getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(Address emp_address) {
		this.emp_address = emp_address;
	}
	public String[] getEmp_hobbies() {
		return emp_hobbies;
	}
	public void setEmp_hobbies(String[] emp_hobbies) {
		this.emp_hobbies = emp_hobbies;
	}
	public long getEmp_contact() {
		return emp_contact;
	}
	public void setEmp_contact(long emp_contact) {
		this.emp_contact = emp_contact;
	}
	
	
	

}

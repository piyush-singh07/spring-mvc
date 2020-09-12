package com.utc.model;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.utc.validation.IsValidHobby;
import com.utc.validation.IsValidMobile;

public class Student {
	@Size(min=4,max=8)
	private String sid;
	@Size(min=2,max=20)
	@Pattern(regexp="^[0-9]*")
	private String sname;
	@IsValidMobile
	private String smobile;
	@Past
	private Date sdob;
	@IsValidHobby(listofValidHobbies="Hockey|Cricket|Volleyball|Basketball")
	private String shobby;
	private ArrayList<String> sskills;
	private Address saddress;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public Date getSdob() {
		return sdob;
	}
	public void setSdob(Date sdob) {
		this.sdob = sdob;
	}
	public ArrayList<String> getSskills() {
		return sskills;
	}
	public void setSskills(ArrayList<String> sskills) {
		this.sskills = sskills;
	}
	public Address getSaddress() {
		return saddress;
	}
	public void setSaddress(Address saddress) {
		this.saddress = saddress;
	}
	public String getSmobile() {
		return smobile;
	}
	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}
	public String getShobby() {
		return shobby;
	}
	public void setShobby(String shobby) {
		this.shobby = shobby;
	}
	
	

}

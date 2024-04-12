package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users1")
public class Users1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	
	private String username;
	
	private String password;
	
	@OneToOne
	@JoinColumn(name="department_dpid", referencedColumnName="dpid")
	@JsonManagedReference
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Users1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users1(Integer userid, String username, String password, Department department) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Users1 [userid=" + userid + ", username=" + username + ", password=" + password + ", department="
				+ department + "]";
	}

	
	
	

}

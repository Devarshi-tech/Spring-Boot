package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dpid;
	
	private String dpname;
	
	// mappedBy -> will not create fk column in department table thats why it is used here
	@OneToOne(mappedBy = "department")
	@JsonBackReference
	private Users1 users1;

	public Users1 getUsers1() {
		return users1;
	}

	public void setUsers1(Users1 users1) {
		this.users1 = users1;
	}

	public Integer getDpid() {
		return dpid;
	}

	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	public String getDpname() {
		return dpname;
	}

	public void setDpname(String dpname) {
		this.dpname = dpname;
	}


	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [dpid=" + dpid + ", dpname=" + dpname + ", users1=" + users1 + "]";
	}

	public Department(Integer dpid, String dpname, Users1 users1) {
		super();
		this.dpid = dpid;
		this.dpname = dpname;
		this.users1 = users1;
	}
	
	

}

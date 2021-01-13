package com.halcyon.file_manage.model;

import java.io.Serializable;

import com.halcyon.file_manage.annotations.SystemRole;

public class User implements Serializable {

	private static final long serialVersionUID = 6005944491772865631L;
	private Integer id;
	private String name;
	private String pwd;
	private SystemRole role;

	public User() {
		super();
	}

	
	
	public User(Integer id, String name, String pwd, SystemRole role) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.role = role;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public SystemRole getRole() {
		return role;
	}

	public void setRole(SystemRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", role=" + role + "]";
	}

}

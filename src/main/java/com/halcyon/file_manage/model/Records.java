package com.halcyon.file_manage.model;

import java.io.Serializable;
import java.util.Date;

public class Records implements Serializable {
	private static final long serialVersionUID = -457345446934683367L;
	private String name;
	private Integer id;
	private String info;
	private Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Records [name=" + name + ", id=" + id + ", info=" + info + ", date=" + date + "]";
	}
	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Records(String name, Integer id, String info, Date date) {
		super();
		this.name = name;
		this.id = id;
		this.info = info;
		this.date = date;
	}
	
	
	
}

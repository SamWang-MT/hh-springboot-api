package com.halcyon.file_manage.annotations;

public enum SystemRole {
	
	
	OPERATOR("operator","操作员"),
	ADMIN("admin","管理员");
	
	
	private String code;
	private String name;
	
	SystemRole(String code, String name){
		this.code = code;
		this.name = name;
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

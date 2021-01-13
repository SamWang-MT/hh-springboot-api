package com.halcyon.file_manage.service;

import com.halcyon.file_manage.model.User;

public interface LoginService {
	
	User checkUser(String name, String pwd);

}

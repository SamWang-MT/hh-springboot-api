package com.halcyon.file_manage.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.halcyon.file_manage.annotations.SystemRole;
import com.halcyon.file_manage.model.User;
import com.halcyon.file_manage.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private static Map<String, User> userMap;
	static {
		userMap = new HashMap<String, User>();
		userMap.put("adminadmin", new User(1, "admin", "admin", SystemRole.ADMIN));
		userMap.put("operatoroperator", new User(2, "operator", "operator", SystemRole.OPERATOR));
	}

	@Override
	public User checkUser(String name, String pwd) {
		return userMap.get(name + pwd);
	}

}

package com.halcyon.file_manage.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.halcyon.file_manage.configurer.SystemConstant;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.User;
import com.halcyon.file_manage.service.LoginService;

@RestController
@RequestMapping("/login/")
public class LoginController {

	@Resource
	private LoginService loginService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/api")
	public Result add(@RequestParam String username, @RequestParam String pwd, HttpServletRequest request,
			HttpServletResponse response) {

		Result genFailResult = ResultGenerator.genFailResult("用户名或密码错误！");

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(pwd)) {
			return genFailResult;
		}

		User checkUser = loginService.checkUser(username, pwd);
		if (checkUser == null) {
			return genFailResult;
		}

		HttpSession session = request.getSession();
		session.setAttribute(SystemConstant.USER_ROLES, checkUser.getRole());

		/*
		 * if ("admin".equals(username)) {
		 * session.setAttribute(SystemConstant.USER_ROLES, SystemRole.ADMIN); }else {
		 * session.setAttribute(SystemConstant.USER_ROLES, SystemRole.OPERATOR); }
		 */

		return ResultGenerator.genSuccessResult();
	}

}

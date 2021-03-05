package com.halcyon.file_manage.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;

import cn.hutool.core.util.StrUtil;

/**
 * @ClassName: LoginController
 * @author: Merdader
 * @Date: Mar. 5, 2021 3:15:37 p.m.
 * 
 * @description:
 */
@RestController
//@RequestMapping("/login")
public class LoginController {
	@Value("${login.verification}")
	private   String NAME_PWD;

	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public Result login(HttpServletRequest request, @RequestParam(defaultValue = "") String userName,
			@RequestParam(defaultValue = "") String pwd) {

		if (StrUtil.isBlankIfStr(userName) || StrUtil.isBlankIfStr(pwd) || !(NAME_PWD.equals(userName + pwd))) {
			return ResultGenerator.genFailResult("登陆失败");
		} else {
			request.getSession().setAttribute("sign", NAME_PWD);
		}
		return ResultGenerator.genSuccessResult();
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/logout")
	public Result logout(HttpServletRequest request) {
		request.getSession().setAttribute("sign", null);

		return ResultGenerator.genSuccessResult();
	}

}

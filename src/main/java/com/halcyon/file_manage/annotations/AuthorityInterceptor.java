package com.halcyon.file_manage.annotations;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.halcyon.file_manage.configurer.SystemConstant;
import com.halcyon.file_manage.configurer.WebMvcConfigurer;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultCode;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {

	private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

	public AuthorityInterceptor() {
		super();
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		// 从方法处理器中获取出要调用的方法
		Method method = handlerMethod.getMethod();

		String target = handlerMethod.getBean().getClass().getName() + "." + method.getName();

		Authority authority = (Authority) AuthorityAnnotationContainer.getAuthorityAnnotationContainer()
				.getAuthority(target);

		Boolean isSuccess = false; // 是否能够访问
		// 对应的方法设置的权限
		if (authority != null) {
			// 这里进行条件判断，
			// 本项目中的做法是，取得用户信息，然后判断用户是哪个平台的，在决定是否能够访问。
			// 如果能够访问 isSuccess = true;
			SystemRole[] roles = authority.value();
			HttpSession session = request.getSession();
			SystemRole role = (SystemRole) session.getAttribute(SystemConstant.USER_ROLES);
			if (role != null) {
				// 已经登录 可用的 权限
				for (SystemRole systemRole : roles) {
					if (systemRole == role) {
						isSuccess = true;
					}
				}
			}

		} else {
			// 方法上没有权限
			isSuccess = true;
		}

		if (!isSuccess) {
			Result result = new Result();
			result.setCode(ResultCode.UNAUTHORIZED).setMessage("认证失败");
			responseResult(response, result);

		}

		return isSuccess;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	private void responseResult(HttpServletResponse response, Result result) {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "application/json;charset=UTF-8");
		response.setStatus(200);
		try {
			response.getWriter().write(JSON.toJSONString(result));
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
	}

}
package com.halcyon.file_manage.annotations;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RestController;

@Component
public class AuthorityControllerBeanProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		Class clazz = bean.getClass();
		Boolean isControllerAnnotationInClass = clazz.isAnnotationPresent(Controller.class)
				|| clazz.isAnnotationPresent(RestController.class);

		if (isControllerAnnotationInClass) {
			// 如果这是一个 Controller Bean 的话
			// 那么就读取所有方法的权限配置
			Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());

			for (Method method : methods) {

				Boolean isAuthorityAnnotationInMethod = method.isAnnotationPresent(Authority.class);
				String target = bean.getClass().getName() + "." + method.getName();

				if (isAuthorityAnnotationInMethod) {
					// 如果有 @Authority 注解的话
					// 则记录该注解中的内容
					Authority authority = method.getAnnotation(Authority.class);
					AuthorityAnnotationContainer.getAuthorityAnnotationContainer().addPlatformConfiguration(target,
							authority);
					SystemRole[] value = authority.value();
					
				}
			}

			return bean;
		} else {
			// 否则的话直接返回Bean
			return bean;
		}
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}
}

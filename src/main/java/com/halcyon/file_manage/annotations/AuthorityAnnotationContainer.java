package com.halcyon.file_manage.annotations;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限注解容器
 * 
 * @author Administrator
 *
 */
public class AuthorityAnnotationContainer {
	private volatile static AuthorityAnnotationContainer AuthorityAnnotationContainer; // 1:volatile修饰
	private Map<String, Object> conMap; // 容器

	private AuthorityAnnotationContainer() {
		super();
		this.conMap = new HashMap<String, Object>();

	}

	public static AuthorityAnnotationContainer getAuthorityAnnotationContainer() {
		if (AuthorityAnnotationContainer == null) { // 2:减少不要同步，优化性能
			synchronized (AuthorityAnnotationContainer.class) { // 3：同步，线程安全
				if (AuthorityAnnotationContainer == null) {
					AuthorityAnnotationContainer = new AuthorityAnnotationContainer(); // 4：创建AuthorityAnnotationContainer
																						// 对象
				}
			}
		}
		return AuthorityAnnotationContainer;
	}

	public void addPlatformConfiguration(String method, Authority orleAuthority) {
		this.conMap.put(method, orleAuthority);
	}

	public Object getAuthority(String methodString) {
		return this.getConMap().get(methodString);
	}

	public Map<String, Object> getConMap() {
		return conMap;
	}

	public void setConMap(Map<String, Object> conMap) {
		this.conMap = conMap;
	}

}

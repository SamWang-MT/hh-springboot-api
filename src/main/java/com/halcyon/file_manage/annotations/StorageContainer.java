package com.halcyon.file_manage.annotations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.halcyon.file_manage.model.Chemicalwmnotes;
import com.halcyon.file_manage.model.Chemicalwmstock;

/**
 * 数据容器
 * 
 * @author Administrator
 *
 */
public class StorageContainer {
	public static final String MATERALS_INFO = "MATERALS_INFO";
	public static final String STOCK_INFO = "STOCK_INFO";

	private volatile static StorageContainer storageContainer; // 1:volatile修饰
	private Map<String, Object> conMap; // 容器

	private StorageContainer() {
		super();
		this.conMap = new HashMap<String, Object>();

	}

	public static StorageContainer getContainer() {
		if (storageContainer == null) { // 2:减少不要同步，优化性能
			synchronized (StorageContainer.class) { // 3：同步，线程安全
				if (storageContainer == null) {
					storageContainer = new StorageContainer(); // 4：创建AuthorityAnnotationContainer
																// 对象
				}
			}
		}
		return storageContainer;
	}

	public void refreshMateral(Map<String,Chemicalwmnotes >chemicalwmnotes) {
		this.conMap.put(MATERALS_INFO, chemicalwmnotes);
	}

	public void refreshStorage(List<Chemicalwmstock> chemicalwmstock) {
		this.conMap.put(STOCK_INFO, chemicalwmstock);
	}

	@SuppressWarnings("unchecked")
	public Map<String,Chemicalwmnotes > getMateral() {
		return (Map<String,Chemicalwmnotes >) this.getConMap().get(MATERALS_INFO);
	}

	@SuppressWarnings("unchecked")
	public List<Chemicalwmstock> getStock() {
		return (List<Chemicalwmstock>) this.getConMap().get(STOCK_INFO);
	}

	public Map<String, Object> getConMap() {
		return conMap;
	}

	public void setConMap(Map<String, Object> conMap) {
		this.conMap = conMap;
	}

}

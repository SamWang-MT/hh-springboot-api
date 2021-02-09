package com.halcyon.file_manage.core;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

public interface LocalMapper<T> {
	
    @SelectProvider(type = MySelectProvider.class, method = "dynamicSQL")
    List<T> selectLastLimt();
    
	
	/*
	 * @SelectProvider(type = MySelectProvider.class, method = "dynamicSQL") List<T>
	 * search(Map<String, Object> map );
	 */

}

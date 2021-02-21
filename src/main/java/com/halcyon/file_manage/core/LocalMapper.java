package com.halcyon.file_manage.core;

import java.util.List;
import org.apache.ibatis.annotations.SelectProvider;

public interface LocalMapper<T> {
	
	  @SelectProvider(type = MySelectProvider.class, method = "dynamicSQL") List<T>
	  selectLastLimt(String ids);
	  
	 
    
	/*
	 * @UpdateProvider(type = MyUpdateProvider.class, method = "dynamicSQL")
	 * 
	 * @Options(useCache = false, useGeneratedKeys = false) int
	 * updateOneFieldByIds(T record,String ids,String field , Object vaule );
	 */
    
	/*
	 * @SelectProvider(type = MySelectProvider.class, method = "dynamicSQL") List<T>
	 * search(Map<String, Object> map );
	 */

}

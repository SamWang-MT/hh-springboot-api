    package com.halcyon.file_manage.core;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMap;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

/** 
     * @ClassName: MyUpdateProvider    
     * @author: Merdader
     * @Date: Feb. 21, 2021 1:46:10 a.m.
	 * 
	 * @description: 
     */

public class MyUpdateProvider extends MapperTemplate {

	
    public MyUpdateProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
		// TODO Auto-generated constructor stub
	}

	/**
     * 通过主键更新不为null的字段
     *
     * @param ms
     * @return
     */
    public String updateOneFieldByIds(MappedStatement ms) {
    	
    	ParameterMap parameterMap = ms.getParameterMap();
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.updateSetColumns(entityClass, null, true, isNotEmpty()));
        
        
        sql.append(SqlHelper.wherePKColumns(entityClass));
        return sql.toString();
    }
	
}
 
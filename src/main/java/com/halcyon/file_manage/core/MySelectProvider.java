package com.halcyon.file_manage.core;

import org.apache.ibatis.mapping.MappedStatement;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

public class MySelectProvider  extends MapperTemplate{

	public MySelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
		// TODO Auto-generated constructor stub
	}

    /**
     * 查询全部结果
     *
     * @param ms
     * @return
     */
    public String selectLastLimt(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //修改返回值类型为实体类型
        
        
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append( " ORDER BY ID DESC ");
        return sql.toString();
    }
	
    /**
     * search(Map<String, Object> map );
     * @param ms
     * @return
     */
	/*
	 * public String search(MappedStatement ms, Map<String, Object> map) { final
	 * Class<?> entityClass = getEntityClass(ms); //修改返回值类型为实体类型 setResultType(ms,
	 * entityClass); StringBuilder sql = new StringBuilder();
	 * sql.append(SqlHelper.selectAllColumns(entityClass));
	 * sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
	 * sql.append( " ORDER BY ID DESC "); return sql.toString(); }
	 */
    
    
	
}

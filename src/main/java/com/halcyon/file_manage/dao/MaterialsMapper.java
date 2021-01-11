package com.halcyon.file_manage.dao;


import java.util.List;

import com.halcyon.file_manage.core.Mapper;
import com.halcyon.file_manage.model.Materials;
import com.halcyon.file_manage.model.SearchType;

public interface MaterialsMapper extends Mapper<Materials> {
	
	/*
	 * @Select("select uuid ,matde ,matgr ,measu ,matnr ,remark ,amount\r\n" +
	 * "		from materials " +
	 * "		where  like CONCAT(CONCAT('%',#{mname}),'%')") List<Materials>
	 * selectWithConditionLike(@Param(value = "mname") String mname);
	 */
	
	List<Materials> selectWithConditionLike(SearchType searchType);
	
}
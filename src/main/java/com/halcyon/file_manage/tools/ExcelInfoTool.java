package com.halcyon.file_manage.tools;

import java.util.List;
import java.util.Map;

import com.halcyon.file_manage.model.Records;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

public class ExcelInfoTool {

	public static void main(String[] args) {
//		ExcelReader reader = ExcelUtil.getReader("d:/upload/records.xls");
		
		List<Map<String, Object>> listMapFromXLS = getListMapFromXLS("d:/upload/input.xls");
		
		for (Map<String, Object> map : listMapFromXLS) {
			for (String key : map.keySet()) {
				System.out.println(key + ":"+ map.get(key));
			}
			
		}
		
	}
	/*
	 * ExcelReader reader = ExcelUtil.getReader("d:/upload/records.xls");
	 * List<Records> all = reader.readAll(Records.class);
	 */
	/*
	 * List<Records> all = ExcelInfoTool.getBeansFromXLS("d:/upload/records.xls",
	 * Records.class); for (Records records : all) { System.out.println(records); }
	 */
	// i 变量； 执行条件 ； 一次执行完成 后干什么
	/*
	 * for (int i = 1 ; i< 10 ; i= i+1) { System.out.println(i);
	 * System.out.println("----------"); }
	 */

//	}

	public static <E> List<E> getBeansFromXLS(String filePath, Class<E> beanClass) {
		ExcelReader reader = ExcelUtil.getReader(filePath);
		List<E> all = reader.readAll(beanClass);
		return all;
	}

	public static List<Map<String, Object>> getListMapFromXLS( String filePath ){
		
		ExcelReader reader = ExcelUtil.getReader(filePath);
		List<Map<String, Object>> all = reader.readAll();
		return all;
		
	}
	
	
	

}

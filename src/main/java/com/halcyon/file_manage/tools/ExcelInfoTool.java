package com.halcyon.file_manage.tools;

import java.util.List;

import com.halcyon.file_manage.model.Records;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

public class ExcelInfoTool {

	public static void main(String[] args) {
		/*
		 * ExcelReader reader = ExcelUtil.getReader("d:/upload/records.xls");
		 * List<Records> all = reader.readAll(Records.class);
		 */
		List<Records> all = ExcelInfoTool.getBeansFromXLS("d:/upload/records.xls", Records.class);
		for (Records records : all) {
			System.out.println(records);
		}
	}

	public static <E> List<E> getBeansFromXLS(String filePath, Class<E> beanClass) {
		ExcelReader reader = ExcelUtil.getReader(filePath);
		List<E> all = reader.readAll(beanClass);
		return all;
	}

}

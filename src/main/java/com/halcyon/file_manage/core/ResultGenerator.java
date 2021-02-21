package com.halcyon.file_manage.core;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.halcyon.file_manage.tools.PageInfoUtils;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
	private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
	private static final String FAIL_ARGS_MESSAGE = "请求失败，数据格式异常 ";
	private static final String FAIL_NO_OBJECT = "请求失败，操作操作对象不存在";

	@SuppressWarnings("rawtypes")
	public static Result genSuccessResult() {
		return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
	}

	@SuppressWarnings("unchecked")
	public static <T> Result<T> genSuccessResult(T data) {
		return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
	}

	@SuppressWarnings("unchecked")
	public static <T> Result<T> genSuccessResult(List<T> list, int page, int size) {
		PageInfo<T> pageInfo = null;
		if (page == 0 || size == 0) {
			pageInfo = new PageInfo<T>(list);
		} else {
			pageInfo = PageInfoUtils.list2PageInfo(list, page, size);

		}

		return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(pageInfo);
	}

	@SuppressWarnings("rawtypes")
	public static Result genFailResult(String message) {
		return new Result().setCode(ResultCode.FAIL).setMessage(message);
	}
	
	@SuppressWarnings("rawtypes")
	public static Result genFailResult_Args() {
		return new Result().setCode(ResultCode.FAIL).setMessage(FAIL_ARGS_MESSAGE);
	}
	
	@SuppressWarnings("rawtypes")
	public static Result genFailResult_NotExist() {
		return new Result().setCode(ResultCode.FAIL).setMessage(FAIL_NO_OBJECT);
	}
	
	
}

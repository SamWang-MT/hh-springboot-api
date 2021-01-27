package com.halcyon.file_manage.core;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.halcyon.file_manage.model.StorageInfo;
import com.halcyon.file_manage.tools.PageInfoUtils;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
	private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

	public static Result genSuccessResult() {
		return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
	}

	public static <T> Result<T> genSuccessResult(T data) {
		return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
	}

	public static <T> Result<T> genSuccessResult(List<T> list, int page, int size) {
		PageInfo<T> pageInfo = null;
		if (page == 0 || size == 0) {
			pageInfo = new PageInfo<T>(list);
		} else {
			pageInfo = PageInfoUtils.list2PageInfo(list, page, size);

		}

		return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(pageInfo);
	}

	public static Result genFailResult(String message) {
		return new Result().setCode(ResultCode.FAIL).setMessage(message);
	}
}

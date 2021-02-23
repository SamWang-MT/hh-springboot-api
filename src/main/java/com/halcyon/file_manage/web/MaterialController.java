package com.halcyon.file_manage.web;

import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.StorageInfo;
import com.halcyon.file_manage.service.MaterialService;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created on 2021/01/09.
 */
@RestController
@RequestMapping("/api/material")
public class MaterialController {
	@Resource
	private MaterialService materialService;

	@SuppressWarnings({ "rawtypes" })
	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
			@RequestParam String storageBin) {

		if (StrUtil.isBlankIfStr(storageBin)) {
			return ResultGenerator.genFailResult("请求参数空.");
		}
		List<StorageInfo> list = materialService.listMaterialsByStorageBin(storageBin.trim());
		return ResultGenerator.genSuccessResult(list,page,size);
	}

}

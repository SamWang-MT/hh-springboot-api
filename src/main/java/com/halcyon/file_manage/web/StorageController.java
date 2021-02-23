package com.halcyon.file_manage.web;

import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Shelf;
import com.halcyon.file_manage.service.MaterialService;
import cn.hutool.core.util.StrUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created on 2021/01/25.
 */
@RestController
@RequestMapping("/api/storage")
public class StorageController {
	@Resource
	private MaterialService materialService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/list")
	public Result<List> list(@RequestParam String storageId) {

		if (StrUtil.isBlankIfStr(storageId)) {
			return ResultGenerator.genFailResult("请求参数空.");
		}

		List<Shelf> list = materialService.listSelfByStorageId(storageId.trim());
		return ResultGenerator.genSuccessResult(list);
	}
}

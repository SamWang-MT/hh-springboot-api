package com.halcyon.file_manage.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.halcyon.file_manage.annotations.Authority;
import com.halcyon.file_manage.annotations.SystemRole;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Materials;
import com.halcyon.file_manage.model.SearchType;
import com.halcyon.file_manage.model.StorageInfo;
import com.halcyon.file_manage.service.MaterialService;
import com.halcyon.file_manage.service.MaterialsService;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by CodeGenerator on 2021/01/09.
 */
@RestController
@RequestMapping("/api/material")
public class MaterialController {
	@Resource
	private MaterialService materialService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
			@RequestParam String storageBin) {

		if (StrUtil.isBlankIfStr(storageBin)) {
			return ResultGenerator.genFailResult("请求参数空.");
		}
		// materialsService.findByCondition();
		PageHelper.startPage(page, size);
		List<StorageInfo> list = materialService.listMaterialsByStorageBin(storageBin.trim());
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

}

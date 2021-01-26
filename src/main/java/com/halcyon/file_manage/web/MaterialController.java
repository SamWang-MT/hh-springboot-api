package com.halcyon.file_manage.web;

import com.github.pagehelper.PageInfo;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Shelf;
import com.halcyon.file_manage.model.StorageInfo;
import com.halcyon.file_manage.service.MaterialService;
import com.halcyon.file_manage.tools.PageInfoUtils;

import cn.hutool.core.util.StrUtil;
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/list")
	public Result<PageInfo> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
			@RequestParam String storageBin) {

		if (StrUtil.isBlankIfStr(storageBin)) {
			return ResultGenerator.genFailResult("请求参数空.");
		}
		// materialsService.findByCondition();
//		Page<Object> startPage = PageHelper.startPage(page, size);
		List<StorageInfo> list = materialService.listMaterialsByStorageBin(storageBin.trim());
//		startPage.add(list);
        PageInfo<StorageInfo> pageInfo = null;
        if (page == 0 ||size == 0 ) {
        	pageInfo  = new PageInfo<StorageInfo>(list);
		}else {
			pageInfo = PageInfoUtils.list2PageInfo(list, page, size);
			
		}
		return ResultGenerator.genSuccessResult(pageInfo);
	}

}

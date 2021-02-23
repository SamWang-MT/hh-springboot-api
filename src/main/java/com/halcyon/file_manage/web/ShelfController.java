package com.halcyon.file_manage.web;

import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Shelf;
import com.halcyon.file_manage.service.ShelfService;
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
@RequestMapping("/api/shelf")
public class ShelfController {
	@Resource
	private ShelfService shelfService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/update")
	public Result update(Shelf shelf) {
		if (shelf == null || shelf.getId() == null | StrUtil.isBlankIfStr(shelf.getShelfbin())) {
			ResultGenerator.genFailResult("请求参数不完整");
		}
		Shelf findById = shelfService.select4Id(shelf);
		if (findById == null || !(findById.getShelfbin().trim().equals(shelf.getShelfbin()))) {
			return ResultGenerator.genFailResult("请求参数异常");
		}

		shelfService.updateOne(shelf);
		return ResultGenerator.genSuccessResult();
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
			@RequestParam String shelfBin) {
		if (StrUtil.isBlankIfStr(shelfBin)) {
			return ResultGenerator.genFailResult("请求参数不完整");
		}

		List<Shelf> list = shelfService.findBinStartWith(shelfBin);
		return ResultGenerator.genSuccessResult(list, page, size);
	}
}

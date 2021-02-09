package com.halcyon.file_manage.web;

import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Archive;
import com.halcyon.file_manage.service.ArchiveService;
import com.halcyon.file_manage.tools.FM_SqlUtils;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Merdader on 2021/02/08.
 */
@RestController
@RequestMapping("/archive")
public class ArchiveController {
	@Resource
	private ArchiveService archiveService;

	@PostMapping("/add")
	public Result add(Archive archive) {
		archiveService.save(archive);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		archiveService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(Archive archive) {
		archiveService.update(archive);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		Archive archive = archiveService.findById(id);
		return ResultGenerator.genSuccessResult(archive);
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<Archive> list = archiveService.findAll();

		/*
		 * Condition condition = FM_SqlUtils.getCondition(Archive.class, "category_no",
		 * "11","_category_name", "7"); List<Archive> findByCondition2 =
		 * archiveService.findByCondition(condition );
		 */

		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	/**
	 * 自定查询
	 * 
	 * @param page
	 * @param size
	 * @param categoryNo   普通相等字段使用对象字段名
	 * @param _fileId      模糊查询字段需要下划线开头
	 * @param $archiveDate 范围查询$开头
	 * 
	 * @return
	 */
	@PostMapping("/search")
	public Result search(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "1000") Integer size, @RequestParam(defaultValue = "0") String _fileId,
			@RequestParam(defaultValue = "0") String categoryNo,
			@RequestParam(defaultValue = "0") String $archiveDate) {

		Condition condition = FM_SqlUtils.getCondition(Archive.class, "_fileId", _fileId, "categoryNo", categoryNo,
				"$archiveDate", $archiveDate);
		PageHelper.startPage(page, size);
		List<Archive> list = archiveService.findByCondition(condition);

		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

}

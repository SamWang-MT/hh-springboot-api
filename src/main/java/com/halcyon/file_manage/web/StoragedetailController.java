package com.halcyon.file_manage.web;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Storagedetail;
import com.halcyon.file_manage.service.StoragedetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2021/01/28.
*/
@RestController
@RequestMapping("/storagedetail")
public class StoragedetailController {
    @Resource
    private StoragedetailService storagedetailService;

	/*
	 * @PostMapping("/add") public Result add(Storagedetail storagedetail) {
	 * storagedetailService.save(storagedetail); return
	 * ResultGenerator.genSuccessResult(); }
	 * 
	 * @PostMapping("/delete") public Result delete(@RequestParam Integer id) {
	 * storagedetailService.deleteById(id); return
	 * ResultGenerator.genSuccessResult(); }
	 */

    @PostMapping("/update")
    public Result update(Storagedetail storagedetail) {
        storagedetailService.update(storagedetail);
        return ResultGenerator.genSuccessResult();
    }

	/*
	 * @PostMapping("/detail") public Result detail(@RequestParam Integer id) {
	 * Storagedetail storagedetail = storagedetailService.findById(id); return
	 * ResultGenerator.genSuccessResult(storagedetail); }
	 */

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        List<Storagedetail> list = storagedetailService.findAll();
        return ResultGenerator.genSuccessResult(list,page,size);
    }
}

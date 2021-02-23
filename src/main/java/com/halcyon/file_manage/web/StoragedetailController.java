package com.halcyon.file_manage.web;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Storagedetail;
import com.halcyon.file_manage.service.StoragedetailService;

import cn.hutool.core.util.StrUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
* Created on 2021/01/28.
*/
@RestController
@RequestMapping("api/storagedetail")
public class StoragedetailController {
    @Resource
    private StoragedetailService storagedetailService;


    @PostMapping("/update")
    public Result<?> update(Storagedetail storagedetail) {
        storagedetailService.updateOne(storagedetail);
        return ResultGenerator.genSuccessResult();
    }

  

    @PostMapping("/list")
    public Result<Storagedetail> list(@RequestParam(defaultValue = "0") Integer page, 
    		@RequestParam(defaultValue = "0") Integer size , @RequestParam(defaultValue =" ") String  storageId) {
    	List<Storagedetail> list =  new ArrayList<Storagedetail>();
        if (StrUtil.isBlankIfStr(storageId)) {
        	list = storagedetailService.selectAll();
		}else {
			list.add(storagedetailService.findByStorageId(storageId));
		}
        return ResultGenerator.genSuccessResult(list,page,size);
    }
}

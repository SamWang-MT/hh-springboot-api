package com.halcyon.file_manage.web;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Shelf;
import com.halcyon.file_manage.model.ShelfInfo;
import com.halcyon.file_manage.service.MaterialService;
import com.halcyon.file_manage.service.ShelfService;

import cn.hutool.core.util.StrUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2021/01/25.
*/
@RestController
@RequestMapping("/api/storage")
public class StorageController {
    @Resource
    private MaterialService materialService;



    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, 
    		@RequestParam(defaultValue = "0") Integer size,
    		@RequestParam String storageId
    		) {
        PageHelper.startPage(page, size);
        
        if (StrUtil.isBlankIfStr(storageId)) {
    		return ResultGenerator.genFailResult("请求参数空.");
		}
        
        List<Shelf> list = materialService.listSelfByStorageId(storageId.trim());
        
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

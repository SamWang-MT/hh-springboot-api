package com.halcyon.file_manage.web;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.FileArchive;
import com.halcyon.file_manage.service.FileArchiveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Merdader on 2021/02/08.
*/
@RestController
@RequestMapping("/file/archive")
public class FileArchiveController {
    @Resource
    private FileArchiveService fileArchiveService;

    @PostMapping("/add")
    public Result add(FileArchive fileArchive) {
        fileArchiveService.save(fileArchive);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        fileArchiveService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(FileArchive fileArchive) {
        fileArchiveService.update(fileArchive);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        FileArchive fileArchive = fileArchiveService.findById(id);
        return ResultGenerator.genSuccessResult(fileArchive);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
  
        PageHelper.startPage(page, size);
        List<FileArchive> list = fileArchiveService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
      
    
        
    }
}

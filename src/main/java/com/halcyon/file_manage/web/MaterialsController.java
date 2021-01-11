package com.halcyon.file_manage.web;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Materials;
import com.halcyon.file_manage.model.SearchType;
import com.halcyon.file_manage.service.MaterialsService;

import tk.mybatis.mapper.entity.Condition;

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
@RequestMapping("/materials")
public class MaterialsController {
    @Resource
    private MaterialsService materialsService;

    @PostMapping("/add")
    public Result add(Materials materials) {
        materialsService.save(materials);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        materialsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Materials materials) {
        materialsService.update(materials);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Materials materials = materialsService.findById(id);
        return ResultGenerator.genSuccessResult(materials);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        
    	
		//materialsService.findByCondition();
    	PageHelper.startPage(page, size);
        List<Materials> list = materialsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    
    
    @PostMapping("/search")
    public Result search(
    		Materials materials,
    		@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        
    	
//    	System.out.println(materials);
		//materialsService.findByCondition();
    	PageHelper.startPage(page, size);
        SearchType searchType = new SearchType("matde",materials.getMatde(),"uuid",true);
		List<Materials> list = materialsService.selectByLikeName(searchType );
        
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    
}

package com.halcyon.file_manage.web;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Borrower;
import com.halcyon.file_manage.service.BorrowerService;
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
@RequestMapping("/borrower")
public class BorrowerController {
    @Resource
    private BorrowerService borrowerService;

    @PostMapping("/add")
    public Result add(Borrower borrower) {
        borrowerService.save(borrower);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        borrowerService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Borrower borrower) {
        borrowerService.update(borrower);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Borrower borrower = borrowerService.findById(id);
        return ResultGenerator.genSuccessResult(borrower);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
  
        PageHelper.startPage(page, size);
        List<Borrower> list = borrowerService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
      
    
        
    }
}

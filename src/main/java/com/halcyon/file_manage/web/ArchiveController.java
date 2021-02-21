package com.halcyon.file_manage.web;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Archive;
import com.halcyon.file_manage.service.ArchiveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;
import com.halcyon.file_manage.tools.FM_SqlUtils;


import javax.annotation.Resource;
import java.util.List;

/**
* Created by Merdader on 2021/02/09.
*/
@RestController
@RequestMapping("/archive")
public class ArchiveController {
    @Resource
    private ArchiveService archiveService;

    @PostMapping("/add")
    public Result add(Archive archive) {
    	archive.setId(null);
    	
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
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
  
        PageHelper.startPage(page, size);
        List<Archive> list = archiveService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
             
    }
    
    
    
	
	/**
	 *  通用自定义查询
	 * 
	 * @param page
	 * @param size
	 * @param categoryNo   普通相等字段使用对象字段名
	 * @param _fileId      模糊查询字段需要下划线开头
	 * @param $archiveDate 范围查询$开头 范围查页面传入开始和结束值使用逗号拼接传入
	 * 
	 * @return
	 */
	 
	@PostMapping("/search")
	public Result search(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "0") String _fileId,
			@RequestParam(defaultValue = "0") String categoryNo,
			@RequestParam(defaultValue = "0") String $archiveDate) {
	
		Condition condition = FM_SqlUtils.getConditionWithOrder(Archive.class, 
		// 对象各查询字段名和字段值 依次存入参数数组 ，排序字段 ，排序方式
				new String[] { "_fileId", _fileId, "categoryNo", categoryNo, "$archiveDate", $archiveDate }, "id","desc");
		PageHelper.startPage(page, size);
		List<Archive> list = archiveService.findByCondition(condition);

		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
    
    
}

package ${basePackage}.web;
import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
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
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public Result add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
  
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
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
	 
	/** 
	@PostMapping("/search")
	public Result search(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "0") String _fileId,
			@RequestParam(defaultValue = "0") String categoryNo,
			@RequestParam(defaultValue = "0") String $archiveDate) {
	
		Condition condition = FM_SqlUtils.getCondition(${modelNameUpperCamel}.class, "_fileId", _fileId, "categoryNo", categoryNo,
				"$archiveDate", $archiveDate);
		PageHelper.startPage(page, size);
		List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findByCondition(condition);

		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
    
	 */
    
}

package ${basePackage}.web;
import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;
import com.halcyon.file_manage.tools.FM_SqlUtils;
import cn.hutool.core.util.StrUtil;



import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("api${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public Result add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
    	${modelNameLowerCamel}.setId(null);
    	${modelNameLowerCamel}.setCreateTime(new Date()); 
    	${modelNameLowerCamel}.setUpdateTime(new Date()); 
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
    	${modelNameLowerCamel}.setUpdateTime(new Date());
    
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
     * 根据对象ids 批量修改对象 一个或多个属性值
     * @param ids   // 格式 "1,2,4"
     * @param value	// 字段类型 根据业务类型 需要处理
     * @return
     */
   
    /** 
    @PostMapping("/updateByIds")
    public Result updatebyids(@RequestParam String ids , @RequestParam(defaultValue = " ")  String value ) {
    	
    	if (StrUtil.isBlankIfStr(ids)   ) {
    		 return ResultGenerator.genFailResult_Args();
		}
    	List<${modelNameUpperCamel}> findByIds = ${modelNameLowerCamel}Service.findByIds(ids);
    	if (CollectionUtils.isEmpty(findByIds)) {
    		 return ResultGenerator.genFailResult_NotExist();
		}
    	Date updateTime = new Date();
    	for (${modelNameUpperCamel} entity : findByIds) {
    		entity.setUpdateTime(updateTime);
    		//根据业务需要修改对象值 
    		//	entity.setMark(value);
    		// 页面少量批量处理 可以用循环提交 更新；大量批量处理需要新建优化sql
    		${modelNameLowerCamel}Service.update(entity);
		}
        return ResultGenerator.genSuccessResult();
    }
    
    */
    
    
    
	
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
	
		Condition condition = FM_SqlUtils.getConditionWithOrder(${modelNameUpperCamel}.class, 
		// 对象各查询字段名和字段值 依次存入参数数组 ，排序字段 ，排序方式
				new String[] { "_fileId", _fileId, "categoryNo", categoryNo, "$archiveDate", $archiveDate }, "id","desc");
		PageHelper.startPage(page, size);
		List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findByCondition(condition);

		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
    
	 */
    
}

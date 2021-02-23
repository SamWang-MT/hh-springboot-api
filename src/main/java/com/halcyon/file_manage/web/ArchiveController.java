package com.halcyon.file_manage.web;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.Archive;
import com.halcyon.file_manage.service.ArchiveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;
import com.halcyon.file_manage.tools.FM_SqlUtils;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
* Created by Merdader on 2021/02/21.
*/
@RestController
@RequestMapping("api/archive")
public class ArchiveController {
    @Resource
    private ArchiveService archiveService;

    @PostMapping("/add")
    public Result add( 	@RequestBody  @ApiParam(value = "json/application",required = true)   
    					@Validated  Archive archive) {
    	archive.setId(null);
    	archive.setCreateTime(new Date()); 
    	archive.setUpdateTime(new Date()); 
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
    	archive.setUpdateTime(new Date());
    
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
    	List<Archive> findByIds = archiveService.findByIds(ids);
    	if (CollectionUtils.isEmpty(findByIds)) {
    		 return ResultGenerator.genFailResult_NotExist();
		}
    	Date updateTime = new Date();
    	for (Archive entity : findByIds) {
    		entity.setUpdateTime(updateTime);
    		//根据业务需要修改对象值 
    		//	entity.setMark(value);
    		// 页面少量批量处理 可以用循环提交 更新；大量批量处理需要新建优化sql
    		archiveService.update(entity);
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
	 					  	例如日期范围：'2020-01-05,2020-02-15'，数值范围： '12,19'
	 * 
	 * @return
	 */
	 
	@PostMapping("/search")
	public Result search(
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size, 
			@RequestParam(defaultValue = "0") String _fileNum,
			@RequestParam(defaultValue = "0") String  _archiveName,
			@RequestParam(defaultValue = "0") String _batch,
			@RequestParam(defaultValue = "0") String _filingGroup) {
	
		Condition condition = FM_SqlUtils.getConditionWithOrder(Archive.class, 
		// 对象各查询字段名和字段值 依次存入参数数组 ，排序字段 ，排序方式
				new String[] { 	"_fileNum", _fileNum, "_archiveName", _archiveName,
								"_batch", _batch,"_filingGroup",_filingGroup }, "id","desc");
		PageHelper.startPage(page, size);
		List<Archive> list = archiveService.findByCondition(condition);

		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
    
    
}

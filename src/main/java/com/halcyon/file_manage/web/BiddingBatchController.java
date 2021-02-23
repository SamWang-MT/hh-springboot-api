package com.halcyon.file_manage.web;
import com.halcyon.file_manage.annotations.FM_Constants;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.BiddingBatch;
import com.halcyon.file_manage.service.BiddingBatchService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;
import com.halcyon.file_manage.tools.FM_SqlUtils;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
* Created by Merdader on 2021/02/21.
*/
@RestController
//@Api(tags = {"招标批次操作接口"})
@RequestMapping("api/biddingBatch")
public class BiddingBatchController {
    @Resource
    private BiddingBatchService biddingBatchService;

    @PostMapping("/add")
    public Result add( @RequestBody  @ApiParam(value = "json/application",required = true)  @Validated  BiddingBatch biddingBatch) {
    	biddingBatch.setId(null);
    	biddingBatch.setCreateTime(new Date()); 
    	biddingBatch.setUpdateTime(new Date()); 
        biddingBatchService.save(biddingBatch);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        biddingBatchService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(BiddingBatch biddingBatch) {
    	biddingBatch.setUpdateTime(new Date());
    
        biddingBatchService.update(biddingBatch);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        BiddingBatch biddingBatch = biddingBatchService.findById(id);
        return ResultGenerator.genSuccessResult(biddingBatch);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
  
        PageHelper.startPage(page, size);
        List<BiddingBatch> list = biddingBatchService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
             
    }
    
    
	
 /**
 * 根据一个或多批次ids 和临时货架号tempShelf    实现批量上架或更新货架位置  
 * @param ids   // 格式 "1,2,4"
 * @param value	// 字段类型 根据业务类型 需要处理
 * @return
 */

@PostMapping("/updateByIds")
public Result updatebyids(@RequestParam String ids , @RequestParam(defaultValue = " ")  String tempShelf ) {
	
	if (StrUtil.isBlankIfStr(ids)   ) {
		 return ResultGenerator.genFailResult_Args();
	}
	List<BiddingBatch> findByIds = biddingBatchService.findByIds(ids);
	if (CollectionUtils.isEmpty(findByIds)) {
		 return ResultGenerator.genFailResult_NotExist();
	}
	Date updateTime = new Date();
	for (BiddingBatch entity : findByIds) {
		entity.setUpdateTime(updateTime);
		//根据业务需要修改对象值 - 批量上架 
		entity.setIsOnShelf(FM_Constants.YES);
		entity.setTempShelf(tempShelf);
		// 页面少量批量处理 可以用循环提交 更新；大量批量处理需要新建优化sql
		biddingBatchService.update(entity);
	}
    return ResultGenerator.genSuccessResult();
}
    
    
    
	

/**
 * 页面列表综合查询
 * @param page
 * @param size
 * @param year 			批次年份
 * @param _batch		批次号模糊查询
 * @param $biddingDate	招标日期 范围查询
 * @return
 */
	 
	@PostMapping("/search")
	public Result search(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size, 
			@RequestParam(defaultValue = "0") String year,
			@RequestParam(defaultValue = "0") String _batch,
			@RequestParam(defaultValue = "0") String $biddingDate
			) {
	
		Condition condition = FM_SqlUtils.getConditionWithOrder(BiddingBatch.class, 
		// 对象各查询字段名和字段值 依次存入参数数组 ，排序字段 ，排序方式
				new String[] { "year", year, "_batch", _batch, "$biddingDate", $biddingDate }, "id","desc");
		PageHelper.startPage(page, size);
		List<BiddingBatch> list = biddingBatchService.findByCondition(condition);

		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
    
}

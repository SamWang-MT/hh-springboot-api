package com.halcyon.file_manage.web;
import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;
import com.halcyon.file_manage.model.BiddingBatch;
import com.halcyon.file_manage.service.BiddingBatchService;
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
* Created by Merdader on 2021/02/08.
*/
@RestController
@RequestMapping("/bidding/batch")
public class BiddingBatchController {
    @Resource
    private BiddingBatchService biddingBatchService;

    @PostMapping("/add")
    public Result add(BiddingBatch biddingBatch) {
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
	
		Condition condition = FM_SqlUtils.getCondition(BiddingBatch.class, "_fileId", _fileId, "categoryNo", categoryNo,
				"$archiveDate", $archiveDate);
		PageHelper.startPage(page, size);
		List<BiddingBatch> list = biddingBatchService.findByCondition(condition);

		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
    
	 */
    
}

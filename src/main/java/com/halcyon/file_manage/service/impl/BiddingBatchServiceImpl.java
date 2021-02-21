package com.halcyon.file_manage.service.impl;

import com.halcyon.file_manage.dao.BiddingBatchMapper;
import com.halcyon.file_manage.model.BiddingBatch;
import com.halcyon.file_manage.service.BiddingBatchService;
import com.halcyon.file_manage.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Merdader on 2021/02/21.
 */
@Service
@Transactional
public class BiddingBatchServiceImpl extends AbstractService<BiddingBatch> implements BiddingBatchService {
    @Resource
    private BiddingBatchMapper biddingBatchMapper;

}

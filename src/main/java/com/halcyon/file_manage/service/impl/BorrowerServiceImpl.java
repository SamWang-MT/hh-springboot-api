package com.halcyon.file_manage.service.impl;

import com.halcyon.file_manage.dao.BorrowerMapper;
import com.halcyon.file_manage.model.Borrower;
import com.halcyon.file_manage.service.BorrowerService;
import com.halcyon.file_manage.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Merdader on 2021/02/08.
 */
@Service
@Transactional
public class BorrowerServiceImpl extends AbstractService<Borrower> implements BorrowerService {
    @Resource
    private BorrowerMapper borrowerMapper;

}

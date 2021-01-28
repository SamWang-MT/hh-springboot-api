package com.halcyon.file_manage.service.impl;

import com.halcyon.file_manage.dao.StoragedetailMapper;
import com.halcyon.file_manage.model.Storagedetail;
import com.halcyon.file_manage.service.StoragedetailService;
import com.halcyon.file_manage.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/01/28.
 */
@Service
@Transactional
public class StoragedetailServiceImpl extends AbstractService<Storagedetail> implements StoragedetailService {
    @Resource
    private StoragedetailMapper storagedetailMapper;

}

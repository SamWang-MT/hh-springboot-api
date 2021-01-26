package com.halcyon.file_manage.service.impl;

import com.halcyon.file_manage.dao.ShelfMapper;
import com.halcyon.file_manage.model.Shelf;
import com.halcyon.file_manage.service.ShelfService;
import com.halcyon.file_manage.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/01/25.
 */
@Service
@Transactional
public class ShelfServiceImpl extends AbstractService<Shelf> implements ShelfService {
    @Resource
    private ShelfMapper shelfMapper;

}

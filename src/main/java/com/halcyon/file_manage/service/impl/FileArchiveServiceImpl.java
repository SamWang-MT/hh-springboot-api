package com.halcyon.file_manage.service.impl;

import com.halcyon.file_manage.dao.FileArchiveMapper;
import com.halcyon.file_manage.model.FileArchive;
import com.halcyon.file_manage.service.FileArchiveService;
import com.halcyon.file_manage.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Merdader on 2021/02/08.
 */
@Service
@Transactional
public class FileArchiveServiceImpl extends AbstractService<FileArchive> implements FileArchiveService {
    @Resource
    private FileArchiveMapper fileArchiveMapper;

}

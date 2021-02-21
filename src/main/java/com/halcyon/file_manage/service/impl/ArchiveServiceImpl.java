package com.halcyon.file_manage.service.impl;

import com.halcyon.file_manage.dao.ArchiveMapper;
import com.halcyon.file_manage.model.Archive;
import com.halcyon.file_manage.service.ArchiveService;
import com.halcyon.file_manage.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;


/**
 * Created by Merdader on 2021/02/09.
 */
@Service
@Transactional
public class ArchiveServiceImpl extends AbstractService<Archive> implements ArchiveService {
    @Resource
    private ArchiveMapper archiveMapper;

	@Override
	public List<Archive> selectLastLimt(String ids) {
		// TODO Auto-generated method stub
		return archiveMapper.selectLastLimt(ids);
	}


	

}

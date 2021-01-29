package com.halcyon.file_manage.service.impl;

import com.halcyon.file_manage.dao.StoragedetailMapper;
import com.halcyon.file_manage.model.Storagedetail;
import com.halcyon.file_manage.service.StoragedetailService;
import com.halcyon.file_manage.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2021/01/28.
 */
@Service
@Transactional
public class StoragedetailServiceImpl extends AbstractService<Storagedetail> implements StoragedetailService {
	@Resource
	private StoragedetailMapper storagedetailMapper;

	@Override
	public List<Storagedetail> selectAll() {
		return storagedetailMapper.selectAll();
	}

	@Override
	public Storagedetail findByStorageId(String storageId) {
		Storagedetail rtStoragedetail = null;

		List<Storagedetail> selectAll = selectAll();
		for (Storagedetail storagedetail : selectAll) {
			if (storageId.equals(storagedetail.getStorageid())) {
				rtStoragedetail = storagedetail;
			}
		}
		return rtStoragedetail;
	}

	@Override
	public void updateOne(Storagedetail storagedetail) {
		// TODO Auto-generated method stub
		storagedetailMapper.updateOne(storagedetail);
	}

	@Override
	public Storagedetail select4Id(Storagedetail storagedetail) {
		// TODO Auto-generated method stub
		return storagedetailMapper.select4Id(storagedetail);
	}

}

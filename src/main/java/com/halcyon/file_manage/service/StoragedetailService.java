package com.halcyon.file_manage.service;
import com.halcyon.file_manage.model.Storagedetail;

import java.util.List;

import com.halcyon.file_manage.core.Service;


/**
 * Created on 2021/01/28.
 */
public interface StoragedetailService extends Service<Storagedetail> {
	List<Storagedetail>  selectAll ();

	Storagedetail findByStorageId(String storageId);
	void updateOne(Storagedetail storagedetail);
	Storagedetail select4Id(Storagedetail storagedetail);
	
}

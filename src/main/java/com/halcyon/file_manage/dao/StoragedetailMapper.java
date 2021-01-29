package com.halcyon.file_manage.dao;

import java.util.List;

import com.halcyon.file_manage.core.Mapper;
import com.halcyon.file_manage.model.Storagedetail;

public interface StoragedetailMapper extends Mapper<Storagedetail> {
	
	List<Storagedetail>  selectAll ();
	void updateOne(Storagedetail storagedetail);
	
	Storagedetail select4Id(Storagedetail storagedetail);
	
}
package com.halcyon.file_manage.service;
import java.util.List;

import com.halcyon.file_manage.model.Shelf;
import com.halcyon.file_manage.model.StorageInfo;


/**
 * Created on 2021/01/09.
 */
public interface MaterialService  {

	List<StorageInfo> listMaterialsByStorageBin(String storageBin);
	
	List<Shelf> listSelfByStorageId (String storageId);
	
}

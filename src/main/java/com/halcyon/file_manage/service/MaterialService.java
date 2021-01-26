package com.halcyon.file_manage.service;
import java.util.List;

import com.halcyon.file_manage.core.Service;
import com.halcyon.file_manage.model.Materials;
import com.halcyon.file_manage.model.SearchType;
import com.halcyon.file_manage.model.Shelf;
import com.halcyon.file_manage.model.ShelfInfo;
import com.halcyon.file_manage.model.Storage;
import com.halcyon.file_manage.model.StorageInfo;


/**
 * Created by CodeGenerator on 2021/01/09.
 */
public interface MaterialService  {

	List<StorageInfo> listMaterialsByStorageBin(String storageBin);
	
	List<Shelf> listSelfByStorageId (String storageId);
	
}

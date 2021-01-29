package com.halcyon.file_manage.service;
import com.halcyon.file_manage.model.Shelf;
import com.halcyon.file_manage.model.Storagedetail;

import java.util.List;

import com.halcyon.file_manage.core.Service;


/**
 * Created by CodeGenerator on 2021/01/25.
 */
public interface ShelfService extends Service<Shelf> {

	List<Shelf> findBinStartWith(String shelfBin);
	List<Shelf>  selectAll ();
	
	void updateOne(Shelf shelf);
	Shelf select4Id(Shelf shelf);

}

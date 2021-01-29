package com.halcyon.file_manage.dao;

import java.util.List;

import com.halcyon.file_manage.core.Mapper;
import com.halcyon.file_manage.model.Shelf;

public interface ShelfMapper extends Mapper<Shelf> {
	
	List<Shelf>  selectAll ();
	void updateOne(Shelf shelf);
	Shelf select4Id(Shelf shelf); 
}
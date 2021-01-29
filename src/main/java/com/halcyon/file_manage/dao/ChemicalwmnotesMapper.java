package com.halcyon.file_manage.dao;

import java.util.List;

import com.halcyon.file_manage.core.Mapper;
import com.halcyon.file_manage.model.Chemicalwmnotes;

public interface ChemicalwmnotesMapper extends Mapper<Chemicalwmnotes> {
	
	List<Chemicalwmnotes>  selectAll ();
}
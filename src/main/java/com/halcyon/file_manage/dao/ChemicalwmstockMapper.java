package com.halcyon.file_manage.dao;

import java.util.List;

import com.halcyon.file_manage.core.Mapper;
import com.halcyon.file_manage.model.Chemicalwmstock;

public interface ChemicalwmstockMapper extends Mapper<Chemicalwmstock> {
	List<Chemicalwmstock>  selectAll ();
	
}
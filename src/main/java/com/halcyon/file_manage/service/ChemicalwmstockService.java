package com.halcyon.file_manage.service;
import com.halcyon.file_manage.model.Chemicalwmstock;

import java.util.List;

import com.halcyon.file_manage.core.Service;


/**
 * Created on 2021/01/25.
 */
public interface ChemicalwmstockService extends Service<Chemicalwmstock> {
	List<Chemicalwmstock> selectAll();
}

package com.halcyon.file_manage.service.impl;

import com.halcyon.file_manage.dao.ChemicalwmstockMapper;
import com.halcyon.file_manage.model.Chemicalwmstock;
import com.halcyon.file_manage.service.ChemicalwmstockService;
import com.halcyon.file_manage.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/01/25.
 */
@Service
@Transactional
public class ChemicalwmstockServiceImpl extends AbstractService<Chemicalwmstock> implements ChemicalwmstockService {
    @Resource
    private ChemicalwmstockMapper chemicalwmstockMapper;

	@Override
	public List<Chemicalwmstock> selectAll() {
		// TODO Auto-generated method stub
		return chemicalwmstockMapper.selectAll();
	}

}

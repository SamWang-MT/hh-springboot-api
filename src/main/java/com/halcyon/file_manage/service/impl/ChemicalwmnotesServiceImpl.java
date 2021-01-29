package com.halcyon.file_manage.service.impl;

import com.halcyon.file_manage.dao.ChemicalwmnotesMapper;
import com.halcyon.file_manage.model.Chemicalwmnotes;
import com.halcyon.file_manage.service.ChemicalwmnotesService;
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
public class ChemicalwmnotesServiceImpl extends AbstractService<Chemicalwmnotes> implements ChemicalwmnotesService {
    @Resource
    private ChemicalwmnotesMapper chemicalwmnotesMapper;

	@Override
	public List<Chemicalwmnotes> selectAll() {
		// TODO Auto-generated method stub
		return chemicalwmnotesMapper.selectAll();
	}

    
}

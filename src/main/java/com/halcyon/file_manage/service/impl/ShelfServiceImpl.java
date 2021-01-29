package com.halcyon.file_manage.service.impl;

import com.halcyon.file_manage.dao.ShelfMapper;
import com.halcyon.file_manage.model.Shelf;
import com.halcyon.file_manage.service.ShelfService;

import cn.hutool.core.util.StrUtil;

import com.halcyon.file_manage.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2021/01/25.
 */
@Service
@Transactional
public class ShelfServiceImpl extends AbstractService<Shelf> implements ShelfService {
	@Resource
	private ShelfMapper shelfMapper;

	@Override
	public List<Shelf> findBinStartWith(String shelfBin) {

		List<Shelf> findAll = selectAll();
		List<Shelf> rt_listList = new ArrayList<Shelf>();

//		Iterator<Shelf> iterator = findAll.iterator();
		for (Shelf shelf : findAll) {
			String shelfbin2 = shelf.getShelfbin();
			
			if (StrUtil.startWith(shelfbin2, shelfBin)) {
				rt_listList.add(shelf);
			}
		}
		return rt_listList;

	}

	@Override
	public List<Shelf> selectAll() {
		// TODO Auto-generated method stub
		return shelfMapper.selectAll();
	}

	@Override
	public void updateOne(Shelf shelf) {
		// TODO Auto-generated method stub
		shelfMapper.updateOne(shelf);
	}

	@Override
	public Shelf select4Id(Shelf shelf) {
		// TODO Auto-generated method stub
		return shelfMapper.select4Id(shelf);
	}

}

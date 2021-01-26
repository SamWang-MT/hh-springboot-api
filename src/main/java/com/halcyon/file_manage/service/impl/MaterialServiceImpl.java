package com.halcyon.file_manage.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement.Else;
import com.halcyon.file_manage.annotations.StorageContainer;
import com.halcyon.file_manage.core.AbstractService;
import com.halcyon.file_manage.dao.MaterialsMapper;
import com.halcyon.file_manage.model.Chemicalwmnotes;
import com.halcyon.file_manage.model.Chemicalwmstock;
import com.halcyon.file_manage.model.Materials;
import com.halcyon.file_manage.model.SearchType;
import com.halcyon.file_manage.model.Shelf;
import com.halcyon.file_manage.model.ShelfInfo;
import com.halcyon.file_manage.model.Storage;
import com.halcyon.file_manage.model.StorageInfo;
import com.halcyon.file_manage.service.MaterialService;
import com.halcyon.file_manage.service.MaterialsService;
import com.halcyon.file_manage.service.ShelfService;

import cn.hutool.core.util.StrUtil;
import tk.mybatis.mapper.entity.Condition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2021/01/09.
 */
@Service
public class MaterialServiceImpl implements MaterialService {
	@Resource
	private ShelfService shelfService;

	@Override
	public List<StorageInfo> listMaterialsByStorageBin(String storageBin) {

		List<StorageInfo> rtInfos = new ArrayList<StorageInfo>();
		StorageContainer container = StorageContainer.getContainer();

		List<Chemicalwmstock> stocks = container.getStock();
		Map<String, Chemicalwmnotes> materalsMap = container.getMateral();

		for (Chemicalwmstock chemicalwmstock : stocks) {
			String storagebin = chemicalwmstock.getStoragebin();
			
			if (StrUtil.startWith(storagebin, storageBin)) {
				StorageInfo info = null;
				Chemicalwmnotes materal = materalsMap.get(chemicalwmstock.getMaterialno());
				info = new StorageInfo(chemicalwmstock, materal);
				rtInfos.add(info);
			}
		}
		return rtInfos;
	}

	@Override
	public List<Shelf> listSelfByStorageId(String storageId) {
	
		List<Shelf> shelfList = shelfService.findAll();
		List<Shelf> rt_listList = new ArrayList<Shelf>();
		for (Shelf shelf : shelfList) {
			String storagebin = shelf.getShelfbin();
			if (StrUtil.startWith(storagebin, storageId)) {
				rt_listList.add(shelf);
			}
		}
		return rt_listList;
	}

}

package com.halcyon.file_manage.service.impl;

import org.springframework.stereotype.Service;
import com.halcyon.file_manage.annotations.StorageContainer;
import com.halcyon.file_manage.model.Chemicalwmnotes;
import com.halcyon.file_manage.model.Chemicalwmstock;
import com.halcyon.file_manage.model.Shelf;
import com.halcyon.file_manage.model.StorageInfo;
import com.halcyon.file_manage.service.MaterialService;
import com.halcyon.file_manage.service.ShelfService;

import cn.hutool.core.util.StrUtil;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
		List<Shelf> shelfList = shelfService.selectAll();
		List<Shelf> rt_listList = new ArrayList<Shelf>();
		for (Shelf shelf : shelfList) {
			String storagebin = shelf.getShelfbin();
			if (StrUtil.startWith(storagebin, storageId)) {
				rt_listList.add(shelf);
			}
		}
		return rt_listList;
	}

	@Override
	public List<StorageInfo> listAbnormalPosition() {
		List<StorageInfo> rtInfos = new ArrayList<StorageInfo>();
		StorageContainer container = StorageContainer.getContainer();

		List<Chemicalwmstock> stocks = container.getStock();
		sortList(stocks);
		Map<String, Chemicalwmnotes> materalsMap = container.getMateral();
		
		for (Chemicalwmstock chemicalwmstock : stocks) {
			String storagebin = chemicalwmstock.getStoragebin();
			storagebin = storagebin.trim();
			String storageID = storagebin.substring(0, 2);			
			
//			if (StrUtil.startWith(storagebin, storageBin)) {
				Chemicalwmnotes materal = materalsMap.get(chemicalwmstock.getMaterialno());
				if ( !StrUtil.isBlankIfStr(storageID) &&  materal !=null &&  !StrUtil.isBlankIfStr(materal.getStorageLocation())
						&& !materal.getStorageLocation().contains(storageID)  ) {
					StorageInfo info  = new StorageInfo(chemicalwmstock, materal);
					rtInfos.add(info);
				}
				
//			}
		}
		return rtInfos;
		
		
	}
	
	
	
	   private void sortList(List<Chemicalwmstock> list) {
	        Collections.sort(list, new Comparator<Chemicalwmstock>() {
	            @Override
	            public int compare(Chemicalwmstock o1, Chemicalwmstock o2) {
	            	return  o1.getStoragebin().compareTo(o2.getStoragebin());
	            }
	        });
	   }
	   
	   
	   public static void main(String[] args) {
		
		/*
		 * MaterialServiceImpl materialServiceImpl = new MaterialServiceImpl();
		 * 
		 * List<Chemicalwmstock> list = new ArrayList<Chemicalwmstock>();
		 * 
		 * Chemicalwmstock c1 = new Chemicalwmstock(); c1.setStoragebin("23-2");
		 * Chemicalwmstock c2 = new Chemicalwmstock(); c2.setStoragebin("22-3");
		 * Chemicalwmstock c3 = new Chemicalwmstock(); c3.setStoragebin("12-");
		 * Chemicalwmstock c4 = new Chemicalwmstock(); c4.setStoragebin("23-1");
		 * 
		 * list.add(c1); list.add(c2); list.add(c3); list.add(c4);
		 * System.out.println(list);
		 * 
		 * materialServiceImpl.sortList(list);
		 * 
		 * System.out.println(list);
		 */
	}


}

package com.halcyon.file_manage.model;

import java.util.List;

public class ShelfInfo extends Shelf {

	private List<StorageInfo> storageBinlist;

	public ShelfInfo() {
		super();
	}

	public ShelfInfo(Shelf shelf, List<StorageInfo> storageBinlist) {
		super();
		this.setId(shelf.getId());
		this.setMark(shelf.getMark());
		this.setMaxbin(shelf.getMaxbin());
		this.setShelfbin(shelf.getShelfbin());
		this.setShelfcol(shelf.getShelfcol());
		this.setShelfrow(shelf.getShelfrow());
		this.setShelftype(shelf.getShelftype());

		this.storageBinlist = storageBinlist;
	}

	public List<StorageInfo> getStorageBinlist() {
		return storageBinlist;
	}

	public void setStorageBinlist(List<StorageInfo> storageBinlist) {
		this.storageBinlist = storageBinlist;
	}

}

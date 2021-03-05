package com.halcyon.file_manage.model;

import java.util.Map;

import cn.hutool.core.util.StrUtil;

public class StorageInfo extends Chemicalwmstock {

	/*
	 * "storageBin": "41-01-001", = "materalNo": "10000001",= "chemicalBrand": ""，!
	 * "baseUnit": "Kg", "totalQuantity": 123.230,=
	 * "description":" description- descriptions",=
	 * "dOCLink":"127.0.0.1:8080/chemical/3.html";!
	 */

	private String chemicalBrand;
	private String dOCLink;

	public String getChemicalBrand() {
		return chemicalBrand;
	}

	public void setChemicalBrand(String chemicalBrand) {
		this.chemicalBrand = chemicalBrand;
	}

	public String getdOCLink() {
		return dOCLink;
	}

	public void setdOCLink(String dOCLink) {
		this.dOCLink = dOCLink;
	}

	public StorageInfo() {
		super();
	}

	public StorageInfo(Chemicalwmstock stock, String chemicalBrand, String dOCLink) {
		super();
		this.setId(stock.getId());
		this.setStoragebin(stock.getStoragebin());
		this.setMaterialno(stock.getMaterialno());
		this.setPlant(stock.getPlant());
		this.setDescription(stock.getDescription());
		this.setBaseunit(stock.getBaseunit());

		this.chemicalBrand = chemicalBrand;
		this.dOCLink = dOCLink;
	}

	public StorageInfo(Chemicalwmstock stock, Chemicalwmnotes materal) {
		super();

		this.setId(stock.getId());
		this.setStoragebin(stock.getStoragebin());
		this.setMaterialno(stock.getMaterialno());
		this.setPlant(stock.getPlant());
		this.setDescription(stock.getDescription());
		this.setTotalquantity(stock.getTotalquantity());
		this.setBaseunit(stock.getBaseunit());
		if (materal != null) {
			String chemicalbrand2 = materal.getChemicalbrand();
			if (StrUtil.isBlankIfStr(chemicalbrand2)) {
				this.chemicalBrand = "non hazardous";
			} else {
				this.chemicalBrand = chemicalbrand2;
			}
			this.dOCLink = materal.getDoclink();
		}
	}

}

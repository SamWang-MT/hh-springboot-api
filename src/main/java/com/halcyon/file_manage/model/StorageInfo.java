package com.halcyon.file_manage.model;

public class StorageInfo extends Chemicalwmstock {


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
		if (materal !=  null) {
			this.chemicalBrand = materal.getChemicalbrand();
			this.dOCLink = materal.getDoclink();
		}

	}

}

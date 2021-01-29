package com.halcyon.file_manage.model;

import java.math.BigDecimal;
import javax.persistence.*;
//@Table(name = "local_sap_data.ChemicalWMStock") 
public class Chemicalwmstock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 工厂
     */
    @Column(name = "Plant")
    private String plant;

    /**
     * 仓位
     */
    @Column(name = "StorageBin")
    private String storagebin;

    /**
     * 物料号
     */
    @Column(name = "MaterialNo")
    private String materialno;

    /**
     * 数量
     */
    @Column(name = "TotalQuantity")
    private BigDecimal totalquantity;

    /**
     * 物料说明
     */
    @Column(name = "Baseunit")
    private String baseunit;
    
    /**
     * 单位
     */
    @Column(name = "Description")
    private String description;


    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getBaseunit() {
		return baseunit;
	}

	public void setBaseunit(String baseunit) {
		this.baseunit = baseunit;
	}

	/**
     * 获取工厂
     *
     * @return Plant - 工厂
     */
    public String getPlant() {
        return plant;
    }

    /**
     * 设置工厂
     *
     * @param plant 工厂
     */
    public void setPlant(String plant) {
        this.plant = plant;
    }

    /**
     * 获取仓位
     *
     * @return StorageBin - 仓位
     */
    public String getStoragebin() {
        return storagebin;
    }

    /**
     * 设置仓位
     *
     * @param storagebin 仓位
     */
    public void setStoragebin(String storagebin) {
        this.storagebin = storagebin;
    }

    /**
     * 获取物料号
     *
     * @return MaterialNo - 物料号
     */
    public String getMaterialno() {
        return materialno;
    }

    /**
     * 设置物料号
     *
     * @param materialno 物料号
     */
    public void setMaterialno(String materialno) {
        this.materialno = materialno;
    }

    /**
     * 获取数量
     *
     * @return TotalQuantity - 数量
     */
    public BigDecimal getTotalquantity() {
        return totalquantity;
    }

    /**
     * 设置数量
     *
     * @param totalquantity 数量
     */
    public void setTotalquantity(BigDecimal totalquantity) {
        this.totalquantity = totalquantity;
    }

    /**
     * 获取物料说明
     *
     * @return Description - 物料说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置物料说明
     *
     * @param description 物料说明
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
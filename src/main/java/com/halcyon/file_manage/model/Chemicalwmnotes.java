package com.halcyon.file_manage.model;

import javax.persistence.*;

public class Chemicalwmnotes {
    /**
     * 物料号
     */
    @Id
    @Column(name = "MaterialNo")
    private String materialno;

    /**
     * 物料危险标签
     */
    @Column(name = "ChemicalBrand")
    private String chemicalbrand;

    /**
     * 物料说明
     */
    @Column(name = "DOCLink")
    private String doclink;

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
     * 获取物料危险标签
     *
     * @return ChemicalBrand - 物料危险标签
     */
    public String getChemicalbrand() {
        return chemicalbrand;
    }

    /**
     * 设置物料危险标签
     *
     * @param chemicalbrand 物料危险标签
     */
    public void setChemicalbrand(String chemicalbrand) {
        this.chemicalbrand = chemicalbrand;
    }

    /**
     * 获取物料说明
     *
     * @return DOCLink - 物料说明
     */
    public String getDoclink() {
        return doclink;
    }

    /**
     * 设置物料说明
     *
     * @param doclink 物料说明
     */
    public void setDoclink(String doclink) {
        this.doclink = doclink;
    }
}
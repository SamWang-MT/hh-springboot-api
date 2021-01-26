package com.halcyon.file_manage.model;

import javax.persistence.*;

public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shelfBin")
    private String shelfbin;

    /**
     * 货架类型
     */
    @Column(name = "shelfType")
    private Integer shelftype;

    /**
     * 货架行
     */
    @Column(name = "shelfRow")
    private Integer shelfrow;

    /**
     * 货架列
     */
    @Column(name = "shelfCol")
    private Integer shelfcol;

    @Column(name = "maxBin")
    private Integer maxbin;

    /**
     * 备注
     */
    private String mark;

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

    /**
     * @return shelfBin
     */
    public String getShelfbin() {
        return shelfbin;
    }

    /**
     * @param shelfbin
     */
    public void setShelfbin(String shelfbin) {
        this.shelfbin = shelfbin;
    }

    /**
     * 获取货架类型
     *
     * @return shelfType - 货架类型
     */
    public Integer getShelftype() {
        return shelftype;
    }

    /**
     * 设置货架类型
     *
     * @param shelftype 货架类型
     */
    public void setShelftype(Integer shelftype) {
        this.shelftype = shelftype;
    }

    /**
     * 获取货架行
     *
     * @return shelfRow - 货架行
     */
    public Integer getShelfrow() {
        return shelfrow;
    }

    /**
     * 设置货架行
     *
     * @param shelfrow 货架行
     */
    public void setShelfrow(Integer shelfrow) {
        this.shelfrow = shelfrow;
    }

    /**
     * 获取货架列
     *
     * @return shelfCol - 货架列
     */
    public Integer getShelfcol() {
        return shelfcol;
    }

    /**
     * 设置货架列
     *
     * @param shelfcol 货架列
     */
    public void setShelfcol(Integer shelfcol) {
        this.shelfcol = shelfcol;
    }

    /**
     * @return maxBin
     */
    public Integer getMaxbin() {
        return maxbin;
    }

    /**
     * @param maxbin
     */
    public void setMaxbin(Integer maxbin) {
        this.maxbin = maxbin;
    }

    /**
     * 获取备注
     *
     * @return mark - 备注
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置备注
     *
     * @param mark 备注
     */
    public void setMark(String mark) {
        this.mark = mark;
    }
}
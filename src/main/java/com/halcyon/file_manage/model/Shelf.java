package com.halcyon.file_manage.model;

import java.util.Date;
import javax.persistence.*;

public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 仓库ID
     */
    @Column(name = "warehouse_id")
    private String warehouseId;

    /**
     * 仓库名称
     */
    @Column(name = "warehouse_name")
    private String warehouseName;

    /**
     * 货架号
     */
    @Column(name = "shelf_id")
    private String shelfId;

    /**
     * 货架类型
     */
    @Column(name = "shelf_type")
    private String shelfType;

    /**
     * 货架档案类型 一级：10投标/20评标/30内部文档 二级分类：1物资公开/2物资非公开/3非物资公开/4非物资非公开
     */
    @Column(name = "shelf_file_type")
    private String shelfFileType;

    /**
     * 货架仓位行数
     */
    @Column(name = "shelf_row")
    private Integer shelfRow;

    /**
     * 货架仓位列数
     */
    @Column(name = "shelf_col")
    private Integer shelfCol;

    /**
     * 是否是货架对象 是Y ；否N
     */
    @Column(name = "is_shelf")
    private String isShelf;

    /**
     * 仓位：01-02-0304,01仓库02架-03行04列仓位 
     */
    @Column(name = "storage_id")
    private String storageId;

    /**
     * Y是， N否
     */
    @Column(name = "is_empty")
    private String isEmpty;

    /**
     * 仓位宽度毫米
     */
    private Integer width;

    /**
     * 剩余宽度
     */
    @Column(name = "remain_width")
    private Integer remainWidth;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取仓库ID
     *
     * @return warehouse_id - 仓库ID
     */
    public String getWarehouseId() {
        return warehouseId;
    }

    /**
     * 设置仓库ID
     *
     * @param warehouseId 仓库ID
     */
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * 获取仓库名称
     *
     * @return warehouse_name - 仓库名称
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * 设置仓库名称
     *
     * @param warehouseName 仓库名称
     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    /**
     * 获取货架号
     *
     * @return shelf_id - 货架号
     */
    public String getShelfId() {
        return shelfId;
    }

    /**
     * 设置货架号
     *
     * @param shelfId 货架号
     */
    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }

    /**
     * 获取货架类型
     *
     * @return shelf_type - 货架类型
     */
    public String getShelfType() {
        return shelfType;
    }

    /**
     * 设置货架类型
     *
     * @param shelfType 货架类型
     */
    public void setShelfType(String shelfType) {
        this.shelfType = shelfType;
    }

    /**
     * 获取货架档案类型 一级：10投标/20评标/30内部文档 二级分类：1物资公开/2物资非公开/3非物资公开/4非物资非公开
     *
     * @return shelf_file_type - 货架档案类型 一级：10投标/20评标/30内部文档 二级分类：1物资公开/2物资非公开/3非物资公开/4非物资非公开
     */
    public String getShelfFileType() {
        return shelfFileType;
    }

    /**
     * 设置货架档案类型 一级：10投标/20评标/30内部文档 二级分类：1物资公开/2物资非公开/3非物资公开/4非物资非公开
     *
     * @param shelfFileType 货架档案类型 一级：10投标/20评标/30内部文档 二级分类：1物资公开/2物资非公开/3非物资公开/4非物资非公开
     */
    public void setShelfFileType(String shelfFileType) {
        this.shelfFileType = shelfFileType;
    }

    /**
     * 获取货架仓位行数
     *
     * @return shelf_row - 货架仓位行数
     */
    public Integer getShelfRow() {
        return shelfRow;
    }

    /**
     * 设置货架仓位行数
     *
     * @param shelfRow 货架仓位行数
     */
    public void setShelfRow(Integer shelfRow) {
        this.shelfRow = shelfRow;
    }

    /**
     * 获取货架仓位列数
     *
     * @return shelf_col - 货架仓位列数
     */
    public Integer getShelfCol() {
        return shelfCol;
    }

    /**
     * 设置货架仓位列数
     *
     * @param shelfCol 货架仓位列数
     */
    public void setShelfCol(Integer shelfCol) {
        this.shelfCol = shelfCol;
    }

    /**
     * 获取是否是货架对象 是Y ；否N
     *
     * @return is_shelf - 是否是货架对象 是Y ；否N
     */
    public String getIsShelf() {
        return isShelf;
    }

    /**
     * 设置是否是货架对象 是Y ；否N
     *
     * @param isShelf 是否是货架对象 是Y ；否N
     */
    public void setIsShelf(String isShelf) {
        this.isShelf = isShelf;
    }

    /**
     * 获取仓位：01-02-0304,01仓库02架-03行04列仓位 
     *
     * @return storage_id - 仓位：01-02-0304,01仓库02架-03行04列仓位 
     */
    public String getStorageId() {
        return storageId;
    }

    /**
     * 设置仓位：01-02-0304,01仓库02架-03行04列仓位 
     *
     * @param storageId 仓位：01-02-0304,01仓库02架-03行04列仓位 
     */
    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    /**
     * 获取Y是， N否
     *
     * @return is_empty - Y是， N否
     */
    public String getIsEmpty() {
        return isEmpty;
    }

    /**
     * 设置Y是， N否
     *
     * @param isEmpty Y是， N否
     */
    public void setIsEmpty(String isEmpty) {
        this.isEmpty = isEmpty;
    }

    /**
     * 获取仓位宽度毫米
     *
     * @return width - 仓位宽度毫米
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 设置仓位宽度毫米
     *
     * @param width 仓位宽度毫米
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 获取剩余宽度
     *
     * @return remain_width - 剩余宽度
     */
    public Integer getRemainWidth() {
        return remainWidth;
    }

    /**
     * 设置剩余宽度
     *
     * @param remainWidth 剩余宽度
     */
    public void setRemainWidth(Integer remainWidth) {
        this.remainWidth = remainWidth;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * @param mark
     */
    public void setMark(String mark) {
        this.mark = mark;
    }
}
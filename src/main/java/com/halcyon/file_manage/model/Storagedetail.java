package com.halcyon.file_manage.model;

import javax.persistence.*;

public class Storagedetail {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 仓库号
     */
    @Column(name = "storageId")
    private String storageid;

    /**
     * 仓库名称
     */
    @Column(name = "storageName")
    private String storagename;

    /**
     * 仓库详细信息
     */
    @Column(name = "storageDetail")
    private String storagedetail;

    /**
     * 备注
     */
    private String mark;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取仓库号
     *
     * @return storageId - 仓库号
     */
    public String getStorageid() {
        return storageid;
    }

    /**
     * 设置仓库号
     *
     * @param storageid 仓库号
     */
    public void setStorageid(String storageid) {
        this.storageid = storageid;
    }

    /**
     * 获取仓库名称
     *
     * @return storageName - 仓库名称
     */
    public String getStoragename() {
        return storagename;
    }

    /**
     * 设置仓库名称
     *
     * @param storagename 仓库名称
     */
    public void setStoragename(String storagename) {
        this.storagename = storagename;
    }

    /**
     * 获取仓库详细信息
     *
     * @return storageDetail - 仓库详细信息
     */
    public String getStoragedetail() {
        return storagedetail;
    }

    /**
     * 设置仓库详细信息
     *
     * @param storagedetail 仓库详细信息
     */
    public void setStoragedetail(String storagedetail) {
        this.storagedetail = storagedetail;
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
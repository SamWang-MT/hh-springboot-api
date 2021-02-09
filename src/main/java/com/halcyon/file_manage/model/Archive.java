package com.halcyon.file_manage.model;

import java.util.Date;
import javax.persistence.*;

public class Archive {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 年度
     */
    private Integer year;

    /**
     * 分类号
     */
    @Column(name = "category_no")
    private String categoryNo;

    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * ID号是案卷编号的后四位
     */
    @Column(name = "archive_id")
    private String archiveId;

    /**
     * 档号
     */
    @Column(name = "file_id")
    private String fileId;

    @Column(name = "archive_name")
    private String archiveName;

    /**
     * 保管期限-年
     */
    @Column(name = "archive_limit")
    private Integer archiveLimit;

    @Column(name = "archive_copies")
    private Integer archiveCopies;

    /**
     * 卷盒规格
     */
    @Column(name = "folder_size")
    private Integer folderSize;

    /**
     * 立卷单位
     */
    @Column(name = "archive_date")
    private Date archiveDate;

    /**
     * 立卷单位
     */
    @Column(name = "filing_group")
    private String filingGroup;

    /**
     * 立卷人
     */
    @Column(name = "filling_person")
    private String fillingPerson;

    /**
     * 立卷日期
     */
    @Column(name = "filing_date")
    private Date filingDate;

    /**
     * 每份件数
     */
    @Column(name = "units_per_file")
    private Integer unitsPerFile;

    /**
     * 总页数
     */
    @Column(name = "total_page")
    private Integer totalPage;

    /**
     * 卷盒状态：0.初始 1.未上架 2.上架 3.移库 4.销毁
     */
    @Column(name = "folder_status")
    private String folderStatus;

    /**
     * 借出状态： 0.档案在架 1. 已借出 2.超期未归还 3.丢失
     */
    @Column(name = "borrow_status")
    private String borrowStatus;

    /**
     * 销毁时间
     */
    @Column(name = "destroyed_time")
    private Date destroyedTime;

    @Column(name = "destroyed_mark")
    private String destroyedMark;

    @Column(name = "storage_id")
    private String storageId;

    private String mark;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取年度
     *
     * @return year - 年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年度
     *
     * @param year 年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取分类号
     *
     * @return category_no - 分类号
     */
    public String getCategoryNo() {
        return categoryNo;
    }

    /**
     * 设置分类号
     *
     * @param categoryNo 分类号
     */
    public void setCategoryNo(String categoryNo) {
        this.categoryNo = categoryNo;
    }

    /**
     * 获取分类名称
     *
     * @return category_name - 分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名称
     *
     * @param categoryName 分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 获取ID号是案卷编号的后四位
     *
     * @return archive_id - ID号是案卷编号的后四位
     */
    public String getArchiveId() {
        return archiveId;
    }

    /**
     * 设置ID号是案卷编号的后四位
     *
     * @param archiveId ID号是案卷编号的后四位
     */
    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId;
    }

    /**
     * 获取档号
     *
     * @return file_id - 档号
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * 设置档号
     *
     * @param fileId 档号
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**
     * @return archive_name
     */
    public String getArchiveName() {
        return archiveName;
    }

    /**
     * @param archiveName
     */
    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    /**
     * 获取保管期限-年
     *
     * @return archive_limit - 保管期限-年
     */
    public Integer getArchiveLimit() {
        return archiveLimit;
    }

    /**
     * 设置保管期限-年
     *
     * @param archiveLimit 保管期限-年
     */
    public void setArchiveLimit(Integer archiveLimit) {
        this.archiveLimit = archiveLimit;
    }

    /**
     * @return archive_copies
     */
    public Integer getArchiveCopies() {
        return archiveCopies;
    }

    /**
     * @param archiveCopies
     */
    public void setArchiveCopies(Integer archiveCopies) {
        this.archiveCopies = archiveCopies;
    }

    /**
     * 获取卷盒规格
     *
     * @return folder_size - 卷盒规格
     */
    public Integer getFolderSize() {
        return folderSize;
    }

    /**
     * 设置卷盒规格
     *
     * @param folderSize 卷盒规格
     */
    public void setFolderSize(Integer folderSize) {
        this.folderSize = folderSize;
    }

    /**
     * 获取立卷单位
     *
     * @return archive_date - 立卷单位
     */
    public Date getArchiveDate() {
        return archiveDate;
    }

    /**
     * 设置立卷单位
     *
     * @param archiveDate 立卷单位
     */
    public void setArchiveDate(Date archiveDate) {
        this.archiveDate = archiveDate;
    }

    /**
     * 获取立卷单位
     *
     * @return filing_group - 立卷单位
     */
    public String getFilingGroup() {
        return filingGroup;
    }

    /**
     * 设置立卷单位
     *
     * @param filingGroup 立卷单位
     */
    public void setFilingGroup(String filingGroup) {
        this.filingGroup = filingGroup;
    }

    /**
     * 获取立卷人
     *
     * @return filling_person - 立卷人
     */
    public String getFillingPerson() {
        return fillingPerson;
    }

    /**
     * 设置立卷人
     *
     * @param fillingPerson 立卷人
     */
    public void setFillingPerson(String fillingPerson) {
        this.fillingPerson = fillingPerson;
    }

    /**
     * 获取立卷日期
     *
     * @return filing_date - 立卷日期
     */
    public Date getFilingDate() {
        return filingDate;
    }

    /**
     * 设置立卷日期
     *
     * @param filingDate 立卷日期
     */
    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }

    /**
     * 获取每份件数
     *
     * @return units_per_file - 每份件数
     */
    public Integer getUnitsPerFile() {
        return unitsPerFile;
    }

    /**
     * 设置每份件数
     *
     * @param unitsPerFile 每份件数
     */
    public void setUnitsPerFile(Integer unitsPerFile) {
        this.unitsPerFile = unitsPerFile;
    }

    /**
     * 获取总页数
     *
     * @return total_page - 总页数
     */
    public Integer getTotalPage() {
        return totalPage;
    }

    /**
     * 设置总页数
     *
     * @param totalPage 总页数
     */
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 获取卷盒状态：0.初始 1.未上架 2.上架 3.移库 4.销毁
     *
     * @return folder_status - 卷盒状态：0.初始 1.未上架 2.上架 3.移库 4.销毁
     */
    public String getFolderStatus() {
        return folderStatus;
    }

    /**
     * 设置卷盒状态：0.初始 1.未上架 2.上架 3.移库 4.销毁
     *
     * @param folderStatus 卷盒状态：0.初始 1.未上架 2.上架 3.移库 4.销毁
     */
    public void setFolderStatus(String folderStatus) {
        this.folderStatus = folderStatus;
    }

    /**
     * 获取借出状态： 0.档案在架 1. 已借出 2.超期未归还 3.丢失
     *
     * @return borrow_status - 借出状态： 0.档案在架 1. 已借出 2.超期未归还 3.丢失
     */
    public String getBorrowStatus() {
        return borrowStatus;
    }

    /**
     * 设置借出状态： 0.档案在架 1. 已借出 2.超期未归还 3.丢失
     *
     * @param borrowStatus 借出状态： 0.档案在架 1. 已借出 2.超期未归还 3.丢失
     */
    public void setBorrowStatus(String borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    /**
     * 获取销毁时间
     *
     * @return destroyed_time - 销毁时间
     */
    public Date getDestroyedTime() {
        return destroyedTime;
    }

    /**
     * 设置销毁时间
     *
     * @param destroyedTime 销毁时间
     */
    public void setDestroyedTime(Date destroyedTime) {
        this.destroyedTime = destroyedTime;
    }

    /**
     * @return destroyed_mark
     */
    public String getDestroyedMark() {
        return destroyedMark;
    }

    /**
     * @param destroyedMark
     */
    public void setDestroyedMark(String destroyedMark) {
        this.destroyedMark = destroyedMark;
    }

    /**
     * @return storage_id
     */
    public String getStorageId() {
        return storageId;
    }

    /**
     * @param storageId
     */
    public void setStorageId(String storageId) {
        this.storageId = storageId;
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
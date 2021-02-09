package com.halcyon.file_manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "file_archive")
public class FileArchive {
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
     * 文件序号
     */
    @Column(name = "serial_no")
    private String serialNo;

    /**
     * 文件档号
     */
    @Column(name = "document_id")
    private String documentId;

    /**
     * 文件题名
     */
    @Column(name = "file_name")
    private String fileName;

    @Column(name = "subject_term")
    private String subjectTerm;

    /**
     * 立卷单位
     */
    @Column(name = "archive_dept")
    private String archiveDept;

    /**
     * 保管期限-年
     */
    @Column(name = "archive_limit")
    private Integer archiveLimit;

    /**
     * 密级
     */
    @Column(name = "security_grade")
    private String securityGrade;

    /**
     * 页号
     */
    @Column(name = "page_no")
    private Integer pageNo;

    /**
     * 页数
     */
    @Column(name = "page_count")
    private Integer pageCount;

    /**
     * 成文日期
     */
    @Column(name = "creation_date")
    private Date creationDate;

    /**
     * 归档份数
     */
    @Column(name = "archive_copies")
    private Integer archiveCopies;

    /**
     * 立卷单位
     */
    @Column(name = "archive_date")
    private Date archiveDate;

    /**
     * 责任者
     */
    private String accountable;

    @Column(name = "`document_ no`")
    private String documentNo;

    @Column(name = "batch_no")
    private String batchNo;

    /**
     * 起始页
     */
    @Column(name = "start_page")
    private Integer startPage;

    /**
     * 终止页
     */
    @Column(name = "end_page")
    private Integer endPage;

    @Column(name = "create_date")
    private Date createDate;

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
     * 获取文件序号
     *
     * @return serial_no - 文件序号
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * 设置文件序号
     *
     * @param serialNo 文件序号
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 获取文件档号
     *
     * @return document_id - 文件档号
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * 设置文件档号
     *
     * @param documentId 文件档号
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    /**
     * 获取文件题名
     *
     * @return file_name - 文件题名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件题名
     *
     * @param fileName 文件题名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return subject_term
     */
    public String getSubjectTerm() {
        return subjectTerm;
    }

    /**
     * @param subjectTerm
     */
    public void setSubjectTerm(String subjectTerm) {
        this.subjectTerm = subjectTerm;
    }

    /**
     * 获取立卷单位
     *
     * @return archive_dept - 立卷单位
     */
    public String getArchiveDept() {
        return archiveDept;
    }

    /**
     * 设置立卷单位
     *
     * @param archiveDept 立卷单位
     */
    public void setArchiveDept(String archiveDept) {
        this.archiveDept = archiveDept;
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
     * 获取密级
     *
     * @return security_grade - 密级
     */
    public String getSecurityGrade() {
        return securityGrade;
    }

    /**
     * 设置密级
     *
     * @param securityGrade 密级
     */
    public void setSecurityGrade(String securityGrade) {
        this.securityGrade = securityGrade;
    }

    /**
     * 获取页号
     *
     * @return page_no - 页号
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置页号
     *
     * @param pageNo 页号
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取页数
     *
     * @return page_count - 页数
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * 设置页数
     *
     * @param pageCount 页数
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * 获取成文日期
     *
     * @return creation_date - 成文日期
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * 设置成文日期
     *
     * @param creationDate 成文日期
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 获取归档份数
     *
     * @return archive_copies - 归档份数
     */
    public Integer getArchiveCopies() {
        return archiveCopies;
    }

    /**
     * 设置归档份数
     *
     * @param archiveCopies 归档份数
     */
    public void setArchiveCopies(Integer archiveCopies) {
        this.archiveCopies = archiveCopies;
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
     * 获取责任者
     *
     * @return accountable - 责任者
     */
    public String getAccountable() {
        return accountable;
    }

    /**
     * 设置责任者
     *
     * @param accountable 责任者
     */
    public void setAccountable(String accountable) {
        this.accountable = accountable;
    }

    /**
     * @return document_ no
     */
    public String getDocumentNo() {
        return documentNo;
    }

    /**
     * @param documentNo
     */
    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    /**
     * @return batch_no
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * @param batchNo
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    /**
     * 获取起始页
     *
     * @return start_page - 起始页
     */
    public Integer getStartPage() {
        return startPage;
    }

    /**
     * 设置起始页
     *
     * @param startPage 起始页
     */
    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    /**
     * 获取终止页
     *
     * @return end_page - 终止页
     */
    public Integer getEndPage() {
        return endPage;
    }

    /**
     * 设置终止页
     *
     * @param endPage 终止页
     */
    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
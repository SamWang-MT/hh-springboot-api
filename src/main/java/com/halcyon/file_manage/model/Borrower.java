package com.halcyon.file_manage.model;

import java.util.Date;
import javax.persistence.*;

public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 借阅人
     */
    private String borrower;

    /**
     * 联系方式
     */
    @Column(name = "contactInfo")
    private String contactinfo;

    /**
     * 借阅部门
     */
    @Column(name = "borrower_dept")
    private String borrowerDept;

    /**
     * 借阅原因：1 查阅/2公司内部使用/3借阅原件/4借阅复印件/5借阅扫描件
     */
    @Column(name = "borrow_for")
    private String borrowFor;

    /**
     * 借阅起始时间
     */
    @Column(name = "borrow_from")
    private Date borrowFrom;

    /**
     * 计划归还时间
     */
    @Column(name = "return_time")
    private Date returnTime;

    /**
     * 档案管理员
     */
    @Column(name = "file_admin")
    private String fileAdmin;

    /**
     * 实际归还时间
     */
    @Column(name = "return_real")
    private Date returnReal;

    /**
     * 借阅状态：0 初始创建/1 已借出/3 已归还 /2 续借中/4 超期未归还/5 确认丢失
     */
    private String status;

    /**
     * 借阅的档案IDS
     */
    @Column(name = "file_ids")
    private String fileIds;

    /**
     * 借阅各档案说明 逗号分隔
     */
    @Column(name = "file_tips")
    private String fileTips;

    /**
     * 备注
     */
    private String remark;

    /**
     * 审批文件地址
     */
    @Column(name = "file_url")
    private String fileUrl;

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
     * 获取借阅人
     *
     * @return borrower - 借阅人
     */
    public String getBorrower() {
        return borrower;
    }

    /**
     * 设置借阅人
     *
     * @param borrower 借阅人
     */
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    /**
     * 获取联系方式
     *
     * @return contactInfo - 联系方式
     */
    public String getContactinfo() {
        return contactinfo;
    }

    /**
     * 设置联系方式
     *
     * @param contactinfo 联系方式
     */
    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo;
    }

    /**
     * 获取借阅部门
     *
     * @return borrower_dept - 借阅部门
     */
    public String getBorrowerDept() {
        return borrowerDept;
    }

    /**
     * 设置借阅部门
     *
     * @param borrowerDept 借阅部门
     */
    public void setBorrowerDept(String borrowerDept) {
        this.borrowerDept = borrowerDept;
    }

    /**
     * 获取借阅原因：1 查阅/2公司内部使用/3借阅原件/4借阅复印件/5借阅扫描件
     *
     * @return borrow_for - 借阅原因：1 查阅/2公司内部使用/3借阅原件/4借阅复印件/5借阅扫描件
     */
    public String getBorrowFor() {
        return borrowFor;
    }

    /**
     * 设置借阅原因：1 查阅/2公司内部使用/3借阅原件/4借阅复印件/5借阅扫描件
     *
     * @param borrowFor 借阅原因：1 查阅/2公司内部使用/3借阅原件/4借阅复印件/5借阅扫描件
     */
    public void setBorrowFor(String borrowFor) {
        this.borrowFor = borrowFor;
    }

    /**
     * 获取借阅起始时间
     *
     * @return borrow_from - 借阅起始时间
     */
    public Date getBorrowFrom() {
        return borrowFrom;
    }

    /**
     * 设置借阅起始时间
     *
     * @param borrowFrom 借阅起始时间
     */
    public void setBorrowFrom(Date borrowFrom) {
        this.borrowFrom = borrowFrom;
    }

    /**
     * 获取计划归还时间
     *
     * @return return_time - 计划归还时间
     */
    public Date getReturnTime() {
        return returnTime;
    }

    /**
     * 设置计划归还时间
     *
     * @param returnTime 计划归还时间
     */
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    /**
     * 获取档案管理员
     *
     * @return file_admin - 档案管理员
     */
    public String getFileAdmin() {
        return fileAdmin;
    }

    /**
     * 设置档案管理员
     *
     * @param fileAdmin 档案管理员
     */
    public void setFileAdmin(String fileAdmin) {
        this.fileAdmin = fileAdmin;
    }

    /**
     * 获取实际归还时间
     *
     * @return return_real - 实际归还时间
     */
    public Date getReturnReal() {
        return returnReal;
    }

    /**
     * 设置实际归还时间
     *
     * @param returnReal 实际归还时间
     */
    public void setReturnReal(Date returnReal) {
        this.returnReal = returnReal;
    }

    /**
     * 获取借阅状态：0 初始创建/1 已借出/3 已归还 /2 续借中/4 超期未归还/5 确认丢失
     *
     * @return status - 借阅状态：0 初始创建/1 已借出/3 已归还 /2 续借中/4 超期未归还/5 确认丢失
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置借阅状态：0 初始创建/1 已借出/3 已归还 /2 续借中/4 超期未归还/5 确认丢失
     *
     * @param status 借阅状态：0 初始创建/1 已借出/3 已归还 /2 续借中/4 超期未归还/5 确认丢失
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取借阅的档案IDS
     *
     * @return file_ids - 借阅的档案IDS
     */
    public String getFileIds() {
        return fileIds;
    }

    /**
     * 设置借阅的档案IDS
     *
     * @param fileIds 借阅的档案IDS
     */
    public void setFileIds(String fileIds) {
    	fileIds = fileIds.replace(" ", "");
    	
        this.fileIds = fileIds;
    }

    /**
     * 获取借阅各档案说明 逗号分隔
     *
     * @return file_tips - 借阅各档案说明 逗号分隔
     */
    public String getFileTips() {
        return fileTips;
    }

    /**
     * 设置借阅各档案说明 逗号分隔
     *
     * @param fileTips 借阅各档案说明 逗号分隔
     */
    public void setFileTips(String fileTips) {
    	fileTips = fileTips.replace(" ", "");
        this.fileTips = fileTips;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取审批文件地址
     *
     * @return file_url - 审批文件地址
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 设置审批文件地址
     *
     * @param fileUrl 审批文件地址
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
package com.halcyon.file_manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bidding_batch")
public class BiddingBatch {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 年度
     */
    private Integer year;

    /**
     * 标段
     */
    private Integer block;

    /**
     * 包
     */
    private Integer packages;

    /**
     * 招标日期
     */
    @Column(name = "bidding_date")
    private Date biddingDate;

    /**
     * 招标月份
     */
    @Column(name = "bidding_month")
    private Integer biddingMonth;

    /**
     * 临时货架号
     */
    @Column(name = "temp_shelf")
    private String tempShelf;

    /**
     * 是否归档
     */
    @Column(name = "is_filed")
    private String isFiled;

    /**
     * 是否上架
     */
    @Column(name = "is_on_shelf")
    private String isOnShelf;

    /**
     * 计划上架数量
     */
    @Column(name = "plan_amount")
    private Integer planAmount;

    /**
     * 实际上架数量
     */
    @Column(name = "actual_amount")
    private Integer actualAmount;

    /**
     * 状态：已计划0/临时货架1/上架中2/已完成3
     */
    private Integer status;

    /**
     * 备注
     */
    private String mark;

    /**
     * 创建日期
     */
    @Column(name = "create_date")
    private Date createDate;

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
     * 获取标段
     *
     * @return block - 标段
     */
    public Integer getBlock() {
        return block;
    }

    /**
     * 设置标段
     *
     * @param block 标段
     */
    public void setBlock(Integer block) {
        this.block = block;
    }

    /**
     * 获取包
     *
     * @return packages - 包
     */
    public Integer getPackages() {
        return packages;
    }

    /**
     * 设置包
     *
     * @param packages 包
     */
    public void setPackages(Integer packages) {
        this.packages = packages;
    }

    /**
     * 获取招标日期
     *
     * @return bidding_date - 招标日期
     */
    public Date getBiddingDate() {
        return biddingDate;
    }

    /**
     * 设置招标日期
     *
     * @param biddingDate 招标日期
     */
    public void setBiddingDate(Date biddingDate) {
        this.biddingDate = biddingDate;
    }

    /**
     * 获取招标月份
     *
     * @return bidding_month - 招标月份
     */
    public Integer getBiddingMonth() {
        return biddingMonth;
    }

    /**
     * 设置招标月份
     *
     * @param biddingMonth 招标月份
     */
    public void setBiddingMonth(Integer biddingMonth) {
        this.biddingMonth = biddingMonth;
    }

    /**
     * 获取临时货架号
     *
     * @return temp_shelf - 临时货架号
     */
    public String getTempShelf() {
        return tempShelf;
    }

    /**
     * 设置临时货架号
     *
     * @param tempShelf 临时货架号
     */
    public void setTempShelf(String tempShelf) {
        this.tempShelf = tempShelf;
    }

    /**
     * 获取是否归档
     *
     * @return is_filed - 是否归档
     */
    public String getIsFiled() {
        return isFiled;
    }

    /**
     * 设置是否归档
     *
     * @param isFiled 是否归档
     */
    public void setIsFiled(String isFiled) {
        this.isFiled = isFiled;
    }

    /**
     * 获取是否上架
     *
     * @return is_on_shelf - 是否上架
     */
    public String getIsOnShelf() {
        return isOnShelf;
    }

    /**
     * 设置是否上架
     *
     * @param isOnShelf 是否上架
     */
    public void setIsOnShelf(String isOnShelf) {
        this.isOnShelf = isOnShelf;
    }

    /**
     * 获取计划上架数量
     *
     * @return plan_amount - 计划上架数量
     */
    public Integer getPlanAmount() {
        return planAmount;
    }

    /**
     * 设置计划上架数量
     *
     * @param planAmount 计划上架数量
     */
    public void setPlanAmount(Integer planAmount) {
        this.planAmount = planAmount;
    }

    /**
     * 获取实际上架数量
     *
     * @return actual_amount - 实际上架数量
     */
    public Integer getActualAmount() {
        return actualAmount;
    }

    /**
     * 设置实际上架数量
     *
     * @param actualAmount 实际上架数量
     */
    public void setActualAmount(Integer actualAmount) {
        this.actualAmount = actualAmount;
    }

    /**
     * 获取状态：已计划0/临时货架1/上架中2/已完成3
     *
     * @return status - 状态：已计划0/临时货架1/上架中2/已完成3
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态：已计划0/临时货架1/上架中2/已完成3
     *
     * @param status 状态：已计划0/临时货架1/上架中2/已完成3
     */
    public void setStatus(Integer status) {
        this.status = status;
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

    /**
     * 获取创建日期
     *
     * @return create_date - 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期
     *
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
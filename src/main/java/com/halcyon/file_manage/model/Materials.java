package com.halcyon.file_manage.model;

import javax.persistence.*;

public class Materials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uuid;

    private String matde;

    private String matgr;

    private String measu;

    private Integer matnr;

    private String remark;

    private Integer amount;

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
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return matde
     */
    public String getMatde() {
        return matde;
    }

    /**
     * @param matde
     */
    public void setMatde(String matde) {
        this.matde = matde;
    }

    /**
     * @return matgr
     */
    public String getMatgr() {
        return matgr;
    }

    /**
     * @param matgr
     */
    public void setMatgr(String matgr) {
        this.matgr = matgr;
    }

    /**
     * @return measu
     */
    public String getMeasu() {
        return measu;
    }

    /**
     * @param measu
     */
    public void setMeasu(String measu) {
        this.measu = measu;
    }

    /**
     * @return matnr
     */
    public Integer getMatnr() {
        return matnr;
    }

    /**
     * @param matnr
     */
    public void setMatnr(Integer matnr) {
        this.matnr = matnr;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

	@Override
	public String toString() {
		return "Materials [id=" + id + ", uuid=" + uuid + ", matde=" + matde + ", matgr=" + matgr + ", measu=" + measu
				+ ", matnr=" + matnr + ", remark=" + remark + ", amount=" + amount + "]";
	}
    
    
    
    
}
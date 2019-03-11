package com.lattice.latticegoods.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class GoodsProperties implements Serializable {
    private static final long serialVersionUID = -6072305017862540682L;
    private Integer proid;

    private Integer pronameid;

    private Integer provalueid;

    private Byte status;

    private Date created;

    private Date updated;

    private Integer skuid;

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getPronameid() {
        return pronameid;
    }

    public void setPronameid(Integer pronameid) {
        this.pronameid = pronameid;
    }

    public Integer getProvalueid() {
        return provalueid;
    }

    public void setProvalueid(Integer provalueid) {
        this.provalueid = provalueid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getSkuid() {
        return skuid;
    }

    public void setSkuid(Integer skuid) {
        this.skuid = skuid;
    }
}
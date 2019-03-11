package com.lattice.latticegoods.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class GoodsProName implements Serializable {
    private static final long serialVersionUID = 5027559788445140366L;
    private Integer pronameid;

    private Integer cid;

    private String title;

    private Byte status;

    private Date created;

    private Date updated;

    public Integer getPronameid() {
        return pronameid;
    }

    public void setPronameid(Integer pronameid) {
        this.pronameid = pronameid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
}